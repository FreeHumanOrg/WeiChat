package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.BasicSituationDao;
import com.weichat.dao.ServerDao;
import com.weichat.model.Qiyefuwu;
import com.weichat.service.ServerService;
import com.weichat.util.RandomUtils;

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
public class ServerServiceImpl extends BaseServiceImpl<Qiyefuwu, Double>
		implements ServerService {
	@Resource(name = "serverDaoImpl")
	private ServerDao serverDao;

	@Resource(name = "basicSituationDaoImpl")
	private BasicSituationDao basicSituationDao;

	@Override
	public Qiyefuwu findQiyefuwuById(Double id) {
		return serverDao.findQiyefuwuById(id);
	}

	@Override
	public Boolean checkQiyefuwu(Double id) {
		return serverDao.checkQiyefuwu(id);
	}

	@Override
	public Boolean updateQiyefuwu(Qiyefuwu qiyefuwu) {
		return serverDao.updateQiyefuwu(qiyefuwu);
	}

	@Override
	public Boolean addServerByEnterpriseService(Qiyefuwu qiyefuwu,
			Double enterpriseSituationId) {
		qiyefuwu.setId(RandomUtils.createIdentitySerialByUUID());
		qiyefuwu.setInfomation(basicSituationDao
				.findById(enterpriseSituationId));
		return serverDao.addServerByEnterprise(qiyefuwu);
	}

}
