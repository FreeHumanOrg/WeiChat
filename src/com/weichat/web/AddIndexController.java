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
 * �����ҳController
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�BaseDaoImpl.java ��������TODO �����ˣ����� ����ʱ�䣺2016-6-20 ����11:30:04
 * �޸��ˣ����� �޸�ʱ�䣺2016-6-20 ����11:30:04 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("addIndexController")
@RequestMapping(value = "/addindex")
public class AddIndexController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(AddIndexController.class);

	@Resource(name = "userServiceImpl")
	private UserService userService;

	/**
	 * ���ҵ�񲿷���ҳ��ת.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/frame", method = RequestMethod.GET)
	public String addIndex(ModelMap modelMap) {
		LOGGER.info("��ת��frameҳ��ɹ���"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		return "/add/common/frame";
	}

	/**
	 * ��ҵ���������ҳ��ת.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/ebs", method = RequestMethod.GET)
	public String enterpriseBasicSituationIndex(ModelMap modelMap) {
		LOGGER.info("��ת��enterprise_basic_situation�µ�indexҳ��ɹ���"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		return "/add/enterprise_basic_situation/index";
	}
}