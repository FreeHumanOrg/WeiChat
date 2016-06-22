package com.weichat.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.service.DevelopmentService;
import com.weichat.util.DateTimeUtils;

@Controller("developmentController")
@RequestMapping(value = "/development")
public class DevelopmentController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(DevelopmentController.class);

	@Resource(name = "developmentServiceImpl")
	private DevelopmentService developmentService;
	
	@RequestMapping(value = "/developmentshow", method = RequestMethod.GET)
	public String developmentShow(HttpServletRequest request,ModelMap modelMap){
		LOGGER.info("跳转到enterprise_update_situation下的development页面成功！"
				+ DateTimeUtils.getNowDateToStringUsingDateTimeTemplateOne());
		Double id=Double.parseDouble(request.getParameter("id"));
		return "/update/enterprise_update_situation/development";
	}
}
