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
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<meta name=" apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<title>企业基本信息</title>
		<meta http-equiv="keywords" content="企业">
		<meta http-equiv="description" content="企业">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../mobile/css/base.css" />
		<script src="../mobile/js/jquery1.9.0.min.js" type="text/javascript"></script>
		<script src="../mobile/js/base.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="qyjbqk subcontent clearfloat">
			<form id="postForm" action="<%=basePath %>basicSituationMobile/add.jhtml" method="post">
				<div class="intbox clearfloat">
					<span class="name">企业名称：</span><input type="text" class="write" name="name"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">项目名称：</span><input type="text" class="write" name="productname"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">产品描述：</span><input type="text" class="write" name="productdes"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">行业分类：</span><input type="text" class="write" name="dustry"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">行业代码：</span><input type="text" class="write" name="industrycode"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">企业法人：</span><input type="text" class="write" name="legalperson"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">企业联系人：</span><input type="text" class="write" name="contacts"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">企业联系方式：</span><input type="text" class="write" name="telenumber"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">企业网站：</span><input type="text" class="write" name="enterprisewebsite"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">签约时间：</span><input type="text" class="write" name="signingtime"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">占地（亩）：</span><input type="text" class="write" name="area"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">协议投资（万元）：</span><input type="text" class="write" name="agreement"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">预计年产值：</span><input type="text" class="write" name="estimated"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">预计年税收：</span><input type="text" class="write" name="annualtax"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">协议开工时间：</span><input type="text" class="write" name="begintime"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">协议竣工时间：</span><input type="text" class="write" name="completiontime"/>
				</div>
				<div class="intbox clearfloat">
					<span class="name">备注：</span><input type="text" class="write" name="beizhu"/>
				</div>
				<div class="btn clearfloat">
					<a href="javascript:submitForm();" class="submit">提交</a>
				</div>
			</form>
		</div>
		<script src="../mobile/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../mobile/js/base.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			function submitForm(){
				$("#postForm").submit();
			}
		</script>
	</body>
</html>