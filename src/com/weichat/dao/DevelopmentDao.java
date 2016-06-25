package com.weichat.dao;

import java.util.List;

import com.weichat.model.Guotu;
import com.weichat.model.Jiansejindu;
import com.weichat.model.Productpeoper;
import com.weichat.model.Yaosu;
import com.weichat.model.Zhengwuqingkuang;

/**
 * 
 * 建设情况接口
 * 
 * 项目名称：WeiChat 类名称：DevelopmentDao.java 类描述：TODO 创建人：李帅康 创建时间：下午2:03:30 修改人：李帅康
 * 修改时间： 下午2:03:30 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface DevelopmentDao extends BaseDao<Object, Double> {
	/**
	 * 查询所有项目促进联系人
	 * 
	 * @param id
	 * @return
	 */
	List<Productpeoper> findProductpeoperById(Double id);

	/**
	 * 添加一个新的项目促建联系人信息.
	 * 
	 * @param productpeoper
	 * @return
	 */
	Boolean addNewProductPeoperFromDevelopment(Productpeoper productpeoper);

	/**
	 * 添加一个新的政务办理情况信息.
	 * 
	 * @param zhengwuqingkuang
	 * @return
	 */
	Boolean addNewGovernmentSituationFromDevelopment(
			Zhengwuqingkuang zhengwuqingkuang);

	/**
	 * 添加一个新的国土办理情况信息.
	 * 
	 * @param guotu
	 * @return
	 */
	Boolean addNewLandSituationFromDevelopment(Guotu guotu);

	/**
	 * 添加一个新的要素保障信息.
	 * 
	 * @param guotu
	 * @return
	 */
	Boolean addNewElementsOfSecurityFromDevelopment(Yaosu yaosu);

	/**
	 * 添加一个新的项目建设进度信息.
	 * 
	 * @param guotu
	 * @param enterpriseSituationId
	 * @return
	 */
	Boolean addNewProjectBuildToProgressFromDevelopment(Jiansejindu jiansejindu);
}
