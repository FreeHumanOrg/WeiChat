package com.weichat.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.weichat.dao.DevelopmentDao;
import com.weichat.model.Guotu;
import com.weichat.model.Jiansejindu;
import com.weichat.model.Productpeoper;
import com.weichat.model.Yaosu;
import com.weichat.model.Zhengwuqingkuang;

/**
 * ��������ӿ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�DevelopmentDaoImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����2:23:06
 * �޸��ˣ���˧�� �޸�ʱ�䣺 ����2:23:06 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("developmentDaoImpl")
public class DevelopmentDaoImpl extends BaseDaoImpl<Object, Double> implements
		DevelopmentDao {
	/**
	 * ������ҵid��ѯ��������е���Ŀ�ٽ���ϵ��
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Productpeoper> findProductpeoperById(Double id) {
		return this.hibernateTemplate.find(
				"from Productpeoper t where t.infomation.id=?",
				new Object[] { id });
	}

	@Override
	public Boolean addNewProductPeoperFromDevelopment(
			Productpeoper productpeoper) {
		try {
			super.save(productpeoper);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean addNewGovernmentSituationFromDevelopment(
			Zhengwuqingkuang zhengwuqingkuang) {
		try {
			super.save(zhengwuqingkuang);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean addNewLandSituationFromDevelopment(Guotu guotu) {
		try {
			super.save(guotu);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean addNewElementsOfSecurityFromDevelopment(Yaosu yaosu) {
		try {
			save(yaosu);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean addNewProjectBuildToProgressFromDevelopment(
			Jiansejindu jiansejindu) {
		try {
			save(jiansejindu);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
