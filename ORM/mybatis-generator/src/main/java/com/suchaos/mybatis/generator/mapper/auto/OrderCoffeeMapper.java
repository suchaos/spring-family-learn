package com.suchaos.mybatis.generator.mapper.auto;

import com.suchaos.mybatis.generator.model.auto.OrderCoffeeExample;
import com.suchaos.mybatis.generator.model.auto.OrderCoffeeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OrderCoffeeMapper {
    long countByExample(OrderCoffeeExample example);

    int deleteByExample(OrderCoffeeExample example);

    int deleteByPrimaryKey(OrderCoffeeKey key);

    int insert(OrderCoffeeKey record);

    int insertSelective(OrderCoffeeKey record);

    List<OrderCoffeeKey> selectByExampleWithRowbounds(OrderCoffeeExample example, RowBounds rowBounds);

    List<OrderCoffeeKey> selectByExample(OrderCoffeeExample example);

    int updateByExampleSelective(@Param("record") OrderCoffeeKey record, @Param("example") OrderCoffeeExample example);

    int updateByExample(@Param("record") OrderCoffeeKey record, @Param("example") OrderCoffeeExample example);
}