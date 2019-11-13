package com.suchaos.waiter.service;

import com.suchaos.waiter.controller.response.NewOrderResponse;
import com.suchaos.waiter.enumration.OrderState;
import com.suchaos.waiter.mapper.auto.CoffeeMapper;
import com.suchaos.waiter.mapper.auto.OrderCoffeeMapper;
import com.suchaos.waiter.mapper.auto.OrderMapper;
import com.suchaos.waiter.model.auto.Coffee;
import com.suchaos.waiter.model.auto.Order;
import com.suchaos.waiter.model.auto.OrderCoffee;
import com.suchaos.waiter.model.auto.OrderCoffeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 下单服务
 *
 * @author suchao
 * @date 2019/11/13
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderCoffeeMapper orderCoffeeMapper;

    @Autowired
    private CoffeeMapper coffeeMapper;

    @Transactional
    public Order saveOrder(String customer, List<Long> coffees) {
        Order order = new Order().withState(OrderState.INIT).withCustomer(customer)
                .withCreateTime(LocalDateTime.now())
                .withUpdateTime(LocalDateTime.now());
        orderMapper.insert(order);
        coffees.forEach(coffeeId -> {
            OrderCoffee orderCoffee = new OrderCoffee().withCoffeeId(coffeeId).withOrderId(order.getId());
            orderCoffeeMapper.insert(orderCoffee);
        });
        return order;
    }

    @Transactional(readOnly = true)
    public NewOrderResponse getOrder(Long id) {
        Order order = orderMapper.selectByPrimaryKey(id);

        OrderCoffeeExample orderCoffeeExample = new OrderCoffeeExample();
        OrderCoffeeExample.Criteria criteria = orderCoffeeExample.createCriteria();
        criteria.andOrderIdEqualTo(order.getId());
        List<OrderCoffee> orderCoffees = orderCoffeeMapper.selectByExample(orderCoffeeExample);

        List<Coffee> coffees = new ArrayList<>();
        orderCoffees.forEach( orderCoffee -> {
            Coffee coffee = coffeeMapper.selectByPrimaryKey(orderCoffee.getCoffeeId());
            coffees.add(coffee);
        });
        NewOrderResponse response = NewOrderResponse.builder()
                .customer(order.getCustomer())
                .id(order.getId())
                .state(order.getState())
                .items(coffees)
                .build();
        return response;
    }
}
