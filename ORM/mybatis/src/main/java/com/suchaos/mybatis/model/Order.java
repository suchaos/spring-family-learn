package com.suchaos.mybatis.model;

import lombok.*;

import java.util.List;

/**
 * CoffeeOrder 存储每次下的单，具体下单内容存在 OrderCoffee 中
 *
 * @author suchao
 * @date 2019/11/8
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order extends BaseEntity {

    private String customer;

    private OrderState state;

    private List<Coffee> coffees;
}
