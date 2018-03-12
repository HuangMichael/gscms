package com.subway.columns;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 站点管理数据查询接口
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */

public interface ColumnsRepository extends JpaRepository<Columns, Long> {


    /**
     * @param name
     * @param status
     * @return
     */
    List<Columns> findByNameContainingAndStatus(String name, String status);


    /**
     * @param name
     * @param status
     * @param pageable
     * @return
     */
    Page<Columns> findByNameContainingAndStatus(String name, String status, Pageable pageable);


}
