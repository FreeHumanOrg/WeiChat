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
 * 企业发展实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：Qiyefazhan.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日 下午3:54:13
 * 修改人：王晶 修改时间：2016年6月22日 下午3:54:13 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "qiyefazhan", catalog = "new")
public class Qiyefazhan implements java.io.Serializable, IHistory {
	private static final long serialVersionUID = 3756156090935771980L;

	private Double id;

	private Infomation infomation;

	/**
	 * 固定资产投资
	 */
	private String investment;

	/**
	 * 产值
	 */
	private String chanzhi;

	/**
	 * 税收
	 */
	private String shuishou;

	/**
	 * 上规时间
	 */
	private String shangTime;

	/**
	 * 下规时间
	 */
	private String xiaTime;

	/**
	 * 投产时间
	 */
	private String touTime;

	/**
	 * 高新技术企业
	 */
	private String jiushuQiye;

	/**
	 * 从业人员总数
	 */
	private String renYuan;

	/**
	 * 主要产品
	 */
	private String zhuyaoPro;

	public Qiyefazhan() {
	}

	public Qiyefazhan(Infomation infomation, String investment, String chanzhi,
			String shuishou, String shangTime, String xiaTime, String touTime,
			String jiushuQiye, String renYuan, String zhuyaoPro) {
		this.infomation = infomation;
		this.investment = investment;
		this.chanzhi = chanzhi;
		this.shuishou = shuishou;
		this.shangTime = shangTime;
		this.xiaTime = xiaTime;
		this.touTime = touTime;
		this.jiushuQiye = jiushuQiye;
		this.renYuan = renYuan;
		this.zhuyaoPro = zhuyaoPro;
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
	@JoinColumn(name = "infomationid")
	public Infomation getInfomation() {
		return this.infomation;
	}

	public void setInfomation(Infomation infomation) {
		this.infomation = infomation;
	}

	@Column(name = "investment", length = 600)
	public String getInvestment() {
		return this.investment;
	}

	public void setInvestment(String investment) {
		this.investment = investment;
	}

	@Column(name = "chanzhi", length = 600)
	public String getChanzhi() {
		return this.chanzhi;
	}

	public void setChanzhi(String chanzhi) {
		this.chanzhi = chanzhi;
	}

	@Column(name = "shuishou", length = 600)
	public String getShuishou() {
		return this.shuishou;
	}

	public void setShuishou(String shuishou) {
		this.shuishou = shuishou;
	}

	@Column(name = "shangTime", length = 600)
	public String getShangTime() {
		return this.shangTime;
	}

	public void setShangTime(String shangTime) {
		this.shangTime = shangTime;
	}

	@Column(name = "xiaTime", length = 600)
	public String getXiaTime() {
		return this.xiaTime;
	}

	public void setXiaTime(String xiaTime) {
		this.xiaTime = xiaTime;
	}

	@Column(name = "touTime", length = 600)
	public String getTouTime() {
		return this.touTime;
	}

	public void setTouTime(String touTime) {
		this.touTime = touTime;
	}

	@Column(name = "jiushuQiye", length = 600)
	public String getJiushuQiye() {
		return this.jiushuQiye;
	}

	public void setJiushuQiye(String jiushuQiye) {
		this.jiushuQiye = jiushuQiye;
	}

	@Column(name = "renYuan", length = 600)
	public String getRenYuan() {
		return this.renYuan;
	}

	public void setRenYuan(String renYuan) {
		this.renYuan = renYuan;
	}

	@Column(name = "zhuyaoPro", length = 600)
	public String getZhuyaoPro() {
		return this.zhuyaoPro;
	}

	public void setZhuyaoPro(String zhuyaoPro) {
		this.zhuyaoPro = zhuyaoPro;
	}

	/**
	 * 实现了IHistory接口，重写getLogDetail()方法
	 */
	@Transient
	@Override
	public String getLogDetail() {
		StringBuffer sbLog = new StringBuffer();
		sbLog.append("固定资产投资：" + investment);
		sbLog.append(";产值：" + chanzhi);
		sbLog.append(";税收：" + shuishou);
		sbLog.append(";上规时间：" + shangTime);
		sbLog.append(";下规时间：" + xiaTime);
		sbLog.append(";投产时间：" + touTime);
		sbLog.append(";高新技术企业：" + jiushuQiye);
		sbLog.append(";从业人员总数：" + renYuan);
		sbLog.append(";主要产品：" + zhuyaoPro);
		return sbLog.toString();
	}
}