package com.weichat.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����ʱ�乤����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�DateTimeUtils.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��21��
 * ����10:11:49 �޸��ˣ����� �޸�ʱ�䣺2016��6��21�� ����10:11:49 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public final class DateTimeUtils {

	/**
	 * ����ʱ��ģ��ö��
	 * 
	 * 
	 * ��Ŀ���ƣ�WeiChat �����ƣ�DateTimeUtils.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��21��
	 * ����10:19:47 �޸��ˣ����� �޸�ʱ�䣺2016��6��21�� ����10:19:47 �޸ı�ע��
	 * 
	 * FreeHuman Soft Team
	 * 
	 * @version 1.0 Beta
	 */
	public enum DateTimeTemplate {

		/**
		 * ����ʱ��ģ��һ
		 */
		DATE_TIME_TEMPLATE_ONE("yyyy-MM-dd HH:mm:ss");

		private String value;

		public String getValue() {
			return value;
		}

		private DateTimeTemplate(String value) {
			this.value = value;
		}
	}

	/**
	 * ��������ʱ��ģ��һ���ظ�ʽ����ĵ�ǰʱ���ַ���
	 * 
	 * @return
	 */
	public static String getNowDateToStringUsingDateTimeTemplateOne() {
		return new SimpleDateFormat(
				DateTimeTemplate.DATE_TIME_TEMPLATE_ONE.getValue())
				.format(new Date(System.currentTimeMillis()));
	}
}
