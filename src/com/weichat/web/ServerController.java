package com.weichat.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weichat.service.SafetyService;
import com.weichat.service.ServerService;
/**
 * 企业服务Controller
 * 
 * 项目名称：WeiChat 类名称：ServerController.java 类描述：TODO 创建人：李帅康 创建时间：下午8:15:07
 * 修改人：李帅康 修改时间：下午8:15:07 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("serverController")
@RequestMapping(value = "/server")
public class ServerController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(ServerController.class);

	@Resource(name = "serverServiceImpl")
	private ServerService serverService;
}
