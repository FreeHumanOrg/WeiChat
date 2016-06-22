package com.weichat.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.weichat.dao.CompanyDao;
import com.weichat.model.Infomation;

/**
 * ��ҵ�ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�CompanyDaoImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����6:54:28 �޸��ˣ���˧��
 * �޸�ʱ�䣺 ����6:54:28 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("companyDaoImpl")
public class CompanyDaoImpl extends BaseDaoImpl implements CompanyDao {

	@Override
	public List<Infomation> findAll() {
		return this.hibernateTemplate.find("from Infomation");
	}

	@Override
	public Infomation findInfomationById(Double id) {
		return (Infomation) this.hibernateTemplate.find(
				"from Infomation where id=?", new Object[] { id }).get(0);
	}

}
