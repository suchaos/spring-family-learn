package com.suchaos.waiter.controller;

import com.suchaos.waiter.controller.request.NewCoffeeRequest;
import com.suchaos.waiter.model.auto.Coffee;
import com.suchaos.waiter.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 对 Coffee 的一系列操作
 *
 * @author suchao
 * @date 2019/11/13
 */
@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping(value = "/", params = "!name")
    public List<Coffee> getAll() {
        return coffeeService.getAll();
    }

    @GetMapping(value = "/", params = "name")
    public Coffee getCoffeeByName(@RequestParam String name) {
        return coffeeService.getByName(name);
    }

    @GetMapping(value = "/{id}")
    public Coffee getCoffeeById(@PathVariable Long id) {
        return coffeeService.getById(id);
    }

    @PostMapping(value = "/")
    public Coffee saveCoffee(@Valid @RequestBody NewCoffeeRequest coffeeRequest) {
        return coffeeService.saveCoffee(coffeeRequest.getName(), coffeeRequest.getPrice());
    }
}
