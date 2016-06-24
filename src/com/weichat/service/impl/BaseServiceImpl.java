package com.weichat.service.impl;

import java.io.Serializable;
import java.util.List;

import com.weichat.dao.BaseDao;
import com.weichat.dao.impl.BaseDaoImpl.SearchType;
import com.weichat.service.BaseService;
import com.weichat.util.Page;

/**
 * DAO基类业务接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：BaseDaoImpl.java 类描述：TODO 创建人：王晶 创建时间：2016-6-20 上午11:30:04
 * 修改人：王晶 修改时间：2016-6-20 上午11:30:04 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class BaseServiceImpl<T, ID extends Serializable> implements
		BaseService<T, ID> {

	/**
	 * DAO基类的属性
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
