package com.weichat.job;

import java.util.List;






import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.weichat.model.OpenEmployeeForm;
import com.weichat.model.OpenEmployeeListForm;
import com.weichat.model.User;
import com.weichat.service.UserService;
import com.weichat.util.RandomUtils;


/**
 * 任务类
 * 
 * 项目名称：WeiChat 类名称：MyJob.java 类描述：TODO 
 * 创建人：李帅康  创建时间：上午9:21:55 
 * 修改人：李帅康  修改时间： 上午9:21:55
 * 修改备注：每隔两小时同步一次用户信息
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class MyJob{

	public void doWork(){
		//
		new MyJob().findEmployeeList();;
	}
	
	/**
	 * 
	 * @Description 初始化企业信息
	 * @return  
	 *
	 */
	private static WeqiaClient initWeqiaClient(){
		//192.168.0.27
		//return new WeqiaClient("2205794","30bbcdb301cfc56390e4e25849ff0f25");
		return new WeqiaClient("jingtang_test", "da72dd333788ad10fedf2db1ac514748");
		//192.168.0.81测试环境
//		return new WeqiaClient("jingtang_test","da72dd333788ad10fedf2db1ac514748");
		
		//return new WeqiaClient("super8","b17fdf3949c5716f9b34c176747c5898");
	}
	
	/**
	 * 
	 *  @Description  接口: 1007   获取员工详情  - 测试
	 *  
	 */
	private static void testFindEmployee(){
		WeqiaClient wqClient = initWeqiaClient();
		OpenEmployeeForm openId = new OpenEmployeeForm();
		openId.setOpenId("4028809b558f992f01558f9932980001");
		String sRet = wqClient.findEmployee(openId);
		System.out.println(sRet);
	}
	
	/**
	 * 
	 * @Description  接口: 1006   获取员工列表  - 测试
	 *
	 */
	private void findEmployeeList(){
		WeqiaClient wqClient = initWeqiaClient();
		OpenEmployeeListForm form = new OpenEmployeeListForm();
		form.setStartRow(0);//分页开始
		form.setEndRow(10);//分页结束
		form.setPageSize(1);
		String sRet = wqClient.findEmployeeList(form);
		System.out.println(sRet);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:cn/../applicationContext.xml"); 
		UserService userService = (UserService) applicationContext.getBean("userService");
		List<User>userlist=userService.findAllService();
		//处理同步的用户json数据
		JSONObject jsonObject=JSONObject.fromObject(sRet);
		JSONArray jsonArray=jsonObject.getJSONArray("list");
		for (Object object : jsonArray) {
			JSONObject obj=JSONObject.fromObject(object);
			System.out.println(obj.get("openId"));
			String openId=obj.getString("openId");
			String account=obj.getString("account");
			String name=obj.getString("name");
			if(userlist!=null&&userlist.size()>0){//更新
				for (User users : userlist) {
					if(users.getOpenid().equals(openId)&&users.getAccount().equals(account)){
						
					}else{
						User user=new User();
						user.setId(RandomUtils.createIdentitySerialByUUID());//主键ID
						user.setAccount(account);//同步过来的账户
						user.setName(name);//同步过来的用户名
						user.setUsername(name);//用户名
						user.setOpenid(openId);//同步过来的openid
						userService.saveService(user);
					}
				}
			}else{//第一次初始化数据
				User inituser=new User();
				inituser.setId(RandomUtils.createIdentitySerialByUUID());//主键ID
				inituser.setAccount(account);//同步过来的账户
				inituser.setName(name);//同步过来的用户名
				inituser.setUsername(name);//用户名
				inituser.setOpenid(openId);//同步过来的openid
				userService.addUser(inituser);
			}
		}
	}
}
