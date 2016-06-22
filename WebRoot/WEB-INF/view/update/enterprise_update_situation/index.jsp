<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>企业基本情况</title>
		<link rel="stylesheet" type="text/css" href="../window/css/base.css" />
	</head>
	<body>
		<div class="qyjbqk subcontent clearfloat">
			<div class="intbox clearfloat">
				<span class="name">企业名称：</span><input type="text" class="write" value="${company.productdes }"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">项目名称：</span><input type="text" class="write"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">产品描述：</span><input type="text" class="write"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">行业分类：</span><input type="text" class="write"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">行业代码：</span><input type="text" class="write"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">企业法人：</span><input type="text" class="write"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">企业联系人：</span><input type="text" class="write"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">企业联系方式：</span><input type="text" class="write"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">企业网站：</span><input type="text" class="write"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">签约时间：</span><input type="text" class="write"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">占地（亩）：</span><input type="text" class="write"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">协议投资（万元）：</span><input type="text" class="write"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">预计年产值：</span><input type="text" class="write"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">预计年税收：</span><input type="text" class="write"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">协议开工时间：</span><input type="text" class="write"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">协议竣工时间：</span><input type="text" class="write"/>
			</div>
			<div class="intbox clearfloat">
				<span class="name">备注：</span><input type="text" class="write"/>
			</div>
			<div class="btn clearfloat">
				<a href="##" class="submit">提交</a>
			</div>
		</div>
		<script src="../window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../window/js/base.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>