package com.weichat.service;

import java.util.List;

import com.weichat.model.Youhuizhengce;

/**
 * 
 * 
 * 
 * 项目名称：WeiChat 类名称：PolicyService.java 类描述：TODO 创建人：李帅康 创建时间：下午2:00:11 修改人：李帅康
 * 修改时间： 下午2:00:11 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface PolicyService extends BaseService<Youhuizhengce, Double> {
	List<Youhuizhengce> findYouhuisById(Double id);

	Youhuizhengce findYouhuizhengceById(Double id);
	/**
	 * 查询优惠政策情况是否存在
	 * @param id
	 * @return
	 */
	Boolean checkYouhuizhengce(Double id);
	/**
	 * 修改优惠政策情况
	 * @param youhuizhengce
	 * @return
	 */
	Boolean updateYouhuizhengce(Youhuizhengce youhuizhengce);

	/**
	 * 添加一个优惠政策情况.
	 * 
	 * @param youhuizhengce
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean addNewPolicyService(Youhuizhengce youhuizhengce,
			Double enterpriseSituationId);
}
