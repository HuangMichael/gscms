package com.subway.${className};

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
* ${comment}业务类
*
* @author huangbin
* @generate by autoCode
* @Date 2018-3-1
*/
@Service
public class ${className?cap_first}Service extends BaseService {


@Autowired
${className?cap_first}Repository ${className}Repository;

public List
<${className?cap_first}> findAll() {
return  ${className}Repository.findAll();
}



public Page< ${className?cap_first}> findAll(Pageable pageable) {
return  ${className}Repository.findAll(pageable);
}


public  ${className?cap_first} findById(Long id) {
return  ${className}Repository.getOne(id);
}

}
