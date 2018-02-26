package com.subway.dao.site;

import com.subway.domain.site.Site;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 站点信息接口
 */
@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {

    /**
     * @return 查询所有的站点
     */
    List<Site> findAll();

    /**
     * @param id
     * @return 根据ID查询站点
     */
    Site findById(Long id);


    /**
     * @param name  站点名称
     * @return 根据站点名称查询
     */
    List<Site> findByNameContaining(String name);


    /**
     * @param name     站点名称
     * @param pageable 根据站点名称查询
     * @return
     */
    Page<Site> findByNameContaining(String name, Pageable pageable);
}
