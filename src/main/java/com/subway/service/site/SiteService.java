package com.subway.service.site;

import com.subway.dao.site.SiteRepository;
import com.subway.domain.site.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 站点信息接口
 */
@Service
public class SiteService {
    @Autowired
    SiteRepository siteRepository;

    /**
     * @param site
     * @return 保存所有的站点
     */
    public Site save(Site site) {
        return siteRepository.save(site);
    }

    /**
     * @param id 根据ID删除
     */
    public void delete(Long id) {
        siteRepository.delete(id);

    }

    /**
     * @return 查询所有的站点
     */
    public List<Site> findAll() {

        return siteRepository.findAll();
    }

    /**
     * @param id
     * @return 根据ID查询站点
     */
    public Site findById(Long id) {
        return siteRepository.findById(id);
    }
}
