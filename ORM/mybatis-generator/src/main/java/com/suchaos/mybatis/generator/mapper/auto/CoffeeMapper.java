package com.suchaos.mybatis.generator.mapper.auto;

import com.suchaos.mybatis.generator.model.auto.Coffee;
import com.suchaos.mybatis.generator.model.auto.CoffeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CoffeeMapper {
    long countByExample(CoffeeExample example);

    int deleteByExample(CoffeeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Coffee record);

    int insertSelective(Coffee record);

    List<Coffee> selectByExampleWithRowbounds(CoffeeExample example, RowBounds rowBounds);

    List<Coffee> selectByExample(CoffeeExample example);

    Coffee selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Coffee record, @Param("example") CoffeeExample example);

    int updateByExample(@Param("record") Coffee record, @Param("example") CoffeeExample example);

    int updateByPrimaryKeySelective(Coffee record);

    int updateByPrimaryKey(Coffee record);
}