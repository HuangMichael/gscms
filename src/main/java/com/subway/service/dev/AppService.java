package com.subway.service.dev;

import com.subway.dao.dev.AppRepository;
import com.subway.dao.member.MemberRepository;
import com.subway.domain.dev.App;
import com.subway.domain.member.Member;
import com.subway.service.app.BaseService;
import com.subway.utils.autoCode.AutoGenerationJavaCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 应用信息接口
 */
@Service
public class AppService extends BaseService {
    @Autowired
    AppRepository appRepository;

    /**
     * @return 查询所有的应用
     */
    public List<App> findAll() {
        return appRepository.findAll();
    }


    /**
     * @return 查询所有的应用
     */
    public Page<App> findAll(Pageable pageable) {
        return appRepository.findAll(pageable);
    }


    /**
     * @return 查询所有的应用
     */
    public List<App> findByName(String name) {
        return appRepository.findByNameContaining(name);
    }


    /**
     * @param id
     * @return 根据ID查询应用
     */
    public App findById(Long id) {
        return appRepository.findById(id);
    }


    /**
     * @param id 自动编码
     */
    public void autoCode(Long id) {
        AutoGenerationJavaCode autoGenerationJavaCode = new AutoGenerationJavaCode("");
        //调用生成java代码方法
        try {
            autoGenerationJavaCode.autoGenerationJavaCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
