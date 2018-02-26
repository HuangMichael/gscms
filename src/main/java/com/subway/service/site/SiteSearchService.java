package com.subway.service.site;

import com.subway.dao.site.SiteRepository;
import com.subway.domain.site.Site;
import com.subway.service.app.BaseService;
import com.subway.utils.search.SortedSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 站点信息接口
 */
@Service
public class SiteSearchService extends BaseService implements SortedSearchable {
    @Autowired
    SiteRepository siteRepository;

    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public List<Site> findByConditions(String searchPhrase, int paramsSize) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return siteRepository.findByNameContaining(array[0]);
    }

    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public Page<Site> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return siteRepository.findByNameContaining(array[0], pageable);
    }
}
