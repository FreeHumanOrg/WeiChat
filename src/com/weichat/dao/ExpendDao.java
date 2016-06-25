package com.weichat.dao;

import com.weichat.model.Qiyefazhan;

/**
 * 企业发展接口
 * 
 * 项目名称：WeiChat 类名称：ExpendDao.java 类描述：TODO 创建人：李帅康 创建时间：下午7:54:17 修改人：李帅康
 * 修改时间：下午7:54:17 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface ExpendDao extends BaseDao<Qiyefazhan, Double> {
	/**
	 * 根据企业id查询企业发展
	 * 
	 * @param id
	 * @return
	 */
	Qiyefazhan findQiyefazhanById(Double id);
	
	Boolean checkQiyefazhan(Double id);
	
	Boolean updateQiyefazhan(Qiyefazhan qiyefazhan);
}
