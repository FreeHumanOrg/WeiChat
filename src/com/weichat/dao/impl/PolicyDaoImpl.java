package com.weichat.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.weichat.dao.PolicyDao;
import com.weichat.model.Youhuizhengce;

/**
 * 
 * 优惠政策接口的实现类
 * 
 * 项目名称：WeiChat 类名称：PolicyDaoImpl.java 类描述：TODO 创建人：李帅康 创建时间：下午2:26:40 修改人：李帅康
 * 修改时间： 下午2:26:40 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("policyDaoImpl")
public class PolicyDaoImpl extends BaseDaoImpl<Youhuizhengce, Double> implements
		PolicyDao {
	/**
	 * 根据企业id查询优惠政策
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Youhuizhengce> findYouhuisById(Double id) {
		return this.hibernateTemplate.find(
				"from Youhuizhengce t where t.infomation.id=?",
				new Object[] { id });
	}
	@Override
	public Youhuizhengce findYouhuizhengceById(Double id) {
		List<Youhuizhengce>list=this.hibernateTemplate.find("from Youhuizhengce t where t.infomation.id=?",new Object[]{id});
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public Boolean addNewPolicy(Youhuizhengce youhuizhengce) {
		try {
			save(youhuizhengce);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean checkYouhuizhengce(Double id) {
		List<Youhuizhengce>list=this.hibernateTemplate.find("from Youhuizhengce t where t.infomation.id=?",new Object[]{id});
		if(list!=null&&list.size()>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Boolean updateYouhuizhengce(Youhuizhengce youhuizhengce) {
		try {
			super.update(youhuizhengce);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
