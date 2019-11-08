package com.suchaos.mybatis;

import com.suchaos.mybatis.mapper.CoffeeMapper;
import com.suchaos.mybatis.mapper.OrderMapper;
import com.suchaos.mybatis.model.Coffee;
import com.suchaos.mybatis.model.Order;
import com.suchaos.mybatis.model.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
@MapperScan("com.suchaos.mybatis.mapper")
public class MybatisApplication implements CommandLineRunner {

    @Autowired
    private CoffeeMapper coffeeMapper;

    @Autowired
    private OrderMapper orderMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testEnumInMybatis();
    }

    private void testMoneyAndLocalDateTimeInMybatis() {
        Coffee c = Coffee.builder().name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0)).build();
        int count = coffeeMapper.save(c);
        log.info("Save {} Coffee: {}", count, c);

        c = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 25.0)).build();
        count = coffeeMapper.save(c);
        log.info("Save {} Coffee: {}", count, c);

        c = coffeeMapper.findById(c.getId());
        log.info("Find Coffee: {}", c);
    }

    private void testEnumInMybatis() {
        Order jackOrder = Order.builder().customer("jack").state(OrderState.INIT).build();
        orderMapper.save(jackOrder);

        jackOrder = orderMapper.findById(jackOrder.getId());
        log.info("JackOrder: {}", jackOrder);
    }
}
