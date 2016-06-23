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
	List<Youhuizhengce> findYouhuiById(Double id);
}
