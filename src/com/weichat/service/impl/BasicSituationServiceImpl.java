package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.BasicSituationDao;
import com.weichat.model.Infomation;
import com.weichat.service.BasicSituationService;
import com.weichat.util.RandomUtils;

/**
 * 企业基本情况业务接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：BasicSituationServiceImpl.java 类描述：TODO 创建人：王晶
 * 创建时间：2016年6月22日 下午3:13:18 修改人：王晶 修改时间：2016年6月22日 下午3:13:18 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Service("basicSituationServiceImpl")
public class BasicSituationServiceImpl extends
		BaseServiceImpl<Infomation, Double> implements BasicSituationService {

	@Resource(name = "basicSituationDaoImpl")
	private BasicSituationDao basicSituationDao;

	@Override
	public Boolean addBasicSituationOfEnterpriseService(Infomation information) {
		information.setId(RandomUtils.createIdentitySerialByUUID());
		return basicSituationDao.addBasicSituationOfEnterprise(information);
	}
}
