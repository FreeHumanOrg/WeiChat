<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
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
			margin-top: -12px;
			margin-right: 20px;
		}
		
		.btn-primary{
			width: 65px;
		}
		
		#progress{
			width: 150px;
			display: inline;
		}
		
		.choose_table{
			float: left;
		}
		
		.status_dropdown button{
			margin-top: -1px;
			margin-left: 10px;
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
				<table style="border-color: white; margin-top: -10px; width: 230px;">
					<tr>
						<td style="border-color: white;">
							跟进进度：
						</td>
						
						<td style="border-color: white; width: 150px;">
							<select class="form-control">
							<option>成交</option> 
							<option>正在跟进</option>
							<option>失败</option>
							</select>
						</td>
					</tr>
				</table>
			</div>
			<div class="intbox">
				<table style="border-color: white; margin-top: -10px; width: 260px;">
					<tr>
						<td style="border-color: white;">
							跟进人：
						</td>
						
						<td style="border-color: white;">
							<input type="text" placeholder="输入客户、联系人" class="form-control" />
						</td>
						
						<td style="border-color: white;">
							<button class="btn btn-primary" style="margin-top: -1px;">搜索</button>
						</td>
						
						<td style="border-color: white;">
							<button class="btn" onclick="location.href='/WeiChat/addindex/frame.jhtml'" style="margin-top: -1px;">新建</button>
						</td>
					</tr>
				</table>
			</div>
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
    					<td class="status_dropdown">
  							<select id="progress" class="form-control">
    							<option value="success">成交</option>
    							<option value="follow">正在跟进</option>
    							<option value="failed">失败</option>
  							</select>
  							<button class="btn btn-primary" style="display: inline;">应用</button>
    					</td>
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