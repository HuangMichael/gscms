package com.subway.service.memberWorks;

import com.subway.dao.memberWorks.MemberWorksRepository;
import com.subway.domain.memberWorks.MemberWorks;
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
public class PavilionWorksSearchService extends BaseService implements SortedSearchable {

    @Autowired
    MemberWorksRepository memberWorksRepository;

    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public List<MemberWorks> findByConditions(String searchPhrase, int paramsSize) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return memberWorksRepository.findByNameContaining(array[0]);
    }

    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public Page<MemberWorks> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return memberWorksRepository.findByNameContaining(array[0], pageable);
    }


}
