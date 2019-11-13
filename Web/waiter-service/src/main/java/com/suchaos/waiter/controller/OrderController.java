package com.suchaos.waiter.controller;

import com.suchaos.waiter.controller.request.NewCoffeeRequest;
import com.suchaos.waiter.controller.request.NewOrderRequest;
import com.suchaos.waiter.controller.response.NewOrderResponse;
import com.suchaos.waiter.mapper.auto.OrderMapper;
import com.suchaos.waiter.model.auto.Order;
import com.suchaos.waiter.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 下单操作
 *
 * @author suchao
 * @date 2019/11/13
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public Order saveOrder(@Valid @RequestBody NewOrderRequest orderRequest) {
        log.info(orderRequest.toString());
        return orderService.saveOrder(orderRequest.getCustomer(), orderRequest.getItems());
    }

    @GetMapping("/{id}")
    public NewOrderResponse getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

}
