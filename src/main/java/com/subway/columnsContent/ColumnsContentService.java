package com.subway.columnsContent;

import java.util.List;
import java.util.Map;

import com.subway.object.ReturnObject;
import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import com.subway.service.commonData.CommonDataService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class ColumnsContentService extends BaseService {


    @Autowired
    ColumnsContentRepository columnsContentRepository;


    @Autowired
    CommonDataService commonDataService;

    /**
     * @return
     */
    public List<ColumnsContent> findAll() {
        return columnsContentRepository.findAll();
    }


    /**
     * @param pageable
     * @return
     */
    public Page<ColumnsContent> findAll(Pageable pageable) {
        return columnsContentRepository.findAll(pageable);
    }


    /**
     * @param id
     * @return
     */
    public ReturnObject delete(Long id) {
        columnsContentRepository.delete(id);
        ColumnsContent columnsContent = columnsContentRepository.getOne(id);
        return commonDataService.getReturnType(columnsContent == null, "记录删除成功", "记录删除失败");
    }


    /**
     * @param id
     * @return
     */
    public ColumnsContent findById(Long id) {
        return columnsContentRepository.getOne(id);
    }

}
