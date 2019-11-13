package com.suchaos.waiter.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 新的咖啡订单
 *
 * @author suchao
 * @date 2019/11/13
 */
@Getter
@Setter
@ToString
public class NewOrderRequest {

    @NotEmpty
    private String customer;

    @NotNull
    private List<Long> items;
}
