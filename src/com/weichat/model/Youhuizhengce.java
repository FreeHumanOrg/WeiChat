package com.weichat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 优惠政策实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：Youhuizhengce.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日 下午3:56:17
 * 修改人：王晶 修改时间：2016年6月22日 下午3:56:17 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "youhuizhengce", catalog = "new")
public class Youhuizhengce implements java.io.Serializable {
	private static final long serialVersionUID = 9191338495573014804L;

	private Double id;
	private Infomation infomation;

	/**
	 * 协议优惠政策内容
	 */
	private String content;

	/**
	 * 应兑现金额
	 */
	private String money;

	/**
	 * 兑现情况
	 */
	private String cashsituation;

	/**
	 * 类目名称
	 */
	private String typename;

	public Youhuizhengce() {
	}

	public Youhuizhengce(Infomation infomation) {
		this.infomation = infomation;
	}

	public Youhuizhengce(Infomation infomation, String content, String money,
			String cashsituation, String typename) {
		this.infomation = infomation;
		this.content = content;
		this.money = money;
		this.cashsituation = cashsituation;
		this.typename = typename;
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