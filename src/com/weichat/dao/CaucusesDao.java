package com.weichat.dao;

import com.weichat.model.Dangtuanjianshe;

/**
 * 党团建设接口
 * 
 * 项目名称：WeiChat 类名称：CaucusesDao.java 类描述：TODO 创建人：李帅康 创建时间：下午8:16:50 修改人：李帅康
 * 修改时间：下午8:16:50 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface CaucusesDao extends BaseDao<Dangtuanjianshe, Double> {
	/**
	 * 根据企业id查询党团建设
	 * 
	 * @param id
	 * @return
	 */
	Dangtuanjianshe findDangtuanjiansheById(Double id);
}
