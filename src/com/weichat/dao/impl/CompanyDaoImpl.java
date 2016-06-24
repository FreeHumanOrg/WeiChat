package com.weichat.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.weichat.dao.CompanyDao;
import com.weichat.model.Infomation;
import com.weichat.util.Page;

/**
 * ��ҵ�ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�CompanyDaoImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����6:54:28 �޸��ˣ���˧��
 * �޸�ʱ�䣺 ����6:54:28 �޸ı�ע��
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
	 * �޸���ҵ������Ϣ
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
