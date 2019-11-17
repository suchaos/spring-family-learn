package com.suchaos.waiter.support;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.joda.money.Money;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * JodaMoneySerializer
 *
 * @author suchao
 * @date 2019/11/12
 */
@JsonComponent
public class JodaMoneySerializer extends StdSerializer<Money> {

    protected JodaMoneySerializer() {
        super(Money.class);
    }

    @Override
    public void serialize(Money value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeNumber(value.getAmount());
    }
}
