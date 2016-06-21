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
 * 企业业务接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：CompanyController.java 类描述：TODO 创建人：李帅康 创建时间：下午10:23:37
 * 修改人：李帅康 修改时间：下午10:23:37 修改备注：
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
	 * 企业列表
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/user/companylist", method = RequestMethod.GET)
	public String companylist(ModelMap modelMap) {
		System.out.println("----------------------进入查询企业列表方法----------------------");
		modelMap.addAttribute("companyList", companyService.findAllService());
		return "/home/companylist";
	}
}
