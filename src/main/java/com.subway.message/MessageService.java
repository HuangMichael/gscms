package com.subway.message;

import java.util.List;
import java.util.Map;

/**
* ���Թ���ҵ����
*  huangbin
*/
@Service

public class MessageService extends BaseService {


@Autowired
MessageRepository MessageRepository;

/**
* @return ��ѯ���е����Թ���
*/
public List<Member> findAll() {
    return  messageRepository.findAll();
    }


    /**
    * @return ��ѯ���е����Թ���
    */
    public Page< Message> findAll(Pageable pageable) {
        return  messageRepository.findAll(pageable);
        }


        /**
        * @return ��ѯ���е����Թ���
        */
        public List< Message> findByName(String name) {
            return  messageRepository.findByNameContaining(name);
            }


            /**
            * @param id
            * @return ����ID��ѯ���Թ���
            */
            public  Message findById(Long id) {
            return  messageRepository.findById(id);
            }

}
