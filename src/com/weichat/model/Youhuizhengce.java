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
public class Youhuizhengce implements java.io.Serializable, IHistory {
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
	private String keystr;

	/**
	 * 条目值
	 */
	private String valuestr;

	public Youhuizhengce() {
	}

	public Youhuizhengce(Infomation infomation) {
		this.infomation = infomation;
	}

	public Youhuizhengce(Infomation infomation, String num, String keystr,
			String valuestr) {
		this.infomation = infomation;
		this.num=num;
		this.keystr=keystr;
		this.valuestr=valuestr;
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

	@Column(name = "num", length = 6000)
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	@Column(name = "keystr", length = 600)
	public String getKeystr() {
		return keystr;
	}

	public void setKeystr(String keystr) {
		this.keystr = keystr;
	}
	
	@Column(name = "valuestr", length = 600)
	public String getValuestr() {
		return valuestr;
	}
	public void setValuestr(String valuestr) {
		this.valuestr = valuestr;
	}

	

	
	

	/**
	 * 实现了IHistory接口，重写getLogDetail()方法
	 */
	@Transient
	public String getLogDetail() {
		StringBuffer sbLog = new StringBuffer();
		sbLog.append("优惠政策：" + getNum());
		sbLog.append(";条目名称：" + getKeystr());
		sbLog.append(";条目值：" + getValuestr());
		return sbLog.toString();
	}

}