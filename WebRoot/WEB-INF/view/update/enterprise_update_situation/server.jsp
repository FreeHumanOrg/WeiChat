<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>企业服务（所属服务）</title>
		<link rel="stylesheet" type="text/css" href="../window/css/base.css" />
		<script src="../window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		</script>
	</head>
	<body>
	<form action="../server/serverupdate.jhtml" method="post" id="serverform">
	<input name="infomation.id" type="hidden" value="${id }">
	<input name="id" type="hidden" value="${server.id }">
		<div class="qyfw subcontent clearfloat">
			<div class="intbox">
				<span class="name">融资</span>
				<input name="longzhi" type="text" class="write" value="${server.longzhi }"/>
			</div>
			<div class="intbox">
				<span class="name">用工</span>
				<input name="yongGong" type="text" class="write" value="${server.yongGong }"/>
			</div>
			<div class="intbox">
				<span class="name">品牌</span>
				<input name="pinpai" type="text" class="write" value="${server.pinpai }"/>
			</div>
			<div class="intbox">
				<span class="name">培训</span>
				<input name="pinxun" type="text" class="write" value="${server.pinxun }"/>
			</div>
			<div class="btn clearfloat">
					<a href="##" class="submit" onclick="document.getElementById('serverform').submit();">提交</a>
			</div>
		</div>
		</form>
	</body>
</html>
