package com.suchaos.context.hierarchy.bean;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 待增强的 Bean
 *
 * @author suchao
 * @date 2019/11/12
 */
@AllArgsConstructor
@Slf4j
public class TestBean {

    private String context;

    public void hello() {
        log.info("hello {}", context);
    }
}
