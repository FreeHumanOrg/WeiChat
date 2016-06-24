package com.weichat.service;

import java.io.Serializable;
import java.util.List;

import com.weichat.dao.impl.BaseDaoImpl.SearchType;
import com.weichat.util.Page;

/**
 * DAO����ҵ��ӿ�
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�BaseDaoImpl.java ��������TODO �����ˣ����� ����ʱ�䣺2016-6-20 ����11:30:04
 * �޸��ˣ����� �޸�ʱ�䣺2016-6-20 ����11:30:04 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface BaseService<T, ID extends Serializable> {
	/**
	 * ��ѯȫ����Ϣ.
	 * 
	 * @return
	 */
	List<T> findAllService();

	/**
	 * ���ݱ�Ų�ѯʵ�����.
	 * 
	 * @param id
	 * @return
	 */
	T findByIdService(ID id);

	/**
	 * ��ҳ����ʵ�����.
	 * 
	 * @param pageable
	 * @return
	 */
	Page<T> findPageService(Page<T> pageable, SearchType searchType);

	/**
	 * �־û�ʵ�����.
	 * 
	 * @param entity
	 * @return
	 */
	Boolean saveService(T entity);

	/**
	 * ����ʵ�����.
	 * 
	 * @param entity
	 * @return
	 */
	Boolean updateService(T entity);

	/**
	 * ɾ��ʵ�����.
	 * 
	 * @param entity
	 * @return
	 */
	Boolean removeService(T entity);
}
