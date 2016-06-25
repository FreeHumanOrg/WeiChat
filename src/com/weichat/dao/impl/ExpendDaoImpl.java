package com.weichat.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static Logger LOGGER = LoggerFactory.getLogger(ExpendDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public Qiyefazhan findQiyefazhanById(Double id) {
		List<Qiyefazhan> list = this.hibernateTemplate.find(
				"from Qiyefazhan t where t.infomation.id=?",
				new Object[] { id });
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Boolean checkQiyefazhan(Double id) {
		try {
			List<Qiyefazhan> list = this.hibernateTemplate.find(
					"from Qiyefazhan t where t.infomation.id=?",
					new Object[] { id });
			if (list != null && list.size() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}

	}

	@Override
	public Boolean updateQiyefazhan(Qiyefazhan qiyefazhan) {
		try {
			super.update(qiyefazhan);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Boolean addNewExpend(Qiyefazhan qiyefazhan) {
		try {
			super.save(qiyefazhan);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
