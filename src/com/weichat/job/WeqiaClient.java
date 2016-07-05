package com.weichat.job;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Properties;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.weichat.model.OpenEmployeeForm;
import com.weichat.model.OpenEmployeeListForm;
import com.weichat.util.EncryptUtils;
import com.weichat.util.JsonUtil;
import com.weichat.util.PropertiesUtils;
import com.weichat.util.UtilDate;

/**
 * 
 * ������WeqiaClient ���ܣ�΢Ǣ����ƽ̨-�ͻ��˽ӿڷ�װ�� ��ϸ���ӿ��࣬ʵ�֡�Ա��������ӡ������ⲿ��Ϣ֪ͨ���Ƚӿڣ� �汾��1.0
 * ���ڣ�2014-08-18 ˵���� ���´���ֻ��Ϊ�˷�����Զ��ṩ����������,��ҵ���Ը����Լ�ϵͳ����Ҫ,���ռ����ĵ���д,����һ��Ҫʹ�øô���
 * �ô������ѧϰ���о�΢Ǣ�ӿ�ʹ��,ֻ���ṩһ���ο�
 * 
 */
public class WeqiaClient {

	// private String serviceUrl = "http://192.168.0.27//openapi.do"; // ����ӿڵ�ַ
	// * private String serviceUrl="http://120.26.74.182//openapi.do";
	// private String cono = "weqia_test"; // ��ҵ΢Ǣ��
	// private String private_key = "653fb16cce53f1b2bef0450a34e42f49"; // ��ҵ˽Կ
	// private String cono = "2205794";
	// * private String cono = "jingtang_test";// ��ҵ΢Ǣ��
	// private String private_key = "30bbcdb301cfc56390e4e25849ff0f25";
	// * private String private_key = "da72dd333788ad10fedf2db1ac514748";

	private String serviceurl, cono, private_key;

	public WeqiaClient() {
		Properties prop = PropertiesUtils
				.getPropertiesFileAsObject("global.properties");
		serviceurl = prop.getProperty("weiqia.serviceurl");
		cono = prop.getProperty("weiqia.cono");
		private_key = prop.getProperty("weiqia.privatekey");
	}

	/*
	 * ���캯��
	 */
	public WeqiaClient(String cono, String private_key,String serviceurl) {
		this.cono = cono;
		this.private_key = private_key;
		this.serviceurl=serviceurl;
	}

	/**
	 * �ӿڱ�ţ� 1007 Ա������
	 * 
	 * @param form
	 * @return
	 */
	public String findEmployee(OpenEmployeeForm openId) {
		String sItype = "1007";
		return callOpenApi(sItype, openId);
	}

	/**
	 * �ӿڱ�ţ� 1006 Ա���б�
	 * 
	 * @param form
	 * @return
	 */
	public String findEmployeeList(OpenEmployeeListForm form) {
		String sItype = "1006";
		return callOpenApi(sItype, form);
	}

	/**
	 * 
	 * @Description ���ÿ��Žӿ�
	 * @param sItype
	 *            �ӿڱ��
	 * @param objectData
	 *            ҵ������
	 * @return
	 * 
	 */
	public String callOpenApi(String sItype, Object objectData) {

		// 1.�ӿڱ��

		// 2.����ʱ��
		String sTime = UtilDate.getRequestTime();

		// 3.ҵ������
		String sData = JsonUtil.toJson(objectData);

		// �ַ����ȱ���
		sData = WeqiaClient.encode(sData);

		// 4.���ܺ��ҵ������
		String sEncryptData = EncryptUtils.aesEncrypt(private_key, sData);

		// 5.MD5ǩ��
		String sSign = EncryptUtils.md5Encrypt(sItype + sTime + cono
				+ sEncryptData + private_key);

		// 6.������������ֵ
		NameValuePair[] data = { new NameValuePair("itype", sItype),
				new NameValuePair("cono", cono),
				new NameValuePair("time", sTime),
				new NameValuePair("data", sEncryptData),
				new NameValuePair("etype", "1"), // 1-AES 2-BASE64
				new NameValuePair("sign", sSign), };

		String sRet = httpPostData(data);

		return sRet;
	}

	/**
	 * 
	 * @Description HTTP POST ����
	 * @param data
	 * @return
	 * 
	 */
	private String httpPostData(NameValuePair[] data) {

		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setContentCharset("UTF-8");

		PostMethod postMethod = new PostMethod(serviceurl);

		// ������ֵ����postMethod��
		postMethod.setRequestBody(data);

		// ִ��postMethod
		int statusCode = 0;

		try {
			statusCode = httpClient.executeMethod(postMethod);
		} catch (HttpException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		String str = "";

		// HttpClient����Ҫ����պ�̷����������POST��PUT�Ȳ����Զ�����ת��
		// 301����302
		if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
				|| statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
			// ��ͷ��ȡ��ת��ĵ�ַ
			Header locationHeader = postMethod.getResponseHeader("location");
			String location = null;
			if (locationHeader != null) {
				location = locationHeader.getValue();
				System.out.println("The page was redirected to:" + location);
			} else {
				System.err.println("Location field value is null.");
			}
			return "";
		} else {
			System.out.println(postMethod.getStatusLine());

			try {
				// ��ȡ����ֵ
				str = postMethod.getResponseBodyAsString();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// System.out.println(str);
		}
		postMethod.releaseConnection();

		return str;
	}

	public static final String encode(String s) {
		if (s == null) {
			return null;
		}
		try {
			return URLEncoder.encode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public static final String decode(String s) {
		if (s == null) {
			return null;
		}
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

}
