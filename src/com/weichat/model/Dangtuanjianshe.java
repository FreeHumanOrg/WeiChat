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
 * 党团建设实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：Dangtuanjianshe.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日
 * 下午3:51:05 修改人：王晶 修改时间：2016年6月22日 下午3:51:05 修改备注：
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
	 * 党组织建设情况
	 */
	private String jianSeQingK;

	/**
	 * 党支部书记
	 */
	private String shuji;

	/**
	 * 联系电话
	 */
	private String phone;

	/**
	 * 党务工作者
	 */
	private String dangwugzz;

	/**
	 * 党员人数
	 */
	private String dangYpeoper;

	/**
	 * 团组织建设情况
	 */
	private String tjianSeQingK;

	/**
	 * 团员人数
	 */
	private String tuanYpeoper;

	/**
	 * 活动开展情况
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
	 * 实现了IHistory接口，重写getLogDetail()方法
	 */
	@Transient
	@Override
	public String getLogDetail() {
		StringBuffer sbLog = new StringBuffer();
		sbLog.append("党组织建设情况：" + jianSeQingK);
		sbLog.append(";党支部书记：" + shuji);
		sbLog.append(";联系电话：" + phone);
		sbLog.append(";党务工作者：" + dangwugzz);
		sbLog.append(";党员人数：" + dangYpeoper);
		sbLog.append(";团组织建设情况：" + tjianSeQingK);
		sbLog.append(";团员人数：" + tuanYpeoper);
		sbLog.append(";活动开展情况：" + huoDongkaiZhan);
		return sbLog.toString();
	}

}