package com.subway.dao.site;

import com.subway.domain.site.Site;
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
}
