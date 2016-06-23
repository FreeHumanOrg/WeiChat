package com.weichat.dao;

import com.weichat.model.Anquanshengchan;

/**
 * ��ȫ�����ӿ�
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�SafetyDao.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����4:17:06 �޸��ˣ���˧�� �޸�ʱ�䣺
 * ����4:17:06 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface SafetyDao extends BaseDao<Anquanshengchan, Double> {
	Anquanshengchan findAnquanshengchanById(Double id);
	
	Boolean updateAnquanshengchan(Anquanshengchan anquanshengchan);
	
	Boolean checkAnquanshengchan(Double id);
	
	Boolean addAnquanshengchan(Anquanshengchan anquanshengchan);
}
