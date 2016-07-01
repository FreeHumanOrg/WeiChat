package com.weichat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.weichat.interceptor.IHistory;

/**
 * ��Ŀ�ٽ���ϵ��ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�Productpeoper.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��22�� ����3:53:05
 * �޸��ˣ����� �޸�ʱ�䣺2016��6��22�� ����3:53:05 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "productpeoper", catalog = "new")
public class Productpeoper implements java.io.Serializable, IHistory {
	private static final long serialVersionUID = 6544471896657473541L;

	private Double id;
	private Infomation infomation;

	/**
	 * ����
	 */
	private String name;

	/**
	 * ��ϵ��ʽ
	 */
	private String telphone;

	public Productpeoper() {
	}

	public Productpeoper(Infomation infomation) {
		this.infomation = infomation;
	}

	public Productpeoper(Infomation infomation, String name, String telphone) {
		this.infomation = infomation;
		this.name = name;
		this.telphone = telphone;
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

	@Column(name = "name", length = 600)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "telphone", length = 60)
	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	/**
	 * ʵ����IHistory�ӿڣ���дgetLogDetail()����
	 */
	@Transient
	@Override
	public String getLogDetail() {
		StringBuffer sbLog = new StringBuffer();
		sbLog.append("������" + name);
		sbLog.append(";��ϵ��ʽ��" + telphone);
		return sbLog.toString();
	}
}