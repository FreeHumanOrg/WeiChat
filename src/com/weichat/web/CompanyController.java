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
import com.weichat.service.UserService;
import com.weichat.util.DateTimeUtils;

/**
 * 
 * ��ҵҵ��ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�CompanyController.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����10:23:37
 * �޸��ˣ���˧�� �޸�ʱ�䣺����10:23:37 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("companyController")
@RequestMapping(value = "/company")
public class CompanyController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(CompanyController.class);
	
	@Resource(name = "companyServiceImpl")
	private CompanyService companyService;
	
	/**
	 * ��ҵ�б�
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/companylist", method = RequestMethod.GET)
	public String companylist(ModelMap modelMap) {
		System.out.println("----------------------�����ѯ��ҵ�б���----------------------");
		modelMap.addAttribute("companyList", companyService.findAllService());
		return "/home/companylist";
	}
	
	/**
	 * ��ҵ����
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/companyshow", method = RequestMethod.GET)
	public String companyshow(HttpServletRequest request,ModelMap modelMap) {
		System.out.println("----------------------�����ѯ��ҵ���鷽��----------------------");
		Double id=Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("company", companyService.findInfomationById(id));
		return "/update/common/frame";
	}
	
	/**
	 * ��ҵ����
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/ebs", method = RequestMethod.GET)
	public String enterpriseBasicSituationShow(HttpServletRequest request,ModelMap modelMap) {
		LOGGER.info("��ת��enterprise_update_situation�µ�indexҳ��ɹ���"
				+ DateTimeUtils.getNowDateToStringUsingDateTimeTemplateOne());
		Double id=Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("company", companyService.findInfomationById(id));
		return "/update/enterprise_update_situation/index";
	}
}
