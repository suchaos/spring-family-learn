package com.suchaos.jpa.dao;

import com.suchaos.jpa.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * 测试 {@link PersonRepository}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    private Long id;

    /**
     * 保存 person 到数据库
     */
    @Before
    public void setUp() {
        assertNotNull(personRepository);
        Person person = Person.builder().name("zhangsan").age(23).build();
        Person savedPerson = personRepository.save(person);
        // 更新 person 的姓名
        savedPerson.setName("UpdataZSName");
        personRepository.save(savedPerson);

        id = savedPerson.getId();
    }


    @Test
    public void getPerson() {
        Optional<Person> byId = personRepository.findById(id);
        assertTrue(byId.isPresent());
        assertEquals("UpdataZSName", byId.get().getName());
        assertEquals(Integer.valueOf(23), byId.get().getAge());
    }
}