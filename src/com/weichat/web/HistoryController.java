package com.weichat.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.model.History;
import com.weichat.model.Infomation;
import com.weichat.model.User;
import com.weichat.service.HistoryService;
import com.weichat.service.UserService;

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

	@Resource(name = "userServiceImpl")
	private UserService userService;

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
		for (int i = 0; i < histories.size(); i++) {
			// 为空
			if (histories.get(i).getInfomationId() == null) {
				User u = userService.findUserByOperateCodeService(histories
						.get(i).getOperatecode());
				Infomation info = new Infomation();
				User user = new User();
				Set<User> userSets = new HashSet<User>();
				user.setUsername(u.getUsername());
				userSets.add(user);
				info.setUsers(userSets);
				histories.get(i).setInfomation(info);
			}
		}
		modelMap.addAttribute("histories", histories);
		return "/home/history";
	}

	/**
	 * 手机端显示历史记录.
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/historymobileshow", method = RequestMethod.GET)
	public String historyMobileShow(ModelMap modelMap) {
		List<History> histories = historyService.findAllHistoryInfoService();
		modelMap.addAttribute("histories", histories);
		return "/mobile/home/history";
	}

}
