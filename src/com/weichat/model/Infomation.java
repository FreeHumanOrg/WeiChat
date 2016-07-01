package com.weichat.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.weichat.interceptor.IHistory;

/**
 * 信息实体类
 * 
 * 
 * 项目名称：WeiChat 类名称：Infomation.java 类描述：TODO 创建人：王晶 创建时间：2016年6月22日 下午3:52:01
 * 修改人：王晶 修改时间：2016年6月22日 下午3:52:01 修改备注：
 * 
 * FreeHuman Soft Team
 * 
 * @version 1.0 Beta
 */
@Entity
@Table(name = "infomation", catalog = "new")
public class Infomation implements java.io.Serializable, IHistory {
	private static final long serialVersionUID = 1459018372173537723L;

	/**
	 * 企业ID
	 */
	private Double id;

	/**
	 * 产品描述
	 */
	private String productdes;

	/**
	 * 企业名称
	 */
	private String name;

	/**
	 * 行业代码
	 */
	private String industrycode;

	/**
	 * 企业联系人
	 */
	private String contacts;

	/**
	 * 企业网站
	 */
	private String enterprisewebsite;

	/**
	 * 占地面积（亩）
	 */
	private String area;

	/**
	 * 预计年产值
	 */
	private String estimated;

	/**
	 * 协议开工时间
	 */
	private String begintime;

	/**
	 * 项目名称
	 */
	private String productname;

	/**
	 * 行业分类
	 */
	private String dustry;

	/**
	 * 企业法人
	 */
	private String legalperson;

	/**
	 * 企业联系方式
	 */
	private String telenumber;

	/**
	 * 签约时间
	 */
	private String signingtime;

	/**
	 * 协议投资（万元）
	 */
	private String agreement;

	/**
	 * 预计年说收
	 */
	private String annualtax;

	/**
	 * 协议竣工时间
	 */
	private String completiontime;
	private String qyname;

	/**
	 * 企业跟进人
	 */
	private String genjinren;

	/**
	 * 企业跟进进度
	 */
	private String genjinjindu;

	/**
	 * 备注
	 */
	private String beizhu;

	private Set<Xiangqing> xiangqings = new HashSet<Xiangqing>(0);
	private Set<Prolist> prolists = new HashSet<Prolist>(0);
	private Set<Dangtuanjianshe> dangtuanjianshes = new HashSet<Dangtuanjianshe>(
			0);
	private Set<User> users = new HashSet<User>(0);
	private Set<Dangtuanjianshe> dangtuanjianshes_1 = new HashSet<Dangtuanjianshe>(
			0);
	private Set<Youhuizhengce> youhuizhengces = new HashSet<Youhuizhengce>(0);
	private Set<Anquanshengchan> anquanshengchans = new HashSet<Anquanshengchan>(
			0);
	private Set<Zhengwuqingkuang> zhengwuqingkuangs = new HashSet<Zhengwuqingkuang>(
			0);
	private Set<Qiyefazhan> qiyefazhans = new HashSet<Qiyefazhan>(0);
	private Set<Productpeoper> productpeopers = new HashSet<Productpeoper>(0);
	private Set<Qiyefuwu> qiyefuwus = new HashSet<Qiyefuwu>(0);
	private Set<Project> projects = new HashSet<Project>(0);
	private Set<Yaosu> yaosus = new HashSet<Yaosu>(0);
	private Set<Jiansejindu> jiansejindus = new HashSet<Jiansejindu>(0);
	private Set<History> histories = new HashSet<History>(0);
	private Set<Guotu> guotus = new HashSet<Guotu>(0);

	public Infomation() {
	}

	public Infomation(Double id, String productdes, String name,
			String industrycode, String contacts, String enterprisewebsite,
			String area, String estimated, String begintime,
			String productname, String dustry, String legalperson,
			String telenumber, String signingtime, String agreement,
			String annualtax, String completiontime, String qyname,
			String beizhu, String genjinren, String genjinjindu,
			Set<Xiangqing> xiangqings, Set<Prolist> prolists,
			Set<Dangtuanjianshe> dangtuanjianshes, Set<User> users,
			Set<Youhuizhengce> youhuizhengces,
			Set<Anquanshengchan> anquanshengchans,
			Set<Zhengwuqingkuang> zhengwuqingkuangs,
			Set<Productpeoper> productpeopers, Set<Qiyefuwu> qiyefuwus,
			Set<Yaosu> yaosus, Set<Jiansejindu> jiansejindus,
			Set<Dangtuanjianshe> dangtuanjianshes_1,
			Set<Qiyefazhan> qiyefazhans, Set<History> histories,
			Set<Project> projects, Set<Guotu> guotus) {
		this.id = id;
		this.productdes = productdes;
		this.name = name;
		this.industrycode = industrycode;
		this.contacts = contacts;
		this.enterprisewebsite = enterprisewebsite;
		this.area = area;
		this.estimated = estimated;
		this.begintime = begintime;
		this.productname = productname;
		this.dustry = dustry;
		this.legalperson = legalperson;
		this.telenumber = telenumber;
		this.signingtime = signingtime;
		this.agreement = agreement;
		this.annualtax = annualtax;
		this.completiontime = completiontime;
		this.qyname = qyname;
		this.beizhu = beizhu;
		this.genjinren = genjinren;
		this.genjinjindu = genjinjindu;
		this.xiangqings = xiangqings;
		this.prolists = prolists;
		this.dangtuanjianshes = dangtuanjianshes;
		this.users = users;
		this.youhuizhengces = youhuizhengces;
		this.anquanshengchans = anquanshengchans;
		this.zhengwuqingkuangs = zhengwuqingkuangs;
		this.productpeopers = productpeopers;
		this.qiyefuwus = qiyefuwus;
		this.yaosus = yaosus;
		this.jiansejindus = jiansejindus;
		this.dangtuanjianshes_1 = dangtuanjianshes_1;
		this.qiyefazhans = qiyefazhans;
		this.histories = histories;
		this.projects = projects;
		this.guotus = guotus;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, precision = 22, scale = 0)
	public Double getId() {
		return this.id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	@Column(name = "productdes", length = 600)
	public String getProductdes() {
		return this.productdes;
	}

	public void setProductdes(String productdes) {
		this.productdes = productdes;
	}

	@Column(name = "name", length = 600)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Industrycode", length = 600)
	public String getIndustrycode() {
		return this.industrycode;
	}

	public void setIndustrycode(String industrycode) {
		this.industrycode = industrycode;
	}

	@Column(name = "contacts", length = 60)
	public String getContacts() {
		return this.contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	@Column(name = "Enterprisewebsite", length = 600)
	public String getEnterprisewebsite() {
		return this.enterprisewebsite;
	}

	public void setEnterprisewebsite(String enterprisewebsite) {
		this.enterprisewebsite = enterprisewebsite;
	}

	@Column(name = "area", length = 600)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "Estimated", length = 600)
	public String getEstimated() {
		return this.estimated;
	}

	public void setEstimated(String estimated) {
		this.estimated = estimated;
	}

	@Column(name = "begintime", length = 600)
	public String getBegintime() {
		return this.begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	@Column(name = "productname", length = 600)
	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@Column(name = "dustry", length = 600)
	public String getDustry() {
		return this.dustry;
	}

	public void setDustry(String dustry) {
		this.dustry = dustry;
	}

	@Column(name = "legalperson", length = 60)
	public String getLegalperson() {
		return this.legalperson;
	}

	public void setLegalperson(String legalperson) {
		this.legalperson = legalperson;
	}

	@Column(name = "telenumber", length = 60)
	public String getTelenumber() {
		return this.telenumber;
	}

	public void setTelenumber(String telenumber) {
		this.telenumber = telenumber;
	}

	@Column(name = "Signingtime", length = 600)
	public String getSigningtime() {
		return this.signingtime;
	}

	public void setSigningtime(String signingtime) {
		this.signingtime = signingtime;
	}

	@Column(name = "agreement", length = 600)
	public String getAgreement() {
		return this.agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	@Column(name = "annualtax", length = 600)
	public String getAnnualtax() {
		return this.annualtax;
	}

	public void setAnnualtax(String annualtax) {
		this.annualtax = annualtax;
	}

	@Column(name = "completiontime", length = 600)
	public String getCompletiontime() {
		return this.completiontime;
	}

	public void setCompletiontime(String completiontime) {
		this.completiontime = completiontime;
	}

	@Column(name = "qyname", length = 600)
	public String getQyname() {
		return this.qyname;
	}

	public void setQyname(String qyname) {
		this.qyname = qyname;
	}

	@Column(name = "beizhu", length = 600)
	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	@Column(name = "genjinren", length = 455)
	public String getGenjinren() {
		return genjinren;
	}

	public void setGenjinren(String genjinren) {
		this.genjinren = genjinren;
	}

	@Column(name = "genjinjindu", length = 15)
	public String getGenjinjindu() {
		return genjinjindu;
	}

	public void setGenjinjindu(String genjinjindu) {
		this.genjinjindu = genjinjindu;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<Xiangqing> getXiangqings() {
		return this.xiangqings;
	}

	public void setXiangqings(Set<Xiangqing> xiangqings) {
		this.xiangqings = xiangqings;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<Prolist> getProlists() {
		return this.prolists;
	}

	public void setProlists(Set<Prolist> prolists) {
		this.prolists = prolists;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<Dangtuanjianshe> getDangtuanjianshes() {
		return this.dangtuanjianshes;
	}

	public void setDangtuanjianshes(Set<Dangtuanjianshe> dangtuanjianshes) {
		this.dangtuanjianshes = dangtuanjianshes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<Dangtuanjianshe> getDangtuanjianshes_1() {
		return this.dangtuanjianshes_1;
	}

	public void setDangtuanjianshes_1(Set<Dangtuanjianshe> dangtuanjianshes_1) {
		this.dangtuanjianshes_1 = dangtuanjianshes_1;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<Youhuizhengce> getYouhuizhengces() {
		return this.youhuizhengces;
	}

	public void setYouhuizhengces(Set<Youhuizhengce> youhuizhengces) {
		this.youhuizhengces = youhuizhengces;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<Anquanshengchan> getAnquanshengchans() {
		return this.anquanshengchans;
	}

	public void setAnquanshengchans(Set<Anquanshengchan> anquanshengchans) {
		this.anquanshengchans = anquanshengchans;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<Zhengwuqingkuang> getZhengwuqingkuangs() {
		return this.zhengwuqingkuangs;
	}

	public void setZhengwuqingkuangs(Set<Zhengwuqingkuang> zhengwuqingkuangs) {
		this.zhengwuqingkuangs = zhengwuqingkuangs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<Qiyefazhan> getQiyefazhans() {
		return this.qiyefazhans;
	}

	public void setQiyefazhans(Set<Qiyefazhan> qiyefazhans) {
		this.qiyefazhans = qiyefazhans;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<Productpeoper> getProductpeopers() {
		return this.productpeopers;
	}

	public void setProductpeopers(Set<Productpeoper> productpeopers) {
		this.productpeopers = productpeopers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<Qiyefuwu> getQiyefuwus() {
		return this.qiyefuwus;
	}

	public void setQiyefuwus(Set<Qiyefuwu> qiyefuwus) {
		this.qiyefuwus = qiyefuwus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<Yaosu> getYaosus() {
		return this.yaosus;
	}

	public void setYaosus(Set<Yaosu> yaosus) {
		this.yaosus = yaosus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<Jiansejindu> getJiansejindus() {
		return this.jiansejindus;
	}

	public void setJiansejindus(Set<Jiansejindu> jiansejindus) {
		this.jiansejindus = jiansejindus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<History> getHistories() {
		return this.histories;
	}

	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infomation")
	public Set<Guotu> getGuotus() {
		return this.guotus;
	}

	public void setGuotus(Set<Guotu> guotus) {
		this.guotus = guotus;
	}

	/**
	 * 实现了IHistory接口，重写getLogDetail()方法
	 */
	@Transient
	public String getLogDetail() {
		StringBuffer sbLog = new StringBuffer();
		sbLog.append("产品描述：" + productdes);
		sbLog.append(";企业名称：" + name);
		sbLog.append(";行业代码：" + industrycode);
		sbLog.append(";企业联系人：" + contacts);
		sbLog.append(";企业网站：" + enterprisewebsite);
		sbLog.append(";占地面积（亩）：" + area);
		sbLog.append(";预计年产值：" + estimated);
		sbLog.append(";协议开工时间：" + begintime);
		sbLog.append(";项目名称：" + productname);
		sbLog.append(";行业分类：" + dustry);
		sbLog.append(";企业法人：" + legalperson);
		sbLog.append(";企业联系方式：" + telenumber);
		sbLog.append(";签约时间：" + signingtime);
		sbLog.append(";协议投资（万元）：" + agreement);
		sbLog.append(";预计年税收：" + annualtax);
		sbLog.append(";协议竣工时间：" + completiontime);
		sbLog.append(";企业跟进人：" + genjinren);
		sbLog.append(";企业跟进进度：" + genjinjindu);
		sbLog.append(";备注：" + beizhu);
		return sbLog.toString();
	}

}