package com.subway.dao.pavilionWorks;


import com.subway.domain.pavilionWorks.PavilionWorks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by huangbin on 2016/1/8 0008.
 */
public interface PavilionWorksRepository extends JpaRepository<PavilionWorks,Long> {
    /**
     * 查询所有菜单
     */
    List<PavilionWorks> findAll();

    /**
     * 根据状态查询所有菜单
     */
    List<PavilionWorks> findByStatus(String status);


    /**
     * 根据id查询会员信息
     */
    PavilionWorks findById(Long id);


    /**
     * @param name 会员名称
     * @return 根据会员名称模糊查询
     */
    List<PavilionWorks> findByNameContaining(String name);



    /**
     * @param name 会员名称
     * @return 根据会员名称模糊查询
     */
    Page<PavilionWorks> findByNameContaining(String name, Pageable pageable);

}
