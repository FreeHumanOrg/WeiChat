package com.weichat.dao;

import com.weichat.model.Qiyefuwu;

/**
 * ��ҵ����ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�ServerDao.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����8:05:57 �޸��ˣ���˧��
 * �޸�ʱ�䣺����8:05:57 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface ServerDao extends BaseDao<Qiyefuwu, Double> {
	/**
	 * ������ҵid��ѯ��ҵ����
	 * 
	 * @param id
	 * @return
	 */
	Qiyefuwu findQiyefuwuById(Double id);
}
