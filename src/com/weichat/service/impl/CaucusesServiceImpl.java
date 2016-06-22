package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.CaucusesDao;
import com.weichat.model.Dangtuanjianshe;
import com.weichat.service.CaucusesService;
/**
 * 党团建设业务接口的实现类
 * 
 * 项目名称：WeiChat 类名称：CaucusesServiceImpl.java 类描述：TODO 创建人：李帅康 创建时间：下午8:22:55
 * 修改人：李帅康 修改时间：下午8:22:55 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("caucusesServiceImpl")
public class CaucusesServiceImpl extends BaseServiceImpl implements CaucusesService {
	@Resource(name = "caucusesDaoImpl")
	private CaucusesDao caucusesDao;
	@Override
	public Dangtuanjianshe findDangtuanjiansheById(Double id) {
		// TODO Auto-generated method stub
		return caucusesDao.findDangtuanjiansheById(id);
	}

}
