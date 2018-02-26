package com.subway.controller.common;


import com.subway.domain.person.Person;
import com.subway.service.commonData.CommonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by huangbin on 2015/12/23 0023.
 * 创建通用数据的控制器 自动选择数据加载方式
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/commonData")
public class CommonDataController extends BaseController {
    @Autowired
    CommonDataService commonDataService;





    /**
     * @return 获得设备状态
     */
    @RequestMapping(value = "/findActivePerson", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> findActivePerson( ) {

//        return commonDataService.findActivePerson();

        return null;
    }


    /**
     * @return 获得服务器时间
     */
    @RequestMapping(value = "/getServerDate", method = RequestMethod.GET)
    @ResponseBody
    public String getServerDate() {
//        return commonDataService.getServerDate();

        return null;
    }

    /**
     * @param session 会话
     * @return 重载session值
     */
    @RequestMapping(value = "/reload", method = RequestMethod.GET)
    @ResponseBody
    public Boolean reload(HttpSession session) {
        boolean result = false;
//        User user = (User) session.getAttribute("currentUser");
//
//        if (user != null) {
//            result = commonDataService.reload(user, session);
//        }
        return result;
    }

}

