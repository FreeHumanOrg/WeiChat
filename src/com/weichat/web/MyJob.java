package com.weichat.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.weichat.job.WeqiaClient;
import com.weichat.model.OpenEmployeeForm;
import com.weichat.model.OpenEmployeeListForm;
import com.weichat.model.User;
import com.weichat.service.UserService;
import com.weichat.util.RandomUtils;


/**
 * ������
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�MyJob.java ��������TODO 
 * �����ˣ���˧��  ����ʱ�䣺����9:21:55 
 * �޸��ˣ���˧��  �޸�ʱ�䣺 ����9:21:55
 * �޸ı�ע��ÿ����Сʱͬ��һ���û���Ϣ
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Component
public class MyJob{
	
	@Resource(name = "userServiceImpl")
	private UserService userService;

	/**
	 * 
	 * @Description ��ʼ����ҵ��Ϣ
	 * @return  
	 *
	 */
	private static WeqiaClient initWeqiaClient(){
		//192.168.0.27
		//return new WeqiaClient("2205794","30bbcdb301cfc56390e4e25849ff0f25");
		return new WeqiaClient("jingtang_test", "da72dd333788ad10fedf2db1ac514748");
		//192.168.0.81���Ի���
//		return new WeqiaClient("jingtang_test","da72dd333788ad10fedf2db1ac514748");
		
		//return new WeqiaClient("super8","b17fdf3949c5716f9b34c176747c5898");
	}
	
	/**
	 * 
	 *  @Description  �ӿ�: 1007   ��ȡԱ������  - ����
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
	 * @Description  �ӿ�: 1006   ��ȡԱ���б�  - ����
	 *
	 */
	private void findEmployeeList(){
		WeqiaClient wqClient = initWeqiaClient();
		OpenEmployeeListForm form = new OpenEmployeeListForm();
		form.setStartRow(0);//��ҳ��ʼ
		form.setEndRow(10);//��ҳ����
		form.setPageSize(1);
		String sRet = wqClient.findEmployeeList(form);
		System.out.println(sRet);
		List<User>userlist=userService.findAllService();
		//����ͬ�����û�json����
		JSONObject jsonObject=JSONObject.fromObject(sRet);
		JSONArray jsonArray=jsonObject.getJSONArray("list");
				
		List<String>strs=new ArrayList<>();
		if(userlist!=null&&userlist.size()>0){//�����û�����
			for (User user : userlist) {
				strs.add(user.getOpenid());
			}
			for (Object object : jsonArray) {
				JSONObject obj=JSONObject.fromObject(object);
				String openId=obj.getString("openId");
				String account=obj.getString("account");
				String name=obj.getString("name");
				System.out.println(openId+","+account+","+name);
				if(strs.isEmpty()&&strs.contains(openId)){
					break;
				}else{
					User inituser=new User();
					inituser.setId(RandomUtils.createIdentitySerialByUUID());//����ID
					inituser.setAccount(account);//ͬ���������˻�
					inituser.setName(name);//ͬ���������û���
					inituser.setUsername(name);//�û���
					inituser.setOpenid(openId);//ͬ��������openid
					userService.addUser(inituser);
				}
			}
		}else{//�������û�����
			for (Object object : jsonArray) {
				JSONObject obj=JSONObject.fromObject(object);
				String openId=obj.getString("openId");
				String account=obj.getString("account");
				String name=obj.getString("name");
				User inituser=new User();
				inituser.setId(RandomUtils.createIdentitySerialByUUID());//����ID
				inituser.setAccount(account);//ͬ���������˻�
				inituser.setName(name);//ͬ���������û���
				inituser.setUsername(name);//�û���
				inituser.setOpenid(openId);//ͬ��������openid
				userService.addUser(inituser);
			}
		}
	}
}
