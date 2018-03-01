package com.subway.templates;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ģ�����ҵ����
 * huangbin
 */
@Service

public class TemplatesService extends BaseService {


    @Autowired
    TemplatesRepository templatesRepository;

    /**
     * @return ��ѯ���е�ģ�����
     */
    public List
            <Templates> findAll() {
        return templatesRepository.findAll();
    }


    /**
     * @return ��ѯ���е�ģ�����
     */
    public Page<Templates> findAll(Pageable pageable) {
        return templatesRepository.findAll(pageable);
    }


    /**
     * @param id
     * @return ����ID��ѯģ�����
     */
    public Templates findById(Long id) {
        return templatesRepository.getOne(id);
    }

}
