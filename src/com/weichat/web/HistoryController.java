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

	@Resource(name = "userServiceImpl")
	private UserService userService;

	/**
	 * ��ʾ��ʷ��¼.
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
			// Ϊ��
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
	 * �ֻ�����ʾ��ʷ��¼.
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
			// Ϊ��
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
