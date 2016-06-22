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
 * �û�ҵ��ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�PolicyController.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����12:34:21
 * �޸��ˣ���˧�� �޸�ʱ�䣺����12:34:21 �޸ı�ע��
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
	 * ��Ӳ�����ҳ��ת.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/frame", method = RequestMethod.GET)
	public String addIndex(ModelMap modelMap) {
		LOGGER.info("��ת��frameҳ��ɹ���"
				+ DateTimeUtils.getNowDateToStringUsingDateTimeTemplateOne());
		return "/add/common/frame";
	}

	/**
	 * �Ż�����ҳ����ת.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/policy", method = RequestMethod.GET)
	public String policy(ModelMap modelMap) {
		LOGGER.info("��ת��enterprise_basic_situation�µ�policyҳ��ɹ���"
				+ DateTimeUtils.getNowDateToStringUsingDateTimeTemplateOne());
		return "/add/enterprise_basic_situation/policy";
	}
	@RequestMapping(value = "/policyshow", method = RequestMethod.GET)
	public String policyShow(HttpServletRequest request,ModelMap modelMap){
		LOGGER.info("��ת��enterprise_update_situation�µ�policyҳ��ɹ���"
				+ DateTimeUtils.getNowDateToStringUsingDateTimeTemplateOne());
		Double id=Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("policies",policyService.findYouhuiById(id));
		return "/update/enterprise_update_situation/policy";
	}
}