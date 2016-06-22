<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>优惠政策情况</title>
		<link rel="stylesheet" type="text/css" href="../window/css/base.css" />
		<script src="../window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<div class="yhzcqk subcontent clearfloat">
			<c:forEach items="${policies }" var="item" varStatus="itemstatus">
				<div class="yh-cont">
					<span class="yh-name">优惠政策${itemstatus }</span>
					<div class="intbox">
					<span class="name">协议优惠政策内容</span>
					<input type="text" class="write" value="${item.content }"/>
					<a href="##" class="delete">删除</a>
				</div>
				<div class="intbox">
					<span class="name">应兑现金额</span>
					<input type="text" class="write" value="${item.money }"/>
					<a href="##" class="delete">删除</a>
				</div>
				<div class="intbox">
					<span class="name">兑现情况</span>
					<input type="text" class="write" value="${item.cashsituation }"/>
					<a href="##" class="delete">删除</a>
				</div>
				<div class="intbox lmmcbox">
					<span class="name">输入类目名称</span>
					<input type="text"  class="lmmc write" value="${item.typename }"/>
					<a href="##" class="add">增加</a>
				</div>
				</div>
			</c:forEach>
			
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
		</div>
		
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