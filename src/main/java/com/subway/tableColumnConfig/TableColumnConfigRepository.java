package com.subway.tableColumnConfig;

import com.subway.tableConfig.TableConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * �������������ݿ���ʽӿ�
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */

public interface TableColumnConfigRepository extends JpaRepository<TableColumnConfig, Long> {


    /**
     * @param tableConfig
     * @param status
     * @return �������ò�ѯ����Ϣ
     */
    List<TableColumnConfig> findByTableConfigAndStatus(TableConfig tableConfig, String status);
}
