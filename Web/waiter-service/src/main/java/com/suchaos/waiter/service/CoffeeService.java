package com.suchaos.waiter.service;

import com.suchaos.waiter.mapper.auto.CoffeeMapper;
import com.suchaos.waiter.model.auto.Coffee;
import com.suchaos.waiter.model.auto.CoffeeExample;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 增删改 Coffee 种类
 *
 * @author suchao
 * @date 2019/11/13
 */
@Service
@CacheConfig(cacheNames = "CoffeeCache")
public class CoffeeService {

    @Autowired
    private CoffeeMapper coffeeMapper;

    @Cacheable
    public List<Coffee> getAll() {
        return coffeeMapper.selectByExample(null);
    }

    @Cacheable(unless="#result == null")
    public Coffee getByName(String name) {
        CoffeeExample example = new CoffeeExample();
        CoffeeExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        List<Coffee> coffees = coffeeMapper.selectByExample(example);
        if (coffees.size() > 0) {
            return coffees.get(0);
        } else {
            return null;
        }
    }

    @Cacheable(unless="#result == null")
    public Coffee getById(Long id) {
        return coffeeMapper.selectByPrimaryKey(id);
    }

    @CacheEvict(allEntries = true)
    public Coffee saveCoffee(String name, Money price) {
        Coffee coffee = new Coffee().withName(name).withPrice(price)
                .withCreateTime(LocalDateTime.now())
                .withUpdateTime(LocalDateTime.now());
        coffeeMapper.insert(coffee);
        return coffee;
    }

}
