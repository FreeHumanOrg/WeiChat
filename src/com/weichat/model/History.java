package com.weichat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * 历史记录实体类
 * 
 * 项目名称：WeiChat 类名称：History.java 类描述：TODO 创建人：王晶 创建时间：2016年6月27日 上午10:55:11
 * 修改人：王晶 修改时间：2016年6月27日 上午10:55:11 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "history", catalog = "new")
public class History implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Double id;

	private Infomation infomation;

	/**
	 * 操作人编号
	 */
	private Double operatecode;

	/**
	 * 操作时间
	 */
	private String operateDateTime;

	/**
	 * 操作类型
	 */
	private String operateType;

	/**
	 * 操作属性
	 */
	private String operateProperty;

	/**
	 * 操作值
	 */
	private String operateValue;

	public History() {
	}

	public History(Double id, Infomation infomation) {
		this.id = id;
		this.infomation = infomation;
	}

	public History(Double id, Infomation infomation, Double operatecode,
			String operateDateTime, String operateType, String operateProperty,
			String operateValue) {
		this.id = id;
		this.infomation = infomation;
		this.operatecode = operatecode;
		this.operateDateTime = operateDateTime;
		this.operateType = operateType;
		this.operateProperty = operateProperty;
		this.operateValue = operateValue;
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
	@JoinColumn(name = "infomationId", nullable = false)
	public Infomation getInfomation() {
		return this.infomation;
	}

	public void setInfomation(Infomation infomation) {
		this.infomation = infomation;
	}

	@Column(name = "operatecode", precision = 22, scale = 0)
	public Double getOperatecode() {
		return this.operatecode;
	}

	public void setOperatecode(Double operatecode) {
		this.operatecode = operatecode;
	}

	@Column(name = "operateDateTime", length = 100)
	public String getOperateDateTime() {
		return this.operateDateTime;
	}

	public void setOperateDateTime(String operateDateTime) {
		this.operateDateTime = operateDateTime;
	}

	@Column(name = "operateType", length = 200)
	public String getOperateType() {
		return this.operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	@Column(name = "operateProperty", length = 200)
	public String getOperateProperty() {
		return this.operateProperty;
	}

	public void setOperateProperty(String operateProperty) {
		this.operateProperty = operateProperty;
	}

	@Column(name = "operateValue", length = 50)
	public String getOperateValue() {
		return this.operateValue;
	}

	public void setOperateValue(String operateValue) {
		this.operateValue = operateValue;
	}
}