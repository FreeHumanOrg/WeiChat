package com.weichat.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.weichat.dao.ServerDao;
import com.weichat.model.Anquanshengchan;
import com.weichat.model.Qiyefuwu;

/**
 * 企业服务接口的实现类
 * 
 * 项目名称：WeiChat 类名称：ServerDaoImpl.java 类描述：TODO 创建人：李帅康 创建时间：下午8:06:56 修改人：李帅康
 * 修改时间：下午8:06:56 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("serverDaoImpl")
public class ServerDaoImpl extends BaseDaoImpl<Qiyefuwu, Double> implements
		ServerDao {
	private static Logger LOGGER = LoggerFactory.getLogger(ServerDaoImpl.class);
	@SuppressWarnings("unchecked")
	@Override
	public Qiyefuwu findQiyefuwuById(Double id) {
		List<Qiyefuwu> list = this.hibernateTemplate.find(
				"from Qiyefuwu t where t.infomation.id=?", new Object[] { id });
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Boolean checkQiyefuwu(Double id) {
		try {
			List<Qiyefuwu> list = this.hibernateTemplate.find("from Qiyefuwu t where t.infomation.id=?",new Object[] { id });
			if (list != null && list.size() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean updateQiyefuwu(Qiyefuwu qiyefuwu) {
		try {
			super.update(qiyefuwu);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

}
