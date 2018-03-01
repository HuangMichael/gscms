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
*  huangbin
*/
@Service

public class MessageService extends BaseService {


@Autowired
MessageRepository messageRepository;

/**
* @return 查询所有的留言管理
*/
public List
<Message> findAll() {
return  messageRepository.findAll();
}


/**
* @return 查询所有的留言管理
*/
public Page< Message> findAll(Pageable pageable) {
return  messageRepository.findAll(pageable);
}


/**
* @param id
* @return 根据ID查询留言管理
*/
public  Message findById(Long id) {
return  messageRepository.getOne(id);
}

}
