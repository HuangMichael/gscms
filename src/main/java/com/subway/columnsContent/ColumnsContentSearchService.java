package com.subway.columnsContent;

import com.subway.service.app.BaseService;
import com.subway.utils.ConstantUtils;
import com.subway.utils.search.SortedSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容查询
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class ColumnsContentSearchService extends BaseService implements SortedSearchable {

    @Autowired
    ColumnsContentRepository columnsContentRepository;


    /**
     * @param searchPhrase 搜索关键字组合
     * @param paramsSize
     * @return
     */
    public List<ColumnsContent> findByConditions(String searchPhrase, int paramsSize) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return columnsContentRepository.findByTitleContainingAndStatus(array[0], ConstantUtils.STATUS_YES);
    }


    /**
     * @param searchPhrase 搜索关键字组合
     * @param paramsSize
     * @param pageable
     * @return
     */
    public Page<ColumnsContent> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return columnsContentRepository.findByTitleContainingAndStatus(array[0], ConstantUtils.STATUS_YES, pageable);
    }

}