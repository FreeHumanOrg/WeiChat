package com.weichat.dao;

import com.weichat.model.Dangtuanjianshe;

/**
 * ���Ž���ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�CaucusesDao.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����8:16:50 �޸��ˣ���˧��
 * �޸�ʱ�䣺����8:16:50 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface CaucusesDao extends BaseDao<Dangtuanjianshe, Double> {
	/**
	 * ������ҵid��ѯ���Ž���
	 * 
	 * @param id
	 * @return
	 */
	Dangtuanjianshe findDangtuanjiansheById(Double id);
}
