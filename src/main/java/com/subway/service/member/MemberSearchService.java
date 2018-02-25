package com.subway.service.member;

import com.subway.dao.member.MemberRepository;
import com.subway.domain.member.Member;
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
public class MemberSearchService extends BaseService implements SortedSearchable {

    @Autowired
    MemberRepository memberRepository;

    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public List<Member> findByConditions(String searchPhrase, int paramsSize) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return memberRepository.findByNameContaining(array[0]);
    }

    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public Page<Member> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return memberRepository.findByNameContaining(array[0], pageable);
    }


}
