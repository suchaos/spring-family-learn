package com.suchaos.context.hierarchy.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 切面
 *
 * @author suchao
 * @date 2019/11/12
 */
@Aspect
@Slf4j
public class TestAspect {

    @AfterReturning("bean(testBean*)")
    public void printAfter() {
        log.info("after hello()");
    }
}
