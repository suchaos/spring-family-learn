package com.suchaos.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Person 实体类
 * <p>
 * 这个类只是为了简单演示 jpa 的演示，在测试类中
 *
 * @author suchao
 * @date 2019/11/8
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private Integer age;
}
