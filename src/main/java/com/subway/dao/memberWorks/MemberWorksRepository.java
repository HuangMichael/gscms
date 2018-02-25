package com.subway.dao.memberWorks;


import com.subway.domain.memberWorks.MemberWorks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by huangbin on 2016/1/8 0008.
 */
public interface MemberWorksRepository extends JpaRepository<MemberWorks,Long> {
    /**
     * 查询所有菜单
     */
    List<MemberWorks> findAll();

    /**
     * 根据状态查询所有菜单
     */
    List<MemberWorks> findByStatus(String status);


    /**
     * 根据id查询会员信息
     */
    MemberWorks findById(Long id);


    /**
     * @param name 会员名称
     * @return 根据会员名称模糊查询
     */
    List<MemberWorks> findByNameContaining(String name);



    /**
     * @param name 会员名称
     * @return 根据会员名称模糊查询
     */
    Page<MemberWorks> findByNameContaining(String name, Pageable pageable);

}
