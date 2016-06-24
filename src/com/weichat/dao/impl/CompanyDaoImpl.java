package com.weichat.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.weichat.dao.CompanyDao;
import com.weichat.model.Infomation;
import com.weichat.util.Page;

/**
 * 企业接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：CompanyDaoImpl.java 类描述：TODO 创建人：李帅康 创建时间：下午6:54:28 修改人：李帅康
 * 修改时间： 下午6:54:28 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("companyDaoImpl")
public class CompanyDaoImpl extends BaseDaoImpl<Infomation, Double> implements
		CompanyDao {
	private static Logger LOGGER = LoggerFactory
			.getLogger(CompanyDaoImpl.class);

	@Override
	public Page<Infomation> findAll(Page<Infomation> pageable) {
		// return this.hibernateTemplate.find("from Infomation");
		// return super.findAll();
		return super.findPage(pageable, SearchType.NONE);
	}

	@Override
	public Infomation findInfomationById(Double id) {
		// return (Infomation) this.hibernateTemplate.find(
		// "from Infomation where id=?", new Object[] { id }).get(0);
		return super.findById(id);
	}

	/**
	 * 修改企业基本信息
	 */
	@Override
	public Boolean updateInfomation(Infomation infomation) {
		try {
			super.update(infomation);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

}
