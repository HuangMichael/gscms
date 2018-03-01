package com.subway.message;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 留言管理业务类
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class MessageService extends BaseService {


    @Autowired
    MessageRepository messageRepository;

    public List <Message> findAll() {
        return messageRepository.findAll();
    }


    public Page<Message> findAll(Pageable pageable) {
        return messageRepository.findAll(pageable);
    }


    public Message findById(Long id) {
        return messageRepository.getOne(id);
    }

}
