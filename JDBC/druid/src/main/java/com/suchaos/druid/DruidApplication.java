package com.suchaos.druid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author suchao
 */
@SpringBootApplication
@Slf4j
public class DruidApplication implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;


	public static void main(String[] args) {
		SpringApplication.run(DruidApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(dataSource.toString());
		jdbcTemplate.queryForList("select * from foo").forEach(row -> log.info(row.toString()));
		jdbcTemplate.queryForList("select * from foo where id = (?)", 1).forEach(row -> log.info(row.toString()));
	}
}
