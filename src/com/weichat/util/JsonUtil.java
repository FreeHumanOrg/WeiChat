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
 * ������JsonUtil
 * ���ܣ�json���ݻ�ת������
 * ��ϸ��ʹ��jackson API ʵ��json��Object�Ļ���ת��
 * �汾��1.0
 * ���ڣ�2014-08-18
 * ˵����
 * ���´���ֻ��Ϊ�˷�����Զ��ṩ����������,��ҵ���Ը����Լ�ϵͳ����Ҫ,���ռ����ĵ���д,����һ��Ҫʹ�øô���
 * �ô������ѧϰ���о�΢Ǣ�ӿ�ʹ��,ֻ���ṩһ���ο�
 *
 */
public class JsonUtil {
	private static final Log log = LogFactory.getLog(JsonUtil.class);

	/**
	 * 
	 * @Description ��objectת����JSON��ʽ���ַ���
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
	 * ��JSON��ʽ���ַ���ת���ɶ�Ӧ�Ķ���ʵ��
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
