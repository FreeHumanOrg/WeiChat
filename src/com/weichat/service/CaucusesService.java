package com.weichat.service;

import com.weichat.model.Dangtuanjianshe;

/**
 * ���Ž���ҵ��ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�CaucusesService.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����8:21:51 �޸��ˣ���˧��
 * �޸�ʱ�䣺����8:21:51 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface CaucusesService extends BaseService<Dangtuanjianshe, Double> {
	Dangtuanjianshe findDangtuanjiansheById(Double id);
}
