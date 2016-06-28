package com.weichat.service;

import com.weichat.interceptor.IHistory;
import com.weichat.model.History;

/**
 * 历史记录业务接口
 * 
 * 
 * 项目名称：WeiChat 类名称：HistoryService.java 类描述：TODO 创建人：王晶 创建时间：2016年6月28日
 * 下午12:19:37 修改人：王晶 修改时间：2016年6月28日 下午12:19:37 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface HistoryService extends BaseService<History, Double> {

	/**
	 * 添加一个新历史记录.
	 * 
	 * @param history
	 * @return
	 */
	Boolean addNewHistoryInfoService(String operateType, IHistory logInfomations);
}
