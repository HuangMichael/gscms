package com.subway.${subDirName};

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
public class ${className}Service extends BaseService {


@Autowired
${className}Repository ${subDirName}Repository;

public List
<${className}> findAll() {
return  ${subDirName}Repository.findAll();
}



public Page< ${className}> findAll(Pageable pageable) {
return  ${subDirName}Repository.findAll(pageable);
}


public  ${className} findById(Long id) {
return  ${subDirName}Repository.getOne(id);
}

}
