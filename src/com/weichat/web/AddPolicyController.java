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
 * �û�ҵ��ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�AddPolicyController.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����12:34:21
 * �޸��ˣ���˧�� �޸�ʱ�䣺����12:34:21 �޸ı�ע��
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
}