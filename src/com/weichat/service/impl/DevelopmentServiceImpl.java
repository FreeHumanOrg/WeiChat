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
 * 建设情况业务接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：DevelopmentServiceImpl.java 类描述：TODO 创建人：李帅康 创建时间：下午2:24:32
 * 修改人：李帅康 修改时间： 下午2:24:32 修改备注：
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
