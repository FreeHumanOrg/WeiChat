package com.weichat.dao;

import com.weichat.model.Qiyefuwu;

/**
 * 企业服务接口
 * 
 * 项目名称：WeiChat 类名称：ServerDao.java 类描述：TODO 创建人：李帅康 创建时间：下午8:05:57 修改人：李帅康
 * 修改时间：下午8:05:57 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface ServerDao extends BaseDao<Qiyefuwu, Double> {
	/**
	 * 根据企业id查询企业服务
	 * 
	 * @param id
	 * @return
	 */
	Qiyefuwu findQiyefuwuById(Double id);
}
