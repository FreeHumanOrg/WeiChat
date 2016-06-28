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
import com.weichat.service.PartyService;
import com.weichat.util.DateTimeUtils;

/**
 * ���Ž���Controller
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�PartyController.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����12:14:53
 * �޸��ˣ���˧�� �޸�ʱ�䣺����12:14:53 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("partyController")
@RequestMapping(value = "/party")
public class PartyController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(PartyController.class);

	@Resource(name = "partyServiceImpl")
	private PartyService partyService;

	/**
	 * ��ѯ���Ž�������
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/partyshow", method = RequestMethod.GET)
	public String partyShow(HttpServletRequest request, ModelMap modelMap) {
		LOGGER.info("��ת��enterprise_update_situation�µ�partyҳ��ɹ���"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("party", partyService.findDangtuanjiansheById(id));
		modelMap.addAttribute("id", id);
		return "/update/enterprise_update_situation/party";
	}

	/**
	 * �޸ĵ��Ž�������
	 * 
	 * @param response
	 * @param dangtuanjianshe
	 * @throws IOException
	 */
	@RequestMapping(value = "/partyupdate", method = RequestMethod.POST)
	public void updateAnquanshengchan(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute Dangtuanjianshe dangtuanjianshe) throws IOException {
		LOGGER.info("��ҵ���Ž����޸�!"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		StringBuffer sbResult = new StringBuffer();
		// �ж���ҵ��ȫ�Ƿ����
		if (partyService.checkDangtuanjianshe(dangtuanjianshe.getInfomation()
				.getId())) {// ����
			if (partyService.updateDangtuanjianshe(dangtuanjianshe)) {
				sbResult.append("<script>alert('��ϲ�������ѳɹ��޸ġ�'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('�ǳ���Ǹ���޸�����ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		} else {// ������
			if (partyService.addDangtuanjiansheService(
					dangtuanjianshe,dangtuanjianshe.getInfomation().getId())) {
				sbResult.append("<script>alert('��ϲ�������ѳɹ�¼�롣'); parent.location.href='../company/companylist.jhtml';</script>");
			} else {
				sbResult.append("<script>alert('�ǳ���Ǹ��¼������ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

	/**
	 * ���һ�����Ž�����Ϣ.
	 * 
	 * @param response
	 * @param dangtuanjianshe
	 * @throws IOException
	 */
	@RequestMapping(value = "/partyadd", method = RequestMethod.POST)
	public void updateParty(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute Dangtuanjianshe dangtuanjianshe) throws IOException {
		StringBuffer sbResult = new StringBuffer();

		if (partyService.addDangtuanjiansheService(
				dangtuanjianshe,
				Double.valueOf(request.getSession()
						.getAttribute("enterpriseId").toString()))) {
			sbResult.append("<script>alert('��ϲ�������ѳɹ�¼�롣'); parent.location.href='../company/companylist.jhtml';</script>");
		} else {
			sbResult.append("<script>alert('�ǳ���Ǹ��¼������ʧ�ܣ����������Ĳ�����'); history.go(-1);</script>");
		}

		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

}
