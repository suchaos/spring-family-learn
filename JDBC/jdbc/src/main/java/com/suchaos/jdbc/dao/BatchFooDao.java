package com.suchaos.jdbc.dao;

import com.suchaos.jdbc.domain.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 批量插入
 *
 * @author suchao
 * @date 2019/11/7
 */
@Repository
public class BatchFooDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void jdbcTemplateBatchInsert() {
        jdbcTemplate.batchUpdate("insert into foo(bar) values(?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, "jdbcTemplateBatchInsert-" + i);
            }

            @Override
            public int getBatchSize() {
                return 2;
            }
        });
    }

    public void namedParameterJdbcTemplateBatchInsert() {
        List<Foo> list = new ArrayList<>();
        list.add(Foo.builder().bar("b-100").build());
        list.add(Foo.builder().bar("b-101").build());
        namedParameterJdbcTemplate
                .batchUpdate("insert into foo (bar) values (:bar)",
                        SqlParameterSourceUtils.createBatch(list));
    }
}
