package com.weichat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.weichat.dao.CompanyDao;
import com.weichat.dao.HistoryDao;
import com.weichat.interceptor.HistoryRecordInterceptor.OperateType;
import com.weichat.interceptor.IHistory;
import com.weichat.model.Anquanshengchan;
import com.weichat.model.Dangtuanjianshe;
import com.weichat.model.Guotu;
import com.weichat.model.History;
import com.weichat.model.Infomation;
import com.weichat.model.Jiansejindu;
import com.weichat.model.Productpeoper;
import com.weichat.model.Qiyefazhan;
import com.weichat.model.Qiyefuwu;
import com.weichat.model.User;
import com.weichat.model.Yaosu;
import com.weichat.model.Youhuizhengce;
import com.weichat.model.Zhengwuqingkuang;
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

	@Override
	public Boolean addNewHistoryInfoService(String operateType,
			IHistory logInfomations) {
		History entity = new History();
		Infomation infomation = null;
		if (logInfomations instanceof Infomation) {
			LOGGER.warn("���ڲ�����ҵ������Ϣ��Infomation���࣡");
			// ��ҵ������ϢҲҪ�����
			// ����Ǹ��»���ɾ����ҵ������Ϣ
			if (operateType.contains(OperateType.UPDATE.getValue())
					|| operateType.contains(OperateType.DELETE.getValue())) {
				entity.setInfomation((Infomation) logInfomations);
				// ��infomation��ֵ�Ա���108��ɾ��ʱ����ʹ�ã�����Ϊ�����쳣
				infomation = (Infomation) logInfomations;
				// �������������
			} else {
				// ������InfomationΪ��
				User u = (User) ((ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes()).getRequest().getSession()
						.getAttribute("userInfo");
				entity.setInfomation(u.getInfomation());
			}
		} else {
			// ��������ҵ������Ϣ֮���ʵ����ҲҪ�����
			// �������������ʵ����Ϣ
			if (operateType.contains(OperateType.SAVE.getValue())) {
				// ���ﻹҪ�����������һ�������������ҵ��Ϣ�����������Ϣ����һ�������޸�ʱֱ�����һ����Ϣ����Ȼ���޸ĵ������ݴ��޵���Hibernate
				// Interceptor����Ϊ�����������޸ģ�
				Object enterpriseSituationIdByObj = ((ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes()).getRequest().getSession()
						.getAttribute("enterpriseId");
				// �����ҵ���Ϊ�����ʾ����һ�����
				if (null == enterpriseSituationIdByObj) {
					// ��ʱҪ�������ʵ���е�Infomation��Id��ѯ�õ�Infomation����Ϣ
					if (logInfomations instanceof Qiyefuwu) {
						Qiyefuwu qiyefuwu = (Qiyefuwu) logInfomations;
						infomation = companyDao.findInfomationById(qiyefuwu
								.getInfomation().getId());
						entity.setInfomation(infomation);
					} else if (logInfomations instanceof Anquanshengchan) {
						Anquanshengchan anquanshengchan = (Anquanshengchan) logInfomations;
						infomation = companyDao
								.findInfomationById(anquanshengchan
										.getInfomation().getId());
						entity.setInfomation(infomation);
					} else if (logInfomations instanceof Dangtuanjianshe) {
						Dangtuanjianshe dangtuanjianshe = (Dangtuanjianshe) logInfomations;
						infomation = companyDao
								.findInfomationById(dangtuanjianshe
										.getInfomation().getId());
						entity.setInfomation(infomation);
					} else if (logInfomations instanceof Guotu) {
						Guotu guotu = (Guotu) logInfomations;
						infomation = companyDao.findInfomationById(guotu
								.getInfomation().getId());
						entity.setInfomation(infomation);
					} else if (logInfomations instanceof Jiansejindu) {
						Jiansejindu jiansejindu = (Jiansejindu) logInfomations;
						infomation = companyDao.findInfomationById(jiansejindu
								.getInfomation().getId());
						entity.setInfomation(infomation);
					} else if (logInfomations instanceof Productpeoper) {
						Productpeoper productpeoper = (Productpeoper) logInfomations;
						infomation = companyDao
								.findInfomationById(productpeoper
										.getInfomation().getId());
						entity.setInfomation(infomation);
					} else if (logInfomations instanceof Qiyefazhan) {
						Qiyefazhan qiyefazhan = (Qiyefazhan) logInfomations;
						infomation = companyDao.findInfomationById(qiyefazhan
								.getInfomation().getId());
						entity.setInfomation(infomation);
					} else if (logInfomations instanceof User) {
						User user = (User) logInfomations;
						infomation = companyDao.findInfomationById(user
								.getInfomation().getId());
						entity.setInfomation(infomation);
					} else if (logInfomations instanceof Yaosu) {
						Yaosu yaosu = (Yaosu) logInfomations;
						infomation = companyDao.findInfomationById(yaosu
								.getInfomation().getId());
						entity.setInfomation(infomation);
					} else if (logInfomations instanceof Youhuizhengce) {
						Youhuizhengce youhuizhengce = (Youhuizhengce) logInfomations;
						infomation = companyDao
								.findInfomationById(youhuizhengce
										.getInfomation().getId());
						entity.setInfomation(infomation);
					} else if (logInfomations instanceof Zhengwuqingkuang) {
						Zhengwuqingkuang zhengwuqingkuang = (Zhengwuqingkuang) logInfomations;
						infomation = companyDao
								.findInfomationById(zhengwuqingkuang
										.getInfomation().getId());
						entity.setInfomation(infomation);
					}
				} else {
					// ��ôҪ��Session���л�ȡ����ҵId�ٸ�����ҵId���в�ѯ
					infomation = companyDao.findInfomationById(Double
							.valueOf(enterpriseSituationIdByObj.toString()));
					entity.setInfomation(infomation);
				}
			}

			// ������޸Ļ���ɾ������ʵ����Ϣ
			if (operateType.contains(OperateType.UPDATE.getValue())
					|| operateType.contains(OperateType.DELETE.getValue())) {
				// ��ôҪ��logInfomationsת��Ϊ��Ӧ��ʵ������ٸ������ʵ������е�Infomation��Id���в�ѯ
				if (logInfomations instanceof Qiyefuwu) {
					Qiyefuwu qiyefuwu = (Qiyefuwu) logInfomations;
					Infomation infoEntity = (Infomation) ((ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes()).getRequest().getSession()
							.getAttribute("infomationEntity");
					infomation = infoEntity;
					if (null == infoEntity) {
						infomation = qiyefuwu.getInfomation();
					}
					entity.setInfomationId(qiyefuwu.getInfomation().getId());
					entity.setInfomation(infoEntity);
				} else if (logInfomations instanceof Anquanshengchan) {
					Anquanshengchan anquanshengchan = (Anquanshengchan) logInfomations;
					Infomation infoEntity = (Infomation) ((ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes()).getRequest().getSession()
							.getAttribute("infomationEntity");
					infomation = infoEntity;
					if (null == infoEntity) {
						infomation = anquanshengchan.getInfomation();
					}
					entity.setInfomationId(anquanshengchan.getInfomation()
							.getId());
					entity.setInfomation(infoEntity);
				} else if (logInfomations instanceof Dangtuanjianshe) {
					Dangtuanjianshe dangtuanjianshe = (Dangtuanjianshe) logInfomations;
					Infomation infoEntity = (Infomation) ((ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes()).getRequest().getSession()
							.getAttribute("infomationEntity");
					infomation = infoEntity;
					if (null == infoEntity) {
						infomation = dangtuanjianshe.getInfomation();
					}
					entity.setInfomationId(dangtuanjianshe.getInfomation()
							.getId());
					entity.setInfomation(infoEntity);
				} else if (logInfomations instanceof Guotu) {
					Guotu guotu = (Guotu) logInfomations;
					Infomation infoEntity = (Infomation) ((ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes()).getRequest().getSession()
							.getAttribute("infomationEntity");
					infomation = infoEntity;
					if (null == infoEntity) {
						infomation = guotu.getInfomation();
					}
					entity.setInfomationId(guotu.getInfomation().getId());
					entity.setInfomation(infoEntity);
				} else if (logInfomations instanceof Jiansejindu) {
					Jiansejindu jiansejindu = (Jiansejindu) logInfomations;
					Infomation infoEntity = (Infomation) ((ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes()).getRequest().getSession()
							.getAttribute("infomationEntity");
					infomation = infoEntity;
					if (null == infoEntity) {
						infomation = jiansejindu.getInfomation();
					}
					entity.setInfomationId(jiansejindu.getInfomation().getId());
					entity.setInfomation(infoEntity);
				} else if (logInfomations instanceof Productpeoper) {
					Productpeoper productpeoper = (Productpeoper) logInfomations;
					Infomation infoEntity = (Infomation) ((ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes()).getRequest().getSession()
							.getAttribute("infomationEntity");
					infomation = infoEntity;
					if (null == infoEntity) {
						infomation = productpeoper.getInfomation();
					}
					entity.setInfomationId(productpeoper.getInfomation()
							.getId());
					entity.setInfomation(infoEntity);
				} else if (logInfomations instanceof Qiyefazhan) {
					Qiyefazhan qiyefazhan = (Qiyefazhan) logInfomations;
					Infomation infoEntity = (Infomation) ((ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes()).getRequest().getSession()
							.getAttribute("infomationEntity");
					infomation = infoEntity;
					if (null == infoEntity) {
						infomation = qiyefazhan.getInfomation();
					}
					entity.setInfomationId(qiyefazhan.getInfomation().getId());
					entity.setInfomation(infoEntity);
				} else if (logInfomations instanceof User) {
					User user = (User) logInfomations;
					Infomation infoEntity = (Infomation) ((ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes()).getRequest().getSession()
							.getAttribute("infomationEntity");
					infomation = infoEntity;
					if (null == infoEntity) {
						infomation = user.getInfomation();
					}
					entity.setInfomationId(user.getInfomation().getId());
					entity.setInfomation(infoEntity);
				} else if (logInfomations instanceof Yaosu) {
					Yaosu yaosu = (Yaosu) logInfomations;
					Infomation infoEntity = (Infomation) ((ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes()).getRequest().getSession()
							.getAttribute("infomationEntity");
					infomation = infoEntity;
					if (null == infoEntity) {
						infomation = yaosu.getInfomation();
					}
					entity.setInfomationId(yaosu.getInfomation().getId());
					entity.setInfomation(infoEntity);
				} else if (logInfomations instanceof Youhuizhengce) {
					Youhuizhengce youhuizhengce = (Youhuizhengce) logInfomations;
					Infomation infoEntity = (Infomation) ((ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes()).getRequest().getSession()
							.getAttribute("infomationEntity");
					infomation = infoEntity;
					if (null == infoEntity) {
						infomation = youhuizhengce.getInfomation();
					}
					entity.setInfomationId(youhuizhengce.getInfomation()
							.getId());
					entity.setInfomation(infoEntity);
				} else if (logInfomations instanceof Zhengwuqingkuang) {
					Zhengwuqingkuang zhengwuqingkuang = (Zhengwuqingkuang) logInfomations;
					Infomation infoEntity = (Infomation) ((ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes()).getRequest().getSession()
							.getAttribute("infomationEntity");
					infomation = infoEntity;
					if (null == infoEntity) {
						infomation = zhengwuqingkuang.getInfomation();
					}
					entity.setInfomationId(zhengwuqingkuang.getInfomation()
							.getId());
					entity.setInfomation(infoEntity);
				}
			}
		}

		entity.setOperateType(operateType);
		entity.setId(RandomUtils.createIdentitySerialByUUID());
		if (logInfomations instanceof Infomation) {
			LOGGER.warn("���ڲ�����ҵ������Ϣ��Infomation���࣡");
			// �������˱����Ϊ��ǰ��ҵ���������
			entity.setOperatecode(entity.getId());
			entity.setInfomationId(null);
		} else {
			entity.setOperatecode(infomation.getId());
		}
		entity.setOperateDateTime(DateTimeUtils
				.getNowDateOfStringFormatUsingDateTimeTemplateOne());
		entity.setOperateProperty(null);
		if (logInfomations instanceof Infomation) {
			LOGGER.warn("���ڲ�����ҵ������Ϣ��Infomation���࣡");
			entity.setOperateValue(logInfomations.getLogDetail());
		} else {
			if (logInfomations instanceof Qiyefuwu) {
				Qiyefuwu qiyefuwu = (Qiyefuwu) logInfomations;
				entity.setOperateValue(qiyefuwu.getLogDetail());
			} else if (logInfomations instanceof Anquanshengchan) {
				Anquanshengchan anquanshengchan = (Anquanshengchan) logInfomations;
				entity.setOperateValue(anquanshengchan.getLogDetail());
			} else if (logInfomations instanceof Dangtuanjianshe) {
				Dangtuanjianshe dangtuanjianshe = (Dangtuanjianshe) logInfomations;
				entity.setOperateValue(dangtuanjianshe.getLogDetail());
			} else if (logInfomations instanceof Guotu) {
				Guotu guotu = (Guotu) logInfomations;
				entity.setOperateValue(guotu.getLogDetail());
			} else if (logInfomations instanceof Jiansejindu) {
				Jiansejindu jiansejindu = (Jiansejindu) logInfomations;
				entity.setOperateValue(jiansejindu.getLogDetail());
			} else if (logInfomations instanceof Productpeoper) {
				Productpeoper productpeoper = (Productpeoper) logInfomations;
				entity.setOperateValue(productpeoper.getLogDetail());
			} else if (logInfomations instanceof Qiyefazhan) {
				Qiyefazhan qiyefazhan = (Qiyefazhan) logInfomations;
				entity.setOperateValue(qiyefazhan.getLogDetail());
			} else if (logInfomations instanceof User) {
				User user = (User) logInfomations;
				entity.setOperateValue(user.getLogDetail());
			} else if (logInfomations instanceof Yaosu) {
				Yaosu yaosu = (Yaosu) logInfomations;
				entity.setOperateValue(yaosu.getLogDetail());
			} else if (logInfomations instanceof Youhuizhengce) {
				Youhuizhengce youhuizhengce = (Youhuizhengce) logInfomations;
				entity.setOperateValue(youhuizhengce.getLogDetail());
			} else if (logInfomations instanceof Zhengwuqingkuang) {
				Zhengwuqingkuang zhengwuqingkuang = (Zhengwuqingkuang) logInfomations;
				entity.setOperateValue(zhengwuqingkuang.getLogDetail());
			}
		}

		return historyDao.addNewHistoryInfo(entity);
	}

	@Override
	public Boolean persistHistoryInfoService(History history) {
		return historyDao.persistHistoryInfo(history);
	}

	@Override
	public List<History> findAllHistoryInfoService() {
		return historyDao.findAllHistoryInfo();
	}
}
