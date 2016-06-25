package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.BasicSituationDao;
import com.weichat.dao.ExpendDao;
import com.weichat.model.Qiyefazhan;
import com.weichat.service.ExpendService;
import com.weichat.util.RandomUtils;

/**
 * ��ҵ��չҵ��ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�ExpandServiceImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����8:02:59
 * �޸��ˣ���˧�� �޸�ʱ�䣺����8:02:59 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("expendServiceImpl")
public class ExpendServiceImpl extends BaseServiceImpl<Qiyefazhan, Double>
		implements ExpendService {
	@Resource(name = "expendDaoImpl")
	private ExpendDao expendDao;

	@Resource(name = "basicSituationDaoImpl")
	private BasicSituationDao basicSituationDao;

	@Override
	public Qiyefazhan findQiyefazhanById(Double id) {
		return expendDao.findQiyefazhanById(id);
	}

	@Override
	public Boolean checkQiyefazhan(Double id) {
		return expendDao.checkQiyefazhan(id);
	}

	@Override
	public Boolean updateQiyefazhan(Qiyefazhan qiyefazhan) {
		return expendDao.updateQiyefazhan(qiyefazhan);
	}

	@Override
	public Boolean addNewExpendService(Qiyefazhan qiyefazhan,
			Double enterpriseSituationId) {
		qiyefazhan.setId(RandomUtils.createIdentitySerialByUUID());
		qiyefazhan.setInfomation(basicSituationDao
				.findById(enterpriseSituationId));
		return expendDao.addNewExpend(qiyefazhan);
	}

}
