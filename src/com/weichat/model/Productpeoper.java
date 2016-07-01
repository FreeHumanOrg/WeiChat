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
 * 项目促进联系人实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：Productpeoper.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日 下午3:53:05
 * 修改人：王晶 修改时间：2016年6月22日 下午3:53:05 修改备注：
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
	 * 姓名
	 */
	private String name;

	/**
	 * 联系方式
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
	 * 实现了IHistory接口，重写getLogDetail()方法
	 */
	@Transient
	@Override
	public String getLogDetail() {
		StringBuffer sbLog = new StringBuffer();
		sbLog.append("姓名：" + name);
		sbLog.append(";联系方式：" + telphone);
		return sbLog.toString();
	}
}