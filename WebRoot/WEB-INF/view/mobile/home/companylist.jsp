<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name=" apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <title>企业列表</title>
    <meta http-equiv="keywords" content="企业">
    <meta http-equiv="description" content="企业">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../mobile/css/base.css" />
	<script src="../mobile/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="../mobile/js/base.js" type="text/javascript" charset="utf-8"></script>
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
			<a href="/WeiChat/addindexmobile/frame.jhtml" class="new">新建</a>
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<th>企业名称</th>
					<th>跟进进度</th>
					<th>跟进人</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${page.content}" var="item">
					<tr>
    					<td><a href="/WeiChat/companymobile/mobileshow.jhtml?id=${item.id }">${item.name }</a></td>
    					<td>
  							<select id="progress">
    							<option value="success">成交</option>
    							<option value="follow">正在跟进</option>
    							<option value="failed">失败</option>
  							</select>
  							<button class="apply" style="display: inline;">应用</button>
    					</td>
    					<td>程光华，邓超，何兴轩</td>
    					<td><a href="##" onclick="$(this).parent().parent().remove();">删除</a></td>
    				</tr>
    			</c:forEach>
			</table>
		</div>
		
		<!-- 分页 -->
		<div>
			<form id="paginationForm" action="../companymobile/companylist.jhtml" method="post">
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
		
	</body>

</html>