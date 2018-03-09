package com.subway.memberWorks;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 会员作品
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */

public interface MemberWorksRepository extends JpaRepository<MemberWorks, Long> {


    /**
     * @param name   名称
     * @param status 状态
     * @return 根据名称模糊查询  根据状态过滤
     */
    List<MemberWorks> findByNameContainingAndStatus(String name, String status);


    /**
     * @param name     名称
     * @param status   状态
     * @param pageable 分页
     * @return 根据名称模糊查询  根据状态过滤
     */
    Page<MemberWorks> findByNameContainingAndStatus(String name, String status, Pageable pageable);


}
