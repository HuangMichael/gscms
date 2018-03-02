package com.subway.columns;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ’æµ„π‹¿Ì‰∏öÂä°Á±?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class ColumnsService extends BaseService {


    @Autowired
    ColumnsRepository columnsRepository;

    public List<Columns> findAll() {
        return columnsRepository.findAll();
    }


    public Page<Columns> findAll(Pageable pageable) {
        return columnsRepository.findAll(pageable);
    }


    public Columns findById(Long id) {
        return columnsRepository.getOne(id);
    }

}
