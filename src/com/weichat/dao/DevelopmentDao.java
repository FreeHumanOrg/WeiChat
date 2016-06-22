package com.weichat.dao;

import java.util.List;

import com.weichat.model.Productpeoper;

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
public interface DevelopmentDao extends BaseDao {
	/**
	 * 查询所有项目促进联系人
	 * 
	 * @param id
	 * @return
	 */
	List<Productpeoper> findProductpeoperById(Double id);
}
