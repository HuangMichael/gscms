package com.subway.dao.member;


import com.subway.domain.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by huangbin on 2016/1/8 0008.
 */
public interface MemberRepository extends CrudRepository<Member, Long>, PagingAndSortingRepository<Member, Long> {
    /**
     * 查询所有菜单
     */
    List<Member> findAll();

    /**
     * 根据状态查询所有菜单
     */
    List<Member> findByStatus(String status);


    /**
     * 根据id查询会员信息
     */
    Member findById(Long id);


    /**
     * @param name 会员名称
     * @return 根据会员名称模糊查询
     */
    List<Member> findByNameContaining(String name);



    /**
     * @param name 会员名称
     * @return 根据会员名称模糊查询
     */
    Page<Member> findByNameContaining(String name, Pageable pageable);

}
