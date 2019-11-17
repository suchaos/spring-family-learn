package com.suchaos.waiter.handler;

import com.suchaos.waiter.enumration.OrderState;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link OrderState} 和 数据库进行的类型转换
 *
 * @author suchao
 * @date 2019/11/13
 */
public class OrderStateTypeHandler extends BaseTypeHandler<OrderState> {

    private final Map<Integer, OrderState> enumMap;

    public OrderStateTypeHandler() {
        OrderState[] orderStates = OrderState.values();
        this.enumMap = new HashMap<>(orderStates.length);
        for (OrderState orderState : orderStates) {
            this.enumMap.put(orderState.getState(), orderState);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OrderState parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getState());
    }

    @Override
    public OrderState getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return this.enumMap.get(rs.getInt(columnName));
    }

    @Override
    public OrderState getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return this.enumMap.get(rs.getInt(columnIndex));
    }

    @Override
    public OrderState getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return this.enumMap.get(cs.getInt(columnIndex));
    }
}
