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
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name=" apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <title>企业历史记录</title>
    <meta http-equiv="keywords" content="企业">
    <meta http-equiv="description" content="企业">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>mobile/css/base.css" />
	<link href="<%=basePath %>window/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<form id="paginationForm" action="<%=basePath %>history/historyshow.jhtml" method="post">
		<div class="history">
			<c:choose>
				<c:when test="${page.content.size() > 0 }">
					<c:forEach items="${page.content }" var="items">
						<div class="history_con">
							<p class="clearfloat">
								<img src="<%=basePath %>window/img/head_pic.png" class="fleft"/>
								<c:forEach items="${items.infomation.users }" var="userItem">
									${userItem.username }
								</c:forEach>
								【${items.companyName }】
								<i class="fright">${items.operateDateTime }</i>
								<i class="fright">${items.operateType }</i>
							</p>
							<span>
								${items.operateValue }
							</span>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					暂无历史记录！
				</c:otherwise>
			</c:choose>
		</div>
			<!-- 分页 -->
		<div>
				<ul class="pagination">
				
					<!-- 首页 -->				
					<li>
						<a class="homePageButton" href="javascript:pageSkip(1,'first');">首页 <span id="homePageNum">1</span></a>
					</li>
					
					<!-- 上一页 -->
					<li>
						<a class="prevPageButton" href="javascript:pageSkip(${page.prevPageIndex},'front');">上一页 <span id="prevPageNum">${page.prevPageIndex}</span></a>
					</li>
					
					<!-- 当前页 -->
					<li>
						<a class="currentPageButton" href="javascript:void(0);"><span id="currentPageNum">${page.pageIndex }</span></a>
					</li>
					
					<!-- 下一页 -->
					<li>
						<a class="nextPageButton" href="javascript:pageSkip(${page.nextPageIndex},'back');">下一页 <span id="nextPageNum">${page.pageIndex+1 }</span></a>
					</li>
					
					<!-- 末页 -->
					<li>
						<a class="lastPageButton" href="javascript:pageSkip(${page.lastPageIndex},'last');">末页 <span id="lastPageNum">${page.lastPageIndex}</span></a>
					</li>
					
					<!-- 空白列 -->
					<li>
						<a><span id="spaces">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></a>
					</li>
					
					<!-- 总页数 -->
					<li>
						<a class="totalPagesButton">共<span id="totalPagesNum">${page.totalPageSize}</span>页</a>
					</li>
					
					<!-- 总条数 -->
					<li>
						<a class="totalCountButton">共<span id="totalCountNum">${page.totalCount}</span>条记录</a>
					</li>
				</ul>
				
				<!-- 上一页： --><input type="hidden" name="prevPageIndex" value="${page.prevPageIndex}" />
				<!-- 当前页： --><input type="hidden" name="pageIndex" value="${page.pageIndex}" />
				<!-- 下一页： --><input type="hidden" name="nextPageIndex" value="${page.nextPageIndex}" />
				<!-- 最后一页： --><input type="hidden" name="lastPageIndex" value="${page.lastPageIndex}" />
				<!-- 总条数： --><input type="hidden" name="totalCount" value="${page.totalCount}" />
				<!-- 总页数： --><%-- ${page.totalPageSize} --%>
			</div>
		</form>
		
		<script src="<%=basePath %>window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath %>window/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function (){
				//前一页
				var prevPageIndex = $("#prevPageNum").text();
				
				//当前页
				var currentPageIndex = $("#currentPageNum").text();
				
				//下一页
				var nextPageIndex = $("#nextPageNum").text();
				
				//末页
				var lastPageIndex = $("#lastPageNum").text();
				
				//总页数
				var totalPagesIndex = $("#totalPagesNum").text();
				
				//当前页等于上一页，上一页按钮不显示
				if (parseInt(prevPageIndex) == parseInt(currentPageIndex)) {
					$(".prevPageButton").css("display","none");
				}else {
					$(".prevPageButton").css("display","block");
				}
				
				//当当前页数大于1时要显示“首页”按钮
				if (parseInt(currentPageIndex)>1) {
					$(".homePageButton").css("display","block");
				}else {
					$(".homePageButton").css("display","none");
				}
				
				//当最后一页小于总页数时要显示“末页”按钮
				if (parseInt(currentPageIndex) < parseInt(totalPagesIndex)) {
					$(".lastPageButton").css("display","block");
				}else {
					$(".lastPageButton").css("display","none");
				}
				
				if (parseInt(nextPageIndex) > parseInt(lastPageIndex)) {
					$(".nextPageButton").css("display","none");
				}else {
					$(".nextPageButton").css("display","block");
				}
			});
			
			function pageSkip(num,type){
				if (type === "front") {
					$("input[name*='pageIndex']").val(parseInt($("#currentPageNum").text())-1);
				}else if (type === "back") {
					$("input[name*='pageIndex']").val(parseInt($("#currentPageNum").text())+1);
				}else if (type === "last") {
					$("input[name*='pageIndex']").val($("#lastPageNum").text()*1);
				}else if (type === "first") {
					$("input[name*='pageIndex']").val($("#homePageNum").text()*1);
				}
				$("#paginationForm").submit();
			}
		</script>
	</body>
</html>