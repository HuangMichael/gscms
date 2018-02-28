package com.subway.message;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 留言管理数据库访问接口
*  huangbin
*/


public interface MessageRepository extends JpaRepository<Message, Long> {


}
