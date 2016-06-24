package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.PartyDao;
import com.weichat.dao.SafetyDao;
import com.weichat.model.Dangtuanjianshe;
import com.weichat.service.PartyService;
/**
 * ���Ž���ҵ��ӿڵ�ʵ����
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�PartyServiceImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����12:13:09
 * �޸��ˣ���˧�� �޸�ʱ�䣺����12:13:09 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("partyServiceImpl")
public class PartyServiceImpl extends BaseServiceImpl<Dangtuanjianshe, Double> implements PartyService{
	@Resource(name = "partyDaoImpl")
	private PartyDao partyDao;
	@Override
	public Dangtuanjianshe findDangtuanjiansheById(Double id) {
		// TODO Auto-generated method stub
		return partyDao.findDangtuanjiansheById(id);
	}

}
