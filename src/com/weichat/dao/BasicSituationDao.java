package com.weichat.dao;

import com.weichat.model.Infomation;

/**
 * 企业基本情况接口
 * 
 * 
 * 项目名称：WeiChat 类名称：BasicSituationDao.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日
 * 下午3:10:12 修改人：王晶 修改时间：2016年6月22日 下午3:10:12 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface BasicSituationDao extends BaseDao<Infomation, Double> {
	/**
	 * 添加企业基本情况.
	 * 
	 * @param information
	 * @return
	 */
	Boolean addBasicSituationOfEnterprise(Infomation information);
}
