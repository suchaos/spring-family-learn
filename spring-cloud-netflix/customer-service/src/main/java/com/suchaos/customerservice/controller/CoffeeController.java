package com.suchaos.customerservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.suchaos.customerservice.integration.CoffeeService;
import com.suchaos.customerservice.model.Coffee;
import com.suchaos.customerservice.model.request.NewCoffeeRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * 对 Coffee 的一系列操作
 *
 * @author suchao
 * @date 2019/11/13
 */
@RestController
@RequestMapping("/coffee")
@Slf4j
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping(value = "/", params = "!name")
    //@HystrixCommand(fallbackMethod = "fallbackGetAllCoffee")
    public List<Coffee> getAll() {
        log.info("开始");
        List<Coffee> all = coffeeService.getAll();
        log.info("正常结束");
        return all;
    }

    public List<Coffee> fallbackGetAllCoffee() {
        log.error("CoffeeController: fall back for getAll");
        return Collections.emptyList();
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
        return coffeeService.saveCoffee(coffeeRequest);
    }
}
