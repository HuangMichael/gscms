package com.subway.pavilionWorks;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 展馆作品信息业务类
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class PavilionWorksService extends BaseService {


    @Autowired
    PavilionWorksRepository pavilionWorksRepository;

    public List<PavilionWorks> findAll() {
        return pavilionWorksRepository.findAll();
    }


    public Page<PavilionWorks> findAll(Pageable pageable) {
        return pavilionWorksRepository.findAll(pageable);
    }


    public PavilionWorks findById(Long id) {
        return pavilionWorksRepository.getOne(id);
    }

}
