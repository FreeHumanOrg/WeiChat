package com.weichat.dao.impl;

import org.springframework.stereotype.Repository;

import com.weichat.dao.ExpendDao;
import com.weichat.model.Qiyefazhan;

/**
 * ��ҵ��չ�ӿڵ�ʵ����
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�ExpendDaoImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����7:58:37 �޸��ˣ���˧��
 * �޸�ʱ�䣺����7:58:37 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("expendDaoImpl")
public class ExpendDaoImpl extends BaseDaoImpl<Qiyefazhan, Double> implements
		ExpendDao {

	@Override
	public Qiyefazhan findQiyefazhanById(Double id) {
		// List<Qiyefazhan>list=this.hibernateTemplate.find("from Qiyefazhan t where t.infomation.id=?",new
		// Object[]{id});
		// if(list!=null&&list.size()>0){
		// return list.get(0);
		// }else{
		// return null;
		// }
		return findById(id);
	}

}
