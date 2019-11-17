package com.suchaos.customerservice.model.response;

import com.suchaos.customerservice.enumration.OrderState;
import com.suchaos.customerservice.model.Coffee;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    private OrderState state;

    private List<Coffee> items;
}
