package com.weichat.util;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.weichat.interceptor.IHistory;
import com.weichat.service.HistoryService;

/**
 * 日志记录的工具类
 * 
 * 重用的写日志工具类
 * 
 * 项目名称：WeiChat 类名称：HistoryRecordUtils.java 类描述：TODO 创建人：王晶 创建时间：2016年6月27日
 * 下午5:22:19 修改人：王晶 修改时间：2016年6月27日 下午5:22:19 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Component
public class HistoryRecordUtils {

	private static Logger LOGGER = LoggerFactory
			.getLogger(HistoryRecordUtils.class);

	private static HistoryService historyService;

	public HistoryService getHistoryService() {
		return historyService;
	}

	@Resource(name = "historyServiceImpl")
	public void setHistoryService(HistoryService historyService) {
		HistoryRecordUtils.historyService = historyService;
	}

	/**
	 * 记录日志.
	 * 
	 * @param operateType
	 * @param logInfomations
	 */
	public static void doLog(String operateType, IHistory logInfomations) {
		if (historyService
				.addNewHistoryInfoService(operateType, logInfomations)) {
			LOGGER.info("添加用户操作的历史记录成功！"
					+ DateTimeUtils
							.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		} else {
			LOGGER.error("添加用户操作的历史记录失败！"
					+ DateTimeUtils
							.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		}
	}
}
