package com.weichat.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.service.PolicyService;
import com.weichat.service.SafetyService;
import com.weichat.util.DateTimeUtils;

/**
 * 安全生产Controller
 * 
 * 
 * 项目名称：WeiChat 类名称：SafetyController.java 类描述：TODO 
 * 创建人：李帅康  创建时间：下午4:22:00 
 * 修改人：李帅康  修改时间： 下午4:22:00
 * 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("safetyController")
@RequestMapping(value = "/safety")
public class SafetyController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(SafetyController.class);

	@Resource(name = "safetyServiceImpl")
	private SafetyService safetyService;
	
	@RequestMapping(value = "/safetyshow", method = RequestMethod.GET)
	public String policyShow(HttpServletRequest request, ModelMap modelMap) {
		LOGGER.info("跳转到enterprise_update_situation下的safety页面成功！"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("safety", safetyService.findAnquanshengchanById(id));
		return "/update/enterprise_update_situation/safety";
	}
}
