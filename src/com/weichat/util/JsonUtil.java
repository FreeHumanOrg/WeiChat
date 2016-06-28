package com.weichat.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


/**
 * 
 * 类名：JsonUtil
 * 功能：json数据互转工具类
 * 详细：使用jackson API 实现json与Object的互相转换
 * 版本：1.0
 * 日期：2014-08-18
 * 说明：
 * 以下代码只是为了方便测试而提供的样例代码,企业可以根据自己系统的需要,按照技术文档编写,并非一定要使用该代码
 * 该代码仅供学习和研究微洽接口使用,只是提供一个参考
 *
 */
public class JsonUtil {
	private static final Log log = LogFactory.getLog(JsonUtil.class);

	/**
	 * 
	 * @Description 把object转换成JSON格式的字符串
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		Writer writer = new StringWriter();
		String result = "";
		try {
			ObjectMapper om = new ObjectMapper();
			om.writeValue(writer, obj);
			result = writer.toString();
			if (log.isDebugEnabled()) {
				System.out.println(result);
			}
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.debug(e.getMessage(), e);
			}
		} finally {
			if(writer != null){
				try {
					writer.close();
					writer = null;
				} catch (IOException e) {
					if (log.isDebugEnabled()) {
						log.debug(e.getMessage(), e);
					}
				}
			}
		}
		
		return result;
	}
	
	/**
	 * 把JSON格式的字符串转换成对应的对象实例
	 * @param json
	 * @param clas
	 * @return
	 */
	public static <T> T toObject(String json, Class<T> clas){
		T obj = null;
		try {
			ObjectMapper om = new ObjectMapper();
			obj = om.readValue(json, clas);
		} catch (JsonParseException e) {
			log.error(e.getMessage(), e);
		} catch (JsonMappingException e) {
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		
		return obj;
	}
	
	public static void main(String[] args){
	   
	}
}
