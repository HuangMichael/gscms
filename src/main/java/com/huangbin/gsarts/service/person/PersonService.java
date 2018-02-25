package com.huangbin.gsarts.service.person;

import com.huangbin.gsarts.service.app.BaseService;
import com.huangbin.gsarts.utils.CommonStatusType;
import com.huangbin.gsarts.utils.RedisUtils;
import com.subway.dao.person.PersonRepository;
import com.huangbin.gsarts.domain.person.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人员业务类
 */
@Service
@Slf4j
public class PersonService extends BaseService {

    @Autowired
    PersonRepository personRepository;

    /**
     * @return 查询激活状态的人员
     */
    public List<Person> findActivePerson() {
        return personRepository.findByStatus(CommonStatusType.STATUS_YES);
    }


    /**
     * @return 查询所有人员
     */
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    /**
     * @param id
     * @return 根据人员id查询人员
     */
    public Person findById(Long id) {
        return personRepository.findById(id);
    }


    /**
     * @param person
     * @return 保存人员信息
     */
    public Person save(Person person) {
        Object str = RedisUtils.get("personList");
        person.setStatus("1");
        person = personRepository.save(person);
        if (str != null) {
            log.info("personList" + str.toString());
            RedisUtils.del("personList");
        }
        return personRepository.save(person);
    }


    /**
     * @param person
     * @return 更新人员信息
     */
    public Person update(Person person) {
        return personRepository.save(person);
    }


    /**
     * @param id
     * @return 删除人员信息
     */
    public boolean delete(Long id) {
        personRepository.delete(id);
        return (personRepository.findById(id) == null);
    }


    /**
     * @return 查询所有的id
     */

    public List<Long> selectAllId() {
        return personRepository.selectAllId();
    }


}
