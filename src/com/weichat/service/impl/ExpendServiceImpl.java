package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.BasicSituationDao;
import com.weichat.dao.ExpendDao;
import com.weichat.model.Qiyefazhan;
import com.weichat.service.ExpendService;
import com.weichat.util.RandomUtils;

/**
 * 企业发展业务接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：ExpandServiceImpl.java 类描述：TODO 创建人：李帅康 创建时间：下午8:02:59
 * 修改人：李帅康 修改时间：下午8:02:59 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("expendServiceImpl")
public class ExpendServiceImpl extends BaseServiceImpl<Qiyefazhan, Double>
		implements ExpendService {
	@Resource(name = "expendDaoImpl")
	private ExpendDao expendDao;

	@Resource(name = "basicSituationDaoImpl")
	private BasicSituationDao basicSituationDao;

	@Override
	public Qiyefazhan findQiyefazhanById(Double id) {
		return expendDao.findQiyefazhanById(id);
	}

	@Override
	public Boolean checkQiyefazhan(Double id) {
		return expendDao.checkQiyefazhan(id);
	}

	@Override
	public Boolean updateQiyefazhan(Qiyefazhan qiyefazhan) {
		return expendDao.updateQiyefazhan(qiyefazhan);
	}

	@Override
	public Boolean addNewExpendService(Qiyefazhan qiyefazhan,
			Double enterpriseSituationId) {
		qiyefazhan.setId(RandomUtils.createIdentitySerialByUUID());
		qiyefazhan.setInfomation(basicSituationDao
				.findById(enterpriseSituationId));
		return expendDao.addNewExpend(qiyefazhan);
	}

}
