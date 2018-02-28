package com.subway.message;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ���Թ���ҵ����
 * huangbin
 */
@Service

public class MessageService extends BaseService {


    @Autowired
    MessageRepository messageRepository;

    /**
     * @return ��ѯ���е����Թ���
     */
    public List
            <Message> findAll() {
        return messageRepository.findAll();
    }


    /**
     * @return ��ѯ���е����Թ���
     */
    public Page<Message> findAll(Pageable pageable) {
        return messageRepository.findAll(pageable);
    }


    /**
     * @param id
     * @return ����ID��ѯ���Թ���
     */
    public Message findById(Long id) {
        return messageRepository.getOne(id);
    }

}
