package com.suchaos.customerservice;

import com.suchaos.customerservice.integration.CoffeeService;
import com.suchaos.customerservice.model.Coffee;
import com.suchaos.customerservice.model.request.NewOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * CustomerRunner
 *
 * @author suchao
 * @date 2019/11/17
 */
@Slf4j
@Component
public class CustomerRunner implements ApplicationRunner {
    @Autowired
    private CoffeeService coffeeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        readMenu();
//        Long id = orderCoffee();
//        queryOrder(id);
    }

    private void readMenu() {
        List<Coffee> coffees = coffeeService.getAll();
        coffees.forEach(c -> log.info("Coffee: {}", c));
    }

//    private Long orderCoffee() {
//        NewOrderRequest orderRequest = NewOrderRequest.builder()
//                .customer("Li Lei")
//                .items(Arrays.asList("capuccino"))
//                .build();
//        CoffeeOrder order = coffeeOrderService.create(orderRequest);
//        log.info("Order ID: {}", order.getId());
//        return order.getId();
//    }
//
//    private void queryOrder(Long id) {
//        CoffeeOrder order = coffeeOrderService.getOrder(id);
//        log.info("Order: {}", order);
//    }
}
