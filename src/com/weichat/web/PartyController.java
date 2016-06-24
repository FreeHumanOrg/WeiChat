package com.weichat.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.service.PartyService;
import com.weichat.service.SafetyService;
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
}
