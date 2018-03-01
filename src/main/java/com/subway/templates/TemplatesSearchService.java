package com.subway.templates;

import java.util.List;
import java.util.Map;

import com.subway.dao. templates. TemplatesRepository;
import com.subway.domain. templates. Templates;
import com.subway.service.app.BaseService;
import com.subway.utils.search.SortedSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
* 模板管理查询业务类
*  huangbin
*/

@Service
public class  TemplatesSearchService extends BaseService implements SortedSearchable {

@Autowired
TemplatesRepository  templatesRepository;

/**
* @param searchPhrase
* @param paramsSize
* @return
*/
public List< Templates> findByConditions(String searchPhrase, int paramsSize) {
String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
return  templatesRepository.findAll();
}

/**
* @param searchPhrase
* @param paramsSize
* @return
*/
public Page< Templates> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
return  templatesRepository.findAll( pageable);
}

}