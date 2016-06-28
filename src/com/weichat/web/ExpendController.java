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

import com.weichat.model.Qiyefazhan;
import com.weichat.service.ExpendService;
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
	 * 
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
		modelMap.addAttribute("expend", expendService.findQiyefazhanById(id));
		modelMap.addAttribute("id", id);
		return "/update/enterprise_update_situation/expand";
	}

	/**
	 * �޸���ҵ��չ
	 * 
	 * @param response
	 * @param qiyefazhan
	 * @throws IOException
	 */
	@RequestMapping(value = "/expendupdate", method = RequestMethod.POST)
	public void updateExpend(HttpServletResponse response,HttpServletRequest request,
			@ModelAttribute Qiyefazhan qiyefazhan) throws IOException {
		LOGGER.info("��ҵ��չ�޸�!"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		StringBuffer sbResult = new StringBuffer();
		// �ж���ҵ��չ�Ƿ����
		if (expendService.checkQiyefazhan(qiyefazhan.getInfomation().getId())) {// ����
			if (expendService.updateQiyefazhan(qiyefazhan)) {
				sbResult.append("<script>alert('��ϲ�������ѳɹ��޸ġ�'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('�ǳ���Ǹ���޸�����ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// ������
				// ������������
			if (expendService.addNewExpendService(qiyefazhan,qiyefazhan.getInfomation().getId())){
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
	 * �޸���ҵ��չ
	 * 
	 * @param response
	 * @param qiyefazhan
	 * @throws IOException
	 */
	@RequestMapping(value = "/expendadd", method = RequestMethod.POST)
	public void addExpend(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute Qiyefazhan qiyefazhan)
			throws IOException {
		StringBuffer sbResult = new StringBuffer();

		if (expendService.addNewExpendService(
				qiyefazhan,
				Double.valueOf(request.getSession()
						.getAttribute("enterpriseId").toString()))) {
			sbResult.append("<script>alert('��ϲ�������ѳɹ�¼�롣'); parent.location.href='../company/companylist.jhtml';</script>");
		} else {
			sbResult.append("<script>alert('�ǳ���Ǹ��¼������ʧ�ܣ����������Ĳ�����'); history.go(-1);</script>");
		}

		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

}
