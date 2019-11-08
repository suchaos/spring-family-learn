package com.suchaos.jpa.service;

import com.suchaos.jpa.dao.CoffeeOrderRepository;
import com.suchaos.jpa.dao.CoffeeRepository;
import com.suchaos.jpa.model.Coffee;
import com.suchaos.jpa.model.CoffeeOrder;
import com.suchaos.jpa.model.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringBucksService
 *
 * @author suchao
 * @date 2019/11/8
 */
@Service
@Slf4j
public class SpringBucksService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    @Transactional(rollbackFor = RuntimeException.class)
    public void initOrders() {
        Coffee espresso = Coffee.builder().name("espresso").
                price(Money.of(CurrencyUnit.of("CNY"), 20.0)).build();
        coffeeRepository.save(espresso);
        log.info("Coffee: " + espresso);

        Coffee latte = Coffee.builder().name("latte").
                price(Money.of(CurrencyUnit.of("CNY"), 22.0)).build();
        coffeeRepository.save(latte);
        log.info("Coffee: " + latte);

        CoffeeOrder order = CoffeeOrder.builder().customer("Li si").items(Collections.singletonList(espresso))
                .state(OrderState.INIT).build();
        coffeeOrderRepository.save(order);
        log.info("Order: " + order);

        order = CoffeeOrder.builder().customer("Wang wu").items(Arrays.asList(espresso, latte))
                .state(OrderState.INIT).build();
        coffeeOrderRepository.save(order);
        log.info("Order: " + order);
    }

    @Transactional(readOnly = true)
    public void readOrders() {
        coffeeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))
                .forEach(coffee -> log.info("Loading {}", coffee));

        List<CoffeeOrder> list = coffeeOrderRepository.findTop3ByOrderByUpdateTimeDescIdAsc();
        log.info("findTop3ByOrderByUpdateTimeDescIdAsc: {}", getJoinedOrderId(list));

        list = coffeeOrderRepository.findByCustomerOrderById("Wang wu");
        log.info("findByCustomerOrderById: {}", getJoinedOrderId(list));

        list.forEach(order -> {
            log.info("Order: {}", order.getId());
            order.getItems().forEach(item -> log.info("    Item {}", item));
        });

        list = coffeeOrderRepository.findByItems_Name("latte");
        log.info("findByItems_Name: {}", getJoinedOrderId(list));
    }

    private String getJoinedOrderId(List<CoffeeOrder> list) {
        return list.stream().map(o -> o.getId().toString())
                .collect(Collectors.joining(","));
    }
}
