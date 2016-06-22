package com.weichat.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weichat.service.ExpendService;
import com.weichat.service.ServerService;

/**
 * ��ҵ��չController
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�ExpendController.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����8:14:40
 * �޸��ˣ���˧�� �޸�ʱ�䣺����8:14:40 �޸ı�ע��
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
