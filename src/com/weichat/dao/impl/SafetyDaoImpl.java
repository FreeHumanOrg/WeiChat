package com.weichat.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.AntPathMatcher;

import com.weichat.dao.SafetyDao;
import com.weichat.model.Anquanshengchan;
/**
 * ��ȫ�����ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�SafetyDaoImpl.java ��������TODO 
 * �����ˣ���˧��  ����ʱ�䣺����4:18:05 
 * �޸��ˣ���˧��  �޸�ʱ�䣺 ����4:18:05
 * �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("safetyDaoImpl")
public class SafetyDaoImpl extends BaseDaoImpl implements SafetyDao{
	/**
	 * ������ҵid��ѯ��ȫ����
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
