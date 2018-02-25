package com.subway.service.pavilionAuthor;

import com.subway.dao.pavilionAuthor.PavilionAuthorRepository;
import com.subway.domain.pavilionAuthor.PavilionAuthor;
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
public class PavilionAuthorSearchService extends BaseService implements SortedSearchable {

    @Autowired
    PavilionAuthorRepository pavilionAuthorRepository;

    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public List<PavilionAuthor> findByConditions(String searchPhrase, int paramsSize) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return pavilionAuthorRepository.findByNameContaining(array[0]);
    }

    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public Page<PavilionAuthor> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return pavilionAuthorRepository.findByNameContaining(array[0], pageable);
    }


}
