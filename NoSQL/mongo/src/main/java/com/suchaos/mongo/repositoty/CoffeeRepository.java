package com.suchaos.mongo.repositoty;

import com.suchaos.mongo.model.Coffee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * CoffeeRepository
 *
 * @author suchao
 * @date 2019/11/9
 */
public interface CoffeeRepository extends MongoRepository<Coffee, String> {
    List<Coffee> findByName(String name);
}
