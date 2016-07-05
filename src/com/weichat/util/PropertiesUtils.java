package com.weichat.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * �����ļ�������
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�PropertiesUtils.java ��������TODO �����ˣ����� ����ʱ�䣺2016��7��5��
 * ����1:24:20 �޸��ˣ����� �޸�ʱ�䣺2016��7��5�� ����1:24:20 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class PropertiesUtils {

	/**
	 * ���������ļ�����·����ȡ������Ϣ�ķ��� ��Properties�����ļ����������Ŀ��srcĿ¼�¡�
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
