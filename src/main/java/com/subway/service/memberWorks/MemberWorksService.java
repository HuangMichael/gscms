package com.subway.service.memberWorks;

import com.subway.dao.memberWorks.MemberWorksRepository;
import com.subway.domain.memberWorks.MemberWorks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员信息接口
 */
@Service
public class MemberWorksService {
    @Autowired
    MemberWorksRepository memberWorksRepository;

    /**
     * @return 查询所有的会员
     */
    public List<MemberWorks> findAll() {
        return memberWorksRepository.findAll();
    }


    /**
     * @return 查询所有的会员
     */
    public Page<MemberWorks> findAll(Pageable pageable) {
        return memberWorksRepository.findAll(pageable);
    }


    /**
     * @return 查询所有的会员
     */
    public List<MemberWorks> findByName(String name) {
        return memberWorksRepository.findByNameContaining(name);
    }


    /**
     * @param id
     * @return 根据ID查询会员
     */
    public MemberWorks findById(Long id) {
        return memberWorksRepository.findById(id);
    }
}
