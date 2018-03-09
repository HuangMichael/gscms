package com.subway.message;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 留言信息数据库访问接口
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */

public interface MessageRepository extends JpaRepository<Message, Long> {

    /**
     * @param content
     * @return
     */
    List<Message> findByContentContaining(String content);

    /**
     * @param content
     * @param pageable
     * @return
     */
    Page<Message> findByContentContaining(String content, Pageable pageable);
}
