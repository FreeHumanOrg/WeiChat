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
	
	@RequestMapping(value = "/servershow", method = RequestMethod.GET)
	public String serverShow(HttpServletRequest request, ModelMap modelMap) {
		LOGGER.info("��ת��enterprise_update_situation�µ�serverҳ��ɹ���"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("safety", serverService.findQiyefuwuById(id));
		modelMap.addAttribute("id", id);
		return "/update/enterprise_update_situation/server";
	}
	
	/**
	 * �޸���ҵ����
	 * @param response
	 * @param dangtuanjianshe
	 * @throws IOException
	 */
	@RequestMapping(value = "/partyupdate", method = RequestMethod.POST)
	public void updateQiyefuwu(HttpServletResponse response,@ModelAttribute Qiyefuwu qiyefuwu)throws IOException{
		LOGGER.info("��ҵ�����޸�!"+DateTimeUtils.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		StringBuffer sbResult = new StringBuffer();
		//�ж���ҵ��ȫ�Ƿ����
		if(serverService.checkQiyefuwu(qiyefuwu.getInfomation().getId())){//����
			if (serverService.updateQiyefuwu(qiyefuwu)) {
				sbResult.append("<script>alert('��ϲ�������ѳɹ��޸ġ�'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('�ǳ���Ǹ���޸�����ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		}else{//������
			//������������
			
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}
}
