package com.subway.${className};

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


@Controller
@EnableAutoConfiguration
@RequestMapping("/${className}")
public class ${className?cap_first}Controller extends BaseController {

@Autowired
ResourceService resourceService;
@Autowired
${className?cap_first}Service ${className}Service;
@Autowired
${className?cap_first}SearchService ${className}SearchService;



@RequestMapping(value = "/data", method = RequestMethod.POST)
@ResponseBody
public MyPage data(HttpSession session, HttpServletRequest request, @RequestParam(value = "current", defaultValue = "0") int current, @RequestParam(value = "rowCount", defaultValue = "10") Long rowCount, @RequestParam(value = "searchPhrase", required = false) String searchPhrase) {
Map
<String, String[]> parameterMap = request.getParameterMap();
Pageable pageable = new PageRequest(current - 1, rowCount.intValue(), super.getSort(parameterMap));
return new PageUtils().searchBySortService(${className}SearchService, searchPhrase, 1, current, rowCount, pageable);
}



@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
@ResponseBody
public ${className?cap_first} findById(@PathVariable("id") Long id) {
return ${className}Service.findById(id);
}


@ResponseBody
@RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
public void exportExcel(HttpServletRequest request, HttpServletResponse response, @RequestParam("param") String param, @RequestParam("docName") String docName, @RequestParam("titles") String titles[], @RequestParam("colNames") String[] colNames) {
List< ${className?cap_first}> dataList = ${className}SearchService.findByConditions(param, 2);
${className}Service.setDataList(dataList);
${className}Service.exportExcel(request, response, docName, titles, colNames);
}


}
