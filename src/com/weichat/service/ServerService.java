package com.weichat.service;

import com.weichat.model.Qiyefuwu;

/**
 * 企业服务业务接口
 * 
 * 项目名称：WeiChat 类名称：ServerService.java 类描述：TODO 创建人：李帅康 创建时间：下午8:10:25 修改人：李帅康
 * 修改时间：下午8:10:25 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface ServerService extends BaseService<Qiyefuwu, Double> {
	Qiyefuwu findQiyefuwuById(Double id);

	Boolean checkQiyefuwu(Double id);

	Boolean updateQiyefuwu(Qiyefuwu qiyefuwu);

	/**
	 * 添加一个企业服务信息.
	 * 
	 * @param qiyefuwu
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean addServerByEnterpriseService(Qiyefuwu qiyefuwu,
			Double enterpriseSituationId);
}
