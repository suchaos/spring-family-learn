package com.suchaos.jpa.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Order
 *
 * @author suchao
 * @date 2019/11/8
 */
@Entity
@Table(name = "T_ORDER")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeOrder extends BaseEntity {

    private String customer;

    @ManyToMany
    @JoinTable(name = "T_ORDER_COFFEE")
    private List<Coffee> items;

    @Column(nullable = false)
    @Enumerated
    private OrderState state;
}
