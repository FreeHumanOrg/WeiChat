<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name=" apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <title>企业优惠政策情况修改</title>
    <meta http-equiv="keywords" content="企业">
    <meta http-equiv="description" content="企业">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../mobile/css/base.css" />
		<script src="../mobile/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
	<form action="../policymobile/policyupdate.jhtml" id="policyform" method="POST">
		<input name="infomation.id" value="${id }" type="hidden">
		<input name="id" value="${policy.id }" type="hidden">
		<div class="yhzcqk subcontent clearfloat">
				<div class="yh-cont">
					<span class="yh-name">优惠政策</span>
					<div class="intbox">
					<span class="name">协议优惠政策内容</span>
					<input name="content" type="text" class="write" value="${policy.content }"/>
					<a href="##" class="delete">删除</a>
				</div>
				<div class="intbox">
					<span class="name">应兑现金额</span>
					<input name="money" type="text" class="write" value="${policy.money }"/>
					<a href="##" class="delete">删除</a>
				</div>
				<div class="intbox">
					<span class="name">兑现情况</span>
					<input name="cashsituation" type="text" class="write" value="${policy.cashsituation }"/>
					<a href="##" class="delete">删除</a>
				</div>
				<!--  
				<div class="intbox lmmcbox">
					<span class="name">输入类目名称</span>
					<input type="text"  class="lmmc write" value="${item.typename }"/>
					<a href="##" class="add">增加</a>
				-->
				</div>
				</div>
				<div class="btn">
					<a href="##" class="add" onclick="document.getElementById('policyform').submit();">提交</a>
				</div>
				</form>
				<!--  
			<div class="yh-cont">
				<span class="yh-name">优惠政策1</span>
				<div class="intbox">
					<span class="name">协议优惠政策内容</span>
					<input type="text" class="write" />
					<a href="##" class="delete">删除</a>
				</div>
				<div class="intbox">
					<span class="name">应兑现金额</span>
					<input type="text" class="write" />
					<a href="##" class="delete">删除</a>
				</div>
				<div class="intbox">
					<span class="name">兑现情况</span>
					<input type="text" class="write" />
					<a href="##" class="delete">删除</a>
				</div>
				<div class="intbox lmmcbox">
					<span class="name">输入类目名称</span>
					<input type="text"  class="lmmc write" />
					<a href="##" class="add">增加</a>
				</div>
			</div>
		    <div class="yh-cont">
				<span class="yh-name">优惠政策2</span>
				<div class="intbox">
					<span class="name">协议优惠政策内容</span>
					<input type="text" class="write" />
					<a href="##" class="delete">删除</a>
				</div>
				<div class="intbox">
					<span class="name">应兑现金额</span>
					<input type="text" class="write" />
					<a href="##" class="delete">删除</a>
				</div>
				<div class="intbox">
					<span class="name">兑现情况</span>
					<input type="text" class="write" />
					<a href="##" class="delete">删除</a>
				</div>
				<div class="intbox lmmcbox">
					<span class="name">输入类目名称</span>
					<input type="text"  class="lmmc write" />
					<a href="##" class="add">增加</a>
				</div>
			</div>
			<div class="btn">
					<a href="##" class="add">提交</a>
				</div>
		</div>-->
		
	</body>
</html>
<script type="text/javascript">
	$(".btn a.add").click(function() {
		$('.tc', window.parent.document).show();
	});
	$(".intbox a.delete").live("click",function(){
		if(confirm('确定要删除此类目吗？')){$(this).parent().remove();}
	});
	$(".intbox a.add").click(function(){
		var oLmmc = $(".intbox input.lmmc").val();
		if(oLmmc==""){
			alert('请输入类目名称');
		}else{
			var oLm = '<div class="intbox"><span class="name">'+oLmmc+'</span><input type="text" class="write" /><a href="##" class="delete">'+'删除'+'</a></div>'
			$("div.lmmcbox").before(oLm);
		}
	});
</script>