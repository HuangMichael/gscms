package com.subway.templates;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 模板管理业务类
 * huangbin
 */
@Service

public class TemplatesService extends BaseService {


    @Autowired
    TemplatesRepository templatesRepository;

    /**
     * @return 查询所有的模板管理
     */
    public List
            <Templates> findAll() {
        return templatesRepository.findAll();
    }


    /**
     * @return 查询所有的模板管理
     */
    public Page<Templates> findAll(Pageable pageable) {
        return templatesRepository.findAll(pageable);
    }


    /**
     * @param id
     * @return 根据ID查询模板管理
     */
    public Templates findById(Long id) {
        return templatesRepository.getOne(id);
    }

}
