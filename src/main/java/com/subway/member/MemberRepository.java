package com.subway.member;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * ��Ա����数据库访问接�?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */

public interface MemberRepository extends JpaRepository<Member, Long> {


    /**
     * @param name
     * @param authKey
     * @return
     */
    List<Member> findByNameAndAuthKey(String name,String authKey);





    /**
     * @param name
     * @param authKey
     * @param pageable
     * @return
     */
    Page<Member> findByNameAndAuthKey(String name, String authKey, Pageable pageable);


}
