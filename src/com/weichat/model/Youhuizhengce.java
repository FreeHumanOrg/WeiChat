package com.weichat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * �Ż�����ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�Youhuizhengce.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��22�� ����3:56:17
 * �޸��ˣ����� �޸�ʱ�䣺2016��6��22�� ����3:56:17 �޸ı�ע��
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
	 * �Ż�����1���Ż�����2
	 * ������1,2��ʾ
	 */
	private String num;

	/**
	 * ��Ŀ����
	 */
	private String key;

	/**
	 * ��Ŀֵ
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