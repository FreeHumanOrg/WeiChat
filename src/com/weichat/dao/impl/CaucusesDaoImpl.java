package com.weichat.dao.impl;

import org.springframework.stereotype.Repository;

import com.weichat.dao.CaucusesDao;
import com.weichat.model.Dangtuanjianshe;

/**
 * ���Ž���ӿڵ�ʵ����
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�CaucusesDaoImpl.java ��������TODO �����ˣ���˧�� ����ʱ�䣺����8:18:44 �޸��ˣ���˧��
 * �޸�ʱ�䣺����8:18:44 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("caucusesDaoImpl")
public class CaucusesDaoImpl extends BaseDaoImpl<Dangtuanjianshe, Double>
		implements CaucusesDao {
	@Override
	public Dangtuanjianshe findDangtuanjiansheById(Double id) {
		// List<Dangtuanjianshe> list = find(
		// "find Dangtuanjianshe t where t.infomation.id=?",
		// new Object[] { id });
		// if (list != null && list.size() > 0) {
		// return list.get(0);
		// } else {
		// return null;
		// }
		return super.findById(id);
	}
}
