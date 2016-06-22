
package com.weichat.service;

import java.util.List;

import com.weichat.model.Infomation;
import com.weichat.model.User;
import com.weichat.model.Youhuizhengce;

/**
 * 
 * 企业业务接口
 * 
 * 项目名称：WeiChat 类名称：CompanyService.java 类描述：TODO 
 * 创建人：李帅康  创建时间：下午6:58:56 
 * 修改人：李帅康  修改时间： 下午6:58:56
 * 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface CompanyService extends BaseService {
	List<Infomation> findAllService();
	
	Infomation findInfomationById(Double id);
	
}
