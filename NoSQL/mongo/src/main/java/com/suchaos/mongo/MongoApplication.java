package com.suchaos.mongo;

import com.mongodb.client.result.UpdateResult;
import com.suchaos.mongo.convert.MoneyReadConvert;
import com.suchaos.mongo.model.Coffee;
import com.suchaos.mongo.repositoty.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author suchao
 * @date 2019/11/9
 */
@SpringBootApplication
@Slf4j
// 是为了 repository 生效，和 MongoTemplate 无关
@EnableMongoRepositories
public class MongoApplication implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(Collections.singletonList(new MoneyReadConvert()));
    }

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //testMongoTemplate();
        testCoffeeRepository();
    }

    private void testMongoTemplate() {
        Coffee coffee = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now()).build();
        Coffee saved = mongoTemplate.save(coffee);
        log.info("Coffee {}", saved);

        List<Coffee> list = mongoTemplate.find(Query.query(Criteria.where("name").is("espresso")), Coffee.class);
        log.info("Find {} Coffee", list.size());
        list.forEach(c -> log.info("Coffee {}", c));

        // 为了看更新时间
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        UpdateResult result = mongoTemplate.updateFirst(Query.query(Criteria.where("name").is("espresso")),
                new Update().set("price", Money.ofMajor(CurrencyUnit.of("CNY"), 30))
                        .currentDate("updateTime"), Coffee.class);
        log.info("Update Result: {}", result.getModifiedCount());
        Coffee byId = mongoTemplate.findById(saved.getId(), Coffee.class);
        log.info("Update Result: {}", byId);

        mongoTemplate.remove(byId);
    }

    private void testCoffeeRepository() {
        Coffee espresso = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now()).build();
        Coffee latte = Coffee.builder()
                .name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now()).build();

        coffeeRepository.insert(Arrays.asList(espresso, latte));
        coffeeRepository.findAll(Sort.by("name")).forEach(coffee -> log.info("Saved Coffee: {}", coffee));

        // 为了看更新时间
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        latte.setPrice(Money.of(CurrencyUnit.of("CNY"), 35.0));
        latte.setUpdateTime(LocalDateTime.now());
        coffeeRepository.save(latte);
        coffeeRepository.findByName("latte").forEach(coffee -> log.info("Coffee {}", coffee));

        coffeeRepository.deleteAll();
    }
}
