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

import com.weichat.model.Anquanshengchan;
import com.weichat.service.SafetyService;
import com.weichat.util.DateTimeUtils;

/**
 * ��ȫ����Controller
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�SafetyController.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����4:22:00
 * �޸��ˣ���˧�� �޸�ʱ�䣺 ����4:22:00 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("safetyController")
@RequestMapping(value = "/safety")
public class SafetyController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(SafetyController.class);

	@Resource(name = "safetyServiceImpl")
	private SafetyService safetyService;

	@RequestMapping(value = "/safetyshow", method = RequestMethod.GET)
	public String safetyShow(HttpServletRequest request, ModelMap modelMap) {
		LOGGER.info("��ת��enterprise_update_situation�µ�safetyҳ��ɹ���"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("safety",
				safetyService.findAnquanshengchanById(id));
		modelMap.addAttribute("id", id);
		return "/update/enterprise_update_situation/safety";
	}

	@RequestMapping(value = "/safetymobileshow", method = RequestMethod.GET)
	public String safetyMobileShow(HttpServletRequest request, ModelMap modelMap) {
		LOGGER.info("��ת��enterprise_update_situation�µ�safetyҳ��ɹ���"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("safety",
				safetyService.findAnquanshengchanById(id));
		modelMap.addAttribute("id", id);
		return "/mobile/update/enterprise_update_situation/safety";
	}

	/**
	 * �޸İ�ȫ��������
	 * 
	 * @param response
	 * @param anquanshengchan
	 * @throws IOException
	 */
	@RequestMapping(value = "/safetyupdate", method = RequestMethod.POST)
	public void updateAnquanshengchan(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute Anquanshengchan anquanshengchan) throws IOException {
		LOGGER.info("��ҵ��ȫ�����޸�!"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		StringBuffer sbResult = new StringBuffer();
		// �ж���ҵ��ȫ�Ƿ����
		if (safetyService.checkAnquanshengchan(anquanshengchan.getInfomation()
				.getId())) {// ����
			if (safetyService.updateAnquanshengchan(anquanshengchan)) {
				sbResult.append("<script>alert('��ϲ�������ѳɹ��޸ġ�'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('�ǳ���Ǹ���޸�����ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// ������
			if (safetyService.addAnquanshengchan(anquanshengchan,
					anquanshengchan.getInfomation().getId())) {
				sbResult.append("<script>alert('��ϲ�������ѳɹ�¼�롣'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('�ǳ���Ǹ��¼������ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

	/**
	 * ��Ӱ�ȫ��������.
	 * 
	 * @param response
	 * @param anquanshengchan
	 * @throws IOException
	 */
	@RequestMapping(value = "/safetyadd", method = RequestMethod.POST)
	public void addAnquanshengchan(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute Anquanshengchan anquanshengchan) throws IOException {
		StringBuffer sbResult = new StringBuffer();

		if (safetyService.addAnquanshengchan(
				anquanshengchan,
				Double.valueOf(request.getSession()
						.getAttribute("enterpriseId").toString()))) {
			sbResult.append("<script>alert('��ϲ�������ѳɹ�¼�롣����������ص���Ϣ��'); parent.location.reload(true);</script>");
		} else {
			sbResult.append("<script>alert('�ǳ���Ǹ��¼������ʧ�ܣ����������Ĳ�����'); history.go(-1);</script>");
		}

		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}
}
