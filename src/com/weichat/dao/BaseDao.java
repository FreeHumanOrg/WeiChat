package com.weichat.dao;

import java.io.Serializable;
import java.util.List;

import com.weichat.dao.impl.BaseDaoImpl.SearchType;
import com.weichat.util.Page;
import com.weichat.util.Pageable;

/**
 * DAO����ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�BaseDaoImpl.java ��������TODO �����ˣ����� ����ʱ�䣺2016-6-20 ����11:30:04
 * �޸��ˣ����� �޸�ʱ�䣺2016-6-20 ����11:30:04 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface BaseDao<T, ID extends Serializable> {
	/**
	 * ��ѯȫ����Ϣ.
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * ���ݱ�Ų�ѯʵ�����.
	 * 
	 * @param id
	 * @return
	 */
	T findById(ID id);

	/**
	 * ���ݱ�Ų�ѯʵ����󼯺�.
	 * 
	 * @param id
	 * @return
	 */
	List<T> findsById(ID id);

	/**
	 * ��ҳ����ʵ�����.
	 * 
	 * @param pageable
	 * @return
	 */
	Page<T> findPage(Pageable pageable, SearchType searchType);

	/**
	 * �־û�ʵ�����.
	 * 
	 * @param entity
	 * @return
	 */
	Boolean save(T entity);

	/**
	 * ����ʵ�����.
	 * 
	 * @param entity
	 * @return
	 */
	Boolean update(T entity);

	/**
	 * ɾ��ʵ�����.
	 * 
	 * @param entity
	 * @return
	 */
	Boolean remove(T entity);
}
