package com.weichat.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.service.UserService;

/**
 * 用户Controller
 * 
 * 
 * 项目名称：WeiChat 类名称：BaseDaoImpl.java 类描述：TODO 创建人：王晶 创建时间：2016-6-20 上午11:30:04
 * 修改人：王晶 修改时间：2016-6-20 上午11:30:04 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("userController")
public class UserController {

	@Resource(name = "userServiceImpl")
	private UserService userService;

	/**
	 * 注册.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/user/reg", method = RequestMethod.GET)
	public String reg(ModelMap modelMap) {
		System.out.println("----------------------进入主方法----------------------");
		modelMap.addAttribute("usersList", userService.findAllService());
		return "/home/index";
	}
}