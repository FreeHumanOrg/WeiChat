package com.weichat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.PolicyDao;
import com.weichat.model.Youhuizhengce;
import com.weichat.service.PolicyService;

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

	@Override
	public List<Youhuizhengce> findYouhuiById(Double id) {
		return policyDao.findYouhuiById(id);
	}

}
