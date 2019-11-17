package com.suchaos.waiter.mapper.auto;

import com.suchaos.waiter.model.auto.OrderCoffee;
import com.suchaos.waiter.model.auto.OrderCoffeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OrderCoffeeMapper {
    long countByExample(OrderCoffeeExample example);

    int deleteByExample(OrderCoffeeExample example);

    int deleteByPrimaryKey(@Param("orderId") Long orderId, @Param("coffeeId") Long coffeeId);

    int insert(OrderCoffee record);

    int insertSelective(OrderCoffee record);

    List<OrderCoffee> selectByExampleWithRowbounds(OrderCoffeeExample example, RowBounds rowBounds);

    List<OrderCoffee> selectByExample(OrderCoffeeExample example);

    int updateByExampleSelective(@Param("record") OrderCoffee record, @Param("example") OrderCoffeeExample example);

    int updateByExample(@Param("record") OrderCoffee record, @Param("example") OrderCoffeeExample example);
}