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
	 * 查询项目促建联系人
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
	 * 查询国土办理情况是否存在
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
	 * 修改国土办理情况
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
	 * 查询要素保障
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
	 * 查询要素保障是否存在
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
	 * 修改要素保障
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
	 * 查询项目建设进度
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
	 * 查询项目建设进度是否存在
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
	 * 修改项目建设进度
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
