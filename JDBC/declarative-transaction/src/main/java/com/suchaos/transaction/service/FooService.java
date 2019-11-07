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
}
