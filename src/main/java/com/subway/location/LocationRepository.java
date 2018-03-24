package com.subway.location;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;


/**
* 位置信息数据库访问接口
*
* @author huangbin
* @generate by autoCode
* @Date 2018-3-1
*/

public interface LocationRepository extends JpaRepository<Location, Long> {


}
