package com.weichat.service;

import java.util.List;

import com.weichat.model.Guotu;
import com.weichat.model.Jiansejindu;
import com.weichat.model.Productpeoper;
import com.weichat.model.Yaosu;
import com.weichat.model.Zhengwuqingkuang;

/**
 * 
 * 建设情况业务接口
 * 
 * 项目名称：WeiChat 类名称：DevelopmentService.java 类描述：TODO 创建人：李帅康 创建时间：下午2:23:14
 * 修改人：李帅康 修改时间： 下午2:23:14 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface DevelopmentService extends BaseService<Object, Double> {
	List<Productpeoper> findProductpeoperById(Double id);

	/**
	 * 添加一个新的项目促建联系人信息.
	 * 
	 * @param productpeoper
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean addNewProductPeoperFromDevelopmentService(
			Productpeoper productpeoper, Double enterpriseSituationId);

	/**
	 * 添加一个新的政务办理情况信息.
	 * 
	 * @param zhengwuqingkuang
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean addNewGovernmentSituationFromDevelopmentService(
			Zhengwuqingkuang zhengwuqingkuang, Double enterpriseSituationId);

	/**
	 * 添加一个新的国土办理情况信息.
	 * 
	 * @param guotu
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean addNewLandSituationFromDevelopmentService(Guotu guotu,
			Double enterpriseSituationId);

	/**
	 * 添加一个新的要素保障信息.
	 * 
	 * @param yaosu
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean addNewElementsOfSecurityFromDevelopmentService(Yaosu yaosu,
			Double enterpriseSituationId);

	/**
	 * 添加一个新的项目建设进度信息.
	 * 
	 * @param jiansejindu
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean addNewProjectBuildToProgressFromDevelopmentService(
			Jiansejindu jiansejindu, Double enterpriseSituationId);
}
