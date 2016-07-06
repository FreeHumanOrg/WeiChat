package com.weichat.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.weichat.dao.HistoryDao;
import com.weichat.dto.HistoryTempDTO;
import com.weichat.interceptor.HistoryRecordInterceptor.OperateType;
import com.weichat.model.History;
import com.weichat.model.Infomation;
import com.weichat.model.User;
import com.weichat.util.DateTimeUtils;
import com.weichat.util.HistoryTimerUtils;
import com.weichat.util.Page;
import com.weichat.util.RandomUtils;

/**
 * 历史记录接口的实现类
 * 
 * 
 * 项目名称：WeiChat 类名称：HistoryDaoImpl.java 类描述：TODO 创建人：王晶 创建时间：2016年6月28日
 * 下午12:16:57 修改人：王晶 修改时间：2016年6月28日 下午12:16:57 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("historyDaoImpl")
public class HistoryDaoImpl extends BaseDaoImpl<History, Double> implements
		HistoryDao {
	private static Logger LOGGER = LoggerFactory
			.getLogger(HistoryDaoImpl.class);

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Boolean addNewHistoryInfo(History history) {
		history.setId(RandomUtils.createIdentitySerialByUUID());
		history.setOperateDateTime(DateTimeUtils.getNowDateOfTimestampFormat());
		LOGGER.warn(DateTimeUtils.getNowDateOfTimestampFormat().toString());
		Infomation tempEntity = (Infomation) ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession()
				.getAttribute("infomationEntity");
		User u = (User) ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession()
				.getAttribute("userInfo");
		history.setOperatecode(u.getId());
		if (history.getOperateType().contains(OperateType.DELETE.getValue())) {
			history.setInfomation(null);
			if (tempEntity == null) {

			} else {
				history.setInfomationId(tempEntity.getId());
			}

		}
		HistoryTempDTO.setHistoryEntity(history);
		// 5秒后执行插入操作而不是立即插入，和上一个删除的事务隔离
		new HistoryTimerUtils(5);
		return true;
	}

	@Override
	public Boolean persistHistoryInfo(History history) {
		try {
			super.save(history);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<History> findAllHistoryInfo() {
		return hibernateTemplate
				.executeFind(new HibernateCallback<List<History>>() {
					@Override
					public List<History> doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createCriteria(History.class)
								.addOrder(Order.desc("operateDateTime")).list();
					}
				});
	}

	@Override
	public Page<History> findPage(Page<History> pageable) {
		return super.findPage(pageable, SearchType.NONE, null);
	}
}
