package com.weichat.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ��ҵ����ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�BaseDaoImpl.java ��������TODO �����ˣ����� ����ʱ�䣺2016-6-20 ����11:30:04
 * �޸��ˣ����� �޸�ʱ�䣺2016-6-20 ����11:30:04 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "qiyefuwu", catalog = "new")
public class Qiyefuwu implements java.io.Serializable {

	private static final long serialVersionUID = 8568964181933381118L;
	private Double id;
	private String longzhi;
	private String yongGong;
	private String pinpai;
	private String pinxun;

	public Qiyefuwu() {
	}

	public Qiyefuwu(String longzhi, String yongGong, String pinpai,
			String pinxun) {
		this.longzhi = longzhi;
		this.yongGong = yongGong;
		this.pinpai = pinpai;
		this.pinxun = pinxun;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 22, scale = 0)
	public Double getId() {
		return this.id;
	}

	public void setId(Double id) {
		this.id = id;
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

}