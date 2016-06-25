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
 * ��ȫ����ʵ����
 * 
 * ��Ŀ���ƣ�WeiChat �����ƣ�Anquanshengchan.java ��������TODO �����ˣ����� ����ʱ�䣺2016��6��22��
 * ����3:49:37 �޸��ˣ����� �޸�ʱ�䣺2016��6��22�� ����3:49:37 �޸ı�ע��
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
	 * ��ȫ���������������Ա�䱸���
	 */
	private String peoYuanQingk;

	/**
	 * ��ȫ��������������
	 */
	private String fuzeName;

	/**
	 * ��ȫ������������ϵ��ʽ
	 */
	private String phone;

	/**
	 * ��ȫ������������ƶȽ�����ȫ���
	 */
	private String jianquanqingk;

	/**
	 * �Ƿ�װ����豸
	 */
	private String yesOrNoJianko;

	/**
	 * �Ƿ����԰����ȫ��������QQȺ
	 */
	private String yesOrNoJoinQq;

	/**
	 * ��ȫ��ʩ����ͬʱ�����
	 */
	private String anquansheshi;

	/**
	 * ְҵ��������ʩ����ͬʱ�����
	 */
	private String zhiyebing;

	/**
	 * ��ȫ������׼���������
	 */
	private String anquanshengchan;

	/**
	 * ��ȫ����������ѵ���
	 */
	private String jiaoyuqingk;

	/**
	 * �¹������Ų��������
	 */
	private String shiguyinhuan;

	/**
	 * ���������桢ʹ��Σ��Ʒ���
	 */
	private String shengchanchucun;

	/**
	 * �Ƿ��漰��ȼ�Է۳�
	 */
	private String yesornofenchen;

	/**
	 * �漰��ȼ�Է۳�������
	 */
	private String yesName;

	/**
	 * �Ƿ�������޿ռ���ҵ
	 */
	private String yesoryouxiankj;

	/**
	 * �������޿ռ���ҵ������
	 */
	private String yesyouname;

	/**
	 * �Ƿ�����ش�Σ��Դ
	 */
	private String yesorzhongda;

	/**
	 * �Ƿ������ص㵥λ
	 */
	private String yesorxiaofang;

	/**
	 * ְҵ��Σ����ְҵ�����������
	 */
	private String zhiybjiankang;

	/**
	 * ��ȫ������Ա��ְҵ����������Ա��֤���
	 */
	private String anquanguanli;

	/**
	 * �繤��ҵ
	 */
	private String diangongzuoye;

	/**
	 * ���������и���ҵ
	 */
	private String hanjiezuoye;

	/**
	 * �ߴ���ҵ
	 */
	private String gaochuzuoye;

	/**
	 * ������յ���ҵ
	 */
	private String zhilengzuoye;

	/**
	 * Σ�ջ�ѧƷ��ȫ��ҵ
	 */
	private String weixianhuaxue;

	/**
	 * ��ȫ����ܾ��϶���������ҵ
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