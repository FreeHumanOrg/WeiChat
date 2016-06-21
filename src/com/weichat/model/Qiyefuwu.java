package com.weichat.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 企业服务实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：BaseDaoImpl.java 类描述：TODO 创建人：王晶 创建时间：2016-6-20 上午11:30:04
 * 修改人：王晶 修改时间：2016-6-20 上午11:30:04 修改备注：
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