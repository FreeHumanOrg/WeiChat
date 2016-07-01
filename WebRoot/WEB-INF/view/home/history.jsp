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
		<title>历史记录</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>window/css/base.css" />
	</head>
	<body>
		<div class="history">
			<c:forEach items="${histories }" var="items">
				<div class="history_con">
					<p class="clearfloat">
						<img src="<%=basePath %>window/img/head_pic.png" class="fleft"/>
						
						<c:forEach items="${items.infomation.users }" var="userItem">
							${userItem.username }
						</c:forEach>
						<i class="fright">${items.operateDateTime }</i>
					</p>
					<span>
						${items.operateValue }
					</span>
				</div>
			</c:forEach>
			<%-- <div class="history_con">
				<p class="clearfloat">
					<img src="<%=basePath %>window/img/head_pic.png" class="fleft"/>
					肖玉芳
					<i class="fright">2016.11.11  16:00</i>
				</p>
				<span>
					修改客户分级：一级
				</span>
			</div> --%>
			<%-- <div class="history_con">
				<p class="clearfloat">
					<img src="<%=basePath %>window/img/head_pic.png" class="fleft"/>
					肖玉芳
					<i class="fright">2016.11.11  16:00</i>
				</p>
				<span>
					删除联系人：联系人信息为空
				</span>
				<span>
					新增联系人电话：15757176695
				</span>
			</div> --%>
		</div>
	</body>
</html>