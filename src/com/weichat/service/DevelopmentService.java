package com.weichat.service;

import java.util.List;

import com.weichat.model.Guotu;
import com.weichat.model.Jiansejindu;
import com.weichat.model.Productpeoper;
import com.weichat.model.Yaosu;
import com.weichat.model.Zhengwuqingkuang;

/**
 * 
 * �������ҵ��ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�DevelopmentService.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����2:23:14
 * �޸��ˣ���˧�� �޸�ʱ�䣺 ����2:23:14 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface DevelopmentService extends BaseService<Object, Double> {
	List<Productpeoper> findProductpeoperById(Double id);

	/**
	 * ���һ���µ���Ŀ�ٽ���ϵ����Ϣ.
	 * 
	 * @param productpeoper
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean addNewProductPeoperFromDevelopmentService(
			Productpeoper productpeoper, Double enterpriseSituationId);

	/**
	 * ���һ���µ�������������Ϣ.
	 * 
	 * @param zhengwuqingkuang
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean addNewGovernmentSituationFromDevelopmentService(
			Zhengwuqingkuang zhengwuqingkuang, Double enterpriseSituationId);

	/**
	 * ���һ���µĹ������������Ϣ.
	 * 
	 * @param guotu
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean addNewLandSituationFromDevelopmentService(Guotu guotu,
			Double enterpriseSituationId);

	/**
	 * ���һ���µ�Ҫ�ر�����Ϣ.
	 * 
	 * @param yaosu
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean addNewElementsOfSecurityFromDevelopmentService(Yaosu yaosu,
			Double enterpriseSituationId);

	/**
	 * ���һ���µ���Ŀ���������Ϣ.
	 * 
	 * @param jiansejindu
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean addNewProjectBuildToProgressFromDevelopmentService(
			Jiansejindu jiansejindu, Double enterpriseSituationId);
}
