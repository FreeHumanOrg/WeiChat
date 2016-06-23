package com.weichat.service;

import com.weichat.model.Dangtuanjianshe;

/**
 * 党团建设业务接口
 * 
 * 项目名称：WeiChat 类名称：CaucusesService.java 类描述：TODO 创建人：李帅康 创建时间：下午8:21:51 修改人：李帅康
 * 修改时间：下午8:21:51 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface CaucusesService extends BaseService<Dangtuanjianshe, Double> {
	Dangtuanjianshe findDangtuanjiansheById(Double id);
}
