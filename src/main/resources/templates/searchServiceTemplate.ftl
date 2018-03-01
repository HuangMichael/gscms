package com.subway.${className};
import com.subway.service.app.BaseService;
import com.subway.utils.search.SortedSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* ${comment}业务查询类
*
* @author huangbin
* @generate by autoCode
* @Date 2018-3-1
*/
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