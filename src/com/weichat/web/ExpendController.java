package com.weichat.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.service.ExpendService;
import com.weichat.service.ServerService;
import com.weichat.util.DateTimeUtils;

/**
 * ��ҵ��չController
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�ExpendController.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����8:14:40
 * �޸��ˣ���˧�� �޸�ʱ�䣺����8:14:40 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("expendController")
@RequestMapping(value = "/expend")
public class ExpendController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(ExpendController.class);

	@Resource(name = "expendServiceImpl")
	private ExpendService expendService;
	/**
	 * ��ѯ��ҵ��չ����
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/expendshow", method = RequestMethod.GET)
	public String policyShow(HttpServletRequest request, ModelMap modelMap) {
		LOGGER.info("��ת��enterprise_update_situation�µ�expendҳ��ɹ���"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("expend",expendService.findQiyefazhanById(id) );
		return "/update/enterprise_update_situation/expand";
	}
	
	
}
