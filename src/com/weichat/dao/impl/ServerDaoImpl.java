package com.weichat.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.weichat.dao.ServerDao;
import com.weichat.model.Qiyefuwu;

/**
 * 企业服务接口的实现类
 * 
 * 项目名称：WeiChat 类名称：ServerDaoImpl.java 类描述：TODO 创建人：李帅康 创建时间：下午8:06:56
 * 修改人：李帅康 修改时间：下午8:06:56 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("serverDaoImpl")
public class ServerDaoImpl extends BaseDaoImpl implements ServerDao{

	@Override
	public Qiyefuwu findQiyefuwuById(Double id) {
		// TODO Auto-generated method stub
		List<Qiyefuwu>list=this.hibernateTemplate.find("from Qiyefuwu t where t.infomation.id=?",new Object[]{id});
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
