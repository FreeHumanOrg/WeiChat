package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.BasicSituationDao;
import com.weichat.dao.SafetyDao;
import com.weichat.model.Anquanshengchan;
import com.weichat.service.SafetyService;
import com.weichat.util.RandomUtils;

/**
 * 安全生产业务实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：SafetyServiceImpl.java 类描述：TODO 创建人：李帅康 创建时间：下午4:27:57
 * 修改人：李帅康 修改时间： 下午4:27:57 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("safetyServiceImpl")
public class SafetyServiceImpl extends BaseServiceImpl<Anquanshengchan, Double>
		implements SafetyService {

	@Resource(name = "safetyDaoImpl")
	private SafetyDao safetyDao;

	@Resource(name = "basicSituationDaoImpl")
	private BasicSituationDao basicSituationDao;

	@Override
	public Anquanshengchan findAnquanshengchanById(Double id) {
		return safetyDao.findAnquanshengchanById(id);
	}

	@Override
	public Boolean updateAnquanshengchan(Anquanshengchan anquanshengchan) {
		return safetyDao.updateAnquanshengchan(anquanshengchan);
	}

	@Override
	public Boolean checkAnquanshengchan(Double id) {
		return safetyDao.checkAnquanshengchan(id);
	}

	@Override
	public Boolean addAnquanshengchan(Anquanshengchan anquanshengchan,
			Double enterpriseSituationId) {
		anquanshengchan.setId(RandomUtils.createIdentitySerialByUUID());
		anquanshengchan.setInfomation(basicSituationDao
				.findById(enterpriseSituationId));
		return safetyDao.addAnquanshengchan(anquanshengchan);
	}

}
