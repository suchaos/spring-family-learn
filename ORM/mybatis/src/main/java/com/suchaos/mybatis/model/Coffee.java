package com.suchaos.mybatis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.joda.money.Money;

import java.time.LocalDateTime;

/**
 * Coffee
 *
 * @author suchao
 * @date 2019/11/8
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coffee extends BaseEntity {

    private String name;

    private Money price;
}
