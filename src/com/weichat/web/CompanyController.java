package com.weichat.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weichat.dto.TreeNodeDTO;
import com.weichat.model.Infomation;
import com.weichat.model.User;
import com.weichat.service.CompanyService;
import com.weichat.service.UserService;
import com.weichat.util.DateTimeUtils;
import com.weichat.util.EncryptUtils;
import com.weichat.util.Page;
import com.weichat.util.PropertiesUtils;

/**
 * 
 * ��ҵҵ��ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�CompanyController.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����10:23:37
 * �޸��ˣ���˧�� �޸�ʱ�䣺2016-06-29 ����15:33:00 �޸ı�ע������û���Ϣ��֤����
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("companyController")
@RequestMapping(value = "/company")
public class CompanyController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(CompanyController.class);

	@Resource(name = "companyServiceImpl")
	private CompanyService companyService;

	@Resource(name = "userServiceImpl")
	private UserService userService;

	private String privateKey;

	public CompanyController() {
		privateKey = PropertiesUtils.getPropertiesFileAsObject(
				"global.properties").getProperty("weiqia.privatekey");
	}

	/**
	 * �û���Ϣ��֤
	 * 
	 * @param session
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/useraccess", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String useraccess(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap,
			@ModelAttribute Page<Infomation> page) {
		String openId = "", time = "", mCoId = "", s = "";
		// da72dd333788ad10fedf2db1ac514748 private_key
		String c = request.getParameter("c");
		String decryptstr = EncryptUtils.aesDecrypt(/*
													 * "da72dd333788ad10fedf2db1ac514748"
													 */privateKey, c);// ����
		System.out.println(decryptstr);
		String[] strs = decryptstr.split("&");
		for (String str : strs) {
			String[] r = str.split("=");
			if (r[0].equals("openId")) {
				openId = r[1];
			} else if (r[0].equals("time")) {
				time = r[1];
			} else if (r[0].equals("mCoId")) {
				mCoId = r[1];
			} else if (r[0].equals("s")) {
				s = r[1];
			}
		}
		// ��ȡ��ǰʱ�䣬��time�Ƚϣ���ʱ����
		Date datenow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		System.out.println((datenow.getTime() - date.getTime()) / 60000);
		if (((datenow.getTime() - date.getTime()) / 60000) > 60) {// ʱ��>10min
			return "/404";
		} else {
			// �ж��û��Ƿ����
			if (openId != "") {
				try {
					User user = userService.findUserByOpenId(openId);
					if (user != null) {// �û�����
						if (s.equals("web")) {// pc�˵�¼
							session.setAttribute("openId", openId);// ���û�openId�ŵ�session
							session.setAttribute("account", user.getAccount());
							session.setAttribute("userInfo", user);
							session.setAttribute("mcoid", mCoId);
							Page<Infomation> list = companyService
									.findAllService(page, mCoId);
							modelMap.addAttribute("page", list);
							return "/home/companylist";
						} else {// app�˵�¼
							session.setAttribute("openId", openId);// ���û�openId�ŵ�session
							session.setAttribute("account", user.getAccount());
							session.setAttribute("userInfo", user);
							session.setAttribute("mcoid", mCoId);
							Page<Infomation> list = companyService
									.findAllService(page, mCoId);
							modelMap.addAttribute("page", list);
							return "/mobile/home/companylist";
						}
					} else {// �û�������
						return "/404";
					}
				} catch (Exception e) {// ��������ѯ�쳣
					return "/404";
				}
			} else {// ��������ȫ
				return "/404";
			}
		}
	}

	/**
	 * ��ҵ�б���ҳ��
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/companylist", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String companylist(ModelMap modelMap,
			@ModelAttribute Page<Infomation> page, HttpSession session) {
		String mcoid = (String) session.getAttribute("mcoid");
		Page<Infomation> list = companyService.findAllService(page, mcoid);
		modelMap.addAttribute("page", list);
		return "/home/companylist";
	}

	/**
	 * ��ҵ����
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/companyshow", method = RequestMethod.GET)
	public String companyshow(HttpServletRequest request, ModelMap modelMap) {
		System.out
				.println("----------------------�����ѯ��ҵ���鷽��----------------------");
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("company", companyService.findInfomationById(id));
		return "/update/common/frame";
	}

	/**
	 * ��ҵ����
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/ebs", method = RequestMethod.GET)
	public String enterpriseBasicSituationShow(HttpServletRequest request,
			ModelMap modelMap) {
		LOGGER.info("��ת��enterprise_update_situation�µ�indexҳ��ɹ���"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("company", companyService.findInfomationById(id));
		return "/update/enterprise_update_situation/index";
	}

	/**
	 * �ֻ�����ҵ�б���ҳ��
	 * 
	 * @param modelMap
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/mobilelist", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String mobilelist(ModelMap modelMap,
			@ModelAttribute Page<Infomation> page, HttpSession session) {
		String mcoid = (String) session.getAttribute("mcoid");
		Page<Infomation> list = companyService.findAllService(page, mcoid);
		modelMap.addAttribute("page", list);
		return "/mobile/home/companylist";
	}

	@RequestMapping(value = "/ebu", method = RequestMethod.POST)
	public void enterpriseBasicSituationUpdate(HttpSession session,
			HttpServletResponse response, @ModelAttribute Infomation infomation)
			throws IOException {
		LOGGER.info("��ҵ��������޸�!"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		StringBuffer sbResult = new StringBuffer();
		String mcoid = (String) session.getAttribute("mcoid");
		infomation.setMcoid(mcoid);// mcoid
		if (companyService.updateInfomation(infomation)) {
			sbResult.append("<script>alert('��ϲ�������ѳɹ��޸ġ�'); parent.location.href='../company/companylist.jhtml';</script>");
		} else {
			sbResult.append("<script>alert('�ǳ���Ǹ���޸�����ʧ�ܣ����������Ĳ�����'); parent.location.href='../company/companylist.jhtml'</script>");
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

	/**
	 * ��ȡ���и�������Ϣ.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/getUsersInfo", method = RequestMethod.POST)
	@ResponseBody
	public Set<TreeNodeDTO> getUsersInfo(ModelMap modelMap, String enterpriseId) {
		/**
		 * ���������ҵ�ı�Ž������˷ֽ⵽������
		 */
		Infomation infomation = companyService.findInfomationById(Double
				.valueOf(enterpriseId));

		Set<TreeNodeDTO> treeNodeDTOs = new HashSet<TreeNodeDTO>();
		String[] genjinrenGroup = new String[] {};
		if (null != infomation.getGenjinren()) {
			// ���շֺŷָ������
			genjinrenGroup = infomation.getGenjinren().split(";");
		}
		List<User> usersList = userService.findAllService();

		boolean flag = false;
		for (User user : usersList) {
			flag = false;
			for (int j = 0; j < genjinrenGroup.length; j++) {
				if (user.getUsername().contains(genjinrenGroup[j])) {
					flag = true;
				}
			}

			treeNodeDTOs.add(new TreeNodeDTO(user.getId(), user.getUsername(),
					"icon-man", flag));
		}
		return treeNodeDTOs;
	}

	/**
	 * ���ĸ�������Ϣ.
	 * 
	 * @param modelMap
	 * @param enterpriseSituationId
	 *            ��ҵ���
	 * @param selectItems
	 *            �����˱��
	 * @return
	 */
	@RequestMapping(value = "/changeGenJinRenInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> changeGenJinRenInfo(
			ModelMap modelMap,
			@RequestParam String enterpriseSituationId,
			@RequestParam(value = "selectItems[]", required = false, defaultValue = "") String[] selectItems) {

		String latestGenJinRensToString = new String();

		// ���Ϊ�����ʾȡ�����и�����
		if (null != selectItems) {

			// ���ȸ��ݴ���ĸ����˱�Ų�ѯ�����еĸ�������Ϣ
			List<User> allGenJinRenInfo = userService
					.findUsersByIdsService(selectItems);

			// ֮�󽫲�ѯ�������и�������Ϣ���û������浽���µĲ�����
			for (int i = 0; i < allGenJinRenInfo.size(); i++) {
				latestGenJinRensToString += allGenJinRenInfo.get(i)
						.getUsername() + ";";
			}
			latestGenJinRensToString = latestGenJinRensToString.substring(0,
					latestGenJinRensToString.lastIndexOf(";"));
		} else {
			latestGenJinRensToString = null;
		}
		Map<String, String> resultMap = new HashMap<String, String>();

		if (companyService
				.updateGenJinRensInfoByEnterpriseSituationIdService(
						Double.valueOf(enterpriseSituationId),
						latestGenJinRensToString)) {
			resultMap.put("result", "success");
			LOGGER.info("���´���ҵ�ĸ����˳ɹ���"
					+ DateTimeUtils
							.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		} else {
			resultMap.put("result", "failed");
			LOGGER.error("���´���ҵ�ĸ�����ʧ�ܡ�"
					+ DateTimeUtils
							.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		}

		return resultMap;
	}

	/**
	 * ���¸���������Ϣ.
	 * 
	 * @param modelMap
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateProgress", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateProgress(ModelMap modelMap,
			String enterpriseSituationId, String progressValue,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		Infomation infomation = companyService.findInfomationById(Double
				.valueOf(enterpriseSituationId));
		infomation.setGenjinjindu(progressValue.contains("-1") ? null
				: progressValue);
		if (companyService.updateInfomation(infomation)) {
			map.put("result", "success");
		} else {
			map.put("result", "failed");
		}
		return map;
	}

	/**
	 * ɾ��һ����ҵ��Ϣ.
	 * 
	 * @param enterpriseSituationId
	 * @return
	 */
	@RequestMapping(value = "/delEnterpriseInfo", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteEnterpriseInfo(String enterpriseSituationId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (companyService.deleteEnterpriseInfoByIdService(Double
				.valueOf(enterpriseSituationId))) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "failed");
		}
		return resultMap;
	}
}
