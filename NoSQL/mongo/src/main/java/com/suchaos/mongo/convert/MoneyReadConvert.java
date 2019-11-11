package com.suchaos.mongo.convert;

import org.bson.Document;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;

/**
 * Document ----> Money 类型的转换
 *
 * @author suchao
 * @date 2019/11/9
 */
public class MoneyReadConvert implements Converter<Document, Money> {
    @Override
    public Money convert(Document source) {
        Document money = (Document) source.get("money");
        BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(money.getString("amount")));
        String currency = ((Document) money.get("currency")).getString("code");
        return Money.of(CurrencyUnit.of(currency), amount);
    }
}
