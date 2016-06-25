package com.weichat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 要素实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：Yaosu.java 类描述：TODO 创建人：王晶 创建时间：2016年6月25日 下午4:04:12 修改人：王晶
 * 修改时间：2016年6月25日 下午4:04:12 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "yaosu", catalog = "new")
public class Yaosu implements java.io.Serializable {
	private static final long serialVersionUID = 5788633981245311085L;

	private Double id;
	private Infomation infomation;

	/**
	 * 路
	 */
	private String loaded;

	/**
	 * 电
	 */
	private String electric;

	/**
	 * 视
	 */
	private String regard;

	/**
	 * 水
	 */
	private String water;

	/**
	 * 气
	 */
	private String gas;

	/**
	 * 讯
	 */
	private String hearing;

	public Yaosu() {
	}

	public Yaosu(Double id, Infomation infomation) {
		this.id = id;
		this.infomation = infomation;
	}

	public Yaosu(Double id, Infomation infomation, String loaded,
			String electric, String regard, String water, String gas,
			String hearing) {
		this.id = id;
		this.infomation = infomation;
		this.loaded = loaded;
		this.electric = electric;
		this.regard = regard;
		this.water = water;
		this.gas = gas;
		this.hearing = hearing;
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

	/**
	 * 数据库原字段名为load导致底层使用SQL插入异常，要避免关键字
	 * 
	 * @return
	 */
	@Column(name = "loaded", length = 600)
	public String getLoaded() {
		return this.loaded;
	}

	public void setLoaded(String loaded) {
		this.loaded = loaded;
	}

	@Column(name = "electric", length = 600)
	public String getElectric() {
		return this.electric;
	}

	public void setElectric(String electric) {
		this.electric = electric;
	}

	@Column(name = "regard", length = 600)
	public String getRegard() {
		return this.regard;
	}

	public void setRegard(String regard) {
		this.regard = regard;
	}

	@Column(name = "water", length = 600)
	public String getWater() {
		return this.water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	@Column(name = "gas", length = 600)
	public String getGas() {
		return this.gas;
	}

	public void setGas(String gas) {
		this.gas = gas;
	}

	@Column(name = "Hearing", length = 600)
	public String getHearing() {
		return this.hearing;
	}

	public void setHearing(String hearing) {
		this.hearing = hearing;
	}

}