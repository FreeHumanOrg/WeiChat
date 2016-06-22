package com.weichat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Prolist实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：Prolist.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日 下午3:53:52
 * 修改人：王晶 修改时间：2016年6月22日 下午3:53:52 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "prolist", catalog = "new")
public class Prolist implements java.io.Serializable {
	private static final long serialVersionUID = -7972147617787943104L;

	private Double id;
	private Infomation infomation;
	private Double money;
	private Double howlong;
	private Double freecheck;
	private String fang;
	private String uploadfu;
	private Double proId;

	public Prolist() {
	}

	public Prolist(Infomation infomation) {
		this.infomation = infomation;
	}

	public Prolist(Infomation infomation, Double money, Double howlong,
			Double freecheck, String fang, String uploadfu, Double proId) {
		this.infomation = infomation;
		this.money = money;
		this.howlong = howlong;
		this.freecheck = freecheck;
		this.fang = fang;
		this.uploadfu = uploadfu;
		this.proId = proId;
	}

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
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