package com.weichat.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.service.UserService;
import com.weichat.util.DateTimeUtils;

/**
 * 
 * 用户业务接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：AddPolicyController.java 类描述：TODO 创建人：李帅康 创建时间：上午12:34:21
 * 修改人：李帅康 修改时间：上午12:34:21 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("addPolicyController")
@RequestMapping(value = "/addpolicy")
public class AddPolicyController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(AddPolicyController.class);

	@Resource(name = "userServiceImpl")
	private UserService userService;

	/**
	 * 添加部分主页跳转.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/frame", method = RequestMethod.GET)
	public String addIndex(ModelMap modelMap) {
		LOGGER.info("跳转到frame页面成功！"
				+ DateTimeUtils.getNowDateToStringUsingDateTimeTemplateOne());
		return "/add/common/frame";
	}

	/**
	 * 优惠政策页面跳转.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/policy", method = RequestMethod.GET)
	public String policy(ModelMap modelMap) {
		LOGGER.info("跳转到enterprise_basic_situation下的policy页面成功！"
				+ DateTimeUtils.getNowDateToStringUsingDateTimeTemplateOne());
		return "/add/enterprise_basic_situation/policy";
	}
}