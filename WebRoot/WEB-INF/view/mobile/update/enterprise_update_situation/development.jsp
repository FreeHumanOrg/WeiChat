<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name=" apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<title>企业建设情况</title>
		<meta http-equiv="keywords" content="企业">
		<meta http-equiv="description" content="企业">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../mobile/css/base.css" />
		<script src="../mobile/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../mobile/js/base.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			window.onload = function() {
				for (var i = 1; i < $(".jsqk .jsqk-con").length; i++) {
					$(".jsqk .jsqk-con").eq(i).hide();
				}
			};
		</script>
	</head>

	<body>
		<div class="jsqk subcontent clearfloat">
			<div class="nav clearfloat">
				<ul>
					<li> <a href="##" class="cur">项目促建联系人</a></li>
					<li> <a href="##">政务办理情况</a></li>
					<li> <a href="##">国土办理情况</a></li>
					<li> <a href="##">要素保障</a></li>
					<li> <a href="##">项目建设进度</a></li>
				</ul>
			</div>
		<form action="../developmentmobile/ppupdate.jhtml" id="productpeople" method="post">
		<input name="id" value="${pp.id }" hidden="hidden" type="text">
		<input name="infomation.id" value="${id }" hidden="hidden" type="text">
			<div class="jsqk-con">
				<div class="intbox">
					<span class="name">姓名</span>
					<input name="name" type="text" class="write" value="${pp.name }"/>
				</div>
				<div class="intbox">
					<span class="name">联系方式</span>
					<input name="telphone" type="text" class="write" value="${pp.telphone }"/>
				</div>
				<div class="btn clearfloat">
					<a href="##" class="submit" onclick="document.getElementById('productpeople').submit();">提交</a>
				</div>
			</div>
		</form>
		
		<form action="../developmentmobile/zwupdate.jhtml" id="zhengwuform" method="post">
			<input name="id" value="${zw.id }" type="text" hidden="hidden">
			<input name="infomation.id" value="${id }" type="text" hidden="hidden">
			<div class="jsqk-con">
				<p class="title">工商税务</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input name="commercialtaxtime" type="text" class="write" value="${zw.commercialtaxtime }"/>
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="commercialtaxcon" type="text" class="write" value="${zw.commercialtaxcon }"/>
				</div>
				<p class="title">发改立项</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input name="projexttime" type="text" class="write" value="${zw.projexttime }" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="projextcon" type="text" class="write" value="${zw.projextcon }"/>
				</div>
				<p class="title">环评</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input name="eiatime" type="text" class="write" value="${zw.eiatime }"/>
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="eiacon" type="text" class="write" value="${zw.eiacon }"/>
				</div>
				<p class="title">用地许可</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input name="permittime" type="text" class="write" value="${zw.permittime }"/>
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="permitcon" type="text" class="write" value="${zw.permitcon }"/>
				</div>
				<p class="title">工程许可</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input name="permissiontime" type="text" class="write" value="${zw.permissiontime }"/>
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="permissioncon" type="text" class="write" value="${zw.permissioncon }"/>
				</div>
				<p class="title">施工工程</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input name="constructionprojectTime" type="text" class="write" value="${zw.constructionprojectTime }"/>
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="constructionprojectCon" type="text" class="write" value="${zw.constructionprojectCon }"/>
				</div>
				<p class="title">消防备验</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input name="fireinspectionTime" type="text" class="write" value="${zw.fireinspectionTime }"/>
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="fireinspectionCon" type="text" class="write" value="${zw.fireinspectionCon }"/>
				</div>
				<p class="title">总平图设计及方案报规</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input name="programmeReportTime" type="text" class="write" value="${zw.programmeReportTime }"/>
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="programmeReportcon" type="text" class="write" value="${zw.programmeReportcon }"/>
				</div>
				<p class="title">施工图设计及图审</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input name="chartreviewtime" type="text" class="write" value="${zw.chartreviewtime }"/>
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="chartreviewcon" type="text" class="write" value="${zw.chartreviewcon }"/>
				</div>
				<p class="title">施工、监理单位确定</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input name="controlUnitTime" type="text" class="write" value="${zw.controlUnitTime }"/>
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="controlUnitcon" type="text" class="write" value="${zw.controlUnitcon }"/>
				</div>
				<p class="title">招标备案</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input name="recordTime" type="text" class="write" value="${zw.recordTime }"/>
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="recordcon" type="text" class="write" value="${zw.recordcon }"/>
				</div>
				<p class="title">其他</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input name="otherTime" type="text" class="write" value="${zw.otherTime }"/>
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="othercon" type="text" class="write" value="${zw.othercon }"/>
				</div>
				<div class="btn clearfloat">
					<a href="##" class="submit" onclick="document.getElementById('zhengwuform').submit();">提交</a>
				</div>
			</div>
		</form>
		
		<form action="../developmentmobile/gtupdate.jhtml" id="guotu" method="post">
		<input name="id" value="${guotu.id }" type="text" hidden="hidden">
		<input name="infomation.id" value="${id }" type="text" hidden="hidden">
			<div class="jsqk-con">
				<p class="title">下达指标</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input name="indexTime" type="text" class="write" value="${guotu.indexTime }"/>
				</div>
				<div class="intbox">
					<span class="name">面积</span>
					<input name="indexCon" type="text" class="write" value="${guotu.indexCon }"/>
				</div>
				<p class="title">土地报征</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input name="landSignTime" type="text" class="write" value="${guotu.landSignTime }"/>
				</div>
				<div class="intbox">
					<span class="name">面积</span>
					<input name="landSigncon" type="text" class="write" value="${guotu.landSigncon }"/>
				</div>
				<p class="title">土地挂牌</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input name="landListingTime" type="text" class="write" value="${guotu.landListingTime }"/>
				</div>
				<div class="intbox">
					<span class="name">面积</span>
					<input name="landListingcon" type="text" class="write" value="${guotu.landListingcon }"/>
				</div>
				<div class="intbox">
					<span class="name">价格</span>
					<input name="landListingPri" type="text" class="write" value="${guotu.landListingPri }"/>
				</div>
				<p class="title">土地办证</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input name="landCertificateT" type="text" class="write" value="${guotu.landCertificateT }"/>
				</div>
				<div class="intbox">
					<span class="name">面积</span>
					<input name="landCertificateC" type="text" class="write" value="${guotu.landCertificateC }"/>
				</div>
				<div class="btn clearfloat">
					<a href="##" class="submit" onclick="document.getElementById('guotu').submit();">提交</a>
				</div>
			</div>
		</form>
		
		<form action="../developmentmobile/ysupdate.jhtml" id="yaosu" method="post">
			<input name="id" type="text" value="${ys.id }" hidden="hidden">
			<input name="infomation.id" type="text" value="${id }" hidden="hidden">
		    <div class="jsqk-con">
				<div class="intbox">
					<span class="name">道路</span>
					<input name="loaded" type="text" class="write" placeholder="描述" value="${ys.loaded }"/>
				</div>
				<div class="intbox">
					<span class="name">水</span>
					<input name="water" type="text" class="write" placeholder="描述" value="${ys.water }"/>
				</div>
				<div class="intbox">
					<span class="name">电</span>
					<input name="electric" type="text" class="write" placeholder="描述" value="${ys.electric }"/>
				</div>
				<div class="intbox">
					<span class="name">气</span>
					<input name="gas" type="text" class="write" placeholder="描述" value="${ys.gas }"/>
				</div>
				<div class="intbox">
					<span class="name">视</span>
					<input name="regard" type="text" class="write" placeholder="描述" value="${ys.regard }"/>
				</div>
				<div class="intbox">
					<span class="name">讯</span>
					<input name="hearing" type="text" class="write" placeholder="描述" value="${ys.hearing }"/>
				</div>
				<div class="btn clearfloat">
					<a href="##" class="submit" onclick="document.getElementById('yaosu').submit();">提交</a>
				</div>
		    </div>
		 </form>
		 
		 <form action="../developmentmobile/jdupdate.jhtml" method="post" id="jianshejindu">
		 <input name="id" type="text" value="${jd.id }" hidden="hidden">
			<input name="infomation.id" type="text" value="${id }" hidden="hidden">
		    <div class="jsqk-con">
		    	<p class="title">计划开工时间</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input name="plannedStartTime" type="text" class="write" value="${jd.plannedStartTime }"/>
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="plannedStartC" type="text" class="write" value="${jd.plannedStartC }"/>
				</div>
				<div class="intbox">
					<span class="name">解决方案</span>
					<input name="plannedStartSol" type="text" class="write" value="${jd.plannedStartSol }"/>
				</div>
				<p class="title">计划竣工时间</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input name="plannedJunTime" type="text" class="write" value="${jd.plannedJunTime}"/>
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="plannedJunC" type="text" class="write" value="${jd.plannedJunC }"/>
				</div>
				<div class="intbox">
					<span class="name">解决方案</span>
					<input name="plannedJunSol" type="text" class="write" value="${jd.plannedJunSol }"/>
				</div>
				<p class="title">实际开工时间</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input name="postnedStartTime" type="text" class="write" value="${jd.postnedStartTime }"/>
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="postnedStartC" type="text" class="write" value="${jd.postnedStartC }"/>
				</div>
				<div class="intbox">
					<span class="name">解决方案</span>
					<input name="postnedStartSol" type="text" class="write" value="${jd.postnedStartSol }"/>
				</div>
				<p class="title">实际竣工时间</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input name="postnedJunTime" type="text" class="write" value="${jd.postnedJunTime }"/>
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input name="postnedJunC" type="text" class="write" value="${jd.postnedJunC }"/>
				</div>
				<div class="intbox">
					<span class="name">解决方案</span>
					<input name="postnedJunSol" type="text" class="write" value="${jd.postnedJunSol }"/>
				</div>
				<p class="title">项目建设进度</p>
				<div class="intbox">
					<span class="name">建筑内容及规模</span>
					<input name="scale" type="text" class="write" value="${jd.scale }"/>
				</div>
				<div class="intbox">
					<span class="name">项目形象进度</span>
					<input name="progress" type="text" class="write" value="${jd.progress }"/>
				</div>
				<div class="btn clearfloat">
					<a href="##" class="submit" onclick="document.getElementById('jianshejindu').submit();">提交</a>
				</div>
		    </div>
		 </form>
		 
		</div>
	</body>
</html>
