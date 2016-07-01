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
 * ���Ž���ʵ����
 * 
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�Dangtuanjianshe.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��22��
 * ����3:51:05 �޸��ˣ����� �޸�ʱ�䣺2016��6��22�� ����3:51:05 �޸ı�ע��
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "dangtuanjianshe", catalog = "new")
public class Dangtuanjianshe implements java.io.Serializable, IHistory {
	private static final long serialVersionUID = 5378040726126750926L;

	private Double id;

	private Infomation infomation;

	/**
	 * ����֯�������
	 */
	private String jianSeQingK;

	/**
	 * ��֧�����
	 */
	private String shuji;

	/**
	 * ��ϵ�绰
	 */
	private String phone;

	/**
	 * ��������
	 */
	private String dangwugzz;

	/**
	 * ��Ա����
	 */
	private String dangYpeoper;

	/**
	 * ����֯�������
	 */
	private String tjianSeQingK;

	/**
	 * ��Ա����
	 */
	private String tuanYpeoper;

	/**
	 * ���չ���
	 */
	private String huoDongkaiZhan;

	public Dangtuanjianshe() {
	}

	public Dangtuanjianshe(Infomation infomation) {
		this.infomation = infomation;
	}

	public Dangtuanjianshe(Infomation infomation, String jianSeQingK,
			String shuji, String phone, String dangwugzz, String dangYpeoper,
			String tjianSeQingK, String tuanYpeoper, String huoDongkaiZhan) {
		this.infomation = infomation;
		this.jianSeQingK = jianSeQingK;
		this.shuji = shuji;
		this.phone = phone;
		this.dangwugzz = dangwugzz;
		this.dangYpeoper = dangYpeoper;
		this.tjianSeQingK = tjianSeQingK;
		this.tuanYpeoper = tuanYpeoper;
		this.huoDongkaiZhan = huoDongkaiZhan;
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

	@Column(name = "jianSeQingK", length = 600)
	public String getJianSeQingK() {
		return this.jianSeQingK;
	}

	public void setJianSeQingK(String jianSeQingK) {
		this.jianSeQingK = jianSeQingK;
	}

	@Column(name = "shuji", length = 600)
	public String getShuji() {
		return this.shuji;
	}

	public void setShuji(String shuji) {
		this.shuji = shuji;
	}

	@Column(name = "phone", length = 600)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "dangwugzz", length = 600)
	public String getDangwugzz() {
		return this.dangwugzz;
	}

	public void setDangwugzz(String dangwugzz) {
		this.dangwugzz = dangwugzz;
	}

	@Column(name = "dangYPeoper", length = 600)
	public String getDangYpeoper() {
		return this.dangYpeoper;
	}

	public void setDangYpeoper(String dangYpeoper) {
		this.dangYpeoper = dangYpeoper;
	}

	@Column(name = "TjianSeQingK", length = 600)
	public String getTjianSeQingK() {
		return this.tjianSeQingK;
	}

	public void setTjianSeQingK(String tjianSeQingK) {
		this.tjianSeQingK = tjianSeQingK;
	}

	@Column(name = "tuanYPeoper", length = 600)
	public String getTuanYpeoper() {
		return this.tuanYpeoper;
	}

	public void setTuanYpeoper(String tuanYpeoper) {
		this.tuanYpeoper = tuanYpeoper;
	}

	@Column(name = "huoDongkaiZhan", length = 600)
	public String getHuoDongkaiZhan() {
		return this.huoDongkaiZhan;
	}

	public void setHuoDongkaiZhan(String huoDongkaiZhan) {
		this.huoDongkaiZhan = huoDongkaiZhan;
	}

	/**
	 * ʵ����IHistory�ӿڣ���дgetLogDetail()����
	 */
	@Transient
	@Override
	public String getLogDetail() {
		StringBuffer sbLog = new StringBuffer();
		sbLog.append("����֯���������" + jianSeQingK);
		sbLog.append(";��֧����ǣ�" + shuji);
		sbLog.append(";��ϵ�绰��" + phone);
		sbLog.append(";�������ߣ�" + dangwugzz);
		sbLog.append(";��Ա������" + dangYpeoper);
		sbLog.append(";����֯���������" + tjianSeQingK);
		sbLog.append(";��Ա������" + tuanYpeoper);
		sbLog.append(";���չ�����" + huoDongkaiZhan);
		return sbLog.toString();
	}

}