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
	/**
	 * ������Ŀ�ٽ���ϵ��
	 */
	@Override
	public Boolean addNewProductPeoperFromDevelopmentService(
			Productpeoper productpeoper, Double enterpriseSituationId) {
		productpeoper.setId(RandomUtils.createIdentitySerialByUUID());
		productpeoper.setInfomation(basicSituationDao
				.findById(enterpriseSituationId));
		return developmentDao.addNewProductPeoperFromDevelopment(productpeoper);
	}
	/**
	 * ��������������
	 */
	@Override
	public Boolean addNewGovernmentSituationFromDevelopmentService(
			Zhengwuqingkuang zhengwuqingkuang, Double enterpriseSituationId) {
		zhengwuqingkuang.setId(RandomUtils.createIdentitySerialByUUID());
		zhengwuqingkuang.setInfomation(basicSituationDao
				.findById(enterpriseSituationId));
		return developmentDao
				.addNewGovernmentSituationFromDevelopment(zhengwuqingkuang);
	}
	/**
	 * ���������������
	 */
	@Override
	public Boolean addNewLandSituationFromDevelopmentService(Guotu guotu,
			Double enterpriseSituationId) {
		guotu.setId(RandomUtils.createIdentitySerialByUUID());
		guotu.setInfomation(basicSituationDao.findById(enterpriseSituationId));
		return developmentDao.addNewLandSituationFromDevelopment(guotu);
	}
	/**
	 * ����Ҫ�ر���
	 */
	@Override
	public Boolean addNewElementsOfSecurityFromDevelopmentService(Yaosu yaosu,
			Double enterpriseSituationId) {
		yaosu.setId(RandomUtils.createIdentitySerialByUUID());
		yaosu.setInfomation(basicSituationDao.findById(enterpriseSituationId));
		return developmentDao.addNewElementsOfSecurityFromDevelopment(yaosu);
	}
	/**
	 * ������Ŀ�������
	 */
	@Override
	public Boolean addNewProjectBuildToProgressFromDevelopmentService(
			Jiansejindu jiansejindu, Double enterpriseSituationId) {
		jiansejindu.setId(RandomUtils.createIdentitySerialByUUID());
		jiansejindu.setInfomation(basicSituationDao
				.findById(enterpriseSituationId));
		return developmentDao
				.addNewProjectBuildToProgressFromDevelopment(jiansejindu);
	}
	/**
	 * ������ҵ��Ų�ѯ��Ŀ�ٽ���ϵ��
	 */
	@Override
	public Productpeoper findProductpeoperById(Double id) {
		return developmentDao.findProductpeoperById(id);
	}
	/**
	 * ������ҵ��Ų�ѯ��Ŀ����ٽ����Ƿ����
	 */
	@Override
	public Boolean checkProductpeoperById(Double id) {
		return developmentDao.checkProductpeoperById(id);
	}

	@Override
	public Boolean updateProductpeoper(Productpeoper productpeoper) {
		return developmentDao.updateProductpeoper(productpeoper);
	}

	@Override
	public Zhengwuqingkuang findZhengwuqingkuangById(Double id) {
		return developmentDao.findZhengwuqingkuangById(id);
	}

	@Override
	public Guotu findGuotuById(Double id) {
		return developmentDao.findGuotuById(id);
	}

	@Override
	public Yaosu findYaosuById(Double id) {
		return developmentDao.findYaosuById(id);
	}

	@Override
	public Jiansejindu findJiansejinduById(Double id) {
		return developmentDao.findJiansejinduById(id);
	}
	@Override
	public Boolean checkZhengwuqingkuang(Double id) {
		return developmentDao.checkZhengwuqingkuangById(id);
	}
	@Override
	public Boolean checkGuotu(Double id) {
		return developmentDao.checkGuotuById(id);
	}
	@Override
	public Boolean checkYaosu(Double id) {
		return developmentDao.checkYaosuById(id);
	}
	@Override
	public Boolean checkJiansejindu(Double id) {
		return developmentDao.checkJiansejinduById(id);
	}
	@Override
	public Boolean updateZhengwuqingkuang(Zhengwuqingkuang zhengwuqingkuang) {
		return developmentDao.updateZhengwuqingkuang(zhengwuqingkuang);
	}
	@Override
	public Boolean updateGuotu(Guotu guotu) {
		return developmentDao.updateGuotu(guotu);
	}
	@Override
	public Boolean updateYaosu(Yaosu yaosu) {
		return developmentDao.updateYaosu(yaosu);
	}
	@Override
	public Boolean updateJiansejindu(Jiansejindu jiansejindu) {
		return developmentDao.updateJiansejindu(jiansejindu);
	}

}
