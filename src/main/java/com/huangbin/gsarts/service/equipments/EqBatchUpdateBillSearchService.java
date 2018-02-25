package com.huangbin.gsarts.service.equipments;

import com.huangbin.gsarts.dao.equipments.EqBatchUpdateBillRepository;
import com.huangbin.gsarts.domain.equipments.EqBatchUpdateBill;
import com.huangbin.gsarts.utils.search.SortedSearchable;
import com.huangbin.gsarts.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 设备批量更新申请单
 * by huangbin 2017年6月21日16:31:59
 */
@Service
public class EqBatchUpdateBillSearchService extends BaseService implements SortedSearchable {

    @Autowired
    EqBatchUpdateBillRepository eqBatchUpdateBillRepository;
    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public List<EqBatchUpdateBill> findByConditions(String searchPhrase, int paramsSize) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return eqBatchUpdateBillRepository.findByEqClass_CnameContainsAndLocations_LocNameContains(array[0], array[1]);
    }

    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public Page<EqBatchUpdateBill> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return  eqBatchUpdateBillRepository.findByEqClass_CnameContainsAndLocations_LocNameContains(array[0], array[1],pageable);
    }


}
