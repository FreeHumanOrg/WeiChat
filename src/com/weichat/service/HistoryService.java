package com.weichat.service;

import com.weichat.interceptor.IHistory;
import com.weichat.model.History;

/**
 * ��ʷ��¼ҵ��ӿ�
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�HistoryService.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��28��
 * ����12:19:37 �޸��ˣ����� �޸�ʱ�䣺2016��6��28�� ����12:19:37 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface HistoryService extends BaseService<History, Double> {

	/**
	 * ���һ������ʷ��¼.
	 * 
	 * @param history
	 * @return
	 */
	Boolean addNewHistoryInfoService(String operateType, IHistory logInfomations);
}
