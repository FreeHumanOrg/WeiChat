package com.weichat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.UserDao;
import com.weichat.model.User;
import com.weichat.service.UserService;

/**
 * 用户业务接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：BaseDaoImpl.java 类描述：TODO 创建人：王晶 创建时间：2016-6-20 上午11:30:04
 * 修改人：王晶 修改时间：2016-6-20 上午11:30:04 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<User, Double> implements
		UserService {
	@Resource(name = "userDaoImpl")
	private UserDao userDao;

	@Override
	public List<User> findAllService() {
		return userDao.findAll();
	}

	@Override
	public List<User> findUsersByIdsService(String[] genJinRenIds) {
		return userDao.findUsersByIds(genJinRenIds);
	}

	@Override
	public Boolean addUser(User user) {
		return userDao.addUser(user);
	}
}
