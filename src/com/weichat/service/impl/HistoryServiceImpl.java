package com.weichat.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.weichat.dao.CompanyDao;
import com.weichat.dao.HistoryDao;
import com.weichat.interceptor.IHistory;
import com.weichat.model.History;
import com.weichat.model.Infomation;
import com.weichat.model.Qiyefuwu;
import com.weichat.service.HistoryService;
import com.weichat.util.DateTimeUtils;
import com.weichat.util.RandomUtils;

@Service("historyServiceImpl")
public class HistoryServiceImpl extends BaseServiceImpl<History, Double>
		implements HistoryService {
	private Logger LOGGER = LoggerFactory.getLogger(HistoryServiceImpl.class);

	@Resource(name = "historyDaoImpl")
	private HistoryDao historyDao;

	@Resource(name = "companyDaoImpl")
	private CompanyDao companyDao;

	@SuppressWarnings({ "rawtypes", "unchecked", "unused", "static-access" })
	@Override
	public Boolean addNewHistoryInfoService(String operateType,
			IHistory logInfomations) {
		History entity = new History();
		Infomation infomation = null;
		if (logInfomations instanceof Infomation) {
			LOGGER.warn("正在操作企业基本信息（Infomation）类！");
		} else {
			infomation = companyDao.findInfomationById(Double
					.valueOf(((ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes()).getRequest().getSession()
							.getAttribute("enterpriseId").toString()));
			entity.setInfomation(infomation);
		}

		entity.setOperateType(operateType);
		entity.setId(RandomUtils.createIdentitySerialByUUID());
		if (logInfomations instanceof Infomation) {
			LOGGER.warn("正在操作企业基本信息（Infomation）类！");
			// 将操作人编号设为当前企业的主键编号
			entity.setOperatecode(entity.getId());
			entity.setInfomationId(null);
		} else {
			entity.setOperatecode(infomation.getId());
			entity.setInfomationId(infomation.getId());
		}
		entity.setOperateDateTime(DateTimeUtils
				.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		entity.setOperateProperty(null);
		if (logInfomations instanceof Infomation) {
			LOGGER.warn("正在操作企业基本信息（Infomation）类！");
			entity.setOperateValue(logInfomations.getLogDetail());
		} else {
			if (logInfomations instanceof Qiyefuwu) {
				Qiyefuwu qiyefuwu = (Qiyefuwu) logInfomations;
				entity.setOperateValue(qiyefuwu.getLogDetail());
			}
			// Class classes = null;
			// try {
			// String className = logInfomations.getClass().getName();
			// classes = Class.forName(className);
			// try {
			// Class infoClass = classes
			// .forName("com.weichat.model.Infomation");
			//
			// Class<?>[] info = logInfomations.getClass().getClasses();
			//
			// for (Class<?> class1 : info) {
			// System.out.println(class1.getName());
			// }
			//
			// } catch (SecurityException e) {
			// e.printStackTrace();
			// }
			// } catch (ClassNotFoundException e) {
			// e.printStackTrace();
			// }
			// entity.setOperateValue();
		}

		return historyDao.addNewHistoryInfo(entity);
	}
}
