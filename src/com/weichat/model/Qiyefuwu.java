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
 * ��ҵ����ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�Qiyefuwu.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��22�� ����3:55:02
 * �޸��ˣ����� �޸�ʱ�䣺2016��6��22�� ����3:55:02 �޸ı�ע��
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
	 * ����
	 */
	private String longzhi;

	/**
	 * �ù�
	 */
	private String yongGong;

	/**
	 * Ʒ��
	 */
	private String pinpai;

	/**
	 * ��ѵ
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
	 * ʵ����IHistory�ӿڣ���дgetLogDetail()����
	 */
	@Transient
	public String getLogDetail() {
		StringBuffer sbLog = new StringBuffer();
		sbLog.append("���ʣ�" + longzhi);
		sbLog.append(";�ù���" + yongGong);
		sbLog.append(";Ʒ�ƣ�" + pinpai);
		sbLog.append(";��ѵ��" + pinxun);
		return sbLog.toString();
	}

}