package com.weichat.service;

import java.util.List;

import com.weichat.model.Productpeoper;
/**
 * 
 * 建设情况业务接口
 * 
 * 项目名称：WeiChat 类名称：DevelopmentService.java 类描述：TODO 
 * 创建人：李帅康  创建时间：下午2:23:14 
 * 修改人：李帅康  修改时间： 下午2:23:14
 * 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public interface DevelopmentService {
	List<Productpeoper> findProductpeoperById(Double id);
}
