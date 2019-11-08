package com.suchaos.jpa.dao;

import com.suchaos.jpa.model.CoffeeOrder;

import java.util.List;

/**
 * CoffeeOrderRepository
 *
 * @author suchao
 * @date 2019/11/8
 */
public interface CoffeeOrderRepository extends BaseRepository<CoffeeOrder, Long> {

    List<CoffeeOrder> findByCustomerOrderById(String customer);

    List<CoffeeOrder> findByItems_Name(String name);
}
