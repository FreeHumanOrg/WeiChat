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
 * 历史记录Controller
 * 
 * 
 * 项目名称：WeiChat 类名称：HistoryController.java 类描述：TODO 创建人：王晶 创建时间：2016年6月30日
 * 下午1:50:23 修改人：王晶 修改时间：2016年6月30日 下午1:50:23 修改备注：
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
	 * 显示历史记录.
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
