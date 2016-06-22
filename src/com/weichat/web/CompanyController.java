package com.weichat.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.model.Infomation;
import com.weichat.service.CompanyService;
import com.weichat.util.DateTimeUtils;

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
@RequestMapping(value = "/company")
public class CompanyController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(CompanyController.class);

	@Resource(name = "companyServiceImpl")
	private CompanyService companyService;

	/**
	 * 企业列表
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/companylist", method = RequestMethod.GET)
	public String companylist(ModelMap modelMap) {
		System.out
				.println("----------------------进入查询企业列表方法----------------------");
		modelMap.addAttribute("companyList", companyService.findAllService());
		return "/home/companylist";
	}

	/**
	 * 企业详情
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/companyshow", method = RequestMethod.GET)
	public String companyshow(HttpServletRequest request, ModelMap modelMap) {
		System.out
				.println("----------------------进入查询企业详情方法----------------------");
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("company", companyService.findInfomationById(id));
		return "/update/common/frame";
	}

	/**
	 * 企业详情
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/ebs", method = RequestMethod.GET)
	public String enterpriseBasicSituationShow(HttpServletRequest request,
			ModelMap modelMap) {
		LOGGER.info("跳转到enterprise_update_situation下的index页面成功！"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("company", companyService.findInfomationById(id));
		return "/update/enterprise_update_situation/index";
	}
	@RequestMapping(value = "/ebu", method = RequestMethod.POST)
	public void enterpriseBasicSituationUpdate(HttpServletResponse response,@ModelAttribute Infomation infomation)throws IOException{
		LOGGER.info("企业基本情况修改!"+DateTimeUtils.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		StringBuffer sbResult = new StringBuffer();
		if(companyService.updateInfomation(infomation)){
			sbResult.append("<script>alert('恭喜！数据已成功修改。'); parent.location.href='../company/companylist.jhtml';</script>");
		}else{
			sbResult.append("<script>alert('非常抱歉，修改数据失败！请重试您的操作。'); parent.location.href='../company/companylist.jhtml'</script>");
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}
}
