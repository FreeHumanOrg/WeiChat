package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.SafetyDao;
import com.weichat.dao.ServerDao;
import com.weichat.model.Qiyefuwu;
import com.weichat.service.ServerService;

/**
 * ��ҵ����ҵ��ӿڵ�ʵ����
 * 
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�ServerServiceImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����8:11:19
 * �޸��ˣ���˧�� �޸�ʱ�䣺����8:11:19 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("serverServiceImpl")
public class ServerServiceImpl extends BaseServiceImpl implements ServerService{
	@Resource(name = "serverDaoImpl")
	private ServerDao serverDao;
	@Override
	public Qiyefuwu findQiyefuwuById(Double id) {
		// TODO Auto-generated method stub
		return serverDao.findQiyefuwuById(id);
	}

}
