package com.subway.dao.pavilionAuthor;


import com.subway.domain.pavilionAuthor.PavilionAuthor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by huangbin on 2016/1/8 0008.
 */
public interface PavilionAuthorRepository extends JpaRepository<PavilionAuthor,Long> {
    /**
     * 查询所有菜单
     */
    List<PavilionAuthor> findAll();

    /**
     * 根据状态查询所有菜单
     */
    List<PavilionAuthor> findByStatus(String status);


    /**
     * 根据id查询会员信息
     */
    PavilionAuthor findById(Long id);


    /**
     * @param name 会员名称
     * @return 根据会员名称模糊查询
     */
    List<PavilionAuthor> findByNameContaining(String name);



    /**
     * @param name 会员名称
     * @return 根据会员名称模糊查询
     */
    Page<PavilionAuthor> findByNameContaining(String name, Pageable pageable);

}
