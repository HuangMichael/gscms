package com.subway.review;

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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
* ³õÉóÁÐ±íæŽ§åˆ¶å™¨ç±»
*
* @author huangbin
* @generate by autoCode
* @Date 2018-3-1
*/
@Controller
@EnableAutoConfiguration
@RequestMapping("/review")
public class ReviewController extends BaseController {

@Autowired
ResourceService resourceService;
@Autowired
ReviewService reviewService;
@Autowired
ReviewSearchService reviewSearchService;


@RequestMapping(value = "/data", method = RequestMethod.POST)
@ResponseBody
public MyPage data(HttpSession session, HttpServletRequest request, @RequestParam(value = "current", defaultValue = "0") int current, @RequestParam(value = "rowCount", defaultValue = "10") Long rowCount, @RequestParam(value = "searchPhrase", required = false) String searchPhrase) {
Map
<String, String[]> parameterMap = request.getParameterMap();
Pageable pageable = new PageRequest(current - 1, rowCount.intValue(), super.getSort(parameterMap));
return new PageUtils().searchBySortService(reviewSearchService, searchPhrase, 1, current, rowCount, pageable);
}


@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
@ResponseBody
public Review findById(@PathVariable("id") Long id) {
return reviewService.findById(id);
}


@ResponseBody
@RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
public void exportExcel(HttpServletRequest request, HttpServletResponse response, @RequestParam("param") String param, @RequestParam("docName") String docName, @RequestParam("titles") String titles[], @RequestParam("colNames") String[] colNames) {
List< Review> dataList = reviewSearchService.findByConditions(param, 2);
reviewService.setDataList(dataList);
reviewService.exportExcel(request, response, docName, titles, colNames);
}


}
