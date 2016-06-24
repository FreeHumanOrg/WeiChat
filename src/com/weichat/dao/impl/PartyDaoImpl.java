package com.weichat.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.weichat.dao.PartyDao;
import com.weichat.model.Dangtuanjianshe;
/**
 * ���Ž���ӿڵ�ʵ����
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�PartyDaoImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����12:11:58
 * �޸��ˣ���˧�� �޸�ʱ�䣺����12:11:58 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("partyDaoImpl")
public class PartyDaoImpl extends BaseDaoImpl<Dangtuanjianshe, Double> implements PartyDao{
	private static Logger LOGGER = LoggerFactory
			.getLogger(PartyDaoImpl.class);
	@Override
	public Dangtuanjianshe findDangtuanjiansheById(Double id) {
		// TODO Auto-generated method stub
		return findById(id);
	}

}
