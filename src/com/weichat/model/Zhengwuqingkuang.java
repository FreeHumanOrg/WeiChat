package com.weichat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 政务情况实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：Zhengwuqingkuang.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日
 * 下午3:56:38 修改人：王晶 修改时间：2016年6月22日 下午3:56:38 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "zhengwuqingkuang", catalog = "new")
public class Zhengwuqingkuang implements java.io.Serializable {
	private static final long serialVersionUID = 701045092500196431L;

	private Double id;

	private Infomation infomation;

	/**
	 * 工商税务办理时间
	 */
	private String commercialtaxtime;

	/**
	 * 工商税务存在的问题
	 */
	private String commercialtaxcon;

	/**
	 * 发改立项办理时间
	 */
	private String projexttime;

	/**
	 * 发改立项存在的问题
	 */
	private String projextcon;

	/**
	 * 环评办理时间
	 */
	private String eiatime;

	/**
	 * 环评存在的问题
	 */
	private String eiacon;

	/**
	 * 用地许可办理时间
	 */
	private String permittime;

	/**
	 * 用地许可存在的问题
	 */
	private String permitcon;

	/**
	 * 工程许可办理时间
	 */
	private String permissiontime;

	/**
	 * 工程许可存在的问题
	 */
	private String permissioncon;

	/**
	 * 施工工程办理时间
	 */
	private String constructionprojectTime;

	/**
	 * 施工工程存在的文体
	 */
	private String constructionprojectCon;

	/**
	 * 消防备检办理时间
	 */
	private String fireinspectionTime;

	/**
	 * 消防备检存在的问题
	 */
	private String fireinspectionCon;

	/**
	 * 总平图设计及方案报规办理时间
	 */
	private String programmeReportTime;

	/**
	 * 总平图设计及方案报规存在的问题
	 */
	private String programmeReportcon;

	/**
	 * 施工图设计及图审办理时间
	 */
	private String chartreviewtime;

	/**
	 * 施工图设计及图审存在的问题
	 */
	private String chartreviewcon;

	/**
	 * 施工、监理单位确定办理时间
	 */
	private String controlUnitTime;

	/**
	 * 施工、监理单位确定存在的问题
	 */
	private String controlUnitcon;

	/**
	 * 招标备案办理时间
	 */
	private String recordTime;

	/**
	 * 招标备案存在的问题
	 */
	private String recordcon;

	/**
	 * 其他办理时间
	 */
	private String otherTime;

	/**
	 * 其他存在的问题
	 */
	private String othercon;

	public Zhengwuqingkuang() {
	}

	public Zhengwuqingkuang(Infomation infomation) {
		this.infomation = infomation;
	}

	public Zhengwuqingkuang(Infomation infomation, String commercialtaxtime,
			String commercialtaxcon, String projexttime, String projextcon,
			String eiatime, String eiacon, String permittime, String permitcon,
			String permissiontime, String permissioncon,
			String constructionprojectTime, String constructionprojectCon,
			String fireinspectionTime, String fireinspectionCon,
			String programmeReportTime, String programmeReportcon,
			String chartreviewtime, String chartreviewcon,
			String controlUnitTime, String controlUnitcon, String recordTime,
			String recordcon, String otherTime, String othercon) {
		this.infomation = infomation;
		this.commercialtaxtime = commercialtaxtime;
		this.commercialtaxcon = commercialtaxcon;
		this.projexttime = projexttime;
		this.projextcon = projextcon;
		this.eiatime = eiatime;
		this.eiacon = eiacon;
		this.permittime = permittime;
		this.permitcon = permitcon;
		this.permissiontime = permissiontime;
		this.permissioncon = permissioncon;
		this.constructionprojectTime = constructionprojectTime;
		this.constructionprojectCon = constructionprojectCon;
		this.fireinspectionTime = fireinspectionTime;
		this.fireinspectionCon = fireinspectionCon;
		this.programmeReportTime = programmeReportTime;
		this.programmeReportcon = programmeReportcon;
		this.chartreviewtime = chartreviewtime;
		this.chartreviewcon = chartreviewcon;
		this.controlUnitTime = controlUnitTime;
		this.controlUnitcon = controlUnitcon;
		this.recordTime = recordTime;
		this.recordcon = recordcon;
		this.otherTime = otherTime;
		this.othercon = othercon;
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

	@Column(name = "commercialtaxtime", length = 60)
	public String getCommercialtaxtime() {
		return this.commercialtaxtime;
	}

	public void setCommercialtaxtime(String commercialtaxtime) {
		this.commercialtaxtime = commercialtaxtime;
	}

	@Column(name = "commercialtaxcon", length = 600)
	public String getCommercialtaxcon() {
		return this.commercialtaxcon;
	}

	public void setCommercialtaxcon(String commercialtaxcon) {
		this.commercialtaxcon = commercialtaxcon;
	}

	@Column(name = "projexttime", length = 60)
	public String getProjexttime() {
		return this.projexttime;
	}

	public void setProjexttime(String projexttime) {
		this.projexttime = projexttime;
	}

	@Column(name = "projextcon", length = 600)
	public String getProjextcon() {
		return this.projextcon;
	}

	public void setProjextcon(String projextcon) {
		this.projextcon = projextcon;
	}

	@Column(name = "eiatime", length = 600)
	public String getEiatime() {
		return this.eiatime;
	}

	public void setEiatime(String eiatime) {
		this.eiatime = eiatime;
	}

	@Column(name = "eiacon", length = 600)
	public String getEiacon() {
		return this.eiacon;
	}

	public void setEiacon(String eiacon) {
		this.eiacon = eiacon;
	}

	@Column(name = "permittime", length = 60)
	public String getPermittime() {
		return this.permittime;
	}

	public void setPermittime(String permittime) {
		this.permittime = permittime;
	}

	@Column(name = "permitcon", length = 600)
	public String getPermitcon() {
		return this.permitcon;
	}

	public void setPermitcon(String permitcon) {
		this.permitcon = permitcon;
	}

	@Column(name = "permissiontime", length = 600)
	public String getPermissiontime() {
		return this.permissiontime;
	}

	public void setPermissiontime(String permissiontime) {
		this.permissiontime = permissiontime;
	}

	@Column(name = "permissioncon", length = 600)
	public String getPermissioncon() {
		return this.permissioncon;
	}

	public void setPermissioncon(String permissioncon) {
		this.permissioncon = permissioncon;
	}

	@Column(name = "ConstructionprojectTime", length = 600)
	public String getConstructionprojectTime() {
		return this.constructionprojectTime;
	}

	public void setConstructionprojectTime(String constructionprojectTime) {
		this.constructionprojectTime = constructionprojectTime;
	}

	@Column(name = "ConstructionprojectCon", length = 600)
	public String getConstructionprojectCon() {
		return this.constructionprojectCon;
	}

	public void setConstructionprojectCon(String constructionprojectCon) {
		this.constructionprojectCon = constructionprojectCon;
	}

	@Column(name = "FireinspectionTime", length = 600)
	public String getFireinspectionTime() {
		return this.fireinspectionTime;
	}

	public void setFireinspectionTime(String fireinspectionTime) {
		this.fireinspectionTime = fireinspectionTime;
	}

	@Column(name = "FireinspectionCon", length = 600)
	public String getFireinspectionCon() {
		return this.fireinspectionCon;
	}

	public void setFireinspectionCon(String fireinspectionCon) {
		this.fireinspectionCon = fireinspectionCon;
	}

	@Column(name = "ProgrammeReportTime", length = 600)
	public String getProgrammeReportTime() {
		return this.programmeReportTime;
	}

	public void setProgrammeReportTime(String programmeReportTime) {
		this.programmeReportTime = programmeReportTime;
	}

	@Column(name = "ProgrammeReportcon", length = 600)
	public String getProgrammeReportcon() {
		return this.programmeReportcon;
	}

	public void setProgrammeReportcon(String programmeReportcon) {
		this.programmeReportcon = programmeReportcon;
	}

	@Column(name = "Chartreviewtime", length = 600)
	public String getChartreviewtime() {
		return this.chartreviewtime;
	}

	public void setChartreviewtime(String chartreviewtime) {
		this.chartreviewtime = chartreviewtime;
	}

	@Column(name = "Chartreviewcon", length = 600)
	public String getChartreviewcon() {
		return this.chartreviewcon;
	}

	public void setChartreviewcon(String chartreviewcon) {
		this.chartreviewcon = chartreviewcon;
	}

	@Column(name = "ControlUnitTime", length = 600)
	public String getControlUnitTime() {
		return this.controlUnitTime;
	}

	public void setControlUnitTime(String controlUnitTime) {
		this.controlUnitTime = controlUnitTime;
	}

	@Column(name = "ControlUnitcon", length = 600)
	public String getControlUnitcon() {
		return this.controlUnitcon;
	}

	public void setControlUnitcon(String controlUnitcon) {
		this.controlUnitcon = controlUnitcon;
	}

	@Column(name = "RecordTime", length = 600)
	public String getRecordTime() {
		return this.recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}

	@Column(name = "Recordcon", length = 600)
	public String getRecordcon() {
		return this.recordcon;
	}

	public void setRecordcon(String recordcon) {
		this.recordcon = recordcon;
	}

	@Column(name = "otherTime", length = 600)
	public String getOtherTime() {
		return this.otherTime;
	}

	public void setOtherTime(String otherTime) {
		this.otherTime = otherTime;
	}

	@Column(name = "othercon", length = 600)
	public String getOthercon() {
		return this.othercon;
	}

	public void setOthercon(String othercon) {
		this.othercon = othercon;
	}

}