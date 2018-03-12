package com.subway.tableColumnConfig;

import com.subway.tableConfig.TableConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * �������������ݿ���ʽӿ�
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */

@Repository
public interface TableColumnConfigRepository extends JpaRepository<TableColumnConfig, Long> {


    /**
     * @param tableConfig
     * @param status
     * @return �������ò�ѯ����Ϣ
     */
    List<TableColumnConfig> findByTableConfigAndStatus(TableConfig tableConfig, String status);




    /**
     * @param colDesc
     * @param status
     * @return �������ò�ѯ����Ϣ
     */
    List<TableColumnConfig> findByColDescContainingAndStatus(String colDesc, String status);


    /**
     * @param colDesc
     * @param status
     * @param pageable
     * @return �������ò�ѯ����Ϣ
     */
    Page<TableColumnConfig> findByColDescContainingAndStatus(String colDesc, String status, Pageable pageable);
}
