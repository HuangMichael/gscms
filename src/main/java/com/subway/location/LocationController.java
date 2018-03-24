package com.subway.location;

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
import com.subway.object.ReturnObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
* 位置信息
*
* @author huangbin
* @generate by autoCode
* @Date 2018-3-1
*/
@Controller
@EnableAutoConfiguration
@RequestMapping("/location")
public class LocationController extends BaseController {

@Autowired
ResourceService resourceService;
@Autowired
LocationService locationService;
@Autowired
LocationSearchService locationSearchService;


@RequestMapping(value = "/data", method = RequestMethod.POST)
@ResponseBody
public MyPage data(HttpSession session, HttpServletRequest request, @RequestParam(value = "current", defaultValue = "0") int current, @RequestParam(value = "rowCount", defaultValue = "10") Long rowCount, @RequestParam(value = "searchPhrase", required = false) String searchPhrase) {
Map
<String, String[]> parameterMap = request.getParameterMap();
Pageable pageable = new PageRequest(current - 1, rowCount.intValue(), super.getSort(parameterMap));
return new PageUtils().searchBySortService(locationSearchService, searchPhrase, 1, current, rowCount, pageable);
}


@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
@ResponseBody
public Location findById(@PathVariable("id") Long id) {
return locationService.findById(id);
}


/**
* @param id
* @return 删除信息
*/
@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
@ResponseBody
public ReturnObject delete(@PathVariable("id") Long id) {
return locationService.delete(id);
}




@ResponseBody
@RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
public void exportExcel(HttpServletRequest request, HttpServletResponse response, @RequestParam("param") String param, @RequestParam("docName") String docName, @RequestParam("titles") String titles[], @RequestParam("colNames") String[] colNames) {
List< Location> dataList = locationSearchService.findByConditions(param, 2);
locationService.setDataList(dataList);
locationService.exportExcel(request, response, docName, titles, colNames);
}


}
