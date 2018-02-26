package com.subway.service.columns;

import com.subway.dao.columns.ColumnsRepository;
import com.subway.domain.columns.Columns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员信息接口
 */
@Service
public class ColumnsService {
    @Autowired
    ColumnsRepository columnsRepository;

    /**
     * @return 查询所有的会员
     */
    public List<Columns> findAll() {
        return columnsRepository.findAll();
    }


    /**
     * @return 查询所有的会员
     */
    public Page<Columns> findAll(Pageable pageable) {
        return columnsRepository.findAll(pageable);
    }


    /**
     * @return 查询所有的会员
     */
    public List<Columns> findByName(String name) {
        return columnsRepository.findByNameContaining(name);
    }


    /**
     * @param id
     * @return 根据ID查询会员
     */
    public Columns findById(Long id) {
        return columnsRepository.findById(id);
    }
}
