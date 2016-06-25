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
 * 建设情况接口实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：DevelopmentDaoImpl.java 类描述：TODO 创建人：李帅康 创建时间：下午2:23:06
 * 修改人：李帅康 修改时间： 下午2:23:06 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("developmentDaoImpl")
public class DevelopmentDaoImpl extends BaseDaoImpl<Object, Double> implements
		DevelopmentDao {
	/**
	 * 根据企业id查询建设情况中的项目促进联系人
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
