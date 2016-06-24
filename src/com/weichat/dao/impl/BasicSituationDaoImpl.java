package com.weichat.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.dao.BasicSituationDao;
import com.weichat.model.Infomation;

/**
 * ��ҵ��������ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�BasicSituationDaoImpl.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��22��
 * ����3:11:10 �޸��ˣ����� �޸�ʱ�䣺2016��6��22�� ����3:11:10 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("basicSituationDaoImpl")
public class BasicSituationDaoImpl extends BaseDaoImpl<Infomation, Double>
		implements BasicSituationDao {

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Boolean addBasicSituationOfEnterprise(Infomation information) {
		try {
			super.save(information);
			return true;
		} catch (DataAccessException e) {
		}
		return false;
	}

	@Override
	public Infomation findById(Double id) {
		return super.findById(id);
	}
}
