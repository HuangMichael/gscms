package com.subway.location;
import com.subway.service.app.BaseService;
import com.subway.utils.search.SortedSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* 位置信息业务查询类
*
* @author huangbin
* @generate by autoCode
* @Date 2018-3-1
*/
@Service
public class  LocationSearchService extends BaseService implements SortedSearchable {

@Autowired
LocationRepository  locationRepository;


public List< Location> findByConditions(String searchPhrase, int paramsSize) {
String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
return  locationRepository.findAll();
}


public Page< Location> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
return  locationRepository.findAll( pageable);
}

}