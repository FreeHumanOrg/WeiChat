package com.weichat.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.weichat.dao.DevelopmentDao;
import com.weichat.model.Productpeoper;
/**
 * ��������ӿ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�DevelopmentDaoImpl.java ��������TODO 
 * �����ˣ���˧��  ����ʱ�䣺����2:23:06 
 * �޸��ˣ���˧��  �޸�ʱ�䣺 ����2:23:06
 * �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("developmentDaoImpl")
public class DevelopmentDaoImpl extends BaseDaoImpl implements DevelopmentDao{

	@Override
	public List<Productpeoper> findProductpeoperById(Double id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Productpeoper");
	}

}
