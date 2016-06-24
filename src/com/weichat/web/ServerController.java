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
 * ��ҵ����Controller
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�ServerController.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����8:15:07
 * �޸��ˣ���˧�� �޸�ʱ�䣺����8:15:07 �޸ı�ע��
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
		LOGGER.info("��ת��enterprise_update_situation�µ�serverҳ��ɹ���"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("safety", serverService.findQiyefuwuById(id));
		modelMap.addAttribute("id", id);
		return "/update/enterprise_update_situation/server";
	}
}
