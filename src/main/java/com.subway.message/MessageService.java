package com.subway.message;

import java.util.List;
import java.util.Map;

/**
* 留言管理业务类
*  huangbin
*/
@Service

public class MessageService extends BaseService {


@Autowired
MessageRepository MessageRepository;

/**
* @return 查询所有的留言管理
*/
public List<Member> findAll() {
    return  messageRepository.findAll();
    }


    /**
    * @return 查询所有的留言管理
    */
    public Page< Message> findAll(Pageable pageable) {
        return  messageRepository.findAll(pageable);
        }


        /**
        * @return 查询所有的留言管理
        */
        public List< Message> findByName(String name) {
            return  messageRepository.findByNameContaining(name);
            }


            /**
            * @param id
            * @return 根据ID查询留言管理
            */
            public  Message findById(Long id) {
            return  messageRepository.findById(id);
            }

}
