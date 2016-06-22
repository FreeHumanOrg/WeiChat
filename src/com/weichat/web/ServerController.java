package com.weichat.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weichat.service.SafetyService;
import com.weichat.service.ServerService;
/**
 * ��ҵ����Controller
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�ServerController.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����8:15:07
 * �޸��ˣ���˧�� �޸�ʱ�䣺����8:15:07 �޸ı�ע��
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
