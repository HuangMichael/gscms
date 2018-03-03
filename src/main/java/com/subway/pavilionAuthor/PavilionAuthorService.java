package com.subway.pavilionAuthor;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 展馆作者信息业务类
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class PavilionAuthorService extends BaseService {


    @Autowired
    PavilionAuthorRepository pavilionAuthorRepository;

    public List<PavilionAuthor> findAll() {
        return pavilionAuthorRepository.findAll();
    }


    public Page<PavilionAuthor> findAll(Pageable pageable) {
        return pavilionAuthorRepository.findAll(pageable);
    }


    public PavilionAuthor findById(Long id) {
        return pavilionAuthorRepository.getOne(id);
    }

}
