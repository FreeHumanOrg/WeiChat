package com.weichat.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.weichat.dao.BaseDao;
import com.weichat.dao.SafetyDao;
import com.weichat.model.Anquanshengchan;
import com.weichat.util.RandomUtils;

/**
 * 安全生产接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：SafetyDaoImpl.java 类描述：TODO 创建人：李帅康 创建时间：下午4:18:05 修改人：李帅康
 * 修改时间： 下午4:18:05 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("safetyDaoImpl")
public class SafetyDaoImpl extends BaseDaoImpl<Anquanshengchan, Double>
		implements SafetyDao {
	private static Logger LOGGER = LoggerFactory.getLogger(SafetyDaoImpl.class);

	/**
	 * 根据企业id查询安全生产
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Anquanshengchan findAnquanshengchanById(Double id) {
//		 List<Anquanshengchan> list = hibernateTemplate.find("from Anquanshengchan t where t.infomation.id=?",new Object[] { id });
//		 if (list != null && list.size() > 0) {
//		 return list.get(0);
//		 } else {
//		 return null;
//		 }
		return findTById(id);
	}

	@Override
	public Boolean updateAnquanshengchan(Anquanshengchan anquanshengchan) {
		try {
			super.update(anquanshengchan);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Boolean checkAnquanshengchan(Double id) {
		try {
			List<Anquanshengchan> list = this.hibernateTemplate.find(
					"from Anquanshengchan t where t.infomation.id=?",
					new Object[] { id });
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
	public Boolean addAnquanshengchan(Anquanshengchan anquanshengchan) {
		// try {
		// anquanshengchan.setId(RandomUtils.createIdentitySerialByUUID());
		// this.hibernateTemplate.save(anquanshengchan);
		// } catch (Exception e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// LOGGER.error(e.getMessage());
		// return false;
		// }
		// return true;
		try {
			anquanshengchan.setId(RandomUtils.createIdentitySerialByUUID());
			super.save(anquanshengchan);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

}
