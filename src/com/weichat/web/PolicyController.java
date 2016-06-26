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
import com.weichat.model.Youhuizhengce;
import com.weichat.service.PolicyService;
import com.weichat.util.DateTimeUtils;

/**
 * 
 * ����Controller
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�PolicyController.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����12:34:21
 * �޸��ˣ����� �޸�ʱ�䣺����16:03:01 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("policyController")
@RequestMapping(value = "/policy")
public class PolicyController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(PolicyController.class);

	@Resource(name = "policyServiceImpl")
	private PolicyService policyService;

	/**
	 * ��Ӳ�����ҳ��ת.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/frame", method = RequestMethod.GET)
	public String addIndex(ModelMap modelMap) {
		LOGGER.info("��ת��frameҳ��ɹ���"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		return "/add/common/frame";
	}

	/**
	 * �Ż�����ҳ����ת.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/policy", method = RequestMethod.GET)
	public String policy(ModelMap modelMap) {
		return "/add/enterprise_basic_situation/policy";
	}

	@RequestMapping(value = "/policyshow", method = RequestMethod.GET)
	public String policyShow(HttpServletRequest request, ModelMap modelMap) {
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("policy", policyService.findYouhuizhengceById(id));
		modelMap.addAttribute("id", id);
		return "/update/enterprise_update_situation/policy";
	}

	@RequestMapping(value = "/policymobileshow", method = RequestMethod.GET)
	public String policyMobileShow(HttpServletRequest request, ModelMap modelMap) {
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("policy", policyService.findYouhuizhengceById(id));
		modelMap.addAttribute("id", id);
		return "/mobile/update/enterprise_update_situation/policy";
	}
	

	/**
	 * ����Ż��������.
	 * 
	 * @param modelMap
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addPolicy", method = RequestMethod.POST)
	public void addPolicy(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap,
			@ModelAttribute Youhuizhengce youhuizhengce) throws IOException {
		StringBuffer sbResult = new StringBuffer();

		if (policyService.addNewPolicyService(
				youhuizhengce,
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
	/**
	 * �޸��Ż��������
	 * 
	 * @param response
	 * @param Youhuizhengce
	 * @throws IOException
	 */
	@RequestMapping(value = "/policyupdate", method = RequestMethod.POST)
	public void updateAnquanshengchan(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute Youhuizhengce youhuizhengce) throws IOException {
		LOGGER.info("�Ż���������޸�!"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		StringBuffer sbResult = new StringBuffer();
		// �ж���ҵ��ȫ�Ƿ����
		if (policyService.checkYouhuizhengce(youhuizhengce.getInfomation().getId())) {// ����
			if (policyService.updateYouhuizhengce(youhuizhengce)) {
				sbResult.append("<script>alert('��ϲ�������ѳɹ��޸ġ�'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('�ǳ���Ǹ���޸�����ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// ������
			if (policyService.addNewPolicyService(youhuizhengce, youhuizhengce.getInfomation().getId())){
				sbResult.append("<script>alert('��ϲ�������ѳɹ�¼�롣'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('�ǳ���Ǹ��¼������ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

	
}