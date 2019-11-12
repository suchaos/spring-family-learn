package com.suchaos.context.hierarchy;

import com.suchaos.context.hierarchy.bean.TestBean;
import com.suchaos.context.hierarchy.config.ChildConfig;
import com.suchaos.context.hierarchy.config.ParentConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@Slf4j
public class ContextHierarchyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ContextHierarchyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApplicationContext parentContext = new AnnotationConfigApplicationContext(ParentConfig.class);
		ConfigurableApplicationContext childContext = new AnnotationConfigApplicationContext(ChildConfig.class);
		childContext.setParent(parentContext);

		TestBean bean = parentContext.getBean("testBeanX", TestBean.class);
		bean.hello();
		log.info("=======================================");

		bean = childContext.getBean("testBeanX", TestBean.class);
		bean.hello();
		log.info("=======================================");

		bean = parentContext.getBean("testBeanY", TestBean.class);
		bean.hello();
	}
}
