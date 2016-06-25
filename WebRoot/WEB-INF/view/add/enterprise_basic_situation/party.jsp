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
		<title>党团建设</title>
		<link rel="stylesheet" type="text/css" href="../window/css/base.css" />
		<script src="../window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		</script>
	</head>
	<body>
	<form id="partyform" action="<%=basePath%>party/partyadd.jhtml" method="post">
		<div class="dtjs subcontent clearfloat">
			<div class="intbox">
				<span class="name">党组织建设情况</span>
				<input name="jianSeQingK" type="text" class="write" />
			</div>
			<div class="intbox">
				<span class="name">党支部书记</span>
				<input name="shuji" type="text" class="write" />
			</div>
			<div class="intbox">
				<span class="name">联系电话</span>
				<input name="phone" type="text" class="write" />
			</div>
			<div class="intbox">
				<span class="name">党务工作者</span>
				<input name="dangwugzz" type="text" class="write" />
			</div>
			<div class="intbox">
				<span class="name">党员人数</span>
				<input name="dangYpeoper" type="text" class="write" />
			</div>
			<div class="intbox">
				<span class="name">团组织建设情况</span>
				<input name="tjianSeQingK" type="text" class="write" />
			</div>
			<div class="intbox">
				<span class="name">团员人数</span>
				<input name="tuanYpeoper" type="text" class="write" />
			</div>
			<div class="intbox">
				<span class="name">活动开展情况</span>
				<input name="huoDongkaiZhan" type="text" class="write" />
			</div>
			<div class="btn clearfloat">
					<a href="javascript:document.getElementById('partyform').submit();" class="submit">提交</a>
				</div>
		</div>
		</form>
	</body>
</html>
