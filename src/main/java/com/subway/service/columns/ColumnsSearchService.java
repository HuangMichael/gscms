package com.subway.service.columns;

import com.subway.dao.columns.ColumnsRepository;
import com.subway.domain.columns.Columns;
import com.subway.service.app.BaseService;
import com.subway.utils.search.SortedSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设备新置查询业务类
 */
@Service
public class ColumnsSearchService extends BaseService implements SortedSearchable {

    @Autowired
    ColumnsRepository columnsRepository;

    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public List<Columns> findByConditions(String searchPhrase, int paramsSize) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return columnsRepository.findByNameContaining(array[0]);
    }

    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public Page<Columns> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return columnsRepository.findByNameContaining(array[0], pageable);
    }


}
