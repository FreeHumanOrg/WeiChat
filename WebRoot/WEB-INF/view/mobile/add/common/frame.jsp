<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name=" apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <title>企业</title>
    <meta http-equiv="keywords" content="企业">
    <meta http-equiv="description" content="企业">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../mobile/css/base.css" />
	<script src="../mobile/js/jquery1.9.0.min.js" type="text/javascript"></script>
	<script src="../mobile/js/base.js" type="text/javascript"></script>
	<script type="text/javascript">
			$().ready(function(){							    
			    $(".leftPanel a").bind("click",function(){
			    	$(".leftPanel a").removeClass("sel");	
			    	$(this).addClass("sel");
			    });
			});
		</script>
</head>

<body style="overflow: hidden;">
	<i class="zk-icon"></i>
	<!--主要内容-->
	<div class="content clearfloat">
		<!--左边菜单栏-->
		<div class="leftPanel">
			<a name="qyjbqk" class="sel" href="../addindexmobile/ebs.jhtml" target="myFrameName"><i class="one"></i>企业基本情况</a>
			<a name="yhzcqk" href="../addindexmobile/policy.jhtml" target="myFrameName"><i class="two"></i>优惠政策情况</a>
			<a name="jsqk" href="../addindexmobile/development.jhtml" target="myFrameName"><i class="three"></i>建设情况</a>
			<a name="aqsc" href="../addindexmobile/safety.jhtml" target="myFrameName"><i class="four"></i>安全生产</a>
			<a name="qyfz" href="../addindexmobile/expand.jhtml" target="myFrameName"><i class="five"></i>企业发展</a>
			<a name="qyfw" href="../addindexmobile/server.jhtml" target="myFrameName"><i class="six"></i>企业服务</a>
			<a name="dtjs" href="../addindexmobile/party.jhtml" target="myFrameName"><i class="seven"></i>党团建设</a>
		</div>
		
		<!--右边内容-->
		<div class="main">
			<iframe frameborder="0" scrolling="auto" src="../addindexmobile/ebs.jhtml" name="myFrameName" id="myFrameName"></iframe>
		</div>
	</div>

	<script src="../mobile/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="../mobile/js/base.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$().ready(function() {
			$(".leftPanel a").bind("click", function() {
				$(".leftPanel a").removeClass("sel");
				$(this).addClass("sel");
			});
		});
	</script>
	<script type="text/javascript">
		$(window).bind("unload", function() {
			var oSrc1 = $("iframe").attr("src");
			for (var i = 0; i < $(".leftPanel a").length; i++) {
				var oSrc2 = $(this).attr("src");
				if (oSrc1 == oSrc2) {
					$(this).addClass("sel").siblings().removeClass("sel");
					return;
				}
			}
		});
	</script>
</body>
</html>