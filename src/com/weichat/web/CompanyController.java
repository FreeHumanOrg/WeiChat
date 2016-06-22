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
		System.out
				.println("----------------------�����ѯ��ҵ�б���----------------------");
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
	public String companyshow(HttpServletRequest request, ModelMap modelMap) {
		System.out
				.println("----------------------�����ѯ��ҵ���鷽��----------------------");
		Double id = Double.parseDouble(request.getParameter("id"));
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
	public String enterpriseBasicSituationShow(HttpServletRequest request,
			ModelMap modelMap) {
		LOGGER.info("��ת��enterprise_update_situation�µ�indexҳ��ɹ���"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("company", companyService.findInfomationById(id));
		return "/update/enterprise_update_situation/index";
	}
	@RequestMapping(value = "/ebu", method = RequestMethod.POST)
	public void enterpriseBasicSituationUpdate(HttpServletResponse response,@ModelAttribute Infomation infomation)throws IOException{
		LOGGER.info("��ҵ��������޸�!"+DateTimeUtils.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		StringBuffer sbResult = new StringBuffer();
		if(companyService.updateInfomation(infomation)){
			sbResult.append("<script>alert('��ϲ�������ѳɹ��޸ġ�'); parent.location.href='../company/companylist.jhtml';</script>");
		}else{
			sbResult.append("<script>alert('�ǳ���Ǹ���޸�����ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}
}
