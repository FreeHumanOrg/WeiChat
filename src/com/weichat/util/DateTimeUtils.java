package com.weichat.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private static Logger LOGGER = LoggerFactory.getLogger(DateTimeUtils.class);

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
		DATE_TIME_TEMPLATE_ONE("yyyy-MM-dd HH:mm:ss"),

		/**
		 * ����ʱ��ģ���
		 */
		DATE_TIME_TEMPLATE_TWO("yyyy-MM-dd");

		private String value;

		public String getValue() {
			return value;
		}

		private DateTimeTemplate(String value) {
			this.value = value;
		}
	}

	/**
	 * ����ʱ��ģ��һ��SysNowDate -> String
	 * 
	 * @return
	 */
	public static String getNowDateOfStringFormatUsingDateTimeTemplateOne() {
		return new SimpleDateFormat(
				DateTimeTemplate.DATE_TIME_TEMPLATE_ONE.getValue())
				.format(new Date(System.currentTimeMillis()));
	}

	/**
	 * ����ʱ��ģ�����SysNowDate -> String
	 * 
	 * @return
	 */
	public static String getNowDateOfStringFormatUsingDateTimeTemplateTwo() {
		return new SimpleDateFormat(
				DateTimeTemplate.DATE_TIME_TEMPLATE_TWO.getValue())
				.format(new Date(System.currentTimeMillis()));
	}

	/**
	 * ����ʱ��ģ��һ��java.util.Date -> java.lang.String
	 * 
	 * @return
	 */
	public static String getDateTimeOfStringFormatFromDateTimeUsingDateTimeTemplateOne(
			Date date) {
		return new SimpleDateFormat(
				DateTimeTemplate.DATE_TIME_TEMPLATE_ONE.getValue())
				.format(date);
	}

	/**
	 * ����ʱ��ģ�����java.util.Date -> java.lang.String
	 * 
	 * @return
	 */
	public static String getDateTimeOfStringFormatFromDateTimeUsingDateTimeTemplateTwo(
			Date date) {
		return new SimpleDateFormat(
				DateTimeTemplate.DATE_TIME_TEMPLATE_TWO.getValue())
				.format(date);
	}

	/**
	 * ����ʱ��ģ��һ��java.lang.String -> java.util.Date
	 * 
	 * @return
	 */
	public static Date getDateTimeObjectFromDateTimeStringUsingDateTimeTemplateOne(
			String dateString) {
		Date date = new Date();
		try {
			date = new SimpleDateFormat(
					DateTimeTemplate.DATE_TIME_TEMPLATE_ONE.getValue())
					.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.error("Format of date string to date object was failed!");
		}
		return date;
	}

	/**
	 * ����ʱ��ģ�����java.lang.String -> java.util.Date
	 * 
	 * @return
	 */
	public static Date getDateTimeObjectFromDateTimeStringUsingDateTimeTemplateTwo(
			String dateString) {
		Date date = new Date();
		try {
			date = new SimpleDateFormat(
					DateTimeTemplate.DATE_TIME_TEMPLATE_TWO.getValue())
					.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.error("Format of date string to date object was failed!");
		}
		return date;
	}

	/**
	 * ����ʱ��ģ��һ��java.sql.Timestamp -> java.util.Date
	 * 
	 * @return
	 */
	public static Date getDateTimeObjectFromTimestampUsingDateTimeTemplateOne(
			Timestamp timestampDate) {
		return new Date(timestampDate.getTime());
	}

	/**
	 * ����ʱ��ģ��һ��java.sql.Timestamp -> java.lang.String
	 * 
	 * @return
	 */
	public static String getTimestampOfStringFormatFromTimestampObjectUsingDateTimeTemplateOne(
			Timestamp timestampDate) {
		return new SimpleDateFormat(
				DateTimeTemplate.DATE_TIME_TEMPLATE_ONE.getValue())
				.format(timestampDate);
	}

	/**
	 * ����ʱ��ģ�����java.sql.Timestamp -> java.lang.String
	 * 
	 * @return
	 */
	public static String getTimestampOfStringFormatFromTimestampObjectUsingDateTimeTemplateTwo(
			Timestamp timestampDate) {
		return new SimpleDateFormat(
				DateTimeTemplate.DATE_TIME_TEMPLATE_ONE.getValue())
				.format(timestampDate);
	}

	/**
	 * ��ǰ����ʱ�䣺SysNowDate -> java.util.Date
	 * 
	 * @return
	 */
	public static Date getNowDateOfDateFormat() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * ʱ�䣺java.util.Date -> java.sql.Date
	 * 
	 * @return
	 */
	public static java.sql.Date getJavaSqlDateOfJavaUtilDateFormat(
			java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}
}
