package com.suchaos.jdbc;

import com.suchaos.jdbc.dao.BatchFooDao;
import com.suchaos.jdbc.dao.FooDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author suchao
 */
@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {

	@Autowired
	private FooDao fooDao;

	@Autowired
	private BatchFooDao batchFooDao;

	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//fooDao.insertData();
		//batchFooDao.jdbcTemplateBatchInsert();
		batchFooDao.namedParameterJdbcTemplateBatchInsert();
		fooDao.listData();
	}
}
