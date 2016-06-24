package com.weichat.dao;

import com.weichat.model.Dangtuanjianshe;
import com.weichat.model.Qiyefuwu;

/**
 * 党团建设接口
 * 
 * 项目名称：WeiChat 类名称：PartyDao.java 类描述：TODO 创建人：李帅康 创建时间：上午12:02:34
 * 修改人：李帅康 修改时间：上午12:02:34 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface PartyDao extends BaseDao<Dangtuanjianshe, Double> {
	/**
	 * 根据企业ID查询党团建设
	 * @param id
	 * @return
	 */
	Dangtuanjianshe findDangtuanjiansheById(Double id);
}
