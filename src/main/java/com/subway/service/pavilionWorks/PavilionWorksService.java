package com.subway.service.pavilionWorks;

import com.subway.dao.pavilionWorks.PavilionWorksRepository;
import com.subway.domain.pavilionWorks.PavilionWorks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员信息接口
 */
@Service
public class PavilionWorksService {
    @Autowired
    PavilionWorksRepository pavilionWorksRepository;

    /**
     * @return 查询所有的会员
     */
    public List<PavilionWorks> findAll() {
        return pavilionWorksRepository.findAll();
    }


    /**
     * @return 查询所有的会员
     */
    public Page<PavilionWorks> findAll(Pageable pageable) {
        return pavilionWorksRepository.findAll(pageable);
    }


    /**
     * @return 查询所有的会员
     */
    public List<PavilionWorks> findByName(String name) {
        return pavilionWorksRepository.findByNameContaining(name);
    }


    /**
     * @param id
     * @return 根据ID查询会员
     */
    public PavilionWorks findById(Long id) {
        return pavilionWorksRepository.findById(id);
    }
}
