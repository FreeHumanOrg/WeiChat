<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>企业列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="window/css/base.css" />
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
		.pagination{
			float:right;
			margin-top: -20px;
			margin-right: 20px;
		}
	</style>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
	<script src="window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="window/js/base.js" type="text/javascript" charset="utf-8"></script>
  </head>
	<body>
		<div class="search clearfloat">
			<div class="mod_select clearfloat">
				<ul>
					<li>
						<span class="select_label">跟进进度：</span>
						<div class="select_box">
							<span class="select_txt"></span><a class="selet_open"><b></b></a>
							<div class="option">
								<a>成交</a>
								<a>正在跟进</a>
								<a>失败</a>
							</div>
						</div>
						<br clear="all" />
					</li>
				</ul>
				<input type="hidden" id="select_value" />
			</div>
			<div class="intbox">
				<span class="name">跟进人：</span>
				<input type="text" class="write" placeholder="输入客户、联系人" />
			</div>
			<a href="##" class="sousuo">搜索</a>
			<a href="/WeiChat/addindex/frame.jhtml" class="new">新建</a>
			<br>
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<th>企业名称</th>
					<th>跟进进度</th>
					<th>跟进人</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${page.content}" var="item">
					<tr>
    					<td><a href="/WeiChat/company/companyshow.jhtml?id=${item.id }">${item.name }</a></td>
    					<td>成交</td>
    					<td>程光华，邓超，何兴轩</td>
    					<td><a href="##" onclick="$(this).parent().parent().remove();">删除</a></td>
    				</tr>
    			</c:forEach>
			</table>
		</div>
		
		<!-- 分页 -->
		<div>
			<form id="paginationForm" action="company/companylist.jhtml" method="post">
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
			</form>
		</div>
		
		<script type="text/javascript">
			$(function (){
				//首页
				//var homePageIndex = $("#homePageNum").text();
				
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