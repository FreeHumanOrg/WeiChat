package com.weichat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.weichat.interceptor.IHistory;

/**
 * 企业服务实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：Qiyefuwu.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日 下午3:55:02
 * 修改人：王晶 修改时间：2016年6月22日 下午3:55:02 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "qiyefuwu", catalog = "new")
public class Qiyefuwu implements java.io.Serializable, IHistory {
	private static final long serialVersionUID = -6946385790618799914L;

	private Double id;

	private Infomation infomation;

	/**
	 * 融资
	 */
	private String longzhi;

	/**
	 * 用工
	 */
	private String yongGong;

	/**
	 * 品牌
	 */
	private String pinpai;

	/**
	 * 培训
	 */
	private String pinxun;

	public Qiyefuwu() {
	}

	public Qiyefuwu(Infomation infomation) {
		this.infomation = infomation;
	}

	public Qiyefuwu(Infomation infomation, String longzhi, String yongGong,
			String pinpai, String pinxun) {
		this.infomation = infomation;
		this.longzhi = longzhi;
		this.yongGong = yongGong;
		this.pinpai = pinpai;
		this.pinxun = pinxun;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, precision = 22, scale = 0)
	public Double getId() {
		return this.id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "infomationid", nullable = false)
	public Infomation getInfomation() {
		return this.infomation;
	}

	public void setInfomation(Infomation infomation) {
		this.infomation = infomation;
	}

	@Column(name = "longzhi", length = 600)
	public String getLongzhi() {
		return this.longzhi;
	}

	public void setLongzhi(String longzhi) {
		this.longzhi = longzhi;
	}

	@Column(name = "yongGong", length = 600)
	public String getYongGong() {
		return this.yongGong;
	}

	public void setYongGong(String yongGong) {
		this.yongGong = yongGong;
	}

	@Column(name = "pinpai", length = 600)
	public String getPinpai() {
		return this.pinpai;
	}

	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}

	@Column(name = "pinxun", length = 600)
	public String getPinxun() {
		return this.pinxun;
	}

	public void setPinxun(String pinxun) {
		this.pinxun = pinxun;
	}

	/**
	 * 实现了IHistory接口，重写getLogDetail()方法
	 */
	@Transient
	public String getLogDetail() {
		StringBuffer sbLog = new StringBuffer();
		sbLog.append("融资：" + longzhi);
		sbLog.append(";用工：" + yongGong);
		sbLog.append(";品牌：" + pinpai);
		sbLog.append(";培训：" + pinxun);
		return sbLog.toString();
	}

}