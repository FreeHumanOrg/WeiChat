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
		<title>企业基本情况</title>
		<link rel="stylesheet" type="text/css" href="../window/css/base.css" />
		<link rel="stylesheet" type="text/css" href="../window/css/jquery.datetimepicker.css" />
	</head>
	<body>
		<div class="qyjbqk subcontent clearfloat">
			<form id="postForm" action="<%=basePath %>basicSituation/add.jhtml" method="post">
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
					<span class="name">签约时间：</span><input type="text" class="write" name="signingtime" types="datetimepicker" />
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
					<span class="name">协议开工时间：</span><input type="text" class="write" name="begintime" types="datetimepicker" />
				</div>
				<div class="intbox clearfloat">
					<span class="name">协议竣工时间：</span><input type="text" class="write" name="completiontime" types="datetimepicker" />
				</div>
				<div class="intbox clearfloat">
					<span class="name">备注：</span><input type="text" class="write" name="beizhu"/>
				</div>
				<div class="btn clearfloat">
					<a href="javascript:submitForm();" class="submit">提交</a>
				</div>
			</form>
		</div>
		<script src="../window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../window/js/base.js" type="text/javascript" charset="utf-8"></script>
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
			
			function submitForm(){
				$("#postForm").submit();
			}
		</script>
	</body>
</html>