package com.weichat.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weichat.model.Dangtuanjianshe;
import com.weichat.model.Qiyefuwu;
import com.weichat.service.SafetyService;
import com.weichat.service.ServerService;
import com.weichat.util.DateTimeUtils;
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
	
	@RequestMapping(value = "/servershow", method = RequestMethod.GET)
	public String serverShow(HttpServletRequest request, ModelMap modelMap) {
		LOGGER.info("跳转到enterprise_update_situation下的server页面成功！"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("safety", serverService.findQiyefuwuById(id));
		modelMap.addAttribute("id", id);
		return "/update/enterprise_update_situation/server";
	}
	
	/**
	 * 修改企业服务
	 * @param response
	 * @param dangtuanjianshe
	 * @throws IOException
	 */
	@RequestMapping(value = "/partyupdate", method = RequestMethod.POST)
	public void updateQiyefuwu(HttpServletResponse response,@ModelAttribute Qiyefuwu qiyefuwu)throws IOException{
		LOGGER.info("企业服务修改!"+DateTimeUtils.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		StringBuffer sbResult = new StringBuffer();
		//判断企业安全是否存在
		if(serverService.checkQiyefuwu(qiyefuwu.getInfomation().getId())){//存在
			if (serverService.updateQiyefuwu(qiyefuwu)) {
				sbResult.append("<script>alert('恭喜！数据已成功修改。'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('非常抱歉，修改数据失败！请重试您的操作。'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		}else{//不存在
			//调用新增方法
			
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}
}
