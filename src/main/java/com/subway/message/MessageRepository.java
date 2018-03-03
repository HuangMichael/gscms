package com.subway.message;


import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 留言信息数据库访问接口
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */

public interface MessageRepository extends JpaRepository<Message, Long> {


}
