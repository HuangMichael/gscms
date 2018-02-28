package com.subway.message;

import com.subway.controller.common.BaseController;
import com.subway.domain.app.MyPage;
import com.subway.service.app.ResourceService;
import com.subway.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * 留言管理控制器类
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/message")
public class MessageController extends BaseController {

    @Autowired
    ResourceService resourceService;
    @Autowired
    MessageService messageService;
    @Autowired
    MessageSearchService messageSearchService;

    /**
     * 分页查询
     *
     * @param session
     * @param request
     * @param current      当前页
     * @param rowCount     每页条数
     * @param searchPhrase 查询关键字
     * @return
     */
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public MyPage data(HttpSession session, HttpServletRequest request, @RequestParam(value = "current", defaultValue = "0") int current, @RequestParam(value = "rowCount", defaultValue = "10") Long rowCount, @RequestParam(value = "searchPhrase", required = false) String searchPhrase) {
        Map
                <String, String[]> parameterMap = request.getParameterMap();
        Pageable pageable = new PageRequest(current - 1, rowCount.intValue(), super.getSort(parameterMap));
        return new PageUtils().searchBySortService(messageSearchService, searchPhrase, 1, current, rowCount, pageable);
    }


    /**
     * @param id 留言管理id
     * @return 根据留言管理id查询
     */
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Message findById(@PathVariable("id") Long id) {
        return messageService.findById(id);
    }
}
