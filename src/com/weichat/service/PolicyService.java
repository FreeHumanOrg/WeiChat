package com.weichat.service;

import java.util.List;

import com.weichat.model.Youhuizhengce;

/**
 * 
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�PolicyService.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����2:00:11 �޸��ˣ���˧��
 * �޸�ʱ�䣺 ����2:00:11 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface PolicyService extends BaseService {
	List<Youhuizhengce> findYouhuiById(Double id);
}
