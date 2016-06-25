<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>建设情况</title>
		<link rel="stylesheet" type="text/css" href="../window/css/base.css" />
		<script src="../window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../window/js/base.js" type="text/javascript" charset="utf-8"></script>
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
			
		<!-- 项目促建联系人 -->
		<form action="<%=basePath%>development/addProductPeoperFromDev.jhtml" method="post" id="productpeople">
			<div class="jsqk-con">
				<div class="intbox">
					<span class="name">姓名</span>
					<input type="text" name="name" class="write" />
				</div>
				<div class="intbox">
					<span class="name">联系方式</span>
					<input type="text" name="telphone" class="write" />
				</div>
				<div class="btn clearfloat">
					<a href="javascript:document.getElementById('productpeople').submit();" class="submit">提交</a>
				</div>
			</div>
		</form>
		
		<!-- 政务办理情况 -->
		<form action="<%=basePath%>/development/addGovernmentSituationFromDev.jhtml" method="post" id="zhengwu">
			<div class="jsqk-con">
				<p class="title">工商税务</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" name="commercialtaxtime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="commercialtaxcon" />
				</div>
				<p class="title">发改立项</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" name="projexttime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="projextcon" />
				</div>
				<p class="title">环评</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" name="eiatime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="eiacon" />
				</div>
				<p class="title">用地许可</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" name="permittime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="permitcon" />
				</div>
				<p class="title">工程许可</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" name="permissiontime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="permissioncon" />
				</div>
				<p class="title">施工工程</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" name="constructionprojectTime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="constructionprojectCon" />
				</div>
				<p class="title">消防备验</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" name="fireinspectionTime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="fireinspectionCon" />
				</div>
				<p class="title">总平图设计及方案报规</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" name="programmeReportTime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="programmeReportcon" />
				</div>
				<p class="title">施工图设计及图审</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" name="chartreviewtime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="chartreviewcon" />
				</div>
				<p class="title">施工、监理单位确定</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" name="controlUnitTime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="controlUnitcon" />
				</div>
				<p class="title">招标备案</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" name="recordTime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="recordcon" />
				</div>
				<p class="title">其他</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" name="otherTime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="othercon" />
				</div>
				<div class="btn clearfloat">
					<a href="javascript:document.getElementById('zhengwu').submit();" class="submit">提交</a>
				</div>
			</div>
		</form>
		
		<!-- 国土办理情况 -->
		<form action="<%=basePath%>/development/addLandSituationFromDev.jhtml" method="post" id="guotu">
			<div class="jsqk-con">
				<p class="title">下达指标</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" name="indexTime" />
				</div>
				<div class="intbox">
					<span class="name">面积</span>
					<input type="text" class="write" name="indexCon" />
				</div>
				<p class="title">土地报征</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" name="landSignTime" />
				</div>
				<div class="intbox">
					<span class="name">面积</span>
					<input type="text" class="write" name="landSigncon" />
				</div>
				<p class="title">土地挂牌</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" name="landListingTime" />
				</div>
				<div class="intbox">
					<span class="name">面积</span>
					<input type="text" class="write" name="landListingcon" />
				</div>
				<div class="intbox">
					<span class="name">价格</span>
					<input type="text" class="write" name="landListingPri" />
				</div>
				<p class="title">土地办证</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" name="landCertificateT" />
				</div>
				<div class="intbox">
					<span class="name">面积</span>
					<input type="text" class="write" name="landCertificateC" />
				</div>
				<div class="btn clearfloat">
					<a href="javascript:document.getElementById('guotu').submit();" class="submit">提交</a>
				</div>
			</div>
		</form>
		
		<!-- 要素保障 -->
		<form action="<%=basePath%>/development/addElementsOfSecurityFromDev.jhtml" method="post" id="yaosu">
		    <div class="jsqk-con">
				<div class="intbox">
					<span class="name">道路</span>
					<input type="text" class="write" name="loaded" placeholder="描述"/>
				</div>
				<div class="intbox">
					<span class="name">水</span>
					<input type="text" class="write" name="water" placeholder="描述"/>
				</div>
				<div class="intbox">
					<span class="name">电</span>
					<input type="text" class="write" name="electric" placeholder="描述"/>
				</div>
				<div class="intbox">
					<span class="name">气</span>
					<input type="text" class="write" name="gas" placeholder="描述"/>
				</div>
				<div class="intbox">
					<span class="name">视</span>
					<input type="text" class="write" name="regard" placeholder="描述"/>
				</div>
				<div class="intbox">
					<span class="name">讯</span>
					<input type="text" class="write" name="hearing" placeholder="描述"/>
				</div>
				<div class="btn clearfloat">
					<a href="javascript:document.getElementById('yaosu').submit();" class="submit">提交</a>
				</div>
		    </div>
		 </form>
		 
		 <!-- 建设进度 -->
		 <form action="<%=basePath%>/development/addProjectBuildToProgressFromDev.jhtml" method="post" id="jianshejindu">
		    <div class="jsqk-con">
		    	<p class="title">计划开工时间</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" name="plannedStartTime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="plannedStartC" />
				</div>
				<div class="intbox">
					<span class="name">解决方案</span>
					<input type="text" class="write" name="plannedStartSol" />
				</div>
				<p class="title">计划竣工时间</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" name="plannedJunTime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="plannedJunC" />
				</div>
				<div class="intbox">
					<span class="name">解决方案</span>
					<input type="text" class="write" name="plannedJunSol" />
				</div>
				<p class="title">实际开工时间</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" name="postnedStartTime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="postnedStartC" />
				</div>
				<div class="intbox">
					<span class="name">解决方案</span>
					<input type="text" class="write" name="plannedStartSol" />
				</div>
				<p class="title">实际竣工时间</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" name="postnedJunTime" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" name="postnedJunC" />
				</div>
				<div class="intbox">
					<span class="name">解决方案</span>
					<input type="text" class="write" name="postnedJunSol" />
				</div>
				<p class="title">项目建设进度</p>
				<div class="intbox">
					<span class="name">建筑内容及规模</span>
					<input type="text" class="write" name="scale" />
				</div>
				<div class="intbox">
					<span class="name">项目形象进度</span>
					<input type="text" class="write" name="progress" />
				</div>
				<div class="btn clearfloat">
					<a href="javascript:document.getElementById('jianshejindu').submit();" class="submit">提交</a>
				</div>
		    </div>
		 </form>
		 
		</div>
	</body>
</html>
