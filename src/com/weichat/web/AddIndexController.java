package com.weichat.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.service.UserService;
import com.weichat.util.DateTimeUtils;

/**
 * 添加主页Controller
 * 
 * 
 * 项目名称：WeiChat 类名称：BaseDaoImpl.java 类描述：TODO 创建人：王晶 创建时间：2016-6-20 上午11:30:04
 * 修改人：王晶 修改时间：2016-6-20 上午11:30:04 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("addIndexController")
@RequestMapping(value = "/addindex")
public class AddIndexController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(AddIndexController.class);

	@Resource(name = "userServiceImpl")
	private UserService userService;

	/**
	 * 添加业务部分主页跳转.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/frame", method = RequestMethod.GET)
	public String addIndex(ModelMap modelMap) {
		LOGGER.info("跳转到frame页面成功！"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		return "/add/common/frame";
	}

	/**
	 * 企业基本情况主页跳转.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/ebs", method = RequestMethod.GET)
	public String enterpriseBasicSituationIndex(ModelMap modelMap) {
		LOGGER.info("跳转到enterprise_basic_situation下的index页面成功！"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		return "/add/enterprise_basic_situation/index";
	}
}