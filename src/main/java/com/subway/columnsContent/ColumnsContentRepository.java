package com.subway.columnsContent;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 栏目内容信息数据库访问接口
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */

public interface ColumnsContentRepository extends JpaRepository<ColumnsContent, Long> {


    /**
     * @param title  标题
     * @param status 状态
     * @return
     */
    List<ColumnsContent> findByTitleContainingAndStatus(String title, String status);


    /**
     * @param title  标题
     * @param status 状态
     * @return
     */
    Page<ColumnsContent> findByTitleContainingAndStatus(String title, String status, Pageable pageable);
}
