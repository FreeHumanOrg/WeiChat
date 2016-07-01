package com.weichat.util;

import java.text.ParseException;
import java.util.UUID;

/**
 * 随机数工具类
 * 
 * 
 * 项目名称：WeiChat 类名称：RandomUtils.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日 下午5:51:51
 * 修改人：王晶 修改时间：2016年6月22日 下午5:51:51 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class RandomUtils {

	/**
	 * 生成主键序列号
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Double createIdentitySerialByUUID() {
		StringBuffer tempSb = new StringBuffer();
		String s = UUID.randomUUID().toString();
		s = s.substring(0, 2);
		char[] charArr = s.toCharArray();
		for (char c : charArr) {
			tempSb.append((int) c);
		}
		return Double.valueOf(tempSb.toString());
	}
}
