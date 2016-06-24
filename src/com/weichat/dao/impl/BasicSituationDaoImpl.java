package com.weichat.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.dao.BasicSituationDao;
import com.weichat.model.Infomation;

/**
 * 企业基本情况接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：BasicSituationDaoImpl.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日
 * 下午3:11:10 修改人：王晶 修改时间：2016年6月22日 下午3:11:10 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("basicSituationDaoImpl")
public class BasicSituationDaoImpl extends BaseDaoImpl<Infomation, Double>
		implements BasicSituationDao {

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Boolean addBasicSituationOfEnterprise(Infomation information) {
		try {
			super.save(information);
			return true;
		} catch (DataAccessException e) {
		}
		return false;
	}

	@Override
	public Infomation findById(Double id) {
		return super.findById(id);
	}
}
