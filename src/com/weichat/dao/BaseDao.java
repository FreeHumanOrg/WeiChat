package com.weichat.dao;

import java.io.Serializable;
import java.util.List;

import com.weichat.dao.impl.BaseDaoImpl.OrderType;
import com.weichat.dao.impl.BaseDaoImpl.SearchType;
import com.weichat.util.Page;

/**
 * DAO基类接口
 * 
 * 项目名称：WeiChat 类名称：BaseDaoImpl.java 类描述：TODO 创建人：王晶 创建时间：2016-6-20 上午11:30:04
 * 修改人：王晶 修改时间：2016-6-20 上午11:30:04 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface BaseDao<T, ID extends Serializable> {
	/**
	 * 查询全部信息.
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * 根据编号查询实体对象.
	 * 
	 * @param id
	 * @return
	 */
	T findById(ID id);

	/**
	 * 根据企业编号查询子模块实体对象
	 * 
	 * @param id
	 * @return
	 */
	T findTById(ID id);

	/**
	 * 根据编号查询实体对象集合.
	 * 
	 * @param id
	 * @return
	 */
	List<T> findsById(ID id);

	/**
	 * 分页查找实体对象.
	 * 
	 * @param pageable
	 * @return
	 */
	Page<T> findPage(Page<T> pageable, SearchType searchType, String mcoid);

	/**
	 * 持久化实体对象.
	 * 
	 * @param entity
	 * @return
	 */
	Boolean save(T entity);

	/**
	 * 更新实体对象.
	 * 
	 * @param entity
	 * @return
	 */
	Boolean update(T entity);

	/**
	 * 删除实体对象.
	 * 
	 * @param entity
	 * @return
	 */
	Boolean remove(T entity);

	/**
	 * 分页查找实体对象并排序
	 * 
	 * @param page
	 * @param searchType
	 * @param orderType
	 * @param columnName
	 * @return
	 */
	Page<T> findPage(Page<T> page, SearchType searchType, OrderType orderType,
			String columnName);
}
