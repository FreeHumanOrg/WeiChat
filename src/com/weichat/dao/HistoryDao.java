package com.weichat.dao;

import java.util.List;

import com.weichat.model.History;

/**
 * ��ʷ��¼�ӿ�
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�HistoryDao.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��28�� ����12:15:30
 * �޸��ˣ����� �޸�ʱ�䣺2016��6��28�� ����12:15:30 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface HistoryDao extends BaseDao<History, Double> {

	/**
	 * ���һ������ʷ��¼.
	 * 
	 * @param history
	 * @return
	 */
	Boolean addNewHistoryInfo(History history);

	/**
	 * �־û���ʷ��¼.
	 * 
	 * @param history
	 * @return
	 */
	Boolean persistHistoryInfo(History history);

	/**
	 * ��ѯȫ����ʷ��¼.
	 * 
	 * @param enterpriseSituationId
	 * @return
	 */
	List<History> findAllHistoryInfo();
}
