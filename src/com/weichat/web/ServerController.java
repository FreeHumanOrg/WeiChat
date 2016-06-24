package com.weichat.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.service.SafetyService;
import com.weichat.service.ServerService;
import com.weichat.util.DateTimeUtils;
/**
 * 企业服务Controller
 * 
 * 项目名称：WeiChat 类名称：ServerController.java 类描述：TODO 创建人：李帅康 创建时间：下午8:15:07
 * 修改人：李帅康 修改时间：下午8:15:07 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("serverController")
@RequestMapping(value = "/server")
public class ServerController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(ServerController.class);

	@Resource(name = "serverServiceImpl")
	private ServerService serverService;
	
	@RequestMapping(value = "/servershow", method = RequestMethod.GET)
	public String serverShow(HttpServletRequest request, ModelMap modelMap) {
		LOGGER.info("跳转到enterprise_update_situation下的server页面成功！"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("safety", serverService.findQiyefuwuById(id));
		modelMap.addAttribute("id", id);
		return "/update/enterprise_update_situation/server";
	}
}
