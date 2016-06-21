package com.weichat.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 信息实体类
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
@Table(name = "infomation", catalog = "new")
public class Infomation implements java.io.Serializable {

	private static final long serialVersionUID = 3282646356289889615L;
	private Double id;
	private String productdes;
	private String name;
	private String industrycode;
	private String contacts;
	private String enterprisewebsite;
	private String area;
	private String estimated;
	private String begintime;
	private String productname;
	private String dustry;
	private String legalperson;
	private String telenumber;
	private String signingtime;
	private String agreement;
	private String annualtax;
	private String completiontime;
	private String qyname;
	private String beizhu;

	public Infomation() {
	}

	public Infomation(String productdes, String name, String industrycode,
			String contacts, String enterprisewebsite, String area,
			String estimated, String begintime, String productname,
			String dustry, String legalperson, String telenumber,
			String signingtime, String agreement, String annualtax,
			String completiontime, String qyname, String beizhu) {
		this.productdes = productdes;
		this.name = name;
		this.industrycode = industrycode;
		this.contacts = contacts;
		this.enterprisewebsite = enterprisewebsite;
		this.area = area;
		this.estimated = estimated;
		this.begintime = begintime;
		this.productname = productname;
		this.dustry = dustry;
		this.legalperson = legalperson;
		this.telenumber = telenumber;
		this.signingtime = signingtime;
		this.agreement = agreement;
		this.annualtax = annualtax;
		this.completiontime = completiontime;
		this.qyname = qyname;
		this.beizhu = beizhu;
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

	@Column(name = "productdes", length = 600)
	public String getProductdes() {
		return this.productdes;
	}

	public void setProductdes(String productdes) {
		this.productdes = productdes;
	}

	@Column(name = "name", length = 600)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Industrycode", length = 600)
	public String getIndustrycode() {
		return this.industrycode;
	}

	public void setIndustrycode(String industrycode) {
		this.industrycode = industrycode;
	}

	@Column(name = "contacts", length = 60)
	public String getContacts() {
		return this.contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	@Column(name = "Enterprisewebsite", length = 600)
	public String getEnterprisewebsite() {
		return this.enterprisewebsite;
	}

	public void setEnterprisewebsite(String enterprisewebsite) {
		this.enterprisewebsite = enterprisewebsite;
	}

	@Column(name = "area", length = 600)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "Estimated", length = 600)
	public String getEstimated() {
		return this.estimated;
	}

	public void setEstimated(String estimated) {
		this.estimated = estimated;
	}

	@Column(name = "begintime", length = 600)
	public String getBegintime() {
		return this.begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	@Column(name = "productname", length = 600)
	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@Column(name = "dustry", length = 600)
	public String getDustry() {
		return this.dustry;
	}

	public void setDustry(String dustry) {
		this.dustry = dustry;
	}

	@Column(name = "legalperson", length = 60)
	public String getLegalperson() {
		return this.legalperson;
	}

	public void setLegalperson(String legalperson) {
		this.legalperson = legalperson;
	}

	@Column(name = "telenumber", length = 60)
	public String getTelenumber() {
		return this.telenumber;
	}

	public void setTelenumber(String telenumber) {
		this.telenumber = telenumber;
	}

	@Column(name = "Signingtime", length = 600)
	public String getSigningtime() {
		return this.signingtime;
	}

	public void setSigningtime(String signingtime) {
		this.signingtime = signingtime;
	}

	@Column(name = "agreement", length = 600)
	public String getAgreement() {
		return this.agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	@Column(name = "annualtax", length = 600)
	public String getAnnualtax() {
		return this.annualtax;
	}

	public void setAnnualtax(String annualtax) {
		this.annualtax = annualtax;
	}

	@Column(name = "completiontime", length = 600)
	public String getCompletiontime() {
		return this.completiontime;
	}

	public void setCompletiontime(String completiontime) {
		this.completiontime = completiontime;
	}

	@Column(name = "qyname", length = 600)
	public String getQyname() {
		return this.qyname;
	}

	public void setQyname(String qyname) {
		this.qyname = qyname;
	}

	@Column(name = "beizhu", length = 600)
	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

}