package com.weichat.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.weichat.job.WeqiaClient;
import com.weichat.model.OpenEmployeeForm;
import com.weichat.model.OpenEmployeeListForm;
import com.weichat.model.User;
import com.weichat.service.UserService;
import com.weichat.util.PropertiesUtils;
import com.weichat.util.RandomUtils;

/**
 * 任务类
 * 
 * 项目名称：WeiChat 类名称：MyJob.java 类描述：TODO 创建人：李帅康 创建时间：上午9:21:55 修改人：李帅康 修改时间：
 * 上午9:21:55 修改备注：每隔两小时调用findEmployeeList()同步一次用户信息
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Component
public class MyJob {

	@Resource(name = "userServiceImpl")
	private UserService userService;

	private static String cono, privateKey, openId,serviceurl;

	public MyJob() {
		Properties prop = PropertiesUtils
				.getPropertiesFileAsObject("global.properties");
		openId = prop.getProperty("weiqia.openid");
		cono = prop.getProperty("weiqia.cono");
		privateKey = prop.getProperty("weiqia.privatekey");
		serviceurl=prop.getProperty("weiqia.serviceurl");
	}

	/**
	 * @Description 初始化企业信息
	 * @return
	 * 
	 */
	private static WeqiaClient initWeqiaClient() {
		// 192.168.0.27
		// return new WeqiaClient("2205794","30bbcdb301cfc56390e4e25849ff0f25");
		// return new WeqiaClient("jingtang_test",
		// "da72dd333788ad10fedf2db1ac514748");
		return new WeqiaClient(cono, privateKey,serviceurl);
		// 192.168.0.81测试环境
		// return new
		// WeqiaClient("jingtang_test","da72dd333788ad10fedf2db1ac514748");

		// return new WeqiaClient("super8","b17fdf3949c5716f9b34c176747c5898");
	}

	/**
	 * 
	 * @Description 接口: 1007 获取员工详情 - 测试
	 * 
	 */
	@SuppressWarnings("unused")
	private static void testFindEmployee() {
		WeqiaClient wqClient = initWeqiaClient();
		OpenEmployeeForm openId = new OpenEmployeeForm();
		// openId.setOpenId("4028809b558f992f01558f9932980001");
		openId.setOpenId(MyJob.openId);
		String sRet = wqClient.findEmployee(openId);
		System.out.println(sRet);
	}

	/**
	 * 
	 * @Description 接口: 1006 获取员工列表 - 测试
	 * 
	 */
	private void findEmployeeList() {
		WeqiaClient wqClient = initWeqiaClient();
		OpenEmployeeListForm form = new OpenEmployeeListForm();
		form.setStartRow(0);// 分页开始
		form.setEndRow(50);// 分页结束
		form.setPageSize(1);
		String sRet = wqClient.findEmployeeList(form);
		System.out.println(sRet);
		List<User> userlist = userService.findAllService();// 查询本地用户数据
		// 处理同步的用户json数据
		JSONObject jsonObject = JSONObject.fromObject(sRet);
		// 此处需要处理
		// {"error":"参数校验错误","data":null,"errorCode":"-16","success":false}
		// {"total":8,"ret":8,"list":[{"openId":"8a25e3ed540dd92901540dd96b950001","name":"zhengxy001","account":"zhengxy001","email":null,"mobile":null,"sex":1,"jobnumber":null,"department":null,"gmtModify":1460521233000,"position":null,"status":1},{"openId":"8a25e3ed540dd92901540e25529d0004","name":"admin8","account":"admin8","email":null,"mobile":null,"sex":1,"jobnumber":null,"department":null,"gmtModify":1460526213000,"position":null,"status":4},{"openId":"4028803e4ca378ab014ca3792d1f0001","name":"admin","account":"admin","email":null,"mobile":"13588022831","sex":null,"jobnumber":null,"department":null,"gmtModify":1460545517000,"position":null,"status":1},{"openId":"8a25e3ed5413f6840155801d8a800043","name":"test001","account":"test001","email":null,"mobile":null,"sex":1,"jobnumber":null,"department":null,"gmtModify":1466733275000,"position":null,"status":1},{"openId":"8a25e3ed540dd92901540dd929580000","name":"单建华","account":"sjh001","email":null,"mobile":null,"sex":1,"jobnumber":null,"department":null,"gmtModify":1466733309000,"position":null,"status":1},{"openId":"8a25e3ed540dd92901540dd99f3e0002","name":"立洋","account":"qily001","email":null,"mobile":null,"sex":1,"jobnumber":null,"department":null,"gmtModify":1466733336000,"position":null,"status":1},{"openId":"8a25e3ed55906b400155906b40f50000","name":"寇洋","account":"kouyang001","email":null,"mobile":null,"sex":1,"jobnumber":null,"department":null,"gmtModify":1467006796000,"position":null,"status":1},{"openId":"8a25e3ed540dd92901540e24c48f0003","name":"sam001","account":"sam001","email":null,"mobile":null,"sex":1,"jobnumber":null,"department":null,"gmtModify":1467198128000,"position":null,"status":1}]}
		// if(jsonObject.get("success").equals(false)){
		// return;
		// }
		JSONArray jsonArray = jsonObject.getJSONArray("list");

		List<String> strs = new ArrayList<>();
		if (userlist != null && userlist.size() > 0) {// 存在用户数据
			for (User user : userlist) {
				strs.add(user.getOpenid());
			}
			for (Object object : jsonArray) {
				JSONObject obj = JSONObject.fromObject(object);
				String openId = obj.getString("openId");
				String account = obj.getString("account");
				String name = obj.getString("name");
				System.out.println(openId + "," + account + "," + name);
				if (strs.contains(openId)) {
				} else {
					User inituser = new User();
					inituser.setId(RandomUtils.createIdentitySerialByUUID());// 主键ID
					inituser.setAccount(account);// 同步过来的账户
					inituser.setName(name);// 同步过来的用户名
					inituser.setUsername(name);// 用户名
					inituser.setOpenid(openId);// 同步过来的openid
					userService.addUser(inituser);
				}
			}
		} else {// 不存在用户数据
			for (Object object : jsonArray) {
				JSONObject obj = JSONObject.fromObject(object);
				String openId = obj.getString("openId");
				String account = obj.getString("account");
				String name = obj.getString("name");
				User inituser = new User();
				inituser.setId(RandomUtils.createIdentitySerialByUUID());// 主键ID
				inituser.setAccount(account);// 同步过来的账户
				inituser.setName(name);// 同步过来的用户名
				inituser.setUsername(name);// 用户名
				inituser.setOpenid(openId);// 同步过来的openid
				userService.addUser(inituser);
			}
		}
	}
}
