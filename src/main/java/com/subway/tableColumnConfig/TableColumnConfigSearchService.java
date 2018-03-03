package com.subway.tableColumnConfig;

import com.subway.service.app.BaseService;
import com.subway.utils.search.SortedSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ����������ҵ���ѯ��
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class TableColumnConfigSearchService extends BaseService implements SortedSearchable {

    @Autowired
    TableColumnConfigRepository tableColumnConfigRepository;


    public List<TableColumnConfig> findByConditions(String searchPhrase, int paramsSize) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return tableColumnConfigRepository.findAll();
    }


    public Page<TableColumnConfig> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return tableColumnConfigRepository.findAll(pageable);
    }

}