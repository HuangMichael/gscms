package com.subway.member;

import java.util.List;
import java.util.Map;

import com.subway.object.ReturnObject;
import com.subway.service.app.BaseService;
import com.subway.service.commonData.CommonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ��Ա����业务�?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class MemberService extends BaseService {


    @Autowired
    MemberRepository memberRepository;


    @Autowired
    CommonDataService commonDataService;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }


    public Page<Member> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }


    public Member findById(Long id) {
        return memberRepository.getOne(id);
    }


    /**
     * @param id id
     * @return ����idɾ������
     */
    public ReturnObject delete(Long id) {
        memberRepository.delete(id);
        Member member = memberRepository.getOne(id);
        return commonDataService.getReturnType(member == null, "��¼ɾ���ɹ�", "��¼ɾ��ʧ��");
    }

}
