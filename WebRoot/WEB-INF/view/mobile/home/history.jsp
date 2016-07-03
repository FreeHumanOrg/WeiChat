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
	</head>
	<body>
		<div class="history">
			<c:choose>
				<c:when test="${histories.size() > 0 }">
					<c:forEach items="${histories }" var="items">
						<div class="history_con">
							<p class="clearfloat">
								<img src="<%=basePath %>mobile/img/head_pic.png" class="fleft"/>
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
				</c:when>
				<c:otherwise>
					暂无历史记录！
				</c:otherwise>
			</c:choose>
		</div>
	</body>
</html>