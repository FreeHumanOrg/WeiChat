package com.weichat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.DevelopmentDao;
import com.weichat.model.Productpeoper;
import com.weichat.service.DevelopmentService;
/**
 * �������ҵ��ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�DevelopmentServiceImpl.java ��������TODO 
 * �����ˣ���˧��  ����ʱ�䣺����2:24:32 
 * �޸��ˣ���˧��  �޸�ʱ�䣺 ����2:24:32
 * �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("developmentServiceImpl")
public class DevelopmentServiceImpl implements DevelopmentService {
	@Resource(name = "developmentDaoImpl")
	private DevelopmentDao developmentDao;
	
	@Override
	public List<Productpeoper> findProductpeoperById(Double id) {
		// TODO Auto-generated method stub
		return developmentDao.findProductpeoperById(id);
	}

}
