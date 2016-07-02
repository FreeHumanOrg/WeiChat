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
		<title>企业发展</title>
		<link rel="stylesheet" type="text/css" href="../window/css/base.css" />
		<link rel="stylesheet" type="text/css" href="../window/css/jquery.datetimepicker.css" />
	</head>
	<body>
	<form id="expendform" action="<%=basePath%>expend/expendadd.jhtml" method="post">
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
				<input type="text" class="write" name="shangTime" types="datetimepicker" />
			</div>
			<div class="intbox">
				<span class="name">下规时间</span>
				<input type="text" class="write" name="xiaTime" types="datetimepicker" />
			</div>
			<div class="intbox">
				<span class="name">投产时间</span>
				<input type="text" class="write" name="touTime" types="datetimepicker" />
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
	
	<script src="../window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="../window/js/jquery.datetimepicker.full.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function (){
			$.datetimepicker.setLocale('ch');//设置中文
				$("input[types*='datetimepicker']").datetimepicker({
				  lang:"ch",           //语言选择中文
			      format:"Y-m-d H:m:s",      //格式化日期
			      timepicker:true,    //关闭时间选项
			      yearStart:2000,     //设置最小年份
			      yearEnd:2050,        //设置最大年份
			      todayButton:true   //关闭选择今天按钮
				});
		});
	</script>
	</body>
</html>
