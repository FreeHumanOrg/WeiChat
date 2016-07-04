package com.weichat.service;

import java.util.List;

import com.weichat.model.User;

/**
 * �û�ҵ��ӿ�
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�BaseDaoImpl.java ��������TODO �����ˣ����� ����ʱ�䣺2016-6-20 ����11:30:04
 * �޸��ˣ����� �޸�ʱ�䣺2016-6-20 ����11:30:04 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface UserService extends BaseService<User, Double> {
	List<User> findAllService();

	Boolean addUser(User user);

	User findUserByOpenId(String openId);

	/**
	 * ���ݶ�������˱�Ų�ѯ�����������Ϣ.
	 * 
	 * @param genJinRenIds
	 * @return
	 */
	List<User> findUsersByIdsService(String[] genJinRenIds);

	/**
	 * ���ݲ����˱�Ų����û���Ϣ.
	 * 
	 * @param operateCode
	 * @return
	 */
	User findUserByOperateCodeService(Double operateCode);
}