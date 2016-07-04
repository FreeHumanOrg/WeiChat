package com.weichat.dao;

import java.util.List;

import com.weichat.model.User;

/**
 * 用户接口
 * 
 * 
 * 项目名称：WeiChat 类名称：BaseDaoImpl.java 类描述：TODO 创建人：王晶 创建时间：2016-6-20 上午11:30:04
 * 修改人：王晶 修改时间：2016-6-20 上午11:30:04 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface UserDao extends BaseDao<User, Double> {
	List<User> findAll();

	Boolean addUser(User user);

	User findUserByOpenId(String openId);

	/**
	 * 根据多个跟进人编号查询多个跟进人信息.
	 * 
	 * @param genJinRenIds
	 * @return
	 */
	List<User> findUsersByIds(String[] genJinRenIds);

	/**
	 * 根据操作人编号查找用户信息.
	 * 
	 * @param operateCode
	 * @return
	 */
	User findUserByOperateCode(Double operateCode);
}
