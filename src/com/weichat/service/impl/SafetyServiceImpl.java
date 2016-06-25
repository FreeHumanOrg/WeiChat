package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.BasicSituationDao;
import com.weichat.dao.SafetyDao;
import com.weichat.model.Anquanshengchan;
import com.weichat.service.SafetyService;
import com.weichat.util.RandomUtils;

/**
 * ��ȫ����ҵ��ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�SafetyServiceImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����4:27:57
 * �޸��ˣ���˧�� �޸�ʱ�䣺 ����4:27:57 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("safetyServiceImpl")
public class SafetyServiceImpl extends BaseServiceImpl<Anquanshengchan, Double>
		implements SafetyService {

	@Resource(name = "safetyDaoImpl")
	private SafetyDao safetyDao;

	@Resource(name = "basicSituationDaoImpl")
	private BasicSituationDao basicSituationDao;

	@Override
	public Anquanshengchan findAnquanshengchanById(Double id) {
		return safetyDao.findAnquanshengchanById(id);
	}

	@Override
	public Boolean updateAnquanshengchan(Anquanshengchan anquanshengchan) {
		return safetyDao.updateAnquanshengchan(anquanshengchan);
	}

	@Override
	public Boolean checkAnquanshengchan(Double id) {
		return safetyDao.checkAnquanshengchan(id);
	}

	@Override
	public Boolean addAnquanshengchan(Anquanshengchan anquanshengchan,
			Double enterpriseSituationId) {
		anquanshengchan.setId(RandomUtils.createIdentitySerialByUUID());
		anquanshengchan.setInfomation(basicSituationDao
				.findById(enterpriseSituationId));
		return safetyDao.addAnquanshengchan(anquanshengchan);
	}

}
