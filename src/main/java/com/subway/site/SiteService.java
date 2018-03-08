package com.subway.site;

import java.util.List;
import java.util.Map;

import com.subway.member.Member;
import com.subway.object.ReturnObject;
import com.subway.service.app.BaseService;
import com.subway.service.commonData.CommonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 站点管理涓氬姟绫?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class SiteService extends BaseService {


    @Autowired
    SiteRepository siteRepository;


    @Autowired

    CommonDataService commonDataService;

    /**
     * @return
     */
    public List<Site> findAll() {
        return siteRepository.findAll();
    }


    /**
     * @param pageable
     * @return
     */
    public Page<Site> findAll(Pageable pageable) {
        return siteRepository.findAll(pageable);
    }


    /**
     * @param id
     * @return
     */
    public Site findById(Long id) {
        return siteRepository.getOne(id);
    }


    /**
     * @param id id
     * @return 根据id删除对象
     */
    public ReturnObject delete(Long id) {
        siteRepository.delete(id);
        Site site = siteRepository.getOne(id);
        return commonDataService.getReturnType(site == null, "记录删除成功", "记录删除失败");
    }

}
