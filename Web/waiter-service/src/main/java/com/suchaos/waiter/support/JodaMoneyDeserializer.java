package com.suchaos.waiter.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * JodaMoneyDeserializer
 *
 * @author suchao
 * @date 2019/11/12
 */
@JsonComponent
public class JodaMoneyDeserializer extends StdDeserializer<Money> {

    protected JodaMoneyDeserializer() {
        super(Money.class);
    }

    @Override
    public Money deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        // 如果只传入一个数字
        return Money.of(CurrencyUnit.of("CNY"), jp.getDecimalValue());
        // 传入一个对象，包含 currency 和 amount
//        ObjectCodec oc = jp.getCodec();
//        JsonNode node = oc.readTree(jp);
//
//        String currency = node.get("currency").asText();
//        BigDecimal amount = node.get("amount").decimalValue();
//        return Money.of(CurrencyUnit.of(currency), amount);
    }
}


//public class JodaMoneyDeserializer extends JsonDeserializer<Money> {
//    @Override
//    public Money deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
//        String text = jp.getText();
//        if (NumberUtils.isParsable(text)) {
//            return Money.of(CurrencyUnit.of("CNY"), NumberUtils.createBigDecimal(text));
//        } else if (StringUtils.isNotEmpty(text)) {
//            String[] split = StringUtils.split(text, " ");
//            if (split != null && split.length == 2 && NumberUtils.isParsable(split[1])) {
//                return Money.of(CurrencyUnit.of(split[0]),
//                        NumberUtils.createBigDecimal(split[1]));
//            }
//        }
//        throw new RuntimeException("JodaMoneyDeserializer");
//    }
//}
