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
 * ��ʷ��¼ʵ����
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�History.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��27�� ����10:55:11
 * �޸��ˣ����� �޸�ʱ�䣺2016��6��27�� ����10:55:11 �޸ı�ע��
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
	 * �����˱��
	 */
	private Double operatecode;

	/**
	 * ����ʱ��
	 */
	private String operateDateTime;

	/**
	 * ��������
	 */
	private String operateType;

	/**
	 * ��������
	 */
	private String operateProperty;

	/**
	 * ����ֵ
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