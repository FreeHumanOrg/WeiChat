package com.weichat.dao;

import java.util.List;

import com.weichat.model.Productpeoper;

/**
 * 
 * ��������ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�DevelopmentDao.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����2:03:30 �޸��ˣ���˧��
 * �޸�ʱ�䣺 ����2:03:30 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface DevelopmentDao extends BaseDao {
	/**
	 * ��ѯ������Ŀ�ٽ���ϵ��
	 * 
	 * @param id
	 * @return
	 */
	List<Productpeoper> findProductpeoperById(Double id);
}
