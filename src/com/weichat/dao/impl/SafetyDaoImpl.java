package com.weichat.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.AntPathMatcher;

import com.weichat.dao.SafetyDao;
import com.weichat.model.Anquanshengchan;
/**
 * 安全生产接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：SafetyDaoImpl.java 类描述：TODO 
 * 创建人：李帅康  创建时间：下午4:18:05 
 * 修改人：李帅康  修改时间： 下午4:18:05
 * 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("safetyDaoImpl")
public class SafetyDaoImpl extends BaseDaoImpl implements SafetyDao{
	/**
	 * 根据企业id查询安全生产
	 */
	@Override
	public Anquanshengchan findAnquanshengchanById(Double id) {
		List<Anquanshengchan>list=this.hibernateTemplate.find("from Anquanshengchan t where t.infomation.id=?",new Object[]{id});
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
