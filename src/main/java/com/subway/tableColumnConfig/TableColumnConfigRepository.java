package com.subway.tableColumnConfig;

import com.subway.tableConfig.TableConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 数据列配置数据库访问接口
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */

public interface TableColumnConfigRepository extends JpaRepository<TableColumnConfig, Long> {


    /**
     * @param tableConfig
     * @param status
     * @return 根据配置查询列信息
     */
    List<TableColumnConfig> findByTableConfigAndStatus(TableConfig tableConfig, String status);
}
