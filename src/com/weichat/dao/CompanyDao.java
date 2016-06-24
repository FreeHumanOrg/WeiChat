package com.weichat.dao;

import com.weichat.model.Infomation;
import com.weichat.util.Page;

/**
 * 
 * ��ҵ�ӿ�
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�CompanyDao.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����6:53:34 �޸��ˣ���˧��
 * �޸�ʱ�䣺 ����6:53:34 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface CompanyDao extends BaseDao<Infomation, Double> {
	Page<Infomation> findAll(Page<Infomation> pageable);

	Infomation findInfomationById(Double id);

	Boolean updateInfomation(Infomation infomation);
}
