package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.BasicSituationDao;
import com.weichat.dao.PartyDao;
import com.weichat.model.Dangtuanjianshe;
import com.weichat.service.PartyService;
import com.weichat.util.RandomUtils;

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
public class PartyServiceImpl extends BaseServiceImpl<Dangtuanjianshe, Double>
		implements PartyService {
	@Resource(name = "partyDaoImpl")
	private PartyDao partyDao;

	@Resource(name = "basicSituationDaoImpl")
	private BasicSituationDao basicSituationDao;

	@Override
	public Dangtuanjianshe findDangtuanjiansheById(Double id) {
		return partyDao.findDangtuanjiansheById(id);
	}

	@Override
	public Boolean updateDangtuanjianshe(Dangtuanjianshe dangtuanjianshe) {
		return partyDao.updateDangtuanjianshe(dangtuanjianshe);
	}

	@Override
	public Boolean checkDangtuanjianshe(Double id) {
		return partyDao.checkDangtuanjianshe(id);
	}

	@Override
	public Boolean addDangtuanjiansheService(Dangtuanjianshe dangtuanjianshe,
			Double enterpriseSituationId) {
		dangtuanjianshe.setId(RandomUtils.createIdentitySerialByUUID());
		dangtuanjianshe.setInfomation(basicSituationDao
				.findById(enterpriseSituationId));
		return partyDao.addDangtuanjianshe(dangtuanjianshe);
	}

}
