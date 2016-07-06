package com.weichat.web;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.model.History;
import com.weichat.model.Infomation;
import com.weichat.model.User;
import com.weichat.service.HistoryService;
import com.weichat.service.UserService;
import com.weichat.util.Page;

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
	@RequestMapping(value = "/historyshow", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String historyShow(ModelMap modelMap,
			@ModelAttribute Page<History> page) {
		Page<History> list = historyService.findPageService(page);

		for (int i = 0; i < list.getContent().size(); i++) {
			// 为空
			if (list.getContent().get(i).getInfomationId() == null) {
				User u = userService.findUserByOperateCodeService(list
						.getContent().get(i).getOperatecode());
				Infomation info = new Infomation();
				User user = new User();
				Set<User> userSets = new HashSet<User>();
				user.setUsername(u.getUsername());
				userSets.add(user);
				info.setUsers(userSets);
				list.getContent().get(i).setInfomation(info);
			}
		}
		modelMap.addAttribute("page", list);
		return "/home/history";
	}

	/**
	 * 手机端显示历史记录.
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/historymobileshow", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String historyMobileShow(ModelMap modelMap,
			@ModelAttribute Page<History> page) {
		Page<History> list = historyService.findPageService(page);
		for (int i = 0; i < list.getContent().size(); i++) {
			// 为空
			if (list.getContent().get(i).getInfomationId() == null) {
				User u = userService.findUserByOperateCodeService(list
						.getContent().get(i).getOperatecode());
				Infomation info = new Infomation();
				User user = new User();
				Set<User> userSets = new HashSet<User>();
				user.setUsername(u.getUsername());
				userSets.add(user);
				info.setUsers(userSets);
				list.getContent().get(i).setInfomation(info);
			}
		}
		modelMap.addAttribute("page", list);
		return "/mobile/home/history";
	}

}
