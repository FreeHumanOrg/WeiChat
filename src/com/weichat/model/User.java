package com.weichat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 地区
	 */
	private String place;

	/**
	 * 描述
	 */
	private String des;

	/**
	 * 爱好
	 */
	private String hobbit;

	/**
	 * 用户类型
	 */
	private Double usertype;

	/**
	 * 注册类型
	 */
	private Double zhucetype;

	/**
	 * 用户姓名
	 */
	private String name;

	/**
	 * 远端客户编号
	 */
	private String openid;

	/**
	 * 远端账户信息
	 */
	private String account;

	public User() {
	}

	public User(Infomation infomation, String username, String password,
			String email, String place, String des, String hobbit,
			Double usertype, Double zhucetype, String name, String openid,
			String account) {
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
		this.openid = openid;
		this.account = account;
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

	@Column(name = "openid", length = 50)
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Column(name = "account", length = 50)
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	// /**
	// * 实现了IHistory接口，重写getLogDetail()方法
	// */
	// @Transient
	// @Override
	// public String getLogDetail() {
	// StringBuffer sbLog = new StringBuffer();
	// sbLog.append("用户名：" + username);
	// sbLog.append(";密码：" + password);
	// sbLog.append(";邮箱：" + email);
	// sbLog.append(";地区：" + place);
	// sbLog.append(";描述：" + des);
	// sbLog.append(";爱好：" + hobbit);
	// sbLog.append(";用户类型：" + usertype);
	// sbLog.append(";注册类型：" + zhucetype);
	// sbLog.append(";用户姓名：" + name);
	// sbLog.append(";远端客户编号：" + openid);
	// sbLog.append(";远端账户信息：" + account);
	// return sbLog.toString();
	// }
}