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
	 * 优惠政策1，优惠政策2
	 * 可以用1,2表示
	 */
	private String num;

	/**
	 * 条目名称
	 */
	private String key;

	/**
	 * 条目值
	 */
	private String value;

	public Youhuizhengce() {
	}

	public Youhuizhengce(Infomation infomation) {
		this.infomation = infomation;
	}

	public Youhuizhengce(Infomation infomation, String num, String key,
			String value) {
		this.infomation = infomation;
		this.num=num;
		this.key=key;
		this.value=value;
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

	@Column(name = "key", length = 600)
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	@Column(name = "num", length = 6000)
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Column(name = "value", length = 600)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}