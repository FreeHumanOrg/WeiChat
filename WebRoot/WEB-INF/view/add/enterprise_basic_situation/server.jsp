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
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>企业服务（所属服务）</title>
		<link rel="stylesheet" type="text/css" href="../window/css/base.css" />
		<script src="../window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		</script>
	</head>
	<body>
		<form id="postForm" action="<%=basePath%>server/serveradd.jhtml" method="post">
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
	</body>
</html>
