package com.weichat.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.model.Guotu;
import com.weichat.model.Jiansejindu;
import com.weichat.model.Productpeoper;
import com.weichat.model.Yaosu;
import com.weichat.model.Zhengwuqingkuang;
import com.weichat.service.DevelopmentService;

@Controller("developmentController")
@RequestMapping(value = "/development")
public class DevelopmentController {

	@Resource(name = "developmentServiceImpl")
	private DevelopmentService developmentService;

	@RequestMapping(value = "/developmentshow", method = RequestMethod.GET)
	public String developmentShow(HttpServletRequest request, ModelMap modelMap) {
		Double id = Double.parseDouble(request.getParameter("id"));
		return "/update/enterprise_update_situation/development";
	}

	/**
	 * ��ӽ�������е���Ŀ�ٽ���ϵ����Ϣ.
	 * 
	 * @param modelMap
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addProductPeoperFromDev", method = RequestMethod.POST)
	public void addProductPeoperFromDev(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap,
			@ModelAttribute Productpeoper productpeoper) throws IOException {
		StringBuffer sbResult = new StringBuffer();

		if (developmentService.addNewProductPeoperFromDevelopmentService(
				productpeoper,
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
	 * ��ӽ�������е�������������Ϣ.
	 * 
	 * @param modelMap
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addGovernmentSituationFromDev", method = RequestMethod.POST)
	public void addGovernmentSituationFromDev(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap,
			@ModelAttribute Zhengwuqingkuang zhengwuqingkuang)
			throws IOException {
		StringBuffer sbResult = new StringBuffer();

		if (developmentService.addNewGovernmentSituationFromDevelopmentService(
				zhengwuqingkuang,
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
	 * ��ӽ�������еĹ������������Ϣ.
	 * 
	 * @param modelMap
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addLandSituationFromDev", method = RequestMethod.POST)
	public void addLandSituationFromDev(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap,
			@ModelAttribute Guotu guotu) throws IOException {
		StringBuffer sbResult = new StringBuffer();

		if (developmentService.addNewLandSituationFromDevelopmentService(
				guotu,
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
	 * ��ӽ�������е�Ҫ�ر�����Ϣ.
	 * 
	 * @param modelMap
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addElementsOfSecurityFromDev", method = RequestMethod.POST)
	public void addElementsOfSecurityFromDev(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap,
			@ModelAttribute Yaosu yaosu) throws IOException {
		StringBuffer sbResult = new StringBuffer();

		if (developmentService.addNewElementsOfSecurityFromDevelopmentService(
				yaosu,
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
	 * ��ӽ�������е���Ŀ���������Ϣ.
	 * 
	 * @param modelMap
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addProjectBuildToProgressFromDev", method = RequestMethod.POST)
	public void addProjectBuildToProgressFromDev(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap,
			@ModelAttribute Jiansejindu jiansejindu) throws IOException {
		StringBuffer sbResult = new StringBuffer();

		if (developmentService
				.addNewProjectBuildToProgressFromDevelopmentService(
						jiansejindu,
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
