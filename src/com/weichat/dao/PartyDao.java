package com.weichat.dao;

import com.weichat.model.Dangtuanjianshe;
import com.weichat.model.Qiyefuwu;

/**
 * ���Ž���ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�PartyDao.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����12:02:34
 * �޸��ˣ���˧�� �޸�ʱ�䣺����12:02:34 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface PartyDao extends BaseDao<Dangtuanjianshe, Double> {
	/**
	 * ������ҵID��ѯ���Ž���
	 * @param id
	 * @return
	 */
	Dangtuanjianshe findDangtuanjiansheById(Double id);
}
