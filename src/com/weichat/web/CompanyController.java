package com.weichat.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.service.CompanyService;
import com.weichat.service.UserService;

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
public class CompanyController {
	@Resource(name = "companyServiceImpl")
	private CompanyService companyService;
	
	/**
	 * ��ҵ�б�
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/user/companylist", method = RequestMethod.GET)
	public String companylist(ModelMap modelMap) {
		System.out.println("----------------------�����ѯ��ҵ�б���----------------------");
		modelMap.addAttribute("companyList", companyService.findAllService());
		return "/home/companylist";
	}
}
