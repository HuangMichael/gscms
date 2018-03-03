package com.subway.pavilionWorks;

import com.subway.service.app.BaseService;
import com.subway.utils.search.SortedSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * չ����Ʒ��Ϣҵ���ѯ��
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class PavilionWorksSearchService extends BaseService implements SortedSearchable {

    @Autowired
    PavilionWorksRepository pavilionWorksRepository;


    public List<PavilionWorks> findByConditions(String searchPhrase, int paramsSize) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return pavilionWorksRepository.findAll();
    }


    public Page<PavilionWorks> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return pavilionWorksRepository.findAll(pageable);
    }

}