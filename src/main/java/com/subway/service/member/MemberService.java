package com.subway.service.member;

import com.subway.dao.member.MemberRepository;
import com.subway.domain.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员信息接口
 */
@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    /**
     * @return 查询所有的会员
     */
    public List<Member> findAll() {
        return memberRepository.findAll();
    }


    /**
     * @return 查询所有的会员
     */
    public Page<Member> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }


    /**
     * @return 查询所有的会员
     */
    public List<Member> findByName(String name) {
        return memberRepository.findByNameContaining(name);
    }


    /**
     * @param id
     * @return 根据ID查询会员
     */
    public Member findById(Long id) {
        return memberRepository.findById(id);
    }
}
