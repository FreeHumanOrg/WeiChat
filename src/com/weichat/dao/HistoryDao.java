package com.weichat.dao;

import java.util.List;

import com.weichat.model.History;

/**
 * 历史记录接口
 * 
 * 
 * 项目名称：WeiChat 类名称：HistoryDao.java 类描述：TODO 创建人：王晶 创建时间：2016年6月28日 下午12:15:30
 * 修改人：王晶 修改时间：2016年6月28日 下午12:15:30 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface HistoryDao extends BaseDao<History, Double> {

	/**
	 * 添加一个新历史记录.
	 * 
	 * @param history
	 * @return
	 */
	Boolean addNewHistoryInfo(History history);

	/**
	 * 持久化历史记录.
	 * 
	 * @param history
	 * @return
	 */
	Boolean persistHistoryInfo(History history);

	/**
	 * 查询全部历史记录.
	 * 
	 * @param enterpriseSituationId
	 * @return
	 */
	List<History> findAllHistoryInfo();
}
