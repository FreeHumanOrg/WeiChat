package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.CompanyDao;
import com.weichat.model.Infomation;
import com.weichat.service.CompanyService;
import com.weichat.util.Page;

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
public class CompanyServiceImpl extends BaseServiceImpl<Infomation, Double>
		implements CompanyService {
	@Resource(name = "companyDaoImpl")
	private CompanyDao companyDao;

	@Override
	public Page<Infomation> findAllService(Page<Infomation> pageable) {
		return companyDao.findAll(pageable);
	}

	@Override
	public Infomation findInfomationById(Double id) {
		return companyDao.findInfomationById(id);
	}

	@Override
	public Boolean updateInfomation(Infomation infomation) {
		return companyDao.updateInfomation(infomation);
	}

	@Override
	public Boolean updateGenJinRensInfoByEnterpriseSituationIdService(
			Double enterpriseSituationId, String latestGenJinRensToString) {
		// 这里首先需要从数据库中读取出当前企业的信息
		Infomation infomation = companyDao.findById(enterpriseSituationId);
		// 然后将其中的跟进人字段更新
		infomation.setGenjinren(latestGenJinRensToString);
		return companyDao.updateInfomation(infomation);
	}

	@Override
	public Boolean deleteEnterpriseInfoByIdService(Double enterpriseSituationId) {
		Infomation infomation = companyDao.findById(enterpriseSituationId);
		return companyDao.deleteEnterpriseInfoById(infomation);
	}
}
