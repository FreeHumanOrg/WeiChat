package com.weichat.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.service.PartyService;
import com.weichat.service.SafetyService;
import com.weichat.util.DateTimeUtils;
/**
 * ���Ž���Controller
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�PartyController.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����12:14:53
 * �޸��ˣ���˧�� �޸�ʱ�䣺����12:14:53 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("partyController")
@RequestMapping(value = "/party")
public class PartyController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(PartyController.class);
	
	@Resource(name = "partyServiceImpl")
	private PartyService partyService;
	
	@RequestMapping(value = "/partyshow", method = RequestMethod.GET)
	public String partyShow(HttpServletRequest request, ModelMap modelMap) {
		LOGGER.info("��ת��enterprise_update_situation�µ�partyҳ��ɹ���"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("party", partyService.findDangtuanjiansheById(id));
		modelMap.addAttribute("id", id);
		return "/update/enterprise_update_situation/party";
	}
}
