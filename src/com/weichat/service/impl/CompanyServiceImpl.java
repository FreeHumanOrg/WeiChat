package com.weichat.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.CompanyDao;
import com.weichat.model.Infomation;
import com.weichat.service.CompanyService;
/**
 * 
 * 用户业务接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：CompanyServiceImpl.java 类描述：TODO 创建人：李帅康 创建时间：下午10:22:57
 * 修改人：李帅康 修改时间：下午10:22:57 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("companyServiceImpl")
public class CompanyServiceImpl implements CompanyService{
	@Resource(name = "companyDaoImpl")
	private CompanyDao companyDao;
	@Override
	public List<Infomation> findAllService() {
		// TODO Auto-generated method stub
		return companyDao.findAll();
	}

}
