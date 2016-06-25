package com.weichat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.BasicSituationDao;
import com.weichat.dao.DevelopmentDao;
import com.weichat.model.Guotu;
import com.weichat.model.Jiansejindu;
import com.weichat.model.Productpeoper;
import com.weichat.model.Yaosu;
import com.weichat.model.Zhengwuqingkuang;
import com.weichat.service.DevelopmentService;
import com.weichat.util.RandomUtils;

/**
 * �������ҵ��ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�DevelopmentServiceImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����2:24:32
 * �޸��ˣ���˧�� �޸�ʱ�䣺 ����2:24:32 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("developmentServiceImpl")
public class DevelopmentServiceImpl extends BaseServiceImpl<Object, Double>
		implements DevelopmentService {
	@Resource(name = "developmentDaoImpl")
	private DevelopmentDao developmentDao;

	@Resource(name = "basicSituationDaoImpl")
	private BasicSituationDao basicSituationDao;

	@Override
	public List<Productpeoper> findProductpeoperById(Double id) {
		return developmentDao.findProductpeoperById(id);
	}

	@Override
	public Boolean addNewProductPeoperFromDevelopmentService(
			Productpeoper productpeoper, Double enterpriseSituationId) {
		productpeoper.setId(RandomUtils.createIdentitySerialByUUID());
		productpeoper.setInfomation(basicSituationDao
				.findById(enterpriseSituationId));
		return developmentDao.addNewProductPeoperFromDevelopment(productpeoper);
	}

	@Override
	public Boolean addNewGovernmentSituationFromDevelopmentService(
			Zhengwuqingkuang zhengwuqingkuang, Double enterpriseSituationId) {
		zhengwuqingkuang.setId(RandomUtils.createIdentitySerialByUUID());
		zhengwuqingkuang.setInfomation(basicSituationDao
				.findById(enterpriseSituationId));
		return developmentDao
				.addNewGovernmentSituationFromDevelopment(zhengwuqingkuang);
	}

	@Override
	public Boolean addNewLandSituationFromDevelopmentService(Guotu guotu,
			Double enterpriseSituationId) {
		guotu.setId(RandomUtils.createIdentitySerialByUUID());
		guotu.setInfomation(basicSituationDao.findById(enterpriseSituationId));
		return developmentDao.addNewLandSituationFromDevelopment(guotu);
	}

	@Override
	public Boolean addNewElementsOfSecurityFromDevelopmentService(Yaosu yaosu,
			Double enterpriseSituationId) {
		yaosu.setId(RandomUtils.createIdentitySerialByUUID());
		yaosu.setInfomation(basicSituationDao.findById(enterpriseSituationId));
		return developmentDao.addNewElementsOfSecurityFromDevelopment(yaosu);
	}

	@Override
	public Boolean addNewProjectBuildToProgressFromDevelopmentService(
			Jiansejindu jiansejindu, Double enterpriseSituationId) {
		jiansejindu.setId(RandomUtils.createIdentitySerialByUUID());
		jiansejindu.setInfomation(basicSituationDao
				.findById(enterpriseSituationId));
		return developmentDao
				.addNewProjectBuildToProgressFromDevelopment(jiansejindu);
	}

}
