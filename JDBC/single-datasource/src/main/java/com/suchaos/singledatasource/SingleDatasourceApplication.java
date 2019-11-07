package com.suchaos.singledatasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Spring 单数据源配置演示
 *
 * @author suchao
 * @date 2019/11/07
 */
@SpringBootApplication
@Slf4j
public class SingleDatasourceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SingleDatasourceApplication.class, args);
    }

    @Autowired
	private DataSource dataSource;

    @Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		showConnection();
		showData();
	}

	private void showConnection(){
		log.info(dataSource.toString());
		try (Connection connection = dataSource.getConnection();) {
			log.info(connection.toString());
		} catch (SQLException e) {
			log.error("connection exception", e);
		}
	}

	private void showData() {
		jdbcTemplate.queryForList("SELECT * FROM FOO")
				.forEach(row -> log.info(row.toString()));
	}
}
