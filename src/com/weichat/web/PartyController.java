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

import com.weichat.model.Dangtuanjianshe;
import com.weichat.service.PartyService;
import com.weichat.util.DateTimeUtils;

/**
 * 党团建设Controller
 * 
 * 项目名称：WeiChat 类名称：PartyController.java 类描述：TODO 创建人：李帅康 创建时间：上午12:14:53
 * 修改人：李帅康 修改时间：上午12:14:53 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("partyController")
@RequestMapping(value = "/party")
public class PartyController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(PartyController.class);

	@Resource(name = "partyServiceImpl")
	private PartyService partyService;

	/**
	 * 查询党团建设详情
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/partyshow", method = RequestMethod.GET)
	public String partyShow(HttpServletRequest request, ModelMap modelMap) {
		LOGGER.info("跳转到enterprise_update_situation下的party页面成功！"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("party", partyService.findDangtuanjiansheById(id));
		modelMap.addAttribute("id", id);
		return "/update/enterprise_update_situation/party";
	}

	/**
	 * 修改党团建设详情
	 * 
	 * @param response
	 * @param dangtuanjianshe
	 * @throws IOException
	 */
	@RequestMapping(value = "/partyupdate", method = RequestMethod.POST)
	public void updateAnquanshengchan(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute Dangtuanjianshe dangtuanjianshe) throws IOException {
		LOGGER.info("企业党团建设修改!"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		StringBuffer sbResult = new StringBuffer();
		// 判断企业安全是否存在
		if (partyService.checkDangtuanjianshe(dangtuanjianshe.getInfomation()
				.getId())) {// 存在
			if (partyService.updateDangtuanjianshe(dangtuanjianshe)) {
				sbResult.append("<script>alert('恭喜！数据已成功修改。'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('非常抱歉，修改数据失败！请重试您的操作。'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// 不存在
			if (partyService.addDangtuanjiansheService(
					dangtuanjianshe,dangtuanjianshe.getInfomation().getId())) {
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
	 * 添加一个党团建设信息.
	 * 
	 * @param response
	 * @param dangtuanjianshe
	 * @throws IOException
	 */
	@RequestMapping(value = "/partyadd", method = RequestMethod.POST)
	public void updateParty(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute Dangtuanjianshe dangtuanjianshe) throws IOException {
		StringBuffer sbResult = new StringBuffer();

		if (partyService.addDangtuanjiansheService(
				dangtuanjianshe,
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
