package com.weichat.service;

import com.weichat.model.Qiyefazhan;

/**
 * 企业发展业务接口
 * 
 * 项目名称：WeiChat 类名称：ExpendService.java 类描述：TODO 创建人：李帅康 创建时间：下午7:59:57 修改人：李帅康
 * 修改时间：下午7:59:57 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface ExpendService extends BaseService<Qiyefazhan, Double> {
	Qiyefazhan findQiyefazhanById(Double id);
	
	Boolean checkQiyefazhan(Double id);
	
	Boolean updateQiyefazhan(Qiyefazhan qiyefazhan);
}
