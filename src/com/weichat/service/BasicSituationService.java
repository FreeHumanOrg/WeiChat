package com.weichat.service;

import com.weichat.model.Infomation;

/**
 * ��ҵ�������ҵ��ӿ�
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�BasicSituationService.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��22��
 * ����3:11:32 �޸��ˣ����� �޸�ʱ�䣺2016��6��22�� ����3:11:32 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface BasicSituationService extends BaseService<Infomation, Double> {
	/**
	 * �����ҵ�������.
	 * 
	 * @param information
	 * @return
	 */
	Double addBasicSituationOfEnterpriseService(Infomation information);

	/**
	 * ���ݱ�Ų���Infomation����.
	 * 
	 * @param id
	 * @return
	 */
	Infomation findByIdService(Double id);
}
