package com.subway.message;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import com.subway.utils.search.SortedSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ���Թ����ѯҵ����
 * huangbin
 */

@Service
public class MessageSearchService extends BaseService implements SortedSearchable {

    @Autowired
    MessageRepository messageRepository;

    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public List<Message> findByConditions(String searchPhrase, int paramsSize) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return messageRepository.findAll();
    }

    /**
     * @param searchPhrase
     * @param paramsSize
     * @return
     */
    public Page<Message> findByConditions(String searchPhrase, int paramsSize, Pageable pageable) {
        String array[] = super.assembleSearchArray(searchPhrase, paramsSize);
        return messageRepository.findAll(pageable);
    }

}