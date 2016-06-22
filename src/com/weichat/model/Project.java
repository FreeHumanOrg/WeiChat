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
 * 项目实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：Project.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日 下午3:53:25
 * 修改人：王晶 修改时间：2016年6月22日 下午3:53:25 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "project", catalog = "new")
public class Project implements java.io.Serializable {
	private static final long serialVersionUID = -491169292670618388L;

	private Integer id;
	private Infomation infomation;
	private String type;
	private String status;
	private String price;
	private String time;
	private Date endtime;
	private Integer people;
	private String address;
	private String proName;

	public Project() {
	}

	public Project(Infomation infomation, String type, String status,
			String price, String time, Date endtime, Integer people,
			String address, String proName) {
		this.infomation = infomation;
		this.type = type;
		this.status = status;
		this.price = price;
		this.time = time;
		this.endtime = endtime;
		this.people = people;
		this.address = address;
		this.proName = proName;
	}

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	@Column(name = "type", length = 20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "status", length = 200)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "price", length = 21)
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name = "time", length = 20)
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "endtime", length = 10)
	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	@Column(name = "people")
	public Integer getPeople() {
		return this.people;
	}

	public void setPeople(Integer people) {
		this.people = people;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "pro_name", length = 200)
	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

}