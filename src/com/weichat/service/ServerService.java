package com.weichat.service;

import com.weichat.model.Qiyefuwu;

/**
 * ��ҵ����ҵ��ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�ServerService.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����8:10:25 �޸��ˣ���˧��
 * �޸�ʱ�䣺����8:10:25 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface ServerService extends BaseService<Qiyefuwu, Double> {
	Qiyefuwu findQiyefuwuById(Double id);
}
