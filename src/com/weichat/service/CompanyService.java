package com.weichat.service;

import com.weichat.model.Infomation;
import com.weichat.util.Page;

/**
 * 
 * 企业业务接口
 * 
 * 项目名称：WeiChat 类名称：CompanyService.java 类描述：TODO 创建人：李帅康 创建时间：下午6:58:56 修改人：李帅康
 * 修改时间： 下午6:58:56 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface CompanyService extends BaseService<Infomation, Double> {
	Page<Infomation> findAllService(Page<Infomation> pageable);

	Infomation findInfomationById(Double id);

	Boolean updateInfomation(Infomation infomation);

	/**
	 * 根据企业编号更新企业跟进人信息.
	 * 
	 * @param enterpriseSituationId
	 * @param genJinRenGroup
	 * @return
	 */
	Boolean updateGenJinRensInfoByEnterpriseSituationIdService(
			Double enterpriseSituationId, String latestGenJinRensToString);

	/**
	 * 根据企业编号删除一个企业信息.
	 * 
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean deleteEnterpriseInfoByIdService(Double enterpriseSituationId);
}
