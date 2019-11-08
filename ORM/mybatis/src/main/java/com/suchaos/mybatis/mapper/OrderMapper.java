package com.suchaos.mybatis.mapper;

import com.suchaos.mybatis.model.Coffee;
import com.suchaos.mybatis.model.Order;
import org.apache.ibatis.annotations.*;

/**
 * OrderMapper
 *
 * @author suchao
 * @date 2019/11/8
 */
@Mapper
public interface OrderMapper {

    @Insert("insert into t_mybatis_order (customer, state, create_time, update_time)"
            + "values (#{customer}, #{state}, now(), now())")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int save(Order order);

    @Select("select * from t_mybatis_order where id = #{id}")
    Order findById(@Param("id") Long id);
}
