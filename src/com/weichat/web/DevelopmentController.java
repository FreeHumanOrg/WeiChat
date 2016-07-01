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
	 * 修改项目促建联系人
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
		// 判断企业安全是否存在
		if (developmentService.checkProductpeoperById(productpeoper
				.getInfomation().getId())) {// 存在
			if (developmentService.updateProductpeoper(productpeoper)) {
				sbResult.append("<script>alert('恭喜！数据已成功修改。'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('非常抱歉，修改数据失败！请重试您的操作。'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// 不存在
				// 调用新增方法
			if (developmentService.addNewProductPeoperFromDevelopmentService(
					productpeoper, productpeoper.getInfomation().getId())) {
				sbResult.append("<script>alert('恭喜！数据已成功录入。'); window.location.href='../../addindex/frame.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('非常抱歉，录入数据失败！请重试您的操作。'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

	/**
	 * 修改政务办理情况
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
		// 判断政务办理情况是否存在
		if (developmentService.checkZhengwuqingkuang(zhengwuqingkuang
				.getInfomation().getId())) {// 存在
			if (developmentService.updateZhengwuqingkuang(zhengwuqingkuang)) {
				sbResult.append("<script>alert('恭喜！数据已成功修改。'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('非常抱歉，修改数据失败！请重试您的操作。'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// 不存在
				// 调用新增方法
			if (developmentService
					.addNewGovernmentSituationFromDevelopmentService(
							zhengwuqingkuang, zhengwuqingkuang.getInfomation()
									.getId())) {
				sbResult.append("<script>alert('恭喜！数据已成功录入。'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('非常抱歉，录入数据失败！请重试您的操作。'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

	/**
	 * 修改国土办理情况
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
		// 判断政务办理情况是否存在
		if (developmentService.checkGuotu(guotu.getInfomation().getId())) {// 存在
			if (developmentService.updateGuotu(guotu)) {
				sbResult.append("<script>alert('恭喜！数据已成功修改。'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('非常抱歉，修改数据失败！请重试您的操作。'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// 不存在
				// 调用新增方法
			if (developmentService.addNewLandSituationFromDevelopmentService(
					guotu, guotu.getInfomation().getId())) {
				sbResult.append("<script>alert('恭喜！数据已成功录入。'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('非常抱歉，录入数据失败！请重试您的操作。'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

	/**
	 * 修改要素保障
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
		// 判断政务办理情况是否存在
		if (developmentService.checkYaosu(yaosu.getInfomation().getId())) {// 存在
			if (developmentService.updateYaosu(yaosu)) {
				sbResult.append("<script>alert('恭喜！数据已成功修改。'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('非常抱歉，修改数据失败！请重试您的操作。'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// 不存在
				// 调用新增方法
			if (developmentService
					.addNewElementsOfSecurityFromDevelopmentService(yaosu,
							yaosu.getInfomation().getId())) {
				sbResult.append("<script>alert('恭喜！数据已成功录入。'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('非常抱歉，录入数据失败！请重试您的操作。'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

	/**
	 * 修改项目建设进度
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
		// 判断政务办理情况是否存在
		if (developmentService.checkJiansejindu(jiansejindu.getInfomation()
				.getId())) {// 存在
			if (developmentService.updateJiansejindu(jiansejindu)) {
				sbResult.append("<script>alert('恭喜！数据已成功修改。'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('非常抱歉，修改数据失败！请重试您的操作。'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// 不存在
				// 调用新增方法
			if (developmentService
					.addNewProjectBuildToProgressFromDevelopmentService(
							jiansejindu, jiansejindu.getInfomation().getId())) {
				sbResult.append("<script>alert('恭喜！数据已成功录入。'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('非常抱歉，录入数据失败！请重试您的操作。'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

	/**
	 * 添加建设情况中的项目促建联系人信息.
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
			sbResult.append("<script>alert('恭喜！数据已成功录入。'); location.reload();</script>");
		} else {
			sbResult.append("<script>alert('非常抱歉，录入数据失败！请重试您的操作。'); history.go(-1);</script>");
		}

		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

	/**
	 * 添加建设情况中的政务办理情况信息.
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
			sbResult.append("<script>alert('恭喜！数据已成功录入。'); parent.location.href='../company/companylist.jhtml';</script>");
		} else {
			sbResult.append("<script>alert('非常抱歉，录入数据失败！请重试您的操作。'); history.go(-1);</script>");
		}

		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

	/**
	 * 添加建设情况中的国土办理情况信息.
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
			sbResult.append("<script>alert('恭喜！数据已成功录入。'); parent.location.href='../company/companylist.jhtml';</script>");
		} else {
			sbResult.append("<script>alert('非常抱歉，录入数据失败！请重试您的操作。'); history.go(-1);</script>");
		}

		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

	/**
	 * 添加建设情况中的要素保障信息.
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
			sbResult.append("<script>alert('恭喜！数据已成功录入。'); parent.location.href='../company/companylist.jhtml';</script>");
		} else {
			sbResult.append("<script>alert('非常抱歉，录入数据失败！请重试您的操作。'); history.go(-1);</script>");
		}

		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

	/**
	 * 添加建设情况中的项目建设进度信息.
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
			sbResult.append("<script>alert('恭喜！数据已成功录入。'); parent.location.href='../company/companylist.jhtml';</script>");
		} else {
			sbResult.append("<script>alert('非常抱歉，录入数据失败！请重试您的操作。'); history.go(-1);</script>");
		}

		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}
}
