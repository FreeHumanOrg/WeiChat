package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.BasicSituationDao;
import com.weichat.model.Infomation;
import com.weichat.service.BasicSituationService;
import com.weichat.util.RandomUtils;

/**
 * ��ҵ�������ҵ��ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�BasicSituationServiceImpl.java ��������TODO �����ˣ�����
 * ����ʱ�䣺2016��6��22�� ����3:13:18 �޸��ˣ����� �޸�ʱ�䣺2016��6��22�� ����3:13:18 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("basicSituationServiceImpl")
public class BasicSituationServiceImpl extends
		BaseServiceImpl<Infomation, Double> implements BasicSituationService {

	@Resource(name = "basicSituationDaoImpl")
	private BasicSituationDao basicSituationDao;

	@Override
	public Double addBasicSituationOfEnterpriseService(Infomation information) {
		Double randomIdentity = RandomUtils.createIdentitySerialByUUID();
		information.setId(randomIdentity);
		// �ɹ���������ID
		if (basicSituationDao.addBasicSituationOfEnterprise(information)) {
			return randomIdentity;
		} else {
			// ʧ�ܷ��ر�ʶ��-1
			return -1.0;
		}
	}

	@Override
	public Infomation findByIdService(Double id) {
		return basicSituationDao.findById(id);
	}
}
