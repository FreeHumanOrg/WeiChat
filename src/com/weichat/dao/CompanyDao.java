
package com.weichat.dao;

import java.util.List;

import com.weichat.model.Infomation;
import com.weichat.model.User;
import com.weichat.model.Youhuizhengce;

/**
 * 
 * ��ҵ�ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat 
 * �����ƣ�CompanyDao.java 
 * ��������TODO 
 * �����ˣ���˧��
 * ����ʱ�䣺����6:53:34
 * �޸��ˣ���˧��
 * �޸�ʱ�䣺 ����6:53:34
 * �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface CompanyDao extends BaseDao {
	List<Infomation> findAll();
	
	Infomation findInfomationById(Double id);
	
	Boolean updateInfomation(Infomation infomation);
}
