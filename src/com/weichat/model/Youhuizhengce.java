package com.weichat.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户政策实体类
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
@Table(name = "youhuizhengce", catalog = "new")
public class Youhuizhengce implements java.io.Serializable {

	private static final long serialVersionUID = -4251209104272335593L;
	private Double id;
	private String content;
	private String money;
	private String cashsituation;
	private String typename;

	public Youhuizhengce() {
	}

	public Youhuizhengce(String content, String money, String cashsituation,
			String typename) {
		this.content = content;
		this.money = money;
		this.cashsituation = cashsituation;
		this.typename = typename;
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

	@Column(name = "content", length = 6000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "money", length = 600)
	public String getMoney() {
		return this.money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	@Column(name = "Cashsituation", length = 600)
	public String getCashsituation() {
		return this.cashsituation;
	}

	public void setCashsituation(String cashsituation) {
		this.cashsituation = cashsituation;
	}

	@Column(name = "typename", length = 600)
	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

}