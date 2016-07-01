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
 * 国土实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：Guotu.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日 下午3:51:31 修改人：王晶
 * 修改时间：2016年6月22日 下午3:51:31 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "guotu", catalog = "new")
public class Guotu implements java.io.Serializable, IHistory {
	private static final long serialVersionUID = 1613875893519075523L;

	private Double id;

	private Infomation infomation;

	/**
	 * 下达指标时间
	 */
	private String indexTime;

	/**
	 * 土地报征时间
	 */
	private String landSignTime;

	/**
	 * 下达指标面积
	 */
	private String indexCon;

	/**
	 * 土地抱征面积
	 */
	private String landSigncon;

	/**
	 * 土地挂牌时间
	 */
	private String landListingTime;

	/**
	 * 土地挂牌面积
	 */
	private String landListingcon;

	/**
	 * 土地挂牌价格
	 */
	private String landListingPri;

	/**
	 * 土地办证时间
	 */
	private String landCertificateT;

	/**
	 * 土地办证面积
	 */
	private String landCertificateC;

	public Guotu() {
	}

	public Guotu(String indexTime, String landSignTime, String indexCon,
			String landSigncon, String landListingTime, String landListingcon,
			String landListingPri, String landCertificateT,
			String landCertificateC, Infomation infomation) {
		this.indexTime = indexTime;
		this.landSignTime = landSignTime;
		this.indexCon = indexCon;
		this.landSigncon = landSigncon;
		this.landListingTime = landListingTime;
		this.landListingcon = landListingcon;
		this.landListingPri = landListingPri;
		this.landCertificateT = landCertificateT;
		this.landCertificateC = landCertificateC;
		this.infomation = infomation;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, precision = 22, scale = 0)
	public Double getId() {
		return this.id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	@Column(name = "IndexTime", length = 600)
	public String getIndexTime() {
		return this.indexTime;
	}

	public void setIndexTime(String indexTime) {
		this.indexTime = indexTime;
	}

	@Column(name = "LandSignTime", length = 600)
	public String getLandSignTime() {
		return this.landSignTime;
	}

	public void setLandSignTime(String landSignTime) {
		this.landSignTime = landSignTime;
	}

	@Column(name = "IndexCon", length = 600)
	public String getIndexCon() {
		return this.indexCon;
	}

	public void setIndexCon(String indexCon) {
		this.indexCon = indexCon;
	}

	@Column(name = "LandSigncon", length = 600)
	public String getLandSigncon() {
		return this.landSigncon;
	}

	public void setLandSigncon(String landSigncon) {
		this.landSigncon = landSigncon;
	}

	@Column(name = "LandListingTime", length = 600)
	public String getLandListingTime() {
		return this.landListingTime;
	}

	public void setLandListingTime(String landListingTime) {
		this.landListingTime = landListingTime;
	}

	@Column(name = "LandListingcon", length = 600)
	public String getLandListingcon() {
		return this.landListingcon;
	}

	public void setLandListingcon(String landListingcon) {
		this.landListingcon = landListingcon;
	}

	@Column(name = "LandListingPri", length = 600)
	public String getLandListingPri() {
		return this.landListingPri;
	}

	public void setLandListingPri(String landListingPri) {
		this.landListingPri = landListingPri;
	}

	@Column(name = "LandCertificateT", length = 600)
	public String getLandCertificateT() {
		return this.landCertificateT;
	}

	public void setLandCertificateT(String landCertificateT) {
		this.landCertificateT = landCertificateT;
	}

	@Column(name = "LandCertificateC", length = 600)
	public String getLandCertificateC() {
		return this.landCertificateC;
	}

	public void setLandCertificateC(String landCertificateC) {
		this.landCertificateC = landCertificateC;
	}

	public Guotu(Infomation infomation) {
		this.infomation = infomation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "infomationid", nullable = false)
	public Infomation getInfomation() {
		return this.infomation;
	}

	public void setInfomation(Infomation infomation) {
		this.infomation = infomation;
	}

	/**
	 * 实现了IHistory接口，重写getLogDetail()方法
	 */
	@Transient
	@Override
	public String getLogDetail() {
		StringBuffer sbLog = new StringBuffer();
		sbLog.append("下达指标时间：" + indexTime);
		sbLog.append(";土地报征时间：" + landSignTime);
		sbLog.append(";下达指标面积：" + indexCon);
		sbLog.append(";土地抱征面积：" + landSigncon);
		sbLog.append(";土地挂牌时间：" + landListingTime);
		sbLog.append(";土地挂牌面积：" + landListingcon);
		sbLog.append(";土地挂牌价格：" + landListingPri);
		sbLog.append(";土地办证时间：" + landCertificateT);
		sbLog.append(";土地办证面积：" + landCertificateC);
		return sbLog.toString();
	}

}