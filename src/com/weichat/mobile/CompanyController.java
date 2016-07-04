package com.weichat.mobile;

import java.io.IOException;
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
import com.weichat.util.Page;

/**
 * 
 * 企业业务接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：CompanyController.java 类描述：TODO 创建人：李帅康 创建时间：下午10:23:37
 * 修改人：李帅康 修改时间：下午10:23:37 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Controller("companyControllerMobile")
@RequestMapping(value = "/companymobile")
public class CompanyController {
	private static Logger LOGGER = LoggerFactory
			.getLogger(CompanyController.class);

	@Resource(name = "companyServiceImpl")
	private CompanyService companyService;

	@Resource(name = "userServiceImpl")
	private UserService userService;

	/**
	 * 
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/mobileshow", method = RequestMethod.GET)
	public String mobileshow(HttpServletRequest request, ModelMap modelMap) {
		System.out
				.println("----------------------进入手机端查询企业详情方法----------------------");
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("company", companyService.findInfomationById(id));
		return "/mobile/update/common/frame";
	}

	/**
	 * 手机端企业基本详情
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/mobileebs", method = RequestMethod.GET)
	public String enterpriseBasicSituationMobileShow(
			HttpServletRequest request, ModelMap modelMap) {
		LOGGER.info("跳转到enterprise_update_situation下的index页面成功！"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Double id = Double.parseDouble(request.getParameter("id"));
		modelMap.addAttribute("company", companyService.findInfomationById(id));
		return "/mobile/update/enterprise_update_situation/index";
	}

	@RequestMapping(value = "/ebu", method = RequestMethod.POST)
	public void enterpriseBasicSituationUpdate(HttpSession session,HttpServletResponse response,
			@ModelAttribute Infomation infomation) throws IOException {
		LOGGER.info("手机端企业基本情况修改!"
				+ DateTimeUtils
						.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		StringBuffer sbResult = new StringBuffer();
		String mcoid=(String)session.getAttribute("mcoid");
		infomation.setMcoid(mcoid);//mcoid
		if (companyService.updateInfomation(infomation)) {
			sbResult.append("<script>alert('恭喜！数据已成功修改。'); parent.location.href='../company/mobilelist.jhtml';</script>");
		} else {
			sbResult.append("<script>alert('非常抱歉，修改数据失败！请重试您的操作。'); parent.location.href='../company/mobilelist.jhtml'</script>");
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(sbResult.toString());
	}

	/**
	 * 企业列表（主页）
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/companylist", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String companylist(ModelMap modelMap,
			@ModelAttribute Page<Infomation> page,HttpSession session) {
		String mcoid=(String)session.getAttribute("mcoid");
		Page<Infomation> list = companyService.findAllService(page,mcoid);
		modelMap.addAttribute("page", list);
		return "/mobile/home/companylist";
	}

	/**
	 * 获取所有跟进人信息.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/getUsersInfo", method = RequestMethod.POST)
	@ResponseBody
	public Set<TreeNodeDTO> getUsersInfo(ModelMap modelMap, String enterpriseId) {
		/**
		 * 根据这个企业的编号将跟进人分解到数组中
		 */
		Infomation infomation = companyService.findInfomationById(Double
				.valueOf(enterpriseId));

		Set<TreeNodeDTO> treeNodeDTOs = new HashSet<TreeNodeDTO>();
		String[] genjinrenGroup = new String[] {};
		if (null != infomation.getGenjinren()) {
			// 按照分号分割跟进人
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
	 * 更改跟进人信息.
	 * 
	 * @param modelMap
	 * @param enterpriseSituationId
	 *            企业编号
	 * @param selectItems
	 *            跟进人编号
	 * @return
	 */
	@RequestMapping(value = "/changeGenJinRenInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> changeGenJinRenInfo(
			ModelMap modelMap,
			@RequestParam String enterpriseSituationId,
			@RequestParam(value = "selectItems[]", required = false, defaultValue = "") String[] selectItems) {

		String latestGenJinRensToString = new String();

		// 如果为空则表示取消所有跟进人
		if (null != selectItems) {

			// 首先根据传入的跟进人编号查询出所有的跟进人信息
			List<User> allGenJinRenInfo = userService
					.findUsersByIdsService(selectItems);

			// 之后将查询出的所有跟进人信息的用户名保存到更新的参数中
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
			LOGGER.info("更新此企业的跟进人成功。"
					+ DateTimeUtils
							.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		} else {
			resultMap.put("result", "failed");
			LOGGER.error("更新此企业的跟进人失败。"
					+ DateTimeUtils
							.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		}

		return resultMap;
	}

	/**
	 * 更新跟进进度信息.
	 * 
	 * @param modelMap
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateProgress", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> updateProgress(ModelMap modelMap,
			String enterpriseSituationId, String progressValue,
			HttpServletResponse response) throws IOException {
		Map<String, String> resultMap = new HashMap<String, String>();
		Infomation infomation = companyService.findInfomationById(Double
				.valueOf(enterpriseSituationId));
		infomation.setGenjinjindu(progressValue.contains("-1") ? null
				: progressValue);
		if (companyService.updateInfomation(infomation)) {
			resultMap.put("result", "successed");
		} else {
			resultMap.put("result", "failed");
		}
		return resultMap;
	}

	/**
	 * 删除一个企业信息.
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
