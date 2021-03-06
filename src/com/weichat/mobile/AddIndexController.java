package com.weichat.mobile;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.service.UserService;

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
@Controller("addIndexControllerMobile")
@RequestMapping(value = "/addindexmobile")
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
		return "/mobile/add/common/frame";
	}

	/**
	 * 企业基本情况主页跳转.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/ebs", method = RequestMethod.GET)
	public String enterpriseBasicSituationIndex(ModelMap modelMap) {
		return "/mobile/add/enterprise_basic_situation/index";
	}

	/**
	 * 优惠政策情况主页跳转.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/policy", method = RequestMethod.GET)
	public String preferentialPolicyIndex(ModelMap modelMap) {
		return "/mobile/add/enterprise_basic_situation/policy";
	}

	/**
	 * 建设情况主页跳转.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/development", method = RequestMethod.GET)
	public String developmentIndex(ModelMap modelMap) {
		return "/mobile/add/enterprise_basic_situation/development";
	}

	/**
	 * 安全生产主页跳转.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/safety", method = RequestMethod.GET)
	public String safetyIndex(ModelMap modelMap) {
		return "/mobile/add/enterprise_basic_situation/safety";
	}

	/**
	 * 企业发展主页跳转.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/expand", method = RequestMethod.GET)
	public String expandIndex(ModelMap modelMap) {
		return "/mobile/add/enterprise_basic_situation/expand";
	}

	/**
	 * 企业服务主页跳转.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/server", method = RequestMethod.GET)
	public String serverIndex(ModelMap modelMap) {
		return "/mobile/add/enterprise_basic_situation/server";
	}

	/**
	 * 企业建设主页跳转.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/party", method = RequestMethod.GET)
	public String partyIndex(ModelMap modelMap) {
		return "/mobile/add/enterprise_basic_situation/party";
	}
}