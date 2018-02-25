package com.huangbin.gsarts.dao.app.sysLog;

import com.huangbin.gsarts.domain.app.sysLog.SysLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by huangbin on 2016/12/6.
 */
public interface SysLogRepository extends CrudRepository<SysLog, Long>, PagingAndSortingRepository<SysLog, Long> {


}
