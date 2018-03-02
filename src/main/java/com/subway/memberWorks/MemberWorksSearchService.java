package com.subway.memberWorks;

import com.subway.service.app.BaseService;
import com.subway.utils.search.SortedSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ��Ա��Ʒ业务查询�?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class MemberWorksSearchService extends BaseService implements SortedSearchable {

    @Autowired
    MemberWorksRepository memberWorksRepository;


    public List<MemberWorks> findByConditions(String searchPhrase, int paramsSize) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return memberWorksRepository.findAll();
    }


    public Page<MemberWorks> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return memberWorksRepository.findAll(pageable);
    }

}