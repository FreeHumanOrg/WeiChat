<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	<link rel="stylesheet" type="text/css" href="window/css/themes/bootstrap/easyui.css" />
	<link rel="stylesheet" type="text/css" href="window/css/themes/icon.css" />
	<link href="window/css/bootstrap.min.css" rel="stylesheet">
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
		
		.status_dropdown button,button[data-toggle*='modal']{
			margin-top: -1px;
			margin-left: 10px;
		}
		
		#newButtonArea{
			text-align:right;
		}
		
		#newButtonArea a{
			width:125px;
			margin-right: 10px;
		}
	</style>
  </head>
	<body>
	<form id="paginationForm" action="company/companylist.jhtml" method="post">
		<div class="search clearfloat">
			<h2>企业列表</h2>
			<div class="intbox">
				<table style="border-color: white; margin-top: -10px; width: 260px;">
					<tr>
						<td style="border-color: white;">
							企业名称：
						</td>
						<td style="border-color: white;">
							<input name="searchValue" type="text" placeholder="输入企业名称" class="form-control" />
							<input type="text" hidden="hidden" name="searchProperty" value="name">
						</td>
						
						<td style="border-color: white;">
							<a onclick="document.getElementById('paginationForm').submit();" class="btn btn-primary" style="margin-top: -1px; color:white;">搜索</a>
						</td>
					</tr>
				</table>
			</div> 
			<p id="newButtonArea"><a class="btn btn-warning" onclick="location.href='/WeiChat/addindex/frame.jhtml'">新建</a><a class="btn btn-info" onclick="location.href='/WeiChat/history/historyshow.jhtml';">历史</a></p>
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
  							<select id="progress" operate="progresses" class="form-control">
  								<option value="-1" <c:if test="${item.genjinjindu eq '' or item.genjinjindu eq null  }"> selected="selected" </c:if> >--未选择--</option>
    							<option value="成交" <c:if test="${item.genjinjindu eq '成交' }"> selected="selected" </c:if> >成交</option>
    							<option value="正在跟进" <c:if test="${item.genjinjindu eq '正在跟进' }"> selected="selected" </c:if> >正在跟进</option>
    							<option value="失败" <c:if test="${item.genjinjindu eq '失败' }"> selected="selected" </c:if> >失败</option>
  							</select>
  							<button class="btn btn-primary" style="display: inline;" operate="applyButtonSingle" disabled="disabled" enterpriseSituationId="${item.id }">应用</button>
    					</td>
    					<td>
    						<c:choose>
    							<c:when test="${item.genjinren eq null}">
    								暂无跟进人
    							</c:when>
    							<c:otherwise>
    								<c:set var="string2" value="${fn:replace(item.genjinren,';', '、')}" />
    								${string2 }
    							</c:otherwise>
    						</c:choose>
    						<button class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="display: inline;" enterpriseId="${item.id }">编辑</button>
    					</td>
    					<td>
    						<a href="javascript:removeAnEnterpriseSituationInfo(${item.id });">删除</a>
    					</td>
    				</tr>
    			</c:forEach>
			</table>
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
			</form>
		</div>
		
		<!-- 模态对话框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" 
		               data-dismiss="modal" aria-hidden="true">
		                  &times;
		            </button>
		            <h4 class="modal-title" id="myModalLabel">编辑跟进人</h4>
		         </div>
		         <div class="modal-body">
					跟进人：<br/>
					<ul id="tree"></ul>
		         </div>
		         <input type="hidden" id="enterpriseId" />
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" data-dismiss="modal" style="width:65px;">关闭</button>
		            <button id="applyButton" type="button" class="btn btn-primary">应用</button>
		        </div>
				</div>
			</div>
		</div>
		
		<script src="window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="window/js/bootstrap.min.js"></script>
		<script src="window/js/base.js" type="text/javascript" charset="utf-8"></script>
		<script src="window/js/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
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
				
				
				$("button[data-toggle*='modal']").click(function (){
					var eId = $(this).attr("enterpriseId");
					$("#enterpriseId").val(eId);
					//alert(eId);
					$('#tree').tree({
						//设置url为在struts.xml文件中配置的action的访问路径
						url:'<%=basePath%>company/getUsersInfo.jhtml?enterpriseId='+eId,
						//开启动画效果
						animate:true,
						//每个节点都要显示复选框
						checkbox:true,
						//关闭级联选中
						cascadeCheck:false,
						//只在叶节点上才显示复选框
						onlyLeafCheck:true,
						//开启拖拽功能
						dnd:false,
						//鼠标双击事件
						onDbClick:function(node){
							//改变当前节点的折叠/展开状态
							$(this).tree("toggle",node.target);
		                }
					});
					$("#tree").tree('reload');
       			});
       	
		       	$("#applyButton").click(function (){
		       		var selectItems = $('#tree').tree('getChecked');
		       		
		       		var genjinrenIds = new Array();
		       		for (var i = 0; i < selectItems.length; i++) {
		       			var id = selectItems[i].id;
						genjinrenIds[i] = id;
					}
					
					$.ajax({
					    url: '<%=basePath%>company/changeGenJinRenInfo.jhtml',         
					    data: {"selectItems" : genjinrenIds , "enterpriseSituationId" : $("#enterpriseId").val()},
					    dataType:"json",
					    type: "POST",          
					    success: function (data) {
					        if (data.result == "success") {
								alert("恭喜！更改跟进人信息操作成功！");
								window.location.reload(true);
							} else {
								alert("非常抱歉，更新跟进人信息失败！请您重试操作。");
							}
					    }
					});
		       	});
		       	
				$("button[operate*='applyButtonSingle']").click(function (){
					var eId = $(this).attr("enterpriseSituationId");
					var pValue = $(this).siblings("select[operate*='progresses']").val();
					//alert(pValue);
					$.ajax({
					    url: 'company/updateProgress.jhtml',         
					    data: {"enterpriseSituationId" : eId , "progressValue" : pValue},
					    dataType : "json",
					    type: "POST",          
					    async:false,
					    success: function (data) {
					        if (data.result == "success") {
								alert("恭喜！更改跟进进度信息操作成功！");
								window.location.reload(true);
							} else {
								alert("非常抱歉，更新跟进进度信息失败！请您重试操作。");
							}
					    }
					});
				});
				
				$("select[operate*='progresses']").change(function (){
					$(this).find("~ button").removeAttr("disabled");
				});
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
			
			function removeAnEnterpriseSituationInfo(identity){
				$.ajax({
					    url: 'company/delEnterpriseInfo.jhtml',         
					    data: {"enterpriseSituationId" : identity},
					    dataType : "json",
					    type: "get",          
					    success: function (data) {
					        if (data.result == "success") {
								alert("恭喜！您已成功删除此企业的信息！");
						window.location.reload(true);
							} else {
								alert("非常抱歉，删除此企业的信息失败！请重试操作。");
							}
					    }
				});
			}
		</script>		
	</body>
</html>