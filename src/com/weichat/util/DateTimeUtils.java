package com.weichat.util;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	 * 根据日期时间模板一返回格式化后的当前时间字符串
	 * 
	 * @return
	 */
	public static String getNowDateToStringUsingDateTimeTemplateOne() {
		return new SimpleDateFormat(
				DateTimeTemplate.DATE_TIME_TEMPLATE_ONE.getValue())
				.format(new Date(System.currentTimeMillis()));
	}
}
