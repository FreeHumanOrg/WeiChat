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
				<c:forEach items="${companyList}" var="item">
					<tr>
    					<td><a href="">${item.productdes }</a></td>
    					<td>成交</td>
    					<td>程光华，邓超，何兴轩</td>
    					<td><a href="##" onclick="$(this).parent().parent().remove();">删除</a></td>
    				</tr>
    			</c:forEach>
				<tr>
					<td><a href="index.html">四川农耕耘电子商务有限公司</a></td>
					<td>成交</td>
					<td>程光华，邓超，何兴轩</td>
				</tr>
				<tr>
					<td><a href="index.html">四川农耕耘电子商务有限公司</a></td>
					<td>成交</td>
					<td>程光华，邓超，何兴轩</td>
				</tr>
				<tr>
					<td><a href="index.html">四川农耕耘电子商务有限公司</a></td>
					<td>成交</td>
					<td>程光华，邓超，何兴轩</td>
				</tr>
				<tr>
					<td><a href="index.html">四川农耕耘电子商务有限公司</a></td>
					<td>成交</td>
					<td>程光华，邓超，何兴轩</td>
				</tr>
			</table>
		</div>
	</body>

</html>