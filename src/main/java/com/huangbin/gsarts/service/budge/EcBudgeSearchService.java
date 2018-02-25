package com.huangbin.gsarts.service.budge;

import com.huangbin.gsarts.dao.budget.VecbudgetBillRepository;
import com.huangbin.gsarts.domain.EcBudget.VEcBudgetBill;
import com.huangbin.gsarts.service.app.BaseService;
import com.huangbin.gsarts.utils.search.SortedSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangbin on 2016/11/21.
 * 易耗品查询
 */
@Service
public class EcBudgeSearchService extends BaseService implements SortedSearchable {

    @Autowired
    VecbudgetBillRepository vecbudgetBillRepository;

    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public List<VEcBudgetBill> findByConditions(String searchPhrase, int paramsSize) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return vecbudgetBillRepository.findByApplyDateBetweenAndEcnameContainsAndLocationContains(array[0], array[1], array[2], array[3]);
    }

    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public Page<VEcBudgetBill> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return vecbudgetBillRepository.findByApplyDateBetweenAndEcnameContainsAndLocationContains(array[0], array[1], array[2], array[3], pageable);
    }

}
