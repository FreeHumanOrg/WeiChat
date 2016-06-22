package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.SafetyDao;
import com.weichat.model.Anquanshengchan;
import com.weichat.service.SafetyService;
/**
 * ��ȫ����ҵ��ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�SafetyServiceImpl.java ��������TODO 
 * �����ˣ���˧��  ����ʱ�䣺����4:27:57 
 * �޸��ˣ���˧��  �޸�ʱ�䣺 ����4:27:57
 * �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("safetyServiceImpl")
public class SafetyServiceImpl extends BaseServiceImpl implements SafetyService{
	
	@Resource(name = "safetyDaoImpl")
	private SafetyDao safetyDao;
	@Override
	public Anquanshengchan findAnquanshengchanById(Double id) {
		// TODO Auto-generated method stub
		return safetyDao.findAnquanshengchanById(id);
	}

}
