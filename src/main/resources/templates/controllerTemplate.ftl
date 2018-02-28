package com.subway.${className};

import com.subway.controller.common.BaseController;
import com.subway.domain.app.MyPage;
import com.subway.service.app.ResourceService;
import com.subway.${className}.${className?cap_first}SearchService;
import com.subway.${className}.${className?cap_first}Service;
import com.subway.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


/**
*${comment}控制器类
*/
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
return new PageUtils().searchBySortService(${className}SearchService, searchPhrase, 1, current, rowCount, pageable);
}
}
