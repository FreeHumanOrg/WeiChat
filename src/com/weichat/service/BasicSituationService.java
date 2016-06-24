package com.weichat.service;

import com.weichat.model.Infomation;

/**
 * 企业基本情况业务接口
 * 
 * 
 * 项目名称：WeiChat 类名称：BasicSituationService.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日
 * 下午3:11:32 修改人：王晶 修改时间：2016年6月22日 下午3:11:32 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface BasicSituationService extends BaseService<Infomation, Double> {
	/**
	 * 添加企业基本情况.
	 * 
	 * @param information
	 * @return
	 */
	Double addBasicSituationOfEnterpriseService(Infomation information);

	/**
	 * 根据编号查找Infomation对象.
	 * 
	 * @param id
	 * @return
	 */
	Infomation findByIdService(Double id);
}
