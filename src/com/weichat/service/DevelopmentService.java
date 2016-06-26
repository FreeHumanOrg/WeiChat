package com.weichat.service;

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
	/**
	 * ������ҵid��ѯ��Ŀ�ٽ���ϵ��
	 * @param id
	 * @return
	 */
	Productpeoper findProductpeoperById(Double id);
	/**
	 * ������ҵid��ѯ�������
	 * @param id
	 * @return
	 */
	Zhengwuqingkuang findZhengwuqingkuangById(Double id);
	/**
	 * ������ҵid��ѯ�����������
	 * @param id
	 * @return
	 */
	Guotu findGuotuById(Double id);
	/**
	 * ������ҵid��ѯҪ�ر���
	 * @param id
	 * @return
	 */
	Yaosu findYaosuById(Double id);
	/**
	 * ������ҵid��ѯ��Ŀ�������
	 * @param id
	 * @return
	 */
	Jiansejindu findJiansejinduById(Double id);
	
	
	Boolean checkProductpeoperById(Double id);
	
	Boolean checkZhengwuqingkuang(Double id);
	
	Boolean checkGuotu(Double id);
	
	Boolean checkYaosu(Double id);
	
	Boolean checkJiansejindu(Double id);
	
	
	Boolean updateProductpeoper(Productpeoper productpeoper);
	
	Boolean updateZhengwuqingkuang(Zhengwuqingkuang zhengwuqingkuang);
	
	Boolean updateGuotu(Guotu guotu);
	
	Boolean updateYaosu(Yaosu yaosu);
	
	Boolean updateJiansejindu(Jiansejindu jiansejindu);
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
