package com.subway.dao.columns;


import com.subway.domain.columns.Columns;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by huangbin on 2016/1/8 0008.
 */
public interface ColumnsRepository extends CrudRepository<Columns, Long>, PagingAndSortingRepository<Columns, Long> {
    /**
     * 查询所有菜单
     */
    List<Columns> findAll();

    /**
     * 根据状态查询所有菜单
     */
    List<Columns> findByStatus(String status);


    /**
     * 根据id查询会员信息
     */
    Columns findById(Long id);


    /**
     * @param name 会员名称
     * @return 根据会员名称模糊查询
     */
    List<Columns> findByNameContaining(String name);



    /**
     * @param name 会员名称
     * @return 根据会员名称模糊查询
     */
    Page<Columns> findByNameContaining(String name, Pageable pageable);

}
