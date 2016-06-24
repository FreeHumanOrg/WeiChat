package com.weichat.service;

import java.io.Serializable;
import java.util.List;

import com.weichat.dao.impl.BaseDaoImpl.SearchType;
import com.weichat.util.Page;

/**
 * DAO基类业务接口
 * 
 * 
 * 项目名称：WeiChat 类名称：BaseDaoImpl.java 类描述：TODO 创建人：王晶 创建时间：2016-6-20 上午11:30:04
 * 修改人：王晶 修改时间：2016-6-20 上午11:30:04 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface BaseService<T, ID extends Serializable> {
	/**
	 * 查询全部信息.
	 * 
	 * @return
	 */
	List<T> findAllService();

	/**
	 * 根据编号查询实体对象.
	 * 
	 * @param id
	 * @return
	 */
	T findByIdService(ID id);

	/**
	 * 分页查找实体对象.
	 * 
	 * @param pageable
	 * @return
	 */
	Page<T> findPageService(Page<T> pageable, SearchType searchType);

	/**
	 * 持久化实体对象.
	 * 
	 * @param entity
	 * @return
	 */
	Boolean saveService(T entity);

	/**
	 * 更新实体对象.
	 * 
	 * @param entity
	 * @return
	 */
	Boolean updateService(T entity);

	/**
	 * 删除实体对象.
	 * 
	 * @param entity
	 * @return
	 */
	Boolean removeService(T entity);
}
