package com.weichat.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.weichat.dao.impl.HistoryDaoImpl;
import com.weichat.dto.HistoryTempDTO;
import com.weichat.interceptor.HistoryRecordInterceptor.OperateType;
import com.weichat.model.History;

@Component
public class RemindTask extends TimerTask {

	private static Logger LOGGER = LoggerFactory
			.getLogger(HistoryDaoImpl.class);

	public void run() {
		executeJDBC(HistoryTempDTO.getHistoryEntity());
		new HistoryTimerUtils().getInstance().cancel();
	}

	public Boolean executeJDBC(History history) {
		Connection conn = JDBCUtils.getConnection();
		Boolean resultFlag = false;
		StringBuffer sbJDBCSql = new StringBuffer(
				" insert into history(id,operatecode,operateDateTime,operateType,operateProperty,operateValue,infomationId,companyName) ");
		sbJDBCSql.append(" values ( ");
		sbJDBCSql.append(" ?,?,?,?,?,?,?,? ");
		sbJDBCSql.append(" ) ");

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sbJDBCSql.toString());
			pstmt.setDouble(1, RandomUtils.createIdentitySerialByUUID());
			pstmt.setString(2, history.getOperatecode().toString());
			pstmt.setTimestamp(3, history.getOperateDateTime());
			LOGGER.warn(history.getOperateDateTime().toString());

			pstmt.setString(4, history.getOperateType());
			pstmt.setString(5, history.getOperateProperty());
			pstmt.setString(6, history.getOperateValue());

			if (null != history.getInfomation()) {
				// ����ط���������Ϊhistory.getInfomation().getId()��ֵ��infomation���в�������,�����Ҳ�������ͻᱨ��
				if (null != history.getInfomation()) {
					pstmt.setDouble(7, history.getInfomation().getId());
				} else {
					pstmt.setDouble(7, history.getInfomationId());
				}
			} else {
				if (null == history.getInfomationId()
						|| history.getOperateType().contains(
								OperateType.DELETE.getValue())) {
					pstmt.setNull(7, Types.DOUBLE);
				} else {
					System.out.println(history.getInfomationId());
					pstmt.setDouble(7, history.getInfomationId());
				}
			}
			pstmt.setString(8, history.getCompanyName());

			resultFlag = pstmt.execute();
			LOGGER.info("ʹ��JDBC������ʷ��¼�ɹ���"
					+ DateTimeUtils
							.getNowDateOfStringFormatUsingDateTimeTemplateOne());
			resultFlag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("ʹ��JDBC������ʷ��¼ʧ�ܣ�"
					+ DateTimeUtils
							.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		}
		return resultFlag;

	}
}
