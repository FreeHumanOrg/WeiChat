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
 * 企业发展Controller
 * 
 * 项目名称：WeiChat 类名称：ExpendController.java 类描述：TODO 创建人：李帅康 创建时间：下午8:14:40
 * 修改人：李帅康 修改时间：下午8:14:40 修改备注：
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
	 * 查询企业发展详情
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/expendshow", method = RequestMethod.GET)
	public String policyShow(HttpServletRequest request, ModelMap modelMap) {
		LOGGER.info("跳转到enterprise_update_situation下的expend页面成功！"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("expend", expendService.findQiyefazhanById(id));
		modelMap.addAttribute("id", id);
		return "/update/enterprise_update_situation/expand";
	}

	/**
	 * 修改企业发展
	 * 
	 * @param response
	 * @param qiyefazhan
	 * @throws IOException
	 */
	@RequestMapping(value = "/expendupdate", method = RequestMethod.POST)
	public void updateExpend(HttpServletResponse response,HttpServletRequest request,
			@ModelAttribute Qiyefazhan qiyefazhan) throws IOException {
		LOGGER.info("企业发展修改!"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		StringBuffer sbResult = new StringBuffer();
		// 判断企业发展是否存在
		if (expendService.checkQiyefazhan(qiyefazhan.getInfomation().getId())) {// 存在
			if (expendService.updateQiyefazhan(qiyefazhan)) {
				sbResult.append("<script>alert('恭喜！数据已成功修改。'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('非常抱歉，修改数据失败！请重试您的操作。'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// 不存在
				// 调用新增方法
			if (expendService.addNewExpendService(qiyefazhan,qiyefazhan.getInfomation().getId())){
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
	 * 修改企业发展
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
			sbResult.append("<script>alert('恭喜！数据已成功录入。'); parent.location.href='../company/companylist.jhtml';</script>");
		} else {
			sbResult.append("<script>alert('非常抱歉，录入数据失败！请重试您的操作。'); history.go(-1);</script>");
		}

		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

}
