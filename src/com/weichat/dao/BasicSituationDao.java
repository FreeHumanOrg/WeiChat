package com.weichat.dao;

import com.weichat.model.Infomation;

/**
 * ��ҵ��������ӿ�
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�BasicSituationDao.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��22��
 * ����3:10:12 �޸��ˣ����� �޸�ʱ�䣺2016��6��22�� ����3:10:12 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface BasicSituationDao extends BaseDao<Infomation, Double> {
	/**
	 * �����ҵ�������.
	 * 
	 * @param information
	 * @return
	 */
	Boolean addBasicSituationOfEnterprise(Infomation information);
}
