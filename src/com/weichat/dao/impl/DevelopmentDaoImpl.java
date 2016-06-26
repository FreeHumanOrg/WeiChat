package com.weichat.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static Logger LOGGER = LoggerFactory.getLogger(DevelopmentDaoImpl.class);
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
	/**
	 * ��ѯ��Ŀ�ٽ���ϵ��
	 */
	@Override
	public Productpeoper findProductpeoperById(Double id) {
		List<Productpeoper>list=this.hibernateTemplate.find("from Productpeoper t where t.infomation.id=?",new Object[]{id});
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public Boolean checkProductpeoperById(Double id) {
		List<Productpeoper>list=this.hibernateTemplate.find("from Productpeoper t where t.infomation.id=?",new Object[]{id});
		if(list!=null&&list.size()>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Boolean updateProductpeoper(Productpeoper productpeoper) {
		try {
			super.update(productpeoper);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Zhengwuqingkuang findZhengwuqingkuangById(Double id) {
		List<Zhengwuqingkuang>list=this.hibernateTemplate.find("from Zhengwuqingkuang t where t.infomation.id=?",new Object[]{id});
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public Boolean checkZhengwuqingkuangById(Double id) {
		List<Zhengwuqingkuang>list=this.hibernateTemplate.find("from Zhengwuqingkuang t where t.infomation.id=?",new Object[]{id});
		if(list!=null&&list.size()>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Boolean updateZhengwuqingkuang(Zhengwuqingkuang zhengwuqingkuang) {
		try {
			super.update(zhengwuqingkuang);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Guotu findGuotuById(Double id) {
		List<Guotu>list=this.hibernateTemplate.find("from Guotu t where t.infomation.id=?",new Object[]{id});
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	/**
	 * ��ѯ������������Ƿ����
	 */
	@Override
	public Boolean checkGuotuById(Double id) {
		List<Guotu>list=this.hibernateTemplate.find("from Guotu t where t.infomation.id=?",new Object[]{id});
		if(list!=null&&list.size()>0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * �޸Ĺ����������
	 */
	@Override
	public Boolean updateGuotu(Guotu guotu) {
		try {
			super.update(guotu);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}
	/**
	 * ��ѯҪ�ر���
	 */
	@Override
	public Yaosu findYaosuById(Double id) {
		List<Yaosu>list=this.hibernateTemplate.find("from Yaosu t where t.infomation.id=?",new Object[]{id});
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	/**
	 * ��ѯҪ�ر����Ƿ����
	 */
	@Override
	public Boolean checkYaosuById(Double id) {
		List<Yaosu>list=this.hibernateTemplate.find("from Yaosu t where t.infomation.id=?",new Object[]{id});
		if(list!=null&&list.size()>0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * �޸�Ҫ�ر���
	 */
	@Override
	public Boolean updateYaosu(Yaosu yaosu) {
		try {
			super.update(yaosu);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}
	/**
	 * ��ѯ��Ŀ�������
	 */
	@Override
	public Jiansejindu findJiansejinduById(Double id) {
		List<Jiansejindu>list=this.hibernateTemplate.find("from Jiansejindu t where t.infomation.id=?",new Object[]{id});
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	/**
	 * ��ѯ��Ŀ��������Ƿ����
	 */
	@Override
	public Boolean checkJiansejinduById(Double id) {
		List<Jiansejindu>list=this.hibernateTemplate.find("from Jiansejindu t where t.infomation.id=?",new Object[]{id});
		if(list!=null&&list.size()>0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * �޸���Ŀ�������
	 */
	@Override
	public Boolean updateJiansejindu(Jiansejindu jiansejindu) {
		try {
			super.update(jiansejindu);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

}
