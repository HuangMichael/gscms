package com.subway.tableColumnConfig;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import com.subway.tableConfig.TableConfig;
import com.subway.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ����������ҵ����
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class TableColumnConfigService extends BaseService {


    @Autowired
    TableColumnConfigRepository tableColumnConfigRepository;

    public List<TableColumnConfig> findAll() {
        return tableColumnConfigRepository.findAll();
    }


    public Page<TableColumnConfig> findAll(Pageable pageable) {
        return tableColumnConfigRepository.findAll(pageable);
    }


    public TableColumnConfig findById(Long id) {
        return tableColumnConfigRepository.getOne(id);
    }


    /**
     * @param tableConfig ��������Ϣ
     * @return
     */
    public List<TableColumnConfig> findByTableConfigAndStatus(TableConfig tableConfig) {
        return tableColumnConfigRepository.findByTableConfigAndStatus(tableConfig, ConstantUtils.STATUS_YES);
    }

}
