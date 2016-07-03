package com.weichat.dao.impl;

import java.util.List;

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
import com.weichat.util.DateTimeUtils;
import com.weichat.util.HistoryTimerUtils;
import com.weichat.util.RandomUtils;

/**
 * ��ʷ��¼�ӿڵ�ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�HistoryDaoImpl.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��28��
 * ����12:16:57 �޸��ˣ����� �޸�ʱ�䣺2016��6��28�� ����12:16:57 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Repository("historyDaoImpl")
public class HistoryDaoImpl extends BaseDaoImpl<History, Double> implements
		HistoryDao {

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Boolean addNewHistoryInfo(History history) {
		history.setId(RandomUtils.createIdentitySerialByUUID());
		history.setOperateDateTime(DateTimeUtils
				.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		Infomation tempEntity = (Infomation) ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession()
				.getAttribute("infomationEntity");

		if (history.getOperateType().contains(OperateType.DELETE.getValue())) {
			history.setInfomation(null);
			history.setInfomationId(tempEntity.getId());
		}
		HistoryTempDTO.setHistoryEntity(history);
		// 5���ִ�в�������������������룬����һ��ɾ�����������
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

	@Override
	public List<History> findAllHistoryInfo() {
		return super.findAll();
	}
}
