package com.weichat.dao.impl;

import java.util.List;

import com.weichat.dao.CompanyDao;
import com.weichat.model.Infomation;

/**
 * ��ҵ�ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat 
 * �����ƣ�CompanyDaoImpl.java 
 * ��������TODO 
 * �����ˣ���˧��
 * ����ʱ�䣺����6:54:28
 * �޸��ˣ���˧��
 * �޸�ʱ�䣺 ����6:54:28
 * �޸ı�ע��
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
