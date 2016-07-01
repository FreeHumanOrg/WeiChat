package com.weichat.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.model.History;
import com.weichat.service.HistoryService;

/**
 * ��ʷ��¼Controller
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�HistoryController.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��30��
 * ����1:50:23 �޸��ˣ����� �޸�ʱ�䣺2016��6��30�� ����1:50:23 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("historyController")
@RequestMapping(value = "/history")
public class HistoryController {
	@Resource(name = "historyServiceImpl")
	private HistoryService historyService;

	/**
	 * ��ʾ��ʷ��¼.
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/historyshow", method = RequestMethod.GET)
	public String historyShow(ModelMap modelMap) {
		List<History> histories = historyService.findAllHistoryInfoService();
		modelMap.addAttribute("histories", histories);
		return "/home/history";
	}
}
