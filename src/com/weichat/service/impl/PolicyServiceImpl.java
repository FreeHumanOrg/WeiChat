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
 * 项目名称：WeiChat 类名称：PolicyServiceImpl.java 类描述：TODO 创建人：李帅康 创建时间：下午2:00:39
 * 修改人：李帅康 修改时间： 下午2:00:39 修改备注：
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
