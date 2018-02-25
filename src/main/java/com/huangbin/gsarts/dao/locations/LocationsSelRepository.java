package com.huangbin.gsarts.dao.locations;

import com.huangbin.gsarts.domain.locations.LocationsSel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by huangbin on 2016/3/15 0008.
 * 位置信息查询接口
 */
public interface LocationsSelRepository extends CrudRepository<LocationsSel, Long> {

    List<LocationsSel> findByStatus(String status);


}
