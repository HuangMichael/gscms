package com.subway.templates;

import com.subway.controller.common.BaseController;
import com.subway.domain.app.MyPage;
import com.subway.service.app.ResourceService;
import com.subway.templates.TemplatesSearchService;
import com.subway.templates.TemplatesService;
import com.subway.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


/**
 * 模板管理控制器类
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/templates")
public class TemplatesController extends BaseController {

    @Autowired
    ResourceService resourceService;
    @Autowired
    TemplatesService templatesService;
    @Autowired
    TemplatesSearchService templatesSearchService;

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
        Map<String, String[]> parameterMap = request.getParameterMap();
        Pageable pageable = new PageRequest(current - 1, rowCount.intValue(), super.getSort(parameterMap));
        return new PageUtils().searchBySortService(templatesSearchService, searchPhrase, 1, current, rowCount, pageable);
    }


    /**
     * @param id 模板管理id
     * @return 根据模板管理id查询
     */
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Templates findById(@PathVariable("id") Long id) {
        return templatesService.findById(id);
    }

    /**
     * @param request  请求
     * @param response 响应
     * @param param    查询关键字
     * @param docName  文档名称
     * @param titles   标题集合
     * @param colNames 列名称
     */
    @ResponseBody
    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public void exportExcel(HttpServletRequest request, HttpServletResponse response, @RequestParam("param") String param, @RequestParam("docName") String docName, @RequestParam("titles") String titles[], @RequestParam("colNames") String[] colNames) {
        List<Templates> dataList = templatesSearchService.findByConditions(param, 2);
        templatesService.setDataList(dataList);
        templatesService.exportExcel(request, response, docName, titles, colNames);
    }


}
