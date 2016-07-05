package com.weichat.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期时间工具类
 * 
 * 
 * 项目名称：WeiChat 类名称：DateTimeUtils.java 类描述：TODO 创建人：王晶 创建时间：2016年6月21日
 * 下午10:11:49 修改人：王晶 修改时间：2016年6月21日 下午10:11:49 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public final class DateTimeUtils {
	private static Logger LOGGER = LoggerFactory.getLogger(DateTimeUtils.class);

	/**
	 * 日期时间模板枚举
	 * 
	 * 
	 * 项目名称：WeiChat 类名称：DateTimeUtils.java 类描述：TODO 创建人：王晶 创建时间：2016年6月21日
	 * 下午10:19:47 修改人：王晶 修改时间：2016年6月21日 下午10:19:47 修改备注：
	 * 
	 * FreeHuman Soft Team
	 * 
	 * @version 1.0 Beta
	 */
	public enum DateTimeTemplate {

		/**
		 * 日期时间模板一
		 */
		DATE_TIME_TEMPLATE_ONE("yyyy-MM-dd HH:mm:ss"),

		/**
		 * 日期时间模板二
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
	 * 日期时间模板一：SysNowDate -> String
	 * 
	 * @return
	 */
	public static String getNowDateOfStringFormatUsingDateTimeTemplateOne() {
		return new SimpleDateFormat(
				DateTimeTemplate.DATE_TIME_TEMPLATE_ONE.getValue())
				.format(new Date(System.currentTimeMillis()));
	}

	/**
	 * 日期时间模板二：SysNowDate -> String
	 * 
	 * @return
	 */
	public static String getNowDateOfStringFormatUsingDateTimeTemplateTwo() {
		return new SimpleDateFormat(
				DateTimeTemplate.DATE_TIME_TEMPLATE_TWO.getValue())
				.format(new Date(System.currentTimeMillis()));
	}

	/**
	 * 日期时间模板一：java.util.Date -> java.lang.String
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
	 * 日期时间模板二：java.util.Date -> java.lang.String
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
	 * 日期时间模板一：java.lang.String -> java.util.Date
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
	 * 日期时间模板二：java.lang.String -> java.util.Date
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
	 * 日期时间模板一：java.sql.Timestamp -> java.util.Date
	 * 
	 * @return
	 */
	public static Date getDateTimeObjectFromTimestampUsingDateTimeTemplateOne(
			Timestamp timestampDate) {
		return new Date(timestampDate.getTime());
	}

	/**
	 * 日期时间模板一：java.sql.Timestamp -> java.lang.String
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
	 * 日期时间模板二：java.sql.Timestamp -> java.lang.String
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
	 * 当前日期时间：SysNowDate -> java.util.Date
	 * 
	 * @return
	 */
	public static Date getNowDateOfDateFormat() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * 时间：java.util.Date -> java.sql.Date
	 * 
	 * @return
	 */
	public static java.sql.Date getJavaSqlDateOfJavaUtilDateFormat(
			java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}
}
