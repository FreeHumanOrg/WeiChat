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
 * ����ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�Guotu.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��22�� ����3:51:31 �޸��ˣ�����
 * �޸�ʱ�䣺2016��6��22�� ����3:51:31 �޸ı�ע��
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
	 * �´�ָ��ʱ��
	 */
	private String indexTime;

	/**
	 * ���ر���ʱ��
	 */
	private String landSignTime;

	/**
	 * �´�ָ�����
	 */
	private String indexCon;

	/**
	 * ���ر������
	 */
	private String landSigncon;

	/**
	 * ���ع���ʱ��
	 */
	private String landListingTime;

	/**
	 * ���ع������
	 */
	private String landListingcon;

	/**
	 * ���ع��Ƽ۸�
	 */
	private String landListingPri;

	/**
	 * ���ذ�֤ʱ��
	 */
	private String landCertificateT;

	/**
	 * ���ذ�֤���
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
	 * ʵ����IHistory�ӿڣ���дgetLogDetail()����
	 */
	@Transient
	@Override
	public String getLogDetail() {
		StringBuffer sbLog = new StringBuffer();
		sbLog.append("�´�ָ��ʱ�䣺" + indexTime);
		sbLog.append(";���ر���ʱ�䣺" + landSignTime);
		sbLog.append(";�´�ָ�������" + indexCon);
		sbLog.append(";���ر��������" + landSigncon);
		sbLog.append(";���ع���ʱ�䣺" + landListingTime);
		sbLog.append(";���ع��������" + landListingcon);
		sbLog.append(";���ع��Ƽ۸�" + landListingPri);
		sbLog.append(";���ذ�֤ʱ�䣺" + landCertificateT);
		sbLog.append(";���ذ�֤�����" + landCertificateC);
		return sbLog.toString();
	}

}