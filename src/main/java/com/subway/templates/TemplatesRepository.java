package com.subway.templates;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 模板管理数据库访问接口
*  huangbin
*/


public interface TemplatesRepository extends JpaRepository<Templates, Long> {


}
