package com.subway.columns;

import com.subway.service.app.BaseService;
import com.subway.utils.search.SortedSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ’æµ„π‹¿Ì‰∏öÂä°Êü•ËØ¢Á±?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class ColumnsSearchService extends BaseService implements SortedSearchable {

    @Autowired
    ColumnsRepository columnsRepository;


    public List<Columns> findByConditions(String searchPhrase, int paramsSize) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return columnsRepository.findAll();
    }


    public Page<Columns> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return columnsRepository.findAll(pageable);
    }

}