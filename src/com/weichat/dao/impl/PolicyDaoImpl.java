package com.weichat.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.weichat.dao.PolicyDao;
import com.weichat.model.Youhuizhengce;
/**
 * 
 * �Ż����߽ӿڵ�ʵ����
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�PolicyDaoImpl.java ��������TODO 
 * �����ˣ���˧��  ����ʱ�䣺����2:26:40 
 * �޸��ˣ���˧��  �޸�ʱ�䣺 ����2:26:40
 * �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("policyDaoImpl")
public class PolicyDaoImpl extends BaseDaoImpl implements PolicyDao{

	@Override
	public List<Youhuizhengce> findYouhuiById(Double id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Youhuizhengce where id=?",new Object[]{id});
	}
}
