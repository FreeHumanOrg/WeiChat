package com.weichat.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性文件工具类
 * 
 * 
 * 项目名称：WeiChat 类名称：PropertiesUtils.java 类描述：TODO 创建人：王晶 创建时间：2016年7月5日
 * 下午1:24:20 修改人：王晶 修改时间：2016年7月5日 下午1:24:20 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class PropertiesUtils {

	/**
	 * 根据属性文件名称路径获取属性信息的方法 【Properties属性文件必须放在项目的src目录下】
	 * 
	 * @param propertiesPath
	 * @return
	 */
	public static Properties getPropertiesFileAsObject(String propertiesFileName) {
		Properties pps = new Properties();

		InputStream in;
		try {
			String path = Thread.currentThread().getContextClassLoader()
					.getResource("").getPath().replace("%20", " ")
					+ propertiesFileName;
			in = new BufferedInputStream(new FileInputStream(
					path.substring(path.indexOf("/"))));
			pps.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return pps;
	}
}
