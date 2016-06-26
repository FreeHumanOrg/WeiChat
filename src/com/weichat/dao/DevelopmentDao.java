package com.weichat.dao;

import java.util.List;

import com.weichat.model.Guotu;
import com.weichat.model.Jiansejindu;
import com.weichat.model.Productpeoper;
import com.weichat.model.Yaosu;
import com.weichat.model.Zhengwuqingkuang;

/**
 * 
 * ��������ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�DevelopmentDao.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����2:03:30 �޸��ˣ���˧��
 * �޸�ʱ�䣺 ����2:03:30 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface DevelopmentDao extends BaseDao<Object, Double> {
	/**
	 * ��ѯ������Ŀ�ٽ���ϵ��
	 * 
	 * @param id
	 * @return
	 */
	Productpeoper findProductpeoperById(Double id);
	
	Boolean checkProductpeoperById(Double id);
	
	Boolean updateProductpeoper(Productpeoper productpeoper);
	/**
	 * ������ҵid��ѯ�������
	 * @param id
	 * @return
	 */
	Zhengwuqingkuang findZhengwuqingkuangById(Double id);
	
	Boolean checkZhengwuqingkuangById(Double id);
	
	Boolean updateZhengwuqingkuang(Zhengwuqingkuang zhengwuqingkuang);
	
	/**
	 * ������ҵid��ѯ�����������
	 * @param id
	 * @return
	 */
	Guotu findGuotuById(Double id);
	
	Boolean checkGuotuById(Double id);
	
	Boolean updateGuotu(Guotu guotu);
	/**
	 * ������ҵid��ѯҪ�ر���
	 * @param id
	 * @return
	 */
	Yaosu findYaosuById(Double id);
	
	Boolean checkYaosuById(Double id);
	
	Boolean updateYaosu(Yaosu yaosu);
	
	/**
	 * ������ҵid��ѯ��Ŀ�������
	 * @param id
	 * @return
	 */
	Jiansejindu findJiansejinduById(Double id);
	
	Boolean checkJiansejinduById(Double id);
	
	Boolean updateJiansejindu(Jiansejindu jiansejindu);

	/**
	 * ���һ���µ���Ŀ�ٽ���ϵ����Ϣ.
	 * 
	 * @param productpeoper
	 * @return
	 */
	Boolean addNewProductPeoperFromDevelopment(Productpeoper productpeoper);

	/**
	 * ���һ���µ�������������Ϣ.
	 * 
	 * @param zhengwuqingkuang
	 * @return
	 */
	Boolean addNewGovernmentSituationFromDevelopment(
			Zhengwuqingkuang zhengwuqingkuang);

	/**
	 * ���һ���µĹ������������Ϣ.
	 * 
	 * @param guotu
	 * @return
	 */
	Boolean addNewLandSituationFromDevelopment(Guotu guotu);

	/**
	 * ���һ���µ�Ҫ�ر�����Ϣ.
	 * 
	 * @param guotu
	 * @return
	 */
	Boolean addNewElementsOfSecurityFromDevelopment(Yaosu yaosu);

	/**
	 * ���һ���µ���Ŀ���������Ϣ.
	 * 
	 * @param guotu
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean addNewProjectBuildToProgressFromDevelopment(Jiansejindu jiansejindu);
}
