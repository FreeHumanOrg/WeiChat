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
 * 安全生产Controller
 * 
 * 
 * 项目名称：WeiChat 类名称：SafetyController.java 类描述：TODO 创建人：李帅康 创建时间：下午4:22:00
 * 修改人：李帅康 修改时间： 下午4:22:00 修改备注：
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
		LOGGER.info("跳转到enterprise_update_situation下的safety页面成功！"
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
		LOGGER.info("跳转到enterprise_update_situation下的safety页面成功！"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("safety",
				safetyService.findAnquanshengchanById(id));
		modelMap.addAttribute("id", id);
		return "/mobile/update/enterprise_update_situation/safety";
	}

	/**
	 * 修改安全生产详情
	 * 
	 * @param response
	 * @param anquanshengchan
	 * @throws IOException
	 */
	@RequestMapping(value = "/safetyupdate", method = RequestMethod.POST)
	public void updateAnquanshengchan(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute Anquanshengchan anquanshengchan) throws IOException {
		LOGGER.info("企业安全生产修改!"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		StringBuffer sbResult = new StringBuffer();
		// 判断企业安全是否存在
		if (safetyService.checkAnquanshengchan(anquanshengchan.getInfomation()
				.getId())) {// 存在
			if (safetyService.updateAnquanshengchan(anquanshengchan)) {
				sbResult.append("<script>alert('恭喜！数据已成功修改。'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('非常抱歉，修改数据失败！请重试您的操作。'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// 不存在
			if (safetyService.addAnquanshengchan(anquanshengchan,
					anquanshengchan.getInfomation().getId())) {
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
	 * 添加安全生产详情.
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
			sbResult.append("<script>alert('恭喜！数据已成功录入。请继续添加相关的信息。'); parent.location.reload(true);</script>");
		} else {
			sbResult.append("<script>alert('非常抱歉，录入数据失败！请重试您的操作。'); history.go(-1);</script>");
		}

		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}
}
