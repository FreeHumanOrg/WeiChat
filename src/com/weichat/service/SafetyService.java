package com.weichat.service;

import com.weichat.model.Anquanshengchan;
/**
 * ��ȫ����ҵ��ӿ�
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�SafetyService.java ��������TODO 
 * �����ˣ���˧��  ����ʱ�䣺����4:33:52 
 * �޸��ˣ���˧��  �޸�ʱ�䣺 ����4:33:52
 * �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface SafetyService extends BaseService {
	Anquanshengchan findAnquanshengchanById(Double id);
}
