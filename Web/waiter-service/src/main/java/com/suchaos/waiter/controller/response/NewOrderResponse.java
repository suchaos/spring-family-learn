package com.suchaos.waiter.controller.response;

import com.suchaos.waiter.model.auto.Coffee;
import lombok.*;

import java.util.List;

/**
 * Response for create order
 *
 * @author suchao
 * @date 2019/11/13
 */
@Getter
@Setter
@ToString
@Builder
public class NewOrderResponse {

    private Long id;

    private String customer;

    private Integer state;

    private List<Coffee> items;
}
