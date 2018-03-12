package com.subway.review;

import com.subway.columnsContent.ColumnsContent;
import com.subway.columnsContent.ColumnsContentRepository;
import com.subway.service.app.BaseService;
import com.subway.utils.ConstantUtils;
import com.subway.utils.search.SortedSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * �����б�业务查询�?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class ReviewSearchService extends BaseService implements SortedSearchable {

    @Autowired
    ColumnsContentRepository columnsContentRepository;


    /**
     * @param searchPhrase 搜索关键字组合
     * @param paramsSize
     * @return
     */
    public List<ColumnsContent> findByConditions(String searchPhrase, int paramsSize) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return columnsContentRepository.findByTitleContainingAndStatusAndAuditStatus(array[0], array[1], ConstantUtils.AUDIT_STATUS_0);
    }


    /**
     * @param searchPhrase 搜索关键字组合
     * @param paramsSize
     * @param pageable
     * @return
     */
    public Page<ColumnsContent> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return columnsContentRepository.findByTitleContainingAndStatusAndAuditStatus(array[0], array[1], ConstantUtils.AUDIT_STATUS_0, pageable);
    }

}