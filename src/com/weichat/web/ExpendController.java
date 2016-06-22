package com.weichat.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.service.ExpendService;
import com.weichat.service.ServerService;
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
		modelMap.addAttribute("expend",expendService.findQiyefazhanById(id) );
		return "/update/enterprise_update_situation/expand";
	}
	
	
}
