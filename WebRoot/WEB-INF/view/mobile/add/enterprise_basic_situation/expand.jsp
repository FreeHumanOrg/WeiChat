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
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name=" apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <title>企业发展</title>
    <meta http-equiv="keywords" content="企业">
    <meta http-equiv="description" content="企业">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../mobile/css/base.css" />
	<script src="../mobile/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	
	<body>
	<form id="expendform" action="<%=basePath%>expendmobile/expendadd.jhtml" method="post">
		<div class="qyfz subcontent clearfloat">
			<div class="intbox">
				<span class="name">固定资产投资</span>
				<input type="text" class="write" name="investment" />
			</div>
			<div class="intbox">
				<span class="name">产值</span>
				<input type="text" class="write" name="chanzhi" />
			</div>
			<div class="intbox">
				<span class="name">税收</span>
				<input type="text" class="write" name="shuishou" />
			</div>
			<p class="title">规模企业培育</p>
			<div class="intbox">
				<span class="name">上规时间</span>
				<input type="text" class="write" name="shangTime" />
			</div>
			<div class="intbox">
				<span class="name">下规时间</span>
				<input type="text" class="write" name="xiaTime" />
			</div>
			<div class="intbox">
				<span class="name">投产时间</span>
				<input type="text" class="write" name="touTime" />
			</div>
			<div class="intbox">
				<span class="name">高新技术企业</span>
				<input type="text" class="write" name="jiushuQiye" />
			</div>
			<div class="intbox">
				<span class="name">从业人员总数</span>
				<input type="text" class="write" name="renYuan" />
			</div>
			<div class="intbox">
				<span class="name">主要产品</span>
				<input type="text" class="write" name="zhuyaoPro" />
			</div>
			<div class="btn clearfloat">
				<a href="javascript:document.getElementById('expendform').submit();" class="submit">提交</a>
			</div>
		</div>
	</form>
	</body>
</html>
