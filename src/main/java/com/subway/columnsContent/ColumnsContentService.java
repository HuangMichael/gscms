package com.subway.columnsContent;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ��Ŀ������Ϣҵ����
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class ColumnsContentService extends BaseService {


    @Autowired
    ColumnsContentRepository columnsContentRepository;

    public List<ColumnsContent> findAll() {
        return columnsContentRepository.findAll();
    }


    public Page<ColumnsContent> findAll(Pageable pageable) {
        return columnsContentRepository.findAll(pageable);
    }


    public ColumnsContent findById(Long id) {
        return columnsContentRepository.getOne(id);
    }

}
