package com.weichat.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.weichat.dao.ServerDao;
import com.weichat.model.Qiyefuwu;

/**
 * ��ҵ����ӿڵ�ʵ����
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�ServerDaoImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����8:06:56
 * �޸��ˣ���˧�� �޸�ʱ�䣺����8:06:56 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("serverDaoImpl")
public class ServerDaoImpl extends BaseDaoImpl implements ServerDao{

	@Override
	public Qiyefuwu findQiyefuwuById(Double id) {
		// TODO Auto-generated method stub
		List<Qiyefuwu>list=this.hibernateTemplate.find("from Qiyefuwu t where t.infomation.id=?",new Object[]{id});
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
