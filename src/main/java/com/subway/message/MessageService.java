package com.subway.message;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import com.subway.service.commonData.CommonDataService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.subway.object.ReturnObject;

/**
 * ������Ϣҵ����
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class MessageService extends BaseService {


    @Autowired
    MessageRepository messageRepository;


    @Autowired
    CommonDataService commonDataService;

//    /**
//     * @return
//     */
//    public List<Message> findAll() {
//        return messageRepository.findAll();
//    }
//
//
//    /**
//     * @param pageable
//     * @return
//     */
//    public Page<Message> findAll(Pageable pageable) {
//        return messageRepository.findAll(pageable);
//    }


    /**
     * @param id
     * @return
     */
    public ReturnObject delete(Long id) {
        messageRepository.delete(id);
        Message message = messageRepository.getOne(id);
        return commonDataService.getReturnType(message == null, "记录删除成功", "记录删除失败");
    }


    /**
     * @param id
     * @return
     */
    public Message findById(Long id) {
        return messageRepository.getOne(id);
    }

}
