package com.weichat.service.impl;

import java.io.Serializable;
import java.util.List;

import com.weichat.dao.BaseDao;
import com.weichat.dao.impl.BaseDaoImpl.SearchType;
import com.weichat.service.BaseService;
import com.weichat.util.Page;

/**
 * DAO����ҵ��ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�BaseDaoImpl.java ��������TODO �����ˣ����� ����ʱ�䣺2016-6-20 ����11:30:04
 * �޸��ˣ����� �޸�ʱ�䣺2016-6-20 ����11:30:04 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class BaseServiceImpl<T, ID extends Serializable> implements
		BaseService<T, ID> {

	/**
	 * DAO���������
	 */
	private BaseDao<T, ID> baseDao;

	public void setBaseDao(BaseDao<T, ID> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<T> findAllService() {
		return baseDao.findAll();
	}

	@Override
	public T findByIdService(ID id) {
		return baseDao.findById(id);
	}

	@Override
	public Page<T> findPageService(Page<T> pageable, SearchType searchType) {
		return baseDao.findPage(pageable, searchType);
	}

	@Override
	public Boolean saveService(T entity) {
		return baseDao.save(entity);
	}

	@Override
	public Boolean removeService(T entity) {
		return baseDao.save(entity);
	}

	@Override
	public Boolean updateService(T entity) {
		return baseDao.update(entity);
	}

}
