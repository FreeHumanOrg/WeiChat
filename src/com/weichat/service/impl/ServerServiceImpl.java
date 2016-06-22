package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.SafetyDao;
import com.weichat.dao.ServerDao;
import com.weichat.model.Qiyefuwu;
import com.weichat.service.ServerService;

/**
 * 企业服务业务接口的实现类
 * 
 * 
 * 
 * 项目名称：WeiChat 类名称：ServerServiceImpl.java 类描述：TODO 创建人：李帅康 创建时间：下午8:11:19
 * 修改人：李帅康 修改时间：下午8:11:19 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("serverServiceImpl")
public class ServerServiceImpl extends BaseServiceImpl implements ServerService{
	@Resource(name = "serverDaoImpl")
	private ServerDao serverDao;
	@Override
	public Qiyefuwu findQiyefuwuById(Double id) {
		// TODO Auto-generated method stub
		return serverDao.findQiyefuwuById(id);
	}

}
