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
		<div class="yhzcqk subcontent clearfloat">
			<div class="yh-cont">
			<c:if test="${!empty policy}">
				<span class="yh-name">优惠政策1</span>
				<c:forEach items="${policy }" var="item">
					<c:if test="${item.num eq '1' }">
						<form action="../policymobile/policyupdate.jhtml" id="itemform${item.id }" method="post">
							<input name="infomation.id" type="hidden" value="${id }">
							<input name="id" type="hidden" value="${item.id }">
							<input name="num" type="hidden" value="${item.num }">
							<div class="intbox">
								<span class="name">${item.keystr }</span>
								<input name="keystr" type="text" hidden="hidden" value="${item.keystr }">
								<input name="valuestr" type="text" class="write" value="${item.valuestr }"/>
								<a href="##" class="save" onclick="document.getElementById('itemform${item.id}').submit();">保存</a>
								<a href="##" class="delete" onclick="deleteItem(${item.id})">删除</a>
							</div>
						</form>
					</c:if>
				</c:forEach>
					<form action="../policymobile/addPolicy.jhtml" id="addItem1" method="post">
						<input name="infomation.id" type="hidden" value="${id }">
						<div class="intbox lmmcbox">
							<span class="name">输入类目名称</span>
							<input type="text"  class="lmmc write" name="keystr"/>
							<input type="text" type="text" hidden="hidden" name="num" value="1">
							<a href="##" class="add" onclick="document.getElementById('addItem1').submit();">增加</a>
						</div>
					</form>
				
				<span class="yh-name">优惠政策2</span>
				<c:forEach items="${policy }" var="item">
					<c:if test="${item.num eq '2' }">
						<form action="../policymobile/policyupdate.jhtml" id="itemform${item.id }" method="post">
							<input name="infomation.id" type="hidden" value="${id }">
							<input name="id" type="hidden" value="${item.id }">
							<input name="num" type="hidden" value="${item.num }">
							<div class="intbox">
								<span class="name">${item.keystr }</span>
								<input name="keystr" type="text" hidden="hidden" value="${item.keystr }">
								<input name="valuestr" type="text" class="write" value="${item.valuestr }"/>
								<a href="##" class="save" onclick="document.getElementById('itemform${item.id}').submit();">保存</a>
								<a href="##" class="delete" onclick="deleteItem(${item.id})">删除</a>
							</div>
						</form>
						</c:if>
					</c:forEach>
					<form action="../policymobile/addPolicy.jhtml" id="addItem2" method="post">
						<input name="infomation.id" type="hidden" value="${id }">
						<div class="intbox lmmcbox">
							<span class="name">输入类目名称</span>
							<input type="text"  class="lmmc write" name="keystr"/>
							<input type="text" hidden="hidden" name="num" value="2">
							<a href="##" class="add" onclick="document.getElementById('addItem2').submit();">增加</a>
						</div>
					</form>
				</c:if>
			<c:if test="${empty policy}">
			<form action="../policymobile/addPolicy.jhtml" id="addItem1" method="post">
				<input name="infomation.id" type="hidden" value="${id }">
				<div class="intbox lmmcbox">
				<span class="yh-name">优惠政策1</span>
					<span class="name">输入类目名称</span>
					<input type="text"  class="lmmc write" name="keystr"/>
					<input type="text" hidden="hidden" name="num" value="1">
					<a href="##" class="add" onclick="document.getElementById('addItem1').submit();">增加</a>
				</div>
			</form>
			<form action="../policymobile/addPolicy.jhtml" id="addItem2" method="post">
				<input name="infomation.id" type="hidden" value="${id }">
				<div class="intbox lmmcbox">
				<span class="yh-name">优惠政策2</span>
					<span class="name">输入类目名称</span>
					<input type="text"  class="lmmc write" name="keystr"/>
					<input type="text" hidden="hidden" name="num" value="2">
					<a href="##" class="add" onclick="document.getElementById('addItem2').submit();">增加</a>
				</div>
			</form>
			</c:if>
		</div>
		</div>
	</body>
</html>
<script type="text/javascript">
function deleteItem(itemId){
	if (confirm('确定要删除此类目吗？')) {
		$.ajax({
		    url: 'delPolicy.jhtml',         
		    data: {"enterpriseSituationId" : itemId},
		    dataType : "json",
		    type: "get",          
		    success: function (data) {
		        if (data.result == "success") {
					alert("恭喜！您已成功删除此条目！");
					window.location.reload(true);
				} else {
					alert("非常抱歉，删除此企业的信息失败！请重试操作。");
				}
		    }
		});
	}
}

/*
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
	*/
</script>