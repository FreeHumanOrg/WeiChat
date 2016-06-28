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
// * 用于单元测试的Controller
// * 
// * 
// * 项目名称：WeiChat 类名称：TestController.java 类描述：TODO 创建人：王晶 创建时间：2016年6月28日
// * 下午1:00:30 修改人：王晶 修改时间：2016年6月28日 下午1:00:30 修改备注：
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
//		entity.setOperateProperty("未知属性");
//		entity.setOperateValue("未知操作");
//		boolean result = historyService.addNewHistoryInfoService(entity);
//		return "";
//	}
// }
