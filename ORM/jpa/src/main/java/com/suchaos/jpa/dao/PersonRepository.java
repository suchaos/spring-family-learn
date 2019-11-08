package com.suchaos.jpa.dao;

import com.suchaos.jpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository 接口
 *
 * @author suchao
 * @date 2019/11/8
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
