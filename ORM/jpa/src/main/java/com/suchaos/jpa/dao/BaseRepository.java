package com.suchaos.jpa.dao;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * BaseRepository
 *
 * @author suchao
 * @date 2019/11/8
 */
@NoRepositoryBean
public interface BaseRepository<T, Long> extends PagingAndSortingRepository<T, Long> {

    List<T> findTop3ByOrderByUpdateTimeDescIdAsc();
}
