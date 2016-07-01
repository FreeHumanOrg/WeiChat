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
		// history.setOperateType("移除你");
		// history.setOperateValue("移除的值！");

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

		// 5秒后执行插入操作而不是立即插入，和上一个删除的事务隔离
		new HistoryTimerUtils(5);
		// transaction.commit();
		// session.close();
		// LOGGER.info("即将休眠历史记录插入线程。休眠时间："
		// + DateTimeUtils
		// .getNowDateOfStringFormatUsingDateTimeTemplateOne());
		// try {
		// Thread.sleep(20);
		// } catch (InterruptedException e1) {
		// e1.printStackTrace();
		// }
		// LOGGER.info("已经唤醒历史记录插入线程。唤醒时间："
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
		// LOGGER.info("使用JDBC新增历史记录成功！"
		// + DateTimeUtils
		// .getNowDateOfStringFormatUsingDateTimeTemplateOne());
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		// LOGGER.error("使用JDBC新增历史记录失败！"
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
