package com.weichat.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.weichat.dao.BaseDao;

/**
 * DAO基类接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：BaseDaoImpl.java 类描述：TODO 创建人：王晶 创建时间：2016-6-20 上午11:30:04
 * 修改人：王晶 修改时间：2016-6-20 上午11:30:04 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class BaseDaoImpl implements BaseDao {
	@Resource
	protected HibernateTemplate hibernateTemplate;
}
