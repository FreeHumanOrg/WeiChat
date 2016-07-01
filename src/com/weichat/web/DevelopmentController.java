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
		Productpeoper pp = developmentService.findProductpeoperById(id);
		Zhengwuqingkuang zw = developmentService.findZhengwuqingkuangById(id);
		Guotu gt = developmentService.findGuotuById(id);
		Yaosu ys = developmentService.findYaosuById(id);
		Jiansejindu jd = developmentService.findJiansejinduById(id);
		modelMap.addAttribute("pp", pp);
		modelMap.addAttribute("zw", zw);
		modelMap.addAttribute("guotu", gt);
		modelMap.addAttribute("ys", ys);
		modelMap.addAttribute("jd", jd);

		modelMap.addAttribute("id", id);
		return "/update/enterprise_update_situation/development";
	}

	@RequestMapping(value = "/developmentmobileshow", method = RequestMethod.GET)
	public String developmentMobileShow(HttpServletRequest request,
			ModelMap modelMap) {
		Double id = Double.parseDouble(request.getParameter("id"));
		Productpeoper pp = developmentService.findProductpeoperById(id);
		Zhengwuqingkuang zw = developmentService.findZhengwuqingkuangById(id);
		Guotu gt = developmentService.findGuotuById(id);
		Yaosu ys = developmentService.findYaosuById(id);
		Jiansejindu jd = developmentService.findJiansejinduById(id);
		modelMap.addAttribute("pp", pp);
		modelMap.addAttribute("zw", zw);
		modelMap.addAttribute("guotu", gt);
		modelMap.addAttribute("ys", ys);
		modelMap.addAttribute("jd", jd);

		modelMap.addAttribute("id", id);
		return "/mobile/update/enterprise_update_situation/development";
	}

	/**
	 * �޸���Ŀ�ٽ���ϵ��
	 * 
	 * @param response
	 * @param dangtuanjianshe
	 * @throws IOException
	 */
	@RequestMapping(value = "ppupdate", method = RequestMethod.POST)
	public void updateproductpeoper(HttpServletResponse response,
			HttpServletRequest request,
			@ModelAttribute Productpeoper productpeoper) throws IOException {
		StringBuffer sbResult = new StringBuffer();
		// �ж���ҵ��ȫ�Ƿ����
		if (developmentService.checkProductpeoperById(productpeoper
				.getInfomation().getId())) {// ����
			if (developmentService.updateProductpeoper(productpeoper)) {
				sbResult.append("<script>alert('��ϲ�������ѳɹ��޸ġ�'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('�ǳ���Ǹ���޸�����ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// ������
				// ������������
			if (developmentService.addNewProductPeoperFromDevelopmentService(
					productpeoper, productpeoper.getInfomation().getId())) {
				sbResult.append("<script>alert('��ϲ�������ѳɹ�¼�롣'); window.location.href='../../addindex/frame.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('�ǳ���Ǹ��¼������ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

	/**
	 * �޸�����������
	 * 
	 * @param response
	 * @param zhengwuqingkuang
	 * @throws IOException
	 */
	@RequestMapping(value = "zwupdate", method = RequestMethod.POST)
	public void updateZhengwuqingkuang(HttpServletResponse response,
			HttpServletRequest request,
			@ModelAttribute Zhengwuqingkuang zhengwuqingkuang)
			throws IOException {
		StringBuffer sbResult = new StringBuffer();
		// �ж������������Ƿ����
		if (developmentService.checkZhengwuqingkuang(zhengwuqingkuang
				.getInfomation().getId())) {// ����
			if (developmentService.updateZhengwuqingkuang(zhengwuqingkuang)) {
				sbResult.append("<script>alert('��ϲ�������ѳɹ��޸ġ�'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('�ǳ���Ǹ���޸�����ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// ������
				// ������������
			if (developmentService
					.addNewGovernmentSituationFromDevelopmentService(
							zhengwuqingkuang, zhengwuqingkuang.getInfomation()
									.getId())) {
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
	 * �޸Ĺ����������
	 * 
	 * @param response
	 * @param Guotu
	 * @throws IOException
	 */
	@RequestMapping(value = "gtupdate", method = RequestMethod.POST)
	public void updateGuoto(HttpServletResponse response,
			HttpServletRequest request, @ModelAttribute Guotu guotu)
			throws IOException {
		StringBuffer sbResult = new StringBuffer();
		// �ж������������Ƿ����
		if (developmentService.checkGuotu(guotu.getInfomation().getId())) {// ����
			if (developmentService.updateGuotu(guotu)) {
				sbResult.append("<script>alert('��ϲ�������ѳɹ��޸ġ�'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('�ǳ���Ǹ���޸�����ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// ������
				// ������������
			if (developmentService.addNewLandSituationFromDevelopmentService(
					guotu, guotu.getInfomation().getId())) {
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
	 * �޸�Ҫ�ر���
	 * 
	 * @param response
	 * @param yaosu
	 * @throws IOException
	 */
	@RequestMapping(value = "ysupdate", method = RequestMethod.POST)
	public void updateYaosu(HttpServletResponse response,
			HttpServletRequest request, @ModelAttribute Yaosu yaosu)
			throws IOException {
		StringBuffer sbResult = new StringBuffer();
		// �ж������������Ƿ����
		if (developmentService.checkYaosu(yaosu.getInfomation().getId())) {// ����
			if (developmentService.updateYaosu(yaosu)) {
				sbResult.append("<script>alert('��ϲ�������ѳɹ��޸ġ�'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('�ǳ���Ǹ���޸�����ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// ������
				// ������������
			if (developmentService
					.addNewElementsOfSecurityFromDevelopmentService(yaosu,
							yaosu.getInfomation().getId())) {
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
	 * �޸���Ŀ�������
	 * 
	 * @param response
	 * @param Jiansejindu
	 * @throws IOException
	 */
	@RequestMapping(value = "jdupdate", method = RequestMethod.POST)
	public void updateJiansejindu(HttpServletResponse response,
			HttpServletRequest request, @ModelAttribute Jiansejindu jiansejindu)
			throws IOException {
		StringBuffer sbResult = new StringBuffer();
		// �ж������������Ƿ����
		if (developmentService.checkJiansejindu(jiansejindu.getInfomation()
				.getId())) {// ����
			if (developmentService.updateJiansejindu(jiansejindu)) {
				sbResult.append("<script>alert('��ϲ�������ѳɹ��޸ġ�'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('�ǳ���Ǹ���޸�����ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// ������
				// ������������
			if (developmentService
					.addNewProjectBuildToProgressFromDevelopmentService(
							jiansejindu, jiansejindu.getInfomation().getId())) {
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
			sbResult.append("<script>alert('��ϲ�������ѳɹ�¼�롣'); location.reload();</script>");
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
