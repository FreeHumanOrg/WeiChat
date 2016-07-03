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
			<c:if test="${!empty policy}">
			<span class="yh-name">优惠政策1</span>
				<div class="yh-cont">
				<c:forEach items="${policy }" var="item">
					<c:if test="${item.num eq '1' }">
						<form action="../policy/policyupdate.jhtml" id="itemform${item.id }" method="post">
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
					<form action="../policy/addPolicy.jhtml" id="addItem1" method="post">
						<input name="infomation.id" type="hidden" value="${id }">
						<div class="intbox lmmcbox">
							<span class="name">输入类目名称</span>
							<input type="text"  class="lmmc write" name="keystr"/>
							<input type="text" type="text" hidden="hidden" name="num" value="1">
							<a href="##" class="add" onclick="document.getElementById('addItem1').submit();">增加</a>
						</div>
					</form>
				</div>
				<div class="yh-cont">	
				<span class="yh-name">优惠政策2</span>
				<c:forEach items="${policy }" var="item">
					<c:if test="${item.num eq '2' }">
						<form action="../policy/policyupdate.jhtml" id="itemform${item.id }" method="post">
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
					<form action="../policy/addPolicy.jhtml" id="addItem2" method="post">
						<input name="infomation.id" type="hidden" value="${id }">
						<div class="intbox lmmcbox">
							<span class="name">输入类目名称</span>
							<input type="text"  class="lmmc write" name="keystr"/>
							<input type="text" hidden="hidden" name="num" value="2">
							<a href="##" class="add" onclick="document.getElementById('addItem2').submit();">增加</a>
						</div>
					</form>
					</div>
				</c:if>
			<c:if test="${empty policy}">
			<form action="../policy/addPolicy.jhtml" id="addItem1" method="post">
				<input name="infomation.id" type="hidden" value="${id }">
				<div class="intbox lmmcbox">
				<span class="yh-name">优惠政策1</span>
					<span class="name">输入类目名称</span>
					<input type="text"  class="lmmc write" name="keystr"/>
					<input type="text" hidden="hidden" name="num" value="1">
					<a href="##" class="add" onclick="document.getElementById('addItem1').submit();">增加</a>
				</div>
			</form>
			<form action="../policy/addPolicy.jhtml" id="addItem2" method="post">
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
	</body>
</html>
<script type="text/javascript">
function deleteItem(itemId){
	if (confirm('确定要删除此类目吗？')) {
		$.ajax({
		    url: '/WeiChat/policy/delPolicy.jhtml',         
		    data: {"enterpriseSituationId" : itemId},
		    dataType : "json",
		    type: "get",          
		    success: function (data) {
		        if (data.result == "success") {
					alert("恭喜！您已成功删除此条目！");
					window.location.reload(true);
				} else {
					alert("非常抱歉，删除此条目失败！请重试操作。");
				}
		    }
		});
	}
}
</script>