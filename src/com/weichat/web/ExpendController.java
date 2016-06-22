package com.weichat.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weichat.service.ExpendService;
import com.weichat.service.ServerService;

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
}
