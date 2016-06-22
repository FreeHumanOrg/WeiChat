package com.weichat.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.dao.BasicSituationDao;
import com.weichat.model.Infomation;
import com.weichat.util.RandomUtils;

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
public class BasicSituationDaoImpl extends BaseDaoImpl implements
		BasicSituationDao {
	private static Logger LOGGER = LoggerFactory
			.getLogger(BasicSituationDaoImpl.class);

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Boolean addBasicSituationOfEnterprise(Infomation information) {
		try {
			information.setId(RandomUtils.createIdentitySerialByUUID());
			hibernateTemplate.save(information);
		} catch (DataAccessException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}
}