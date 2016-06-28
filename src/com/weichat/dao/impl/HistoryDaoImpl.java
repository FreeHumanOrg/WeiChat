package com.weichat.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.weichat.dao.HistoryDao;
import com.weichat.model.History;
import com.weichat.util.DateTimeUtils;
import com.weichat.util.JDBCUtils;
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
	private static Logger LOGGER = LoggerFactory
			.getLogger(HistoryDaoImpl.class);

	@Override
	public Boolean addNewHistoryInfo(History history) {
		Connection conn = JDBCUtils.getConnection();
		Boolean resultFlag = false;
		StringBuffer sbJDBCSql = new StringBuffer(
				" insert into history(id,operatecode,operateDateTime,operateType,operateProperty,operateValue,infomationId) ");
		sbJDBCSql.append(" values ( ");
		sbJDBCSql.append(" ?,?,?,?,?,?,? ");
		sbJDBCSql.append(" ) ");
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sbJDBCSql.toString());
			pstmt.setDouble(1, RandomUtils.createIdentitySerialByUUID());
			pstmt.setString(2, history.getOperatecode().toString());
			pstmt.setString(3, history.getOperateDateTime());
			pstmt.setString(4, history.getOperateType());
			pstmt.setString(5, history.getOperateProperty());
			pstmt.setString(6, history.getOperateValue());
			if (null == history.getInfomationId()) {
				pstmt.setNull(7, Types.DOUBLE);
			} else {
				pstmt.setDouble(7, history.getInfomationId());
			}
			resultFlag = pstmt.execute();
			LOGGER.info("ʹ��JDBC������ʷ��¼�ɹ���"
					+ DateTimeUtils
							.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("ʹ��JDBC������ʷ��¼ʧ�ܣ�"
					+ DateTimeUtils
							.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		}
		JDBCUtils.close(null, null, conn);
		return resultFlag;
	}
}
