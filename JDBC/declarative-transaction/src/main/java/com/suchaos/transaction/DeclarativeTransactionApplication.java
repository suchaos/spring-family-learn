package com.suchaos.transaction;

import com.suchaos.transaction.service.FooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author suchao
 */
@SpringBootApplication
//@EnableTransactionManagement 不需要这个注解了 ，
// TransactionAutoConfiguration 都已经做了这些工作了
@Slf4j
public class DeclarativeTransactionApplication implements CommandLineRunner {

    @Autowired
    private FooService fooService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DeclarativeTransactionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        fooService.insertRecord();
        log.info("aaa {}", jdbcTemplate.queryForObject("select count(*) from foo where bar='aaa'", Long.class));
        try {
            fooService.insertThenRollback();
        } catch (Exception e) {
            log.info("bbb {}", jdbcTemplate.queryForObject("select count(*) from foo where bar='bbb'", Long.class));
        }

        try {
            fooService.invokeInsertThenRollback();
        } catch (Exception e) {
            log.info("bbb {}", jdbcTemplate.queryForObject("select count(*) from foo where bar='bbb'", Long.class));
        }
    }
}
