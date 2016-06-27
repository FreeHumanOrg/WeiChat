package com.weichat.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weichat.dao.CompanyDao;
import com.weichat.model.Infomation;
import com.weichat.service.CompanyService;
import com.weichat.util.Page;

/**
 * 
 * �û�ҵ��ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�CompanyServiceImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����10:22:57
 * �޸��ˣ���˧�� �޸�ʱ�䣺����10:22:57 �޸ı�ע��
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
		// ����������Ҫ�����ݿ��ж�ȡ����ǰ��ҵ����Ϣ
		Infomation infomation = companyDao.findById(enterpriseSituationId);
		// Ȼ�����еĸ������ֶθ���
		infomation.setGenjinren(latestGenJinRensToString);
		return companyDao.updateInfomation(infomation);
	}

	@Override
	public Boolean deleteEnterpriseInfoByIdService(Double enterpriseSituationId) {
		Infomation infomation = companyDao.findById(enterpriseSituationId);
		return companyDao.deleteEnterpriseInfoById(infomation);
	}
}
