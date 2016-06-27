package com.weichat.service;

import com.weichat.model.Infomation;
import com.weichat.util.Page;

/**
 * 
 * ��ҵҵ��ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�CompanyService.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����6:58:56 �޸��ˣ���˧��
 * �޸�ʱ�䣺 ����6:58:56 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface CompanyService extends BaseService<Infomation, Double> {
	Page<Infomation> findAllService(Page<Infomation> pageable);

	Infomation findInfomationById(Double id);

	Boolean updateInfomation(Infomation infomation);

	/**
	 * ������ҵ��Ÿ�����ҵ��������Ϣ.
	 * 
	 * @param enterpriseSituationId
	 * @param genJinRenGroup
	 * @return
	 */
	Boolean updateGenJinRensInfoByEnterpriseSituationIdService(
			Double enterpriseSituationId, String latestGenJinRensToString);

	/**
	 * ������ҵ���ɾ��һ����ҵ��Ϣ.
	 * 
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean deleteEnterpriseInfoByIdService(Double enterpriseSituationId);
}
