package com.suchaos.param.binding.web;

import com.suchaos.param.binding.model.Coffee;
import org.joda.money.Money;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * CoffeeController
 *
 * @author suchao
 * @date 2019/11/12
 */
@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    /*
        localhost:8080/coffee/save
        Content-Type: application/x-www-form-urlencoded
        name: latte
        price: 15.00
     */

    @PostMapping("/save")
    public Coffee createCoffee(Coffee coffee) {
        return coffee;
    }

    /*
        localhost:8080/coffee/save?name=xxx&price=14
     */

    @GetMapping("/save2")
    public Money createCoffee2(Money money) {
        return money;
    }

    @RequestMapping("/save3")
    public Coffee createCoffee3(@RequestBody Coffee coffee) {
        return coffee;
    }
}
