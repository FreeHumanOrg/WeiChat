package com.weichat.util;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.weichat.interceptor.IHistory;
import com.weichat.service.HistoryService;

/**
 * ��־��¼�Ĺ�����
 * 
 * ���õ�д��־������
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�HistoryRecordUtils.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��27��
 * ����5:22:19 �޸��ˣ����� �޸�ʱ�䣺2016��6��27�� ����5:22:19 �޸ı�ע��
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
	 * ��¼��־.
	 * 
	 * @param operateType
	 * @param logInfomations
	 */
	public static void doLog(String operateType, IHistory logInfomations) {
		if (historyService
				.addNewHistoryInfoService(operateType, logInfomations)) {
			LOGGER.info("����û���������ʷ��¼�ɹ���"
					+ DateTimeUtils
							.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		} else {
			LOGGER.error("����û���������ʷ��¼ʧ�ܣ�"
					+ DateTimeUtils
							.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		}
	}
}
