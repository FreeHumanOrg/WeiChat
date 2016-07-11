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
    <title>企业服务</title>
    <meta http-equiv="keywords" content="企业">
    <meta http-equiv="description" content="企业">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../mobile/css/base.css?v=1.0" />
		<script src="../mobile/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../mobile/js/base.js?v=1.0" type="text/javascript"></script>
	</head>
	<body>
		<div class="main">
		<form id="postForm" action="<%=basePath%>servermobile/serveradd.jhtml" method="post">
			<div class="qyfw subcontent clearfloat">
				<div class="intbox">
					<span class="name">融资</span>
					<input type="text" class="write" name="longzhi" />
				</div>
				<div class="intbox">
					<span class="name">用工</span>
					<input type="text" class="write" name="yongGong" />
				</div>
				<div class="intbox">
					<span class="name">品牌</span>
					<input type="text" class="write" name="pinpai" />
				</div>
				<div class="intbox">
					<span class="name">培训</span>
					<input type="text" class="write" name="pinxun" />
				</div>
				<div class="btn clearfloat">
						<a href="javascript:document.getElementById('postForm').submit();" class="submit">提交</a>
				</div>
			</div>
		</form>
		</div>
	</body>
</html>
