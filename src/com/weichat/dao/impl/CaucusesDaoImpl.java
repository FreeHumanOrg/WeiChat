package com.weichat.dao.impl;

import org.springframework.stereotype.Repository;

import com.weichat.dao.CaucusesDao;
import com.weichat.model.Dangtuanjianshe;

/**
 * 党团建设接口的实现类
 * 
 * 项目名称：WeiChat 类名称：CaucusesDaoImpl.java 类描述：TODO 创建人：李帅康 创建时间：下午8:18:44 修改人：李帅康
 * 修改时间：下午8:18:44 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("caucusesDaoImpl")
public class CaucusesDaoImpl extends BaseDaoImpl<Dangtuanjianshe, Double>
		implements CaucusesDao {
	@Override
	public Dangtuanjianshe findDangtuanjiansheById(Double id) {
		// List<Dangtuanjianshe> list = find(
		// "find Dangtuanjianshe t where t.infomation.id=?",
		// new Object[] { id });
		// if (list != null && list.size() > 0) {
		// return list.get(0);
		// } else {
		// return null;
		// }
		return super.findById(id);
	}
}
