package com.weichat.dao.impl;

import org.springframework.stereotype.Repository;

import com.weichat.dao.ExpendDao;
import com.weichat.model.Qiyefazhan;

/**
 * 企业发展接口的实现类
 * 
 * 项目名称：WeiChat 类名称：ExpendDaoImpl.java 类描述：TODO 创建人：李帅康 创建时间：下午7:58:37 修改人：李帅康
 * 修改时间：下午7:58:37 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("expendDaoImpl")
public class ExpendDaoImpl extends BaseDaoImpl<Qiyefazhan, Double> implements
		ExpendDao {

	@Override
	public Qiyefazhan findQiyefazhanById(Double id) {
		// List<Qiyefazhan>list=this.hibernateTemplate.find("from Qiyefazhan t where t.infomation.id=?",new
		// Object[]{id});
		// if(list!=null&&list.size()>0){
		// return list.get(0);
		// }else{
		// return null;
		// }
		return findById(id);
	}

}
