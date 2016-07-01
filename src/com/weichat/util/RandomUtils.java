package com.weichat.util;

import java.text.ParseException;
import java.util.UUID;

/**
 * �����������
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�RandomUtils.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��22�� ����5:51:51
 * �޸��ˣ����� �޸�ʱ�䣺2016��6��22�� ����5:51:51 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class RandomUtils {

	/**
	 * �����������к�
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
