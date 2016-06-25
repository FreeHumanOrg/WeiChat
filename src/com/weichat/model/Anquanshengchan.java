package com.weichat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * 安全生产实体类
 * 
 * 项目名称：WeiChat 类名称：Anquanshengchan.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日
 * 下午3:49:37 修改人：王晶 修改时间：2016年6月22日 下午3:49:37 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "anquanshengchan", catalog = "new")
public class Anquanshengchan implements java.io.Serializable {
	private static final long serialVersionUID = 1787637852628757821L;

	private Double id;

	private Infomation infomation;

	/**
	 * 安全生产管理机构及人员配备情况
	 */
	private String peoYuanQingk;

	/**
	 * 安全生产负责人姓名
	 */
	private String fuzeName;

	/**
	 * 安全生产负责人联系方式
	 */
	private String phone;

	/**
	 * 安全生产管理规章制度建立健全情况
	 */
	private String jianquanqingk;

	/**
	 * 是否安装监控设备
	 */
	private String yesOrNoJianko;

	/**
	 * 是否加入园区安全生产管理QQ群
	 */
	private String yesOrNoJoinQq;

	/**
	 * 安全设施“三同时”情况
	 */
	private String anquansheshi;

	/**
	 * 职业病防护设施“三同时”情况
	 */
	private String zhiyebing;

	/**
	 * 安全生产标准化建设情况
	 */
	private String anquanshengchan;

	/**
	 * 安全生产教育培训情况
	 */
	private String jiaoyuqingk;

	/**
	 * 事故隐患排查治理情况
	 */
	private String shiguyinhuan;

	/**
	 * 生产、储存、使用危化品情况
	 */
	private String shengchanchucun;

	/**
	 * 是否涉及可燃性粉尘
	 */
	private String yesornofenchen;

	/**
	 * 涉及可燃性粉尘的名称
	 */
	private String yesName;

	/**
	 * 是否存在有限空间作业
	 */
	private String yesoryouxiankj;

	/**
	 * 存在有限空间作业的名称
	 */
	private String yesyouname;

	/**
	 * 是否存在重大危险源
	 */
	private String yesorzhongda;

	/**
	 * 是否消防重点单位
	 */
	private String yesorxiaofang;

	/**
	 * 职业病危害及职业健康管理情况
	 */
	private String zhiybjiankang;

	/**
	 * 安全管理人员、职业健康管理人员持证情况
	 */
	private String anquanguanli;

	/**
	 * 电工作业
	 */
	private String diangongzuoye;

	/**
	 * 焊接与热切割作业
	 */
	private String hanjiezuoye;

	/**
	 * 高处作业
	 */
	private String gaochuzuoye;

	/**
	 * 制冷与空调作业
	 */
	private String zhilengzuoye;

	/**
	 * 危险化学品安全作业
	 */
	private String weixianhuaxue;

	/**
	 * 安全监管总局认定的其他作业
	 */
	private String qitazuoye;

	public Anquanshengchan() {
	}

	public Anquanshengchan(Infomation infomation) {
		this.infomation = infomation;
	}

	public Anquanshengchan(Infomation infomation, String peoYuanQingk,
			String fuzeName, String phone, String jianquanqingk,
			String yesOrNoJianko, String yesOrNoJoinQq, String anquansheshi,
			String zhiyebing, String anquanshengchan, String jiaoyuqingk,
			String shiguyinhuan, String shengchanchucun, String yesornofenchen,
			String yesName, String yesoryouxiankj, String yesyouname,
			String yesorzhongda, String yesorxiaofang, String zhiybjiankang,
			String anquanguanli, String diangongzuoye, String hanjiezuoye,
			String gaochuzuoye, String zhilengzuoye, String weixianhuaxue,
			String qitazuoye) {
		this.infomation = infomation;
		this.peoYuanQingk = peoYuanQingk;
		this.fuzeName = fuzeName;
		this.phone = phone;
		this.jianquanqingk = jianquanqingk;
		this.yesOrNoJianko = yesOrNoJianko;
		this.yesOrNoJoinQq = yesOrNoJoinQq;
		this.anquansheshi = anquansheshi;
		this.zhiyebing = zhiyebing;
		this.anquanshengchan = anquanshengchan;
		this.jiaoyuqingk = jiaoyuqingk;
		this.shiguyinhuan = shiguyinhuan;
		this.shengchanchucun = shengchanchucun;
		this.yesornofenchen = yesornofenchen;
		this.yesName = yesName;
		this.yesoryouxiankj = yesoryouxiankj;
		this.yesyouname = yesyouname;
		this.yesorzhongda = yesorzhongda;
		this.yesorxiaofang = yesorxiaofang;
		this.zhiybjiankang = zhiybjiankang;
		this.anquanguanli = anquanguanli;
		this.diangongzuoye = diangongzuoye;
		this.hanjiezuoye = hanjiezuoye;
		this.gaochuzuoye = gaochuzuoye;
		this.zhilengzuoye = zhilengzuoye;
		this.weixianhuaxue = weixianhuaxue;
		this.qitazuoye = qitazuoye;
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

	@Column(name = "PeoYuanQingk", length = 600)
	public String getPeoYuanQingk() {
		return this.peoYuanQingk;
	}

	public void setPeoYuanQingk(String peoYuanQingk) {
		this.peoYuanQingk = peoYuanQingk;
	}

	@Column(name = "FuzeName", length = 600)
	public String getFuzeName() {
		return this.fuzeName;
	}

	public void setFuzeName(String fuzeName) {
		this.fuzeName = fuzeName;
	}

	@Column(name = "phone", length = 600)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "jianquanqingk", length = 600)
	public String getJianquanqingk() {
		return this.jianquanqingk;
	}

	public void setJianquanqingk(String jianquanqingk) {
		this.jianquanqingk = jianquanqingk;
	}

	@Column(name = "YesOrNoJianko", length = 600)
	public String getYesOrNoJianko() {
		return this.yesOrNoJianko;
	}

	public void setYesOrNoJianko(String yesOrNoJianko) {
		this.yesOrNoJianko = yesOrNoJianko;
	}

	@Column(name = "YesOrNoJoinQQ", length = 600)
	public String getYesOrNoJoinQq() {
		return this.yesOrNoJoinQq;
	}

	public void setYesOrNoJoinQq(String yesOrNoJoinQq) {
		this.yesOrNoJoinQq = yesOrNoJoinQq;
	}

	@Column(name = "anquansheshi", length = 600)
	public String getAnquansheshi() {
		return this.anquansheshi;
	}

	public void setAnquansheshi(String anquansheshi) {
		this.anquansheshi = anquansheshi;
	}

	@Column(name = "zhiyebing", length = 600)
	public String getZhiyebing() {
		return this.zhiyebing;
	}

	public void setZhiyebing(String zhiyebing) {
		this.zhiyebing = zhiyebing;
	}

	@Column(name = "anquanshengchan", length = 600)
	public String getAnquanshengchan() {
		return this.anquanshengchan;
	}

	public void setAnquanshengchan(String anquanshengchan) {
		this.anquanshengchan = anquanshengchan;
	}

	@Column(name = "jiaoyuqingk", length = 600)
	public String getJiaoyuqingk() {
		return this.jiaoyuqingk;
	}

	public void setJiaoyuqingk(String jiaoyuqingk) {
		this.jiaoyuqingk = jiaoyuqingk;
	}

	@Column(name = "shiguyinhuan", length = 600)
	public String getShiguyinhuan() {
		return this.shiguyinhuan;
	}

	public void setShiguyinhuan(String shiguyinhuan) {
		this.shiguyinhuan = shiguyinhuan;
	}

	@Column(name = "shengchanchucun", length = 600)
	public String getShengchanchucun() {
		return this.shengchanchucun;
	}

	public void setShengchanchucun(String shengchanchucun) {
		this.shengchanchucun = shengchanchucun;
	}

	@Column(name = "yesornofenchen", length = 600)
	public String getYesornofenchen() {
		return this.yesornofenchen;
	}

	public void setYesornofenchen(String yesornofenchen) {
		this.yesornofenchen = yesornofenchen;
	}

	@Column(name = "yesName", length = 600)
	public String getYesName() {
		return this.yesName;
	}

	public void setYesName(String yesName) {
		this.yesName = yesName;
	}

	@Column(name = "yesoryouxiankj", length = 600)
	public String getYesoryouxiankj() {
		return this.yesoryouxiankj;
	}

	public void setYesoryouxiankj(String yesoryouxiankj) {
		this.yesoryouxiankj = yesoryouxiankj;
	}

	@Column(name = "yesyouname", length = 600)
	public String getYesyouname() {
		return this.yesyouname;
	}

	public void setYesyouname(String yesyouname) {
		this.yesyouname = yesyouname;
	}

	@Column(name = "yesorzhongda", length = 600)
	public String getYesorzhongda() {
		return this.yesorzhongda;
	}

	public void setYesorzhongda(String yesorzhongda) {
		this.yesorzhongda = yesorzhongda;
	}

	@Column(name = "yesorxiaofang", length = 600)
	public String getYesorxiaofang() {
		return this.yesorxiaofang;
	}

	public void setYesorxiaofang(String yesorxiaofang) {
		this.yesorxiaofang = yesorxiaofang;
	}

	@Column(name = "zhiybjiankang", length = 600)
	public String getZhiybjiankang() {
		return this.zhiybjiankang;
	}

	public void setZhiybjiankang(String zhiybjiankang) {
		this.zhiybjiankang = zhiybjiankang;
	}

	@Column(name = "anquanguanli", length = 600)
	public String getAnquanguanli() {
		return this.anquanguanli;
	}

	public void setAnquanguanli(String anquanguanli) {
		this.anquanguanli = anquanguanli;
	}

	@Column(name = "diangongzuoye", length = 600)
	public String getDiangongzuoye() {
		return this.diangongzuoye;
	}

	public void setDiangongzuoye(String diangongzuoye) {
		this.diangongzuoye = diangongzuoye;
	}

	@Column(name = "hanjiezuoye", length = 600)
	public String getHanjiezuoye() {
		return this.hanjiezuoye;
	}

	public void setHanjiezuoye(String hanjiezuoye) {
		this.hanjiezuoye = hanjiezuoye;
	}

	@Column(name = "gaochuzuoye", length = 600)
	public String getGaochuzuoye() {
		return this.gaochuzuoye;
	}

	public void setGaochuzuoye(String gaochuzuoye) {
		this.gaochuzuoye = gaochuzuoye;
	}

	@Column(name = "zhilengzuoye", length = 600)
	public String getZhilengzuoye() {
		return this.zhilengzuoye;
	}

	public void setZhilengzuoye(String zhilengzuoye) {
		this.zhilengzuoye = zhilengzuoye;
	}

	@Column(name = "weixianhuaxue", length = 600)
	public String getWeixianhuaxue() {
		return this.weixianhuaxue;
	}

	public void setWeixianhuaxue(String weixianhuaxue) {
		this.weixianhuaxue = weixianhuaxue;
	}

	@Column(name = "qitazuoye", length = 600)
	public String getQitazuoye() {
		return this.qitazuoye;
	}

	public void setQitazuoye(String qitazuoye) {
		this.qitazuoye = qitazuoye;
	}

}