//package com.weichat.web;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import com.weichat.model.History;
//import com.weichat.model.Infomation;
//import com.weichat.service.CompanyService;
//import com.weichat.service.HistoryService;
//import com.weichat.util.DateTimeUtils;
//import com.weichat.util.RandomUtils;
//
///**
// * ���ڵ�Ԫ���Ե�Controller
// * 
// * 
// * ��Ŀ���ƣ�WeiChat �����ƣ�TestController.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��28��
// * ����1:00:30 �޸��ˣ����� �޸�ʱ�䣺2016��6��28�� ����1:00:30 �޸ı�ע��
// * 
// * FreeHuman Soft Team
// * 
// * @version 1.0 Beta
// */
//@Controller("testController")
//@RequestMapping(value = "/test")
//public class TestController {
//
//	@Resource(name = "historyServiceImpl")
//	private HistoryService historyService;
//
//	@Resource(name = "companyServiceImpl")
//	private CompanyService companyService;
//
//	@RequestMapping(value = "/saveHistory")
//	public String testSaveHistoryInfo(ModelMap modelMap) {
//		History entity = new History();
//		Infomation infomation = companyService.findInfomationById(Double
//				.valueOf(((ServletRequestAttributes) RequestContextHolder
//						.getRequestAttributes()).getRequest().getSession()
//						.getAttribute("enterpriseId").toString()));
//		entity.setInfomation(infomation);
//		entity.setId(RandomUtils.createIdentitySerialByUUID());
//		entity.setOperatecode(infomation.getId());
//		entity.setOperateDateTime(DateTimeUtils
//				.getNowDateOfStringFormatUsingDateTimeTemplateOne());
//		entity.setOperateProperty("δ֪����");
//		entity.setOperateValue("δ֪����");
//		boolean result = historyService.addNewHistoryInfoService(entity);
//		return "";
//	}
// }
