package com.weichat.service;

import com.weichat.model.Dangtuanjianshe;
/**
 * ���Ž���ҵ��ӿ�
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�PartyService.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����12:12:53
 * �޸��ˣ���˧�� �޸�ʱ�䣺����12:12:53 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface PartyService extends BaseService<Dangtuanjianshe, Double> {
	Dangtuanjianshe findDangtuanjiansheById(Double id);
}
