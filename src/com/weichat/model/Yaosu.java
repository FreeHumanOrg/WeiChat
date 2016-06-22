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
 * 要素实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：Yaosu.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日 下午3:55:59 修改人：王晶
 * 修改时间：2016年6月22日 下午3:55:59 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "yaosu", catalog = "new")
public class Yaosu implements java.io.Serializable {
	private static final long serialVersionUID = 3394678673397183880L;

	private Double id;
	private Infomation infomation;
	private String load;
	private String electric;
	private String regard;
	private String water;
	private String gas;
	private String hearing;

	public Yaosu() {
	}

	public Yaosu(Infomation infomation) {
		this.infomation = infomation;
	}

	public Yaosu(Infomation infomation, String load, String electric,
			String regard, String water, String gas, String hearing) {
		this.infomation = infomation;
		this.load = load;
		this.electric = electric;
		this.regard = regard;
		this.water = water;
		this.gas = gas;
		this.hearing = hearing;
	}

	// Property accessors
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

	@Column(name = "load", length = 600)
	public String getLoad() {
		return this.load;
	}

	public void setLoad(String load) {
		this.load = load;
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