package com.suchaos.jdbc.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Foo 对应数据库的一个对象
 *
 * @author suchao
 * @date 2019/11/7
 */
@Data
@Builder
public class Foo {
    private Long id;
    private String bar;
}
