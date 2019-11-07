package com.suchaos.transaction.service;

import com.suchaos.transaction.exception.RollbackException;

/**
 * FooService 接口
 *
 * @author suchao
 * @date 2019/11/7
 */
public interface FooService {

    void insertRecord();

    void insertThenRollback() throws RollbackException;

    void invokeInsertThenRollback() throws RollbackException;

    /*
        这两个方法是用来比较 REQUIRES_NEW v.s. NESTED 这两种事务传播的不同的
     */

    default void inner() {
    }

    default void outer() {
    }

}
