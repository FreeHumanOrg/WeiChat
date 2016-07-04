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
import com.weichat.service.BasicSituationService;
import com.weichat.util.DateTimeUtils;

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
	 * �����ҵ�������.
	 * 
	 * @param modelMap
	 * @param infomation
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap, @ModelAttribute Infomation infomation)
			throws IOException {
		StringBuffer sbResult = new StringBuffer();
		String mcoid=(String)request.getSession().getAttribute("mcoid");
		infomation.setMcoid(mcoid);//����mcoid
		if (basicSituationService
				.addBasicSituationOfEnterpriseService(infomation) != -1.0) {
			request.getSession().setAttribute("enterpriseId",
					infomation.getId());
			LOGGER.info("������ݳɹ���"
					+ DateTimeUtils
							.getNowDateOfStringFormatUsingDateTimeTemplateOne());
			// �����ҵ������Ϣ��ӳɹ��ı�ʶ�Խ�����Ĺ�������
			request.getSession().setAttribute("addedBasicInfo", "successed");
			sbResult.append("<script>alert('��ϲ�������ѳɹ�¼�롣����������ص���Ϣ��'); parent.location.reload(true);</script>");
		} else {
			LOGGER.info("�������ʧ�ܡ�"
					+ DateTimeUtils
							.getNowDateOfStringFormatUsingDateTimeTemplateOne());
			sbResult.append("<script>alert('�ǳ���Ǹ��¼������ʧ�ܣ����������Ĳ�����'); history.go(-1);</script>");
		}

		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}
}
