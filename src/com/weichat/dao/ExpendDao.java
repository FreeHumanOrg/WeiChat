package com.weichat.dao;

import com.weichat.model.Qiyefazhan;

/**
 * ��ҵ��չ�ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�ExpendDao.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����7:54:17 �޸��ˣ���˧��
 * �޸�ʱ�䣺����7:54:17 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface ExpendDao extends BaseDao<Qiyefazhan, Double> {
	/**
	 * ������ҵid��ѯ��ҵ��չ
	 * 
	 * @param id
	 * @return
	 */
	Qiyefazhan findQiyefazhanById(Double id);
	
	Boolean checkQiyefazhan(Double id);
	
	Boolean updateQiyefazhan(Qiyefazhan qiyefazhan);
}
