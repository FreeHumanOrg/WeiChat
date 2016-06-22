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
 * ��ȫ����Controller
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�SafetyController.java ��������TODO 
 * �����ˣ���˧��  ����ʱ�䣺����4:22:00 
 * �޸��ˣ���˧��  �޸�ʱ�䣺 ����4:22:00
 * �޸ı�ע��
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
		LOGGER.info("��ת��enterprise_update_situation�µ�safetyҳ��ɹ���"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("safety", safetyService.findAnquanshengchanById(id));
		return "/update/enterprise_update_situation/safety";
	}
}
