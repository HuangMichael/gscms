package com.subway.member;

import com.subway.service.app.BaseService;
import com.subway.utils.search.SortedSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员查询类
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class MemberSearchService extends BaseService implements SortedSearchable {

    @Autowired
    MemberRepository memberRepository;


    /**
     * @param searchPhrase 搜索关键字
     * @param paramsSize
     * @return
     */
    public List<Member> findByConditions(String searchPhrase, int paramsSize) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return memberRepository.findByNameContains(array[0]);
    }


    /**
     * @param searchPhrase 搜索关键字
     * @param paramsSize
     * @param pageable
     * @return
     */
    public Page<Member> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return memberRepository.findByNameContains(array[0], pageable);
    }

}