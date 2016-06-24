package com.weichat.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.weichat.dao.PartyDao;
import com.weichat.model.Dangtuanjianshe;
/**
 * 党团建设接口的实现类
 * 
 * 项目名称：WeiChat 类名称：PartyDaoImpl.java 类描述：TODO 创建人：李帅康 创建时间：上午12:11:58
 * 修改人：李帅康 修改时间：上午12:11:58 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("partyDaoImpl")
public class PartyDaoImpl extends BaseDaoImpl<Dangtuanjianshe, Double> implements PartyDao{
	private static Logger LOGGER = LoggerFactory
			.getLogger(PartyDaoImpl.class);
	@Override
	public Dangtuanjianshe findDangtuanjiansheById(Double id) {
		// TODO Auto-generated method stub
		return findById(id);
	}

}
