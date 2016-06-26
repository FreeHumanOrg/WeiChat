package com.weichat.dao;

import java.util.List;

import com.weichat.model.Youhuizhengce;

/**
 * 
 * 优惠政策接口
 * 
 * 项目名称：WeiChat 类名称：PolicyDao.java 类描述：TODO 创建人：李帅康 创建时间：下午1:57:03 修改人：李帅康 修改时间：
 * 下午1:57:03 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface PolicyDao extends BaseDao<Youhuizhengce, Double> {
	List<Youhuizhengce> findYouhuisById(Double id);
	
	Youhuizhengce findYouhuizhengceById(Double id);
	/**
	 * 查询优惠政策情况是否存在
	 * @param id
	 * @return
	 */
	Boolean checkYouhuizhengce(Double id);
	/**
	 * 修改优惠政策情况
	 * @param youhuizhengce
	 * @return
	 */
	Boolean updateYouhuizhengce(Youhuizhengce youhuizhengce);

	/**
	 * 添加一个优惠政策情况.
	 * 
	 * @param youhuizhengce
	 * @return
	 */
	Boolean addNewPolicy(Youhuizhengce youhuizhengce);
}
