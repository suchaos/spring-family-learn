package com.suchaos.jdbc.dao;

import com.suchaos.jdbc.domain.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * FooDao {@link Repository}
 *
 * @author suchao
 * @date 2019/11/7
 */
@Repository
@Slf4j
public class FooDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertData() {
        Arrays.asList("ccc", "ddd").forEach(bar -> {
            jdbcTemplate.update("insert into foo(bar) values(?)", bar);
        });
    }

    public void listData() {
        log.info("count: {}", jdbcTemplate.queryForObject("select count(*) from foo", Long.class));
        printLine();
        List<String> bars = jdbcTemplate.queryForList("select bar from foo", String.class);
        bars.forEach(bar -> log.info("bar: {}", bar));
        printLine();
        List<Foo> list = jdbcTemplate.query("select * from foo",
                (rs, rowNum) -> Foo.builder().
                        id(rs.getLong(1)).
                        bar(rs.getString(2)).
                        build());
        list.forEach(foo -> log.info("foo: {}", foo));
        printLine();
    }

    private static void printLine() {
        log.info("--------------------------------------------------------");
    }

}
