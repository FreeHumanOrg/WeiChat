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
 * 用户实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：User.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日 下午3:55:22 修改人：王晶
 * 修改时间：2016年6月22日 下午3:55:22 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "user", catalog = "new")
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1802126823255466815L;

	private Double id;
	private Infomation infomation;
	private String username;
	private String password;
	private String email;
	private String place;
	private String des;
	private String hobbit;
	private Double usertype;
	private Double zhucetype;
	private String name;

	public User() {
	}

	public User(Infomation infomation, String username, String password,
			String email, String place, String des, String hobbit,
			Double usertype, Double zhucetype, String name) {
		this.infomation = infomation;
		this.username = username;
		this.password = password;
		this.email = email;
		this.place = place;
		this.des = des;
		this.hobbit = hobbit;
		this.usertype = usertype;
		this.zhucetype = zhucetype;
		this.name = name;
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

	@Column(name = "username", length = 60)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 60)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "place", length = 600)
	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Column(name = "des", length = 900)
	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Column(name = "hobbit", length = 600)
	public String getHobbit() {
		return this.hobbit;
	}

	public void setHobbit(String hobbit) {
		this.hobbit = hobbit;
	}

	@Column(name = "usertype", precision = 22, scale = 0)
	public Double getUsertype() {
		return this.usertype;
	}

	public void setUsertype(Double usertype) {
		this.usertype = usertype;
	}

	@Column(name = "zhucetype", precision = 22, scale = 0)
	public Double getZhucetype() {
		return this.zhucetype;
	}

	public void setZhucetype(Double zhucetype) {
		this.zhucetype = zhucetype;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}