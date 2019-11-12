package com.suchaos.param.binding.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.suchaos.param.binding.support.JodaMoneyDeserializer;
import lombok.Data;
import org.joda.money.Money;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * 实体类
 *
 * @author suchao
 * @date 2019/11/12
 */
@Data
public class Coffee {

    private String name;

    //@JsonDeserialize(using = JodaMoneyDeserializer.class)
    private Money price;

    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate date;
}
