package com.weichat.dao.impl;

import java.util.List;

import com.weichat.dao.CompanyDao;
import com.weichat.model.Infomation;

/**
 * 企业接口的实现类
 * 
 * 
 * 项目名称：WeiChat 
 * 类名称：CompanyDaoImpl.java 
 * 类描述：TODO 
 * 创建人：李帅康
 * 创建时间：下午6:54:28
 * 修改人：李帅康
 * 修改时间： 下午6:54:28
 * 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class CompanyDaoImpl extends BaseDaoImpl implements CompanyDao {

	@Override
	public List<Infomation> findAll() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Infomation");
	}

}
