package com.subway.member;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 会员管理鏁版嵁搴撹闂帴鍙?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */

public interface MemberRepository extends JpaRepository<Member, Long> {


    /**
     * @param name
     * @return
     */
    List<Member> findByNameContains(String name);





    /**
     * @param name
     * @param pageable
     * @return
     */
    Page<Member>  findByNameContains(String name, Pageable pageable);


}
