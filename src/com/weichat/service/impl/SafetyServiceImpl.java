package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.SafetyDao;
import com.weichat.model.Anquanshengchan;
import com.weichat.service.SafetyService;
/**
 * 安全生产业务实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：SafetyServiceImpl.java 类描述：TODO 
 * 创建人：李帅康  创建时间：下午4:27:57 
 * 修改人：李帅康  修改时间： 下午4:27:57
 * 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("safetyServiceImpl")
public class SafetyServiceImpl extends BaseServiceImpl implements SafetyService{
	
	@Resource(name = "safetyDaoImpl")
	private SafetyDao safetyDao;
	@Override
	public Anquanshengchan findAnquanshengchanById(Double id) {
		// TODO Auto-generated method stub
		return safetyDao.findAnquanshengchanById(id);
	}

}
