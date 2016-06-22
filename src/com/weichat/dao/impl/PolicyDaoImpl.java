package com.weichat.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.weichat.dao.PolicyDao;
import com.weichat.model.Youhuizhengce;
/**
 * 
 * 优惠政策接口的实现类
 * 
 * 项目名称：WeiChat 类名称：PolicyDaoImpl.java 类描述：TODO 
 * 创建人：李帅康  创建时间：下午2:26:40 
 * 修改人：李帅康  修改时间： 下午2:26:40
 * 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("policyDaoImpl")
public class PolicyDaoImpl extends BaseDaoImpl implements PolicyDao{

	@Override
	public List<Youhuizhengce> findYouhuiById(Double id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Youhuizhengce where id=?",new Object[]{id});
	}
}
