package com.weichat.dao;

import java.util.List;

import com.weichat.model.Youhuizhengce;

/**
 * 
 * �Ż����߽ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�PolicyDao.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����1:57:03 �޸��ˣ���˧�� �޸�ʱ�䣺
 * ����1:57:03 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface PolicyDao extends BaseDao<Youhuizhengce, Double> {
	List<Youhuizhengce> findYouhuiById(Double id);
}
