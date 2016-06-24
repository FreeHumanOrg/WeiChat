package com.weichat.dao;

import com.weichat.model.Dangtuanjianshe;

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
	/**
	 * ���µ��Ž�����Ϣ
	 * @param anquanshengchan
	 * @return
	 */
	Boolean updateDangtuanjianshe(Dangtuanjianshe dangtuanjianshe);
	/**
	 * ������ҵid��ѯ���Ž�����Ϣ�Ƿ����
	 * @param id
	 * @return
	 */
	Boolean checkDangtuanjianshe(Double id);
	/**
	 * �������Ž�����Ϣ
	 * @param dangtuanjianshe
	 * @return
	 */
	Boolean addDangtuanjianshe(Dangtuanjianshe dangtuanjianshe);
}
