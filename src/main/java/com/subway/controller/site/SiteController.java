package com.subway.controller.site;


import com.subway.controller.common.BaseController;
import com.subway.domain.app.MyPage;
import com.subway.domain.pavilionWorks.PavilionWorks;
import com.subway.domain.site.Site;
import com.subway.service.site.SiteSearchService;
import com.subway.service.site.SiteService;
import com.subway.utils.PageUtils;
import com.subway.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
 * 站点控制器
 */
@Controller
@RequestMapping(value = "/site")
public class SiteController extends BaseController {

    @Autowired
    SiteService siteService;

    @Autowired
    SiteSearchService  siteSearchService;

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
        String location = SessionUtil.getCurrentUserLocationBySession(session);
        Map<String, String[]> parameterMap = request.getParameterMap();
        Pageable pageable = new PageRequest(current - 1, rowCount.intValue(), super.getSort(parameterMap));
        return new PageUtils().searchBySortService(siteSearchService, searchPhrase, 1, current, rowCount, pageable);
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
        List<Site> dataList = siteService.findAll();
        siteSearchService.setDataList(dataList);
        siteSearchService.exportExcel(request, response, docName, titles, colNames);
    }
}
