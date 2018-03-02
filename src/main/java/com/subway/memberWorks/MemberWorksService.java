package com.subway.memberWorks;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 会员作品涓氬姟绫?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class MemberWorksService extends BaseService {


    @Autowired
    MemberWorksRepository memberWorksRepository;

    public List
            <MemberWorks> findAll() {
        return memberWorksRepository.findAll();
    }


    public Page<MemberWorks> findAll(Pageable pageable) {
        return memberWorksRepository.findAll(pageable);
    }


    public MemberWorks findById(Long id) {
        return memberWorksRepository.getOne(id);
    }

}
