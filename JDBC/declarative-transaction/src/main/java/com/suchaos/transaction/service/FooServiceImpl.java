package com.suchaos.transaction.service;

import com.suchaos.transaction.exception.RollbackException;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.AopProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * FooService 实现类
 *
 * @author suchao
 * @date 2019/11/7
 */
@Component
public class FooServiceImpl implements FooService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void insertRecord() {
        jdbcTemplate.execute("insert into foo (bar) values ('aaa')");
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("insert into foo (bar) values ('bbb')");
        throw new RollbackException();
    }

    /*
        方法内部调用，要是想要起作用的话，需要真正调用代理对象
            1. 直接注入一个实例，然后调用
            2. AopContext.currentProxy() 得到代理对象
     */

    @Override
    public void invokeInsertThenRollback() throws RollbackException {
        insertThenRollback();
    }
}
