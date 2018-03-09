package com.subway.columns;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Õ¾µã¹ÜÀíæ•°æ®åº“è®¿é—®æ¥å?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */

public interface ColumnsRepository extends JpaRepository<Columns, Long> {


    /**
     * @param name
     * @return
     */
    List<Columns> findByNameContaining(String name);



    /**
     * @param name
     * @param pageable
     * @return
     */
    Page<Columns> findByNameContaining(String name, Pageable pageable);


}
