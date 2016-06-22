package com.weichat.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
public class Infomation implements java.io.Serializable {
	private static final long serialVersionUID = 1459018372173537723L;

	private Double id;
	private String productdes;
	private String name;
	private String industrycode;
	private String contacts;
	private String enterprisewebsite;
	private String area;
	private String estimated;
	private String begintime;
	private String productname;
	private String dustry;
	private String legalperson;
	private String telenumber;
	private String signingtime;
	private String agreement;
	private String annualtax;
	private String completiontime;
	private String qyname;
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

	public Infomation() {
	}

	public Infomation(String productdes, String name, String industrycode,
			String contacts, String enterprisewebsite, String area,
			String estimated, String begintime, String productname,
			String dustry, String legalperson, String telenumber,
			String signingtime, String agreement, String annualtax,
			String completiontime, String qyname, String beizhu,
			Set<Xiangqing> xiangqings, Set<Prolist> prolists,
			Set<Dangtuanjianshe> dangtuanjianshes, Set<User> users,
			Set<Dangtuanjianshe> dangtuanjianshes_1,
			Set<Youhuizhengce> youhuizhengces,
			Set<Anquanshengchan> anquanshengchans,
			Set<Zhengwuqingkuang> zhengwuqingkuangs,
			Set<Qiyefazhan> qiyefazhans, Set<Productpeoper> productpeopers,
			Set<Qiyefuwu> qiyefuwus, Set<Project> projects, Set<Yaosu> yaosus,
			Set<Jiansejindu> jiansejindus) {
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
		this.xiangqings = xiangqings;
		this.prolists = prolists;
		this.dangtuanjianshes = dangtuanjianshes;
		this.users = users;
		this.dangtuanjianshes_1 = dangtuanjianshes_1;
		this.youhuizhengces = youhuizhengces;
		this.anquanshengchans = anquanshengchans;
		this.zhengwuqingkuangs = zhengwuqingkuangs;
		this.qiyefazhans = qiyefazhans;
		this.productpeopers = productpeopers;
		this.qiyefuwus = qiyefuwus;
		this.projects = projects;
		this.yaosus = yaosus;
		this.jiansejindus = jiansejindus;
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

}