package com.weichat.service;

import com.weichat.model.Qiyefazhan;

/**
 * ��ҵ��չҵ��ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�ExpendService.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����7:59:57
 * �޸��ˣ���˧�� �޸�ʱ�䣺����7:59:57 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface ExpendService extends BaseService{
	Qiyefazhan findQiyefazhanById(Double id);
}