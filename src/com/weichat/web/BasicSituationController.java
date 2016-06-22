package com.weichat.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.model.Infomation;
import com.weichat.service.BasicSituationService;

/**
 * ��ҵ�������Controller
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�BasicSituationController.java ��������TODO �����ˣ�����
 * ����ʱ�䣺2016��6��22�� ����3:05:43 �޸��ˣ����� �޸�ʱ�䣺2016��6��22�� ����3:05:43 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("basicSituationController")
@RequestMapping(value = "/basicSituation")
public class BasicSituationController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(AddIndexController.class);

	@Resource(name = "basicSituationServiceImpl")
	private BasicSituationService basicSituationService;

	/**
	 * ������ҵ�������.
	 * 
	 * @param modelMap
	 * @param infomation
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(HttpServletResponse response, ModelMap modelMap,
			@ModelAttribute Infomation infomation) throws IOException {
		StringBuffer sbResult = new StringBuffer();
		if (basicSituationService
				.addBasicSituationOfEnterpriseService(infomation)) {
			sbResult.append("<script>alert('��ϲ�������ѳɹ�¼�롣'); parent.location.href='../company/companylist.jhtml';</script>");
		} else {
			sbResult.append("<script>alert('�ǳ���Ǹ��¼������ʧ�ܣ����������Ĳ�����'); location.href='../basicSituation/add.jhtml'</script>");
		}

		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}
}