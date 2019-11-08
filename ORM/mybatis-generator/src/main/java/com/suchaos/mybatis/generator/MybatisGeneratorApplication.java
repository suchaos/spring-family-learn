package com.suchaos.mybatis.generator;

import com.github.pagehelper.PageHelper;
import com.suchaos.mybatis.generator.mapper.auto.CoffeeMapper;
import com.suchaos.mybatis.generator.model.auto.Coffee;
import com.suchaos.mybatis.generator.model.auto.CoffeeExample;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
@MapperScan("com.suchaos.mybatis.generator.mapper.auto")
public class MybatisGeneratorApplication implements CommandLineRunner {

    @Autowired
    private CoffeeMapper coffeeMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisGeneratorApplication.class, args);
    }


	@Override
	public void run(String... args) {
        CoffeeExample coffeeExample = new CoffeeExample();
        CoffeeExample.Criteria criteria = coffeeExample.createCriteria();
        criteria.andNameLike("san%");
        PageHelper.startPage(1, 2);
        List<Coffee> coffees = coffeeMapper.selectByExample(coffeeExample);
        coffees.forEach(coffee -> log.info("coffee: {}", coffee));
    }
}
