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
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>优惠政策情况</title>
		<link rel="stylesheet" type="text/css" href="../window/css/base.css" />
		<link href="../window/css/bootstrap.min.css" rel="stylesheet">
		<style type="text/css">
			#add1,#add2{
				width:150px;
			}
			
			#applyButton1,#applyButton2{
				width:60px;
			}
		</style>
	</head>
	<body>
		<div class="yhzcqk subcontent clearfloat">
			<button id="add1" class="btn btn-info" data-toggle="modal" data-target="#myModal1">添加优惠政策1</button>
			<button id="add2" class="btn btn-info" data-toggle="modal" data-target="#myModal2">添加优惠政策2</button>
		</div>
		
		<!-- 模态对话框 -->
		<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" 
		               data-dismiss="modal" aria-hidden="true">
		                  &times;
		            </button>
		            <h4 class="modal-title" id="myModalLabel">添加优惠政策1</h4>
		         </div>
		         <div class="modal-body">
					
					<form id="postForm" action="<%=basePath%>policy/addPolicy.jhtml" method="post">
						<span class="name">类目名称</span>
						<input type="text" name="keystr1" class="form-control" />
						
						<span class="name">类目值</span>
						<input type="text" name="valuestr1" class="form-control" />
					</form>
					
		         </div>
		         <input type="hidden" id="enterpriseId" />
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" data-dismiss="modal" style="width:65px;">关闭</button>
		            <button id="applyButton1" type="button" class="btn btn-primary">提交</button>
		        </div>
				</div>
			</div>
		</div>
		
		<!-- 模态对话框 -->
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" 
		               data-dismiss="modal" aria-hidden="true">
		                  &times;
		            </button>
		            <h4 class="modal-title" id="myModalLabel">添加优惠政策2</h4>
		         </div>
		         <div class="modal-body">
					
					<form id="postForm" action="<%=basePath%>policy/addPolicy.jhtml" method="post">
						<span class="name">类目名称</span>
						<input type="text" name="keystr2" class="form-control" />
						
						<span class="name">类目值</span>
						<input type="text" name="valuestr2" class="form-control" />
					</form>
					
		         </div>
		         <input type="hidden" id="enterpriseId" />
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" data-dismiss="modal" style="width:65px;">关闭</button>
		            <button id="applyButton2" type="button" class="btn btn-primary">提交</button>
		        </div>
				</div>
			</div>
		</div>
		
		<script src="../window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../window/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function (){
				$("#applyButton1").click(function (){
					$.ajax({
						url:'<%=basePath%>policy/addPolicy2.jhtml',
						dataType:'json',
						type:'post',
						data:{key:$('input[name*=keystr1]').val(),value:$('input[name*=valuestr1]').val(),flag:1},
						success:function (data){
							if (data.result == 'successed') {
								alert('恭喜！您已成功添加！');
								window.location.reload(true);
							} else {
								alert('添加失败，请重试！');
							}
						}
					});
				});
				
				$("#applyButton2").click(function (){
					$.ajax({
						url:'<%=basePath%>policy/addPolicy2.jhtml',
						dataType:'json',
						type:'post',
						data:{key:$('input[name*=keystr2]').val(),value:$('input[name*=valuestr2]').val(),flag:2},
						success:function (data){
							if (data.result == 'successed') {
								alert('恭喜！您已成功添加！');
								window.location.reload(true);
							} else {
								alert('添加失败，请重试！');
							}
						}
					});
				});
			});
		</script>
	</body>
</html>