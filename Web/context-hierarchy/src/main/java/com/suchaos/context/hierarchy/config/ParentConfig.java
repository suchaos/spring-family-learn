package com.suchaos.context.hierarchy.config;

import com.suchaos.context.hierarchy.aspect.TestAspect;
import com.suchaos.context.hierarchy.bean.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 父容器配置
 *
 * @author suchao
 * @date 2019/11/12
 */
@Configuration
@EnableAspectJAutoProxy
public class ParentConfig {

    @Bean
    public TestBean testBeanX() {
        return new TestBean("parent bean X");
    }

    @Bean
    public TestBean testBeanY() {
        return new TestBean("parent bean Y");
    }

    @Bean
    public TestAspect testAspect() {
        return new TestAspect();
    }
}
