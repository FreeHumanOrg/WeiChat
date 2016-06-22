package com.weichat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 建设进度实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：Jiansejindu.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日 下午3:52:30
 * 修改人：王晶 修改时间：2016年6月22日 下午3:52:30 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "jiansejindu", catalog = "new")
public class Jiansejindu implements java.io.Serializable {
	private static final long serialVersionUID = 4633604878072854018L;

	private Double id;
	private Infomation infomation;
	private String plannedStartTime;
	private String plannedStartC;
	private String plannedJunTime;
	private String plannedJunC;
	private String postnedStartTime;
	private String postnedStartC;
	private String postnedJunTime;
	private String postnedJunC;
	private String scale;
	private String progress;
	private String plannedStartSol;
	private String plannedJunSol;
	private String postnedStartSol;
	private String postnedJunSol;

	public Jiansejindu() {
	}

	public Jiansejindu(Infomation infomation) {
		this.infomation = infomation;
	}

	public Jiansejindu(Infomation infomation, String plannedStartTime,
			String plannedStartC, String plannedJunTime, String plannedJunC,
			String postnedStartTime, String postnedStartC,
			String postnedJunTime, String postnedJunC, String scale,
			String progress, String plannedStartSol, String plannedJunSol,
			String postnedStartSol, String postnedJunSol) {
		this.infomation = infomation;
		this.plannedStartTime = plannedStartTime;
		this.plannedStartC = plannedStartC;
		this.plannedJunTime = plannedJunTime;
		this.plannedJunC = plannedJunC;
		this.postnedStartTime = postnedStartTime;
		this.postnedStartC = postnedStartC;
		this.postnedJunTime = postnedJunTime;
		this.postnedJunC = postnedJunC;
		this.scale = scale;
		this.progress = progress;
		this.plannedStartSol = plannedStartSol;
		this.plannedJunSol = plannedJunSol;
		this.postnedStartSol = postnedStartSol;
		this.postnedJunSol = postnedJunSol;
	}

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
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

	@Column(name = "PlannedStartTime", length = 600)
	public String getPlannedStartTime() {
		return this.plannedStartTime;
	}

	public void setPlannedStartTime(String plannedStartTime) {
		this.plannedStartTime = plannedStartTime;
	}

	@Column(name = "PlannedStartC", length = 600)
	public String getPlannedStartC() {
		return this.plannedStartC;
	}

	public void setPlannedStartC(String plannedStartC) {
		this.plannedStartC = plannedStartC;
	}

	@Column(name = "PlannedJunTime", length = 600)
	public String getPlannedJunTime() {
		return this.plannedJunTime;
	}

	public void setPlannedJunTime(String plannedJunTime) {
		this.plannedJunTime = plannedJunTime;
	}

	@Column(name = "PlannedJunC", length = 600)
	public String getPlannedJunC() {
		return this.plannedJunC;
	}

	public void setPlannedJunC(String plannedJunC) {
		this.plannedJunC = plannedJunC;
	}

	@Column(name = "PostnedStartTime", length = 600)
	public String getPostnedStartTime() {
		return this.postnedStartTime;
	}

	public void setPostnedStartTime(String postnedStartTime) {
		this.postnedStartTime = postnedStartTime;
	}

	@Column(name = "PostnedStartC", length = 600)
	public String getPostnedStartC() {
		return this.postnedStartC;
	}

	public void setPostnedStartC(String postnedStartC) {
		this.postnedStartC = postnedStartC;
	}

	@Column(name = "PostnedJunTime", length = 600)
	public String getPostnedJunTime() {
		return this.postnedJunTime;
	}

	public void setPostnedJunTime(String postnedJunTime) {
		this.postnedJunTime = postnedJunTime;
	}

	@Column(name = "PostnedJunC", length = 600)
	public String getPostnedJunC() {
		return this.postnedJunC;
	}

	public void setPostnedJunC(String postnedJunC) {
		this.postnedJunC = postnedJunC;
	}

	@Column(name = "Scale", length = 600)
	public String getScale() {
		return this.scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	@Column(name = "progress", length = 600)
	public String getProgress() {
		return this.progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	@Column(name = "PlannedStartSol", length = 600)
	public String getPlannedStartSol() {
		return this.plannedStartSol;
	}

	public void setPlannedStartSol(String plannedStartSol) {
		this.plannedStartSol = plannedStartSol;
	}

	@Column(name = "PlannedJunSol", length = 600)
	public String getPlannedJunSol() {
		return this.plannedJunSol;
	}

	public void setPlannedJunSol(String plannedJunSol) {
		this.plannedJunSol = plannedJunSol;
	}

	@Column(name = "PostnedStartSol", length = 600)
	public String getPostnedStartSol() {
		return this.postnedStartSol;
	}

	public void setPostnedStartSol(String postnedStartSol) {
		this.postnedStartSol = postnedStartSol;
	}

	@Column(name = "PostnedJunSol", length = 200)
	public String getPostnedJunSol() {
		return this.postnedJunSol;
	}

	public void setPostnedJunSol(String postnedJunSol) {
		this.postnedJunSol = postnedJunSol;
	}

}