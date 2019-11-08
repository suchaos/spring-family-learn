package com.suchaos.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 单号与 coffee 号的对应
 *
 * @author suchao
 * @date 2019/11/8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCoffee {

    private Long orderId;

    private Long cofferId;
}
