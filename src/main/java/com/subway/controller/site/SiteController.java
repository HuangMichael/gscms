package com.subway.controller.site;


import com.subway.controller.common.BaseController;
import com.subway.domain.site.Site;
import com.subway.service.site.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 站点控制器
 */
@RestController
@RequestMapping(value = "/site")
public class SiteController extends BaseController {

    @Autowired
    SiteService siteService;


    /**
     * @return 保存站点信息
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Site save(@RequestParam("site") Site site) {
        return siteService.save(site);
    }


    /**
     * @return 查询所有的站点信息
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Site> findAll() {
        return siteService.findAll();
    }

    /**
     * @return 查询所有的站点信息d
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Site findById(@PathVariable Long id) {
        return siteService.findById(id);
    }


    /**
     * @return 查询所有的站点信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        siteService.delete(id);
    }


}
