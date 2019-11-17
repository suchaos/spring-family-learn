package com.suchaos.customerservice.integration;

import com.suchaos.customerservice.model.Coffee;
import com.suchaos.customerservice.model.request.NewCoffeeRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * feign
 *
 * @author suchao
 * @date 2019/11/17
 */
@FeignClient(name = "waiter-service", contextId = "coffee-service", path = "/coffee")
public interface CoffeeService {

    @GetMapping(path = "/", params = "!name")
    List<Coffee> getAll();

    @GetMapping("/{id}")
    Coffee getById(@PathVariable Long id);

    @GetMapping(path = "/", params = "name")
    Coffee getByName(@RequestParam String name);

    @PostMapping(value = "/")
    public Coffee saveCoffee(@Valid @RequestBody NewCoffeeRequest coffeeRequest);
}
