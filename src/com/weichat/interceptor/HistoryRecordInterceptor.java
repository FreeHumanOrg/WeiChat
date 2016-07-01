package com.weichat.interceptor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.weichat.model.Infomation;
import com.weichat.util.HistoryRecordUtils;

/**
 * 适用于Hibernate的历史记录拦截器
 * 
 * 
 * 项目名称：WeiChat 类名称：HistoryRecordInterceptor.java 类描述：TODO 创建人：王晶
 * 创建时间：2016年6月27日 下午5:35:06 修改人：王晶 修改时间：2016年6月27日 下午5:35:06 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
public class HistoryRecordInterceptor extends EmptyInterceptor {
	private static final long serialVersionUID = 7981385480497040303L;

	private Logger LOGGER = LoggerFactory
			.getLogger(HistoryRecordInterceptor.class);

	public enum OperateType {
		SAVE("保存"), UPDATE("修改"), DELETE("删除");

		private String value;

		private OperateType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * 持久化数据的历史记录集合
	 */
	@SuppressWarnings("rawtypes")
	private Set saveHisrories = new HashSet();

	/**
	 * 更新数据的历史记录集合
	 */
	@SuppressWarnings("rawtypes")
	private Set upgradeHistories = new HashSet();

	/**
	 * 移除数据的历史记录集合
	 */
	@SuppressWarnings("rawtypes")
	private Set removeHistories = new HashSet();

	/**
	 * 执行保存时的监听方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] arg2,
			String[] arg3, Type[] arg4) throws CallbackException {
		LOGGER.debug("执行onSave()方法");
		if (entity instanceof IHistory) {
			saveHisrories.add(entity);
		}
		return false;
	}

	/**
	 * 执行修改时的监听方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) throws CallbackException {
		LOGGER.debug("执行onFlushDirty()方法");
		if (entity instanceof IHistory) {
			upgradeHistories.add(entity);
		}
		return false;
	}

	/**
	 * 执行删除时的监听方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) throws CallbackException {
		LOGGER.debug("执行onDelete()方法");
		if (entity instanceof Infomation) {
			((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest().getSession()
					.setAttribute("infomationEntity", entity);
		}
		if (entity instanceof IHistory) {
			removeHistories.add(entity);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void postFlush(Iterator iterator) throws CallbackException {
		LOGGER.debug("执行 postFlush()方法");
		try {
			for (Iterator it = saveHisrories.iterator(); it.hasNext();) {
				IHistory entity = (IHistory) it.next();
				HistoryRecordUtils.doLog(OperateType.SAVE.getValue(), entity);
			}

			for (Iterator it = upgradeHistories.iterator(); it.hasNext();) {
				IHistory entity = (IHistory) it.next();
				HistoryRecordUtils.doLog(OperateType.UPDATE.getValue(), entity);
			}

			for (Iterator it = removeHistories.iterator(); it.hasNext();) {
				IHistory entity = (IHistory) it.next();
				HistoryRecordUtils.doLog(OperateType.DELETE.getValue(), entity);
			}
		} finally {
			saveHisrories.clear();
			upgradeHistories.clear();
			removeHistories.clear();
		}
	}
}
