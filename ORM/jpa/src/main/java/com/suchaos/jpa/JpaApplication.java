package com.suchaos.jpa;

import com.suchaos.jpa.service.SpringBucksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author suchao
 */
@SpringBootApplication
@EnableJpaRepositories
public class JpaApplication implements CommandLineRunner {

	@Autowired
	private SpringBucksService springBucksService;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		springBucksService.initOrders();
		springBucksService.readOrders();
	}
}
