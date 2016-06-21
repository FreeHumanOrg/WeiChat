package com.weichat.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 党团建设实体类
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
@Table(name = "dangtuanjianshe", catalog = "new")
public class Dangtuanjianshe implements java.io.Serializable {

	private static final long serialVersionUID = -3857094740576410897L;
	private Double id;
	private String jianSeQingK;
	private String shuji;
	private String phone;
	private String dangwugzz;
	private String dangYpeoper;
	private String tjianSeQingK;
	private String tuanYpeoper;
	private String huoDongkaiZhan;

	public Dangtuanjianshe() {
	}

	public Dangtuanjianshe(String jianSeQingK, String shuji, String phone,
			String dangwugzz, String dangYpeoper, String tjianSeQingK,
			String tuanYpeoper, String huoDongkaiZhan) {
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
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 22, scale = 0)
	public Double getId() {
		return this.id;
	}

	public void setId(Double id) {
		this.id = id;
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

}