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
		// pstmt.setDouble(1, RandomUtils.createIdentitySerialByUUID());
		// pstmt.setString(2, history.getOperatecode().toString());
		// pstmt.setString(3, history.getOperateDateTime());
		// pstmt.setString(4, history.getOperateType());
		// pstmt.setString(5, history.getOperateProperty());
		// pstmt.setString(6, history.getOperateValue());
		// if (null == history.getInfomationId()) {
		// pstmt.setNull(7, Types.DOUBLE);
		// } else {
		// pstmt.setDouble(7, history.getInfomationId());
		// }

		// Session session =
		// hibernateTemplate.getSessionFactory().openSession();
		// Transaction transaction = session.getTransaction();
		// transaction.begin();

		history.setId(RandomUtils.createIdentitySerialByUUID());
		// history.setInfomation(null);
		// history.setInfomationId(0D);
		// history.setOperatecode(history.getOperatecode());
		history.setOperateDateTime(DateTimeUtils
				.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		// history.setOperateProperty("");
		// history.setOperateType("�Ƴ���");
		// history.setOperateValue("�Ƴ���ֵ��");

		// if (session.isOpen() == false) {
		// session.getSessionFactory().openSession(JDBCUtils.getConnection());
		// }

		Infomation tempEntity = (Infomation) ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession()
				.getAttribute("infomationEntity");

		if (history.getOperateType().contains(OperateType.DELETE.getValue())) {
			history.setInfomation(null);
			history.setInfomationId(tempEntity.getId());
		}

		// Serializable result = session.save(history);
		// session.save(history);
		HistoryTempDTO.setHistoryEntity(history);

		// 5���ִ�в�������������������룬����һ��ɾ�����������
		new HistoryTimerUtils(5);
		// transaction.commit();
		// session.close();
		// LOGGER.info("����������ʷ��¼�����̡߳�����ʱ�䣺"
		// + DateTimeUtils
		// .getNowDateOfStringFormatUsingDateTimeTemplateOne());
		// try {
		// Thread.sleep(20);
		// } catch (InterruptedException e1) {
		// e1.printStackTrace();
		// }
		// LOGGER.info("�Ѿ�������ʷ��¼�����̡߳�����ʱ�䣺"
		// + DateTimeUtils
		// .getNowDateOfStringFormatUsingDateTimeTemplateOne());
		// Connection conn = JDBCUtils.getConnection();
		// Boolean resultFlag = false;
		// StringBuffer sbJDBCSql = new StringBuffer(
		// " insert into history(id,operatecode,operateDateTime,operateType,operateProperty,operateValue,infomationId) ");
		// sbJDBCSql.append(" values ( ");
		// sbJDBCSql.append(" ?,?,?,?,?,?,? ");
		// sbJDBCSql.append(" ) ");
		//
		// PreparedStatement pstmt = null;
		// try {
		// pstmt = conn.prepareStatement(sbJDBCSql.toString());
		// pstmt.setDouble(1, RandomUtils.createIdentitySerialByUUID());
		// pstmt.setString(2, history.getOperatecode().toString());
		// pstmt.setString(3, history.getOperateDateTime());
		// pstmt.setString(4, history.getOperateType());
		// pstmt.setString(5, history.getOperateProperty());
		// pstmt.setString(6, history.getOperateValue());
		// if (null == history.getInfomationId()) {
		// pstmt.setNull(7, Types.DOUBLE);
		// } else {
		// pstmt.setDouble(7, history.getInfomationId());
		// }
		// resultFlag = pstmt.execute();
		// LOGGER.info("ʹ��JDBC������ʷ��¼�ɹ���"
		// + DateTimeUtils
		// .getNowDateOfStringFormatUsingDateTimeTemplateOne());
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		// LOGGER.error("ʹ��JDBC������ʷ��¼ʧ�ܣ�"
		// + DateTimeUtils
		// .getNowDateOfStringFormatUsingDateTimeTemplateOne());
		// }
		// JDBCUtils.close(null, pstmt, conn);
		//
		// return resultFlag;
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
