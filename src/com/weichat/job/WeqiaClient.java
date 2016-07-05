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
 * 类名：WeqiaClient 功能：微洽开放平台-客户端接口封装类 详细：接口类，实现“员工批量添加”、“外部消息通知”等接口； 版本：1.0
 * 日期：2014-08-18 说明： 以下代码只是为了方便测试而提供的样例代码,企业可以根据自己系统的需要,按照技术文档编写,并非一定要使用该代码
 * 该代码仅供学习和研究微洽接口使用,只是提供一个参考
 * 
 */
public class WeqiaClient {

	// private String serviceUrl = "http://192.168.0.27//openapi.do"; // 服务接口地址
	// * private String serviceUrl="http://120.26.74.182//openapi.do";
	// private String cono = "weqia_test"; // 企业微洽号
	// private String private_key = "653fb16cce53f1b2bef0450a34e42f49"; // 企业私钥
	// private String cono = "2205794";
	// * private String cono = "jingtang_test";// 企业微洽号
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
	 * 构造函数
	 */
	public WeqiaClient(String cono, String private_key,String serviceurl) {
		this.cono = cono;
		this.private_key = private_key;
		this.serviceurl=serviceurl;
	}

	/**
	 * 接口编号： 1007 员工详情
	 * 
	 * @param form
	 * @return
	 */
	public String findEmployee(OpenEmployeeForm openId) {
		String sItype = "1007";
		return callOpenApi(sItype, openId);
	}

	/**
	 * 接口编号： 1006 员工列表
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
	 * @Description 调用开放接口
	 * @param sItype
	 *            接口编号
	 * @param objectData
	 *            业务数据
	 * @return
	 * 
	 */
	public String callOpenApi(String sItype, Object objectData) {

		// 1.接口编号

		// 2.请求时间
		String sTime = UtilDate.getRequestTime();

		// 3.业务数据
		String sData = JsonUtil.toJson(objectData);

		// 字符串先编码
		sData = WeqiaClient.encode(sData);

		// 4.加密后的业务数据
		String sEncryptData = EncryptUtils.aesEncrypt(private_key, sData);

		// 5.MD5签名
		String sSign = EncryptUtils.md5Encrypt(sItype + sTime + cono
				+ sEncryptData + private_key);

		// 6.填入各个表单域的值
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
	 * @Description HTTP POST 请求
	 * @param data
	 * @return
	 * 
	 */
	private String httpPostData(NameValuePair[] data) {

		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setContentCharset("UTF-8");

		PostMethod postMethod = new PostMethod(serviceurl);

		// 将表单的值放入postMethod中
		postMethod.setRequestBody(data);

		// 执行postMethod
		int statusCode = 0;

		try {
			statusCode = httpClient.executeMethod(postMethod);
		} catch (HttpException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		String str = "";

		// HttpClient对于要求接收后继服务的请求，象POST和PUT等不能自动处理转发
		// 301或者302
		if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
				|| statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
			// 从头中取出转向的地址
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
				// 获取返回值
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
