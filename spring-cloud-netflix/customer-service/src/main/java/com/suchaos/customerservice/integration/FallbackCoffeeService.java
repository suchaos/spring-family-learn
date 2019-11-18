package com.suchaos.customerservice.integration;

import com.suchaos.customerservice.model.Coffee;
import com.suchaos.customerservice.model.request.NewCoffeeRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * fall back for coffee service
 *
 * @author suchao
 * @date 2019/11/18
 */
@Component
@Slf4j
public class FallbackCoffeeService implements CoffeeService {
    @Override
    public List<Coffee> getAll() {
        log.error("FallbackCoffeeService: fall back for getAll");
        log.error("熔断结束");
        return Collections.emptyList();
    }

    @Override
    public Coffee getById(Long id) {
        log.error("FallbackCoffeeService: fall back for getById");
        return null;
    }

    @Override
    public Coffee getByName(String name) {
        return null;
    }

    @Override
    public Coffee saveCoffee(@Valid NewCoffeeRequest coffeeRequest) {
        return null;
    }
}
