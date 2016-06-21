package com.weichat.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
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
@Table(name = "prolist", catalog = "new")
public class Prolist implements java.io.Serializable {

	private static final long serialVersionUID = -3681284656859253801L;
	private Double id;
	private Double money;
	private Double howlong;
	private Double freecheck;
	private String fang;
	private String uploadfu;
	private Double proId;

	public Prolist() {
	}

	public Prolist(Double money, Double howlong, Double freecheck, String fang,
			String uploadfu, Double proId) {
		this.money = money;
		this.howlong = howlong;
		this.freecheck = freecheck;
		this.fang = fang;
		this.uploadfu = uploadfu;
		this.proId = proId;
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

	@Column(name = "money", precision = 22, scale = 0)
	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Column(name = "howlong", precision = 22, scale = 0)
	public Double getHowlong() {
		return this.howlong;
	}

	public void setHowlong(Double howlong) {
		this.howlong = howlong;
	}

	@Column(name = "freecheck", precision = 22, scale = 0)
	public Double getFreecheck() {
		return this.freecheck;
	}

	public void setFreecheck(Double freecheck) {
		this.freecheck = freecheck;
	}

	@Column(name = "fang", length = 600)
	public String getFang() {
		return this.fang;
	}

	public void setFang(String fang) {
		this.fang = fang;
	}

	@Column(name = "uploadfu", length = 600)
	public String getUploadfu() {
		return this.uploadfu;
	}

	public void setUploadfu(String uploadfu) {
		this.uploadfu = uploadfu;
	}

	@Column(name = "pro_id", precision = 22, scale = 0)
	public Double getProId() {
		return this.proId;
	}

	public void setProId(Double proId) {
		this.proId = proId;
	}

}