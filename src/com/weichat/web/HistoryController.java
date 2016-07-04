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
	@RequestMapping(value = "/historyshow", method = RequestMethod.GET)
	public String historyShow(ModelMap modelMap) {
		List<History> histories = historyService.findAllHistoryInfoService();
		for (int i = 0; i < histories.size(); i++) {
			// Ϊ��
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
	 * �ֻ�����ʾ��ʷ��¼.
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
