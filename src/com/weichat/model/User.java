package com.weichat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "new")
public class User implements java.io.Serializable {

	// Fields

	private Double id;
	private String username;
	private String password;
	private String email;
	private String place;
	private String des;
	private String hobbit;
	private Double usertype;
	private Double zhucetype;
	private String name;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String username, String password, String email, String place,
			String des, String hobbit, Double usertype, Double zhucetype,
			String name) {
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

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 22, scale = 0)
	public Double getId() {
		return this.id;
	}

	public void setId(Double id) {
		this.id = id;
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