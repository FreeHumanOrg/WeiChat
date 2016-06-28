package com.weichat.interceptor;

/**
 * 历史记录接口
 * 
 * 所有实现了此接口的实体类都会写日志
 * 
 * 项目名称：WeiChat 类名称：IHistory.java 类描述：TODO 创建人：王晶 创建时间：2016年6月27日 下午5:15:49
 * 修改人：王晶 修改时间：2016年6月27日 下午5:15:49 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface IHistory {
	/**
	 * 操作的实体编号
	 * 
	 * @return
	 */
	Double getId();

	/**
	 * 获取详细信息
	 * 
	 * @return
	 */
	String getLogDetail();
}
