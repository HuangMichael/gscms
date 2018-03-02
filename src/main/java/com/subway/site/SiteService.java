package com.subway.site;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ’æµ„π‹¿Ì‰∏öÂä°Á±?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class SiteService extends BaseService {


    @Autowired
    SiteRepository siteRepository;

    public List<Site> findAll() {
        return siteRepository.findAll();
    }


    public Page<Site> findAll(Pageable pageable) {
        return siteRepository.findAll(pageable);
    }


    public Site findById(Long id) {
        return siteRepository.getOne(id);
    }

}
