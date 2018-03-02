package com.subway.tableConfig;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
* 数据表配置业务类
*
* @author huangbin
* @generate by autoCode
* @Date 2018-3-1
*/
@Service
public class TableConfigService extends BaseService {


@Autowired
TableConfigRepository tableConfigRepository;

public List
<TableConfig> findAll() {
return  tableConfigRepository.findAll();
}



public Page< TableConfig> findAll(Pageable pageable) {
return  tableConfigRepository.findAll(pageable);
}


public  TableConfig findById(Long id) {
return  tableConfigRepository.getOne(id);
}

}
