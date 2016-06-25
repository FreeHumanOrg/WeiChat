package com.weichat.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.weichat.dao.PartyDao;
import com.weichat.model.Dangtuanjianshe;
import com.weichat.util.RandomUtils;

/**
 * 党团建设接口的实现类
 * 
 * 项目名称：WeiChat 类名称：PartyDaoImpl.java 类描述：TODO 创建人：李帅康 创建时间：上午12:11:58 修改人：李帅康
 * 修改时间：上午12:11:58 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("partyDaoImpl")
public class PartyDaoImpl extends BaseDaoImpl<Dangtuanjianshe, Double>
		implements PartyDao {
	private static Logger LOGGER = LoggerFactory.getLogger(PartyDaoImpl.class);

	@Override
	public Dangtuanjianshe findDangtuanjiansheById(Double id) {
		return findById(id);
	}
	@Override
	public Boolean updateDangtuanjianshe(Dangtuanjianshe dangtuanjianshe) {
		try {
			super.update(dangtuanjianshe);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}
	@Override
	public Boolean checkDangtuanjianshe(Double id) {
		try {
			List<Dangtuanjianshe>list=this.hibernateTemplate.find("from Dangtuanjianshe t where t.infomation.id=?",new Object[]{id});
			if(list!=null&&list.size()>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}
	}
	@Override
	public Boolean addDangtuanjianshe(Dangtuanjianshe dangtuanjianshe) {
		try {
			dangtuanjianshe.setId(RandomUtils.createIdentitySerialByUUID());
			super.save(dangtuanjianshe);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			return false;
		}
		return true;
	}

}
