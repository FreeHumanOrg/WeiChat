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

import com.weichat.util.HistoryRecordUtils;

/**
 * ������Hibernate����ʷ��¼������
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�HistoryRecordInterceptor.java ��������TODO �����ˣ�����
 * ����ʱ�䣺2016��6��27�� ����5:35:06 �޸��ˣ����� �޸�ʱ�䣺2016��6��27�� ����5:35:06 �޸ı�ע��
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
		SAVE("����"), UPDATE("�޸�"), DELETE("ɾ��");

		private String value;

		private OperateType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * �־û����ݵ���ʷ��¼����
	 */
	@SuppressWarnings("rawtypes")
	private Set saveHisrories = new HashSet();

	/**
	 * �������ݵ���ʷ��¼����
	 */
	@SuppressWarnings("rawtypes")
	private Set upgradeHistories = new HashSet();

	/**
	 * �Ƴ����ݵ���ʷ��¼����
	 */
	@SuppressWarnings("rawtypes")
	private Set removeHistories = new HashSet();

	@SuppressWarnings("unchecked")
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] arg2,
			String[] arg3, Type[] arg4) throws CallbackException {
		LOGGER.debug("ִ��onSave()����");
		if (entity instanceof IHistory) {
			saveHisrories.add(entity);
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void postFlush(Iterator iterator) throws CallbackException {
		LOGGER.debug("ִ�� postFlush()����");
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