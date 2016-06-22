package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.CaucusesDao;
import com.weichat.model.Dangtuanjianshe;
import com.weichat.service.CaucusesService;
/**
 * ���Ž���ҵ��ӿڵ�ʵ����
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�CaucusesServiceImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����8:22:55
 * �޸��ˣ���˧�� �޸�ʱ�䣺����8:22:55 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("caucusesServiceImpl")
public class CaucusesServiceImpl extends BaseServiceImpl implements CaucusesService {
	@Resource(name = "caucusesDaoImpl")
	private CaucusesDao caucusesDao;
	@Override
	public Dangtuanjianshe findDangtuanjiansheById(Double id) {
		// TODO Auto-generated method stub
		return caucusesDao.findDangtuanjiansheById(id);
	}

}
