package com.weichat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * 详情实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：Xiangqing.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日 下午3:55:41
 * 修改人：王晶 修改时间：2016年6月22日 下午3:55:41 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "xiangqing", catalog = "new")
public class Xiangqing implements java.io.Serializable {
	private static final long serialVersionUID = 3452889664990305809L;

	private Double id;
	private Infomation infomation;
	private Date date;
	private String name;
	private String des;
	private String fujian;

	public Xiangqing() {
	}

	public Xiangqing(Infomation infomation, Date date, String name, String des,
			String fujian) {
		this.infomation = infomation;
		this.date = date;
		this.name = name;
		this.des = des;
		this.fujian = fujian;
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
	@JoinColumn(name = "infomationid")
	public Infomation getInfomation() {
		return this.infomation;
	}

	public void setInfomation(Infomation infomation) {
		this.infomation = infomation;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "name", length = 60)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "des", length = 600)
	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Column(name = "fujian", length = 600)
	public String getFujian() {
		return this.fujian;
	}

	public void setFujian(String fujian) {
		this.fujian = fujian;
	}

}