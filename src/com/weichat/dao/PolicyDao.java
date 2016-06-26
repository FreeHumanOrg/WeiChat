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
	List<Youhuizhengce> findYouhuisById(Double id);
	
	Youhuizhengce findYouhuizhengceById(Double id);
	/**
	 * ��ѯ�Ż���������Ƿ����
	 * @param id
	 * @return
	 */
	Boolean checkYouhuizhengce(Double id);
	/**
	 * �޸��Ż��������
	 * @param youhuizhengce
	 * @return
	 */
	Boolean updateYouhuizhengce(Youhuizhengce youhuizhengce);

	/**
	 * ���һ���Ż��������.
	 * 
	 * @param youhuizhengce
	 * @return
	 */
	Boolean addNewPolicy(Youhuizhengce youhuizhengce);
}
