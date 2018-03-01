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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


/**
 * ���Թ����������
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
     * ��ҳ��ѯ
     *
     * @param session
     * @param request
     * @param current      ��ǰҳ
     * @param rowCount     ÿҳ����
     * @param searchPhrase ��ѯ�ؼ���
     * @return
     */
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public MyPage data(HttpSession session, HttpServletRequest request, @RequestParam(value = "current", defaultValue = "0") int current, @RequestParam(value = "rowCount", defaultValue = "10") Long rowCount, @RequestParam(value = "searchPhrase", required = false) String searchPhrase) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Pageable pageable = new PageRequest(current - 1, rowCount.intValue(), super.getSort(parameterMap));
        return new PageUtils().searchBySortService(messageSearchService, searchPhrase, 1, current, rowCount, pageable);
    }


    /**
     * @param id ���Թ���id
     * @return �������Թ���id��ѯ
     */
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Message findById(@PathVariable("id") Long id) {
        return messageService.findById(id);
    }

    /**
     * @param request  ����
     * @param response ��Ӧ
     * @param param    ��ѯ�ؼ���
     * @param docName  �ĵ�����
     * @param titles   ���⼯��
     * @param colNames ������
     */
    @ResponseBody
    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public void exportExcel(HttpServletRequest request, HttpServletResponse response, @RequestParam("param") String param, @RequestParam("docName") String docName, @RequestParam("titles") String titles[], @RequestParam("colNames") String[] colNames) {
        List<Message> dataList = messageSearchService.findByConditions(param, 2);
        messageService.setDataList(dataList);
        messageService.exportExcel(request, response, docName, titles, colNames);
    }


}
