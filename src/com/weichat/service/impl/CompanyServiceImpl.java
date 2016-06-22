package com.weichat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.CompanyDao;
import com.weichat.model.Infomation;
import com.weichat.service.CompanyService;

/**
 * 
 * �û�ҵ��ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�CompanyServiceImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����10:22:57
 * �޸��ˣ���˧�� �޸�ʱ�䣺����10:22:57 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("companyServiceImpl")
public class CompanyServiceImpl extends BaseServiceImpl implements
		CompanyService {
	@Resource(name = "companyDaoImpl")
	private CompanyDao companyDao;

	@Override
	public List<Infomation> findAllService() {
		return companyDao.findAll();
	}

	@Override
	public Infomation findInfomationById(Double id) {
		return companyDao.findInfomationById(id);
	}

}
