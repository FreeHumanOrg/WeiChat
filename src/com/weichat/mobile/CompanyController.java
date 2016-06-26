package com.weichat.mobile;

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
import com.weichat.util.Page;

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
@Controller("companyControllerMobile")
@RequestMapping(value = "/companymobile")
public class CompanyController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(CompanyController.class);

	@Resource(name = "companyServiceImpl")
	private CompanyService companyService;

	
	/**
	 * 
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/mobileshow", method = RequestMethod.GET)
	public String mobileshow(HttpServletRequest request, ModelMap modelMap) {
		System.out.println("----------------------�����ֻ��˲�ѯ��ҵ���鷽��----------------------");
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("company", companyService.findInfomationById(id));
		return "/mobile/update/common/frame";
	}

	/**
	 * �ֻ�����ҵ��������
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/mobileebs", method = RequestMethod.GET)
	public String enterpriseBasicSituationMobileShow(HttpServletRequest request,
			ModelMap modelMap) {
		LOGGER.info("��ת��enterprise_update_situation�µ�indexҳ��ɹ���"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("company", companyService.findInfomationById(id));
		return "/mobile/update/enterprise_update_situation/index";
	}
	

	@RequestMapping(value = "/ebu", method = RequestMethod.POST)
	public void enterpriseBasicSituationUpdate(HttpServletResponse response,
			@ModelAttribute Infomation infomation) throws IOException {
		LOGGER.info("�ֻ�����ҵ��������޸�!"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		StringBuffer sbResult = new StringBuffer();
		if (companyService.updateInfomation(infomation)) {
			sbResult.append("<script>alert('��ϲ�������ѳɹ��޸ġ�'); parent.location.href='../company/mobilelist.jhtml';</script>");
		} else {
			sbResult.append("<script>alert('�ǳ���Ǹ���޸�����ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/mobilelist.jhtml'</script>");
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}
}
