package com.weichat.service;

import com.weichat.model.Anquanshengchan;
/**
 * 安全生产业务接口
 * 
 * 
 * 项目名称：WeiChat 类名称：SafetyService.java 类描述：TODO 
 * 创建人：李帅康  创建时间：下午4:33:52 
 * 修改人：李帅康  修改时间： 下午4:33:52
 * 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface SafetyService extends BaseService {
	Anquanshengchan findAnquanshengchanById(Double id);
}
