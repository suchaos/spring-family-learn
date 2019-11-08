package com.suchaos.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * BaseEntity 公共父类
 *
 * @author suchao
 * @date 2019/11/8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
