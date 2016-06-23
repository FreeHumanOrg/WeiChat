package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.ExpendDao;
import com.weichat.model.Qiyefazhan;
import com.weichat.service.ExpendService;

/**
 * ��ҵ��չҵ��ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�ExpandServiceImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����8:02:59
 * �޸��ˣ���˧�� �޸�ʱ�䣺����8:02:59 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("expendServiceImpl")
public class ExpendServiceImpl extends BaseServiceImpl<Qiyefazhan, Double>
		implements ExpendService {
	@Resource(name = "expendDaoImpl")
	private ExpendDao expendDao;

	@Override
	public Qiyefazhan findQiyefazhanById(Double id) {
		return expendDao.findQiyefazhanById(id);
	}

}
