package com.subway.${className};

import java.util.List;
import java.util.Map;

import com.subway.dao. ${className}. ${className?cap_first}Repository;
import com.subway.domain. ${className}. ${className?cap_first};
import com.subway.service.app.BaseService;
import com.subway.utils.search.SortedSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class  ${className?cap_first}SearchService extends BaseService implements SortedSearchable {

@Autowired
${className?cap_first}Repository  ${className}Repository;


public List< ${className?cap_first}> findByConditions(String searchPhrase, int paramsSize) {
String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
return  ${className}Repository.findAll();
}


public Page< ${className?cap_first}> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
return  ${className}Repository.findAll( pageable);
}

}