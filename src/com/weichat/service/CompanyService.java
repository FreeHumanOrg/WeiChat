
package com.weichat.service;

import java.util.List;

import com.weichat.model.Infomation;
import com.weichat.model.User;
import com.weichat.model.Youhuizhengce;

/**
 * 
 * ��ҵҵ��ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�CompanyService.java ��������TODO 
 * �����ˣ���˧��  ����ʱ�䣺����6:58:56 
 * �޸��ˣ���˧��  �޸�ʱ�䣺 ����6:58:56
 * �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface CompanyService extends BaseService {
	List<Infomation> findAllService();
	
	Infomation findInfomationById(Double id);
	
}
