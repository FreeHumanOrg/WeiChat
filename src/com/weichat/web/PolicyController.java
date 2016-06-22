package com.weichat.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.service.CompanyService;
import com.weichat.service.PolicyService;
import com.weichat.service.UserService;
import com.weichat.util.DateTimeUtils;

/**
 * 
 * 用户业务接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：PolicyController.java 类描述：TODO 创建人：李帅康 创建时间：上午12:34:21
 * 修改人：李帅康 修改时间：上午12:34:21 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("policyController")
@RequestMapping(value = "/policy")
public class PolicyController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(PolicyController.class);

	@Resource(name = "policyServiceImpl")
	private PolicyService policyService;

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
	@RequestMapping(value = "/policyshow", method = RequestMethod.GET)
	public String policyShow(HttpServletRequest request,ModelMap modelMap){
		LOGGER.info("跳转到enterprise_update_situation下的policy页面成功！"
				+ DateTimeUtils.getNowDateToStringUsingDateTimeTemplateOne());
		Double id=Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("policies",policyService.findYouhuiById(id));
		return "/update/enterprise_update_situation/policy";
	}
}