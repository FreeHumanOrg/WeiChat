package com.weichat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.BasicSituationDao;
import com.weichat.dao.PolicyDao;
import com.weichat.model.Youhuizhengce;
import com.weichat.service.PolicyService;
import com.weichat.util.RandomUtils;

/**
 * 
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�PolicyServiceImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����2:00:39
 * �޸��ˣ���˧�� �޸�ʱ�䣺 ����2:00:39 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("policyServiceImpl")
public class PolicyServiceImpl extends BaseServiceImpl<Youhuizhengce, Double>
		implements PolicyService {
	@Resource(name = "policyDaoImpl")
	private PolicyDao policyDao;

	@Resource(name = "basicSituationDaoImpl")
	private BasicSituationDao basicSituationDao;

	@Override
	public List<Youhuizhengce> findYouhuisById(Double id) {
		return policyDao.findYouhuisById(id);
	}
	@Override
	public Youhuizhengce findYouhuizhengceById(Double id) {
		return policyDao.findYouhuizhengceById(id);
	}
	@Override
	public Boolean addNewPolicyService(Youhuizhengce youhuizhengce,
			Double enterpriseSituationId) {
		youhuizhengce.setId(RandomUtils.createIdentitySerialByUUID());
//		youhuizhengce.setInfomation(basicSituationDao
//				.findById(enterpriseSituationId));
		return policyDao.addNewPolicy(youhuizhengce);
	}

	@Override
	public Boolean checkYouhuizhengce(Double id) {
		return policyDao.checkYouhuizhengce(id);
	}

	@Override
	public Boolean updateYouhuizhengce(Youhuizhengce youhuizhengce) {
		return policyDao.updateYouhuizhengce(youhuizhengce);
	}
	@Override
	public Boolean delPolicy(Double itemId) {
		Youhuizhengce youhuizhengce=policyDao.findById(itemId);
		return policyDao.delPolicy(youhuizhengce);
	}
}
