package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.PartyDao;
import com.weichat.dao.SafetyDao;
import com.weichat.model.Dangtuanjianshe;
import com.weichat.service.PartyService;
/**
 * 党团建设业务接口的实现类
 * 
 * 项目名称：WeiChat 类名称：PartyServiceImpl.java 类描述：TODO 创建人：李帅康 创建时间：上午12:13:09
 * 修改人：李帅康 修改时间：上午12:13:09 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("partyServiceImpl")
public class PartyServiceImpl extends BaseServiceImpl<Dangtuanjianshe, Double> implements PartyService{
	@Resource(name = "partyDaoImpl")
	private PartyDao partyDao;
	@Override
	public Dangtuanjianshe findDangtuanjiansheById(Double id) {
		// TODO Auto-generated method stub
		return partyDao.findDangtuanjiansheById(id);
	}

}
