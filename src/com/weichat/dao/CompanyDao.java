package com.weichat.dao;

import java.util.List;

import com.weichat.model.Infomation;

/**
 * 
 * 企业接口
 * 
 * 项目名称：WeiChat 类名称：CompanyDao.java 类描述：TODO 创建人：李帅康 创建时间：下午6:53:34 修改人：李帅康
 * 修改时间： 下午6:53:34 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface CompanyDao extends BaseDao<Infomation, Double> {
	List<Infomation> findAll();

	Infomation findInfomationById(Double id);

	Boolean updateInfomation(Infomation infomation);
}
