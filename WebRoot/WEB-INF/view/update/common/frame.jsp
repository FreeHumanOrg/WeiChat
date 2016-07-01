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
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>微洽</title>
<link rel="stylesheet" type="text/css" href="../window/css/base.css" />
</head>

<body style="overflow: hidden;">
	<!--主要内容-->
	<div class="content clearfloat">
		<!--左边菜单栏-->
		<div class="leftPanel">
			<a name="qyjbqk" class="sel" href="../company/ebs.jhtml?id=${company.id }" target="myFrameName"><i class="one"></i>企业基本情况</a>
			<a name="yhzcqk" href="../policy/policyshow.jhtml?id=${company.id }" target="myFrameName"><i class="two"></i>优惠政策情况</a>
			<a name="jsqk" href="../development/developmentshow.jhtml?id=${company.id }" target="myFrameName"><i class="three"></i>建设情况</a>
			<a name="aqsc" href="../safety/safetyshow.jhtml?id=${company.id }" target="myFrameName"><i class="four"></i>安全生产</a>
			<a name="qyfz" href="../expend/expendshow.jhtml?id=${company.id }" target="myFrameName"><i class="five"></i>企业发展</a>
			<a name="qyfw" href="../server/servershow.jhtml?id=${company.id }" target="myFrameName"><i class="six"></i>企业服务</a>
			<a name="dtjs" href="../party/partyshow.jhtml?id=${company.id }" target="myFrameName"><i class="seven"></i>党团建设</a>
			<%-- <a name="lsjl" href="../history/historyshow.jhtml?id=${company.id }" target="myFrameName"><i class="eight"></i>历史记录</a> --%>
		</div>
		
		<!--右边内容-->
		<div class="main">
			<iframe frameborder="0" scrolling="auto" src="../company/ebs.jhtml?id=${company.id }" name="myFrameName" id="myFrameName"></iframe>
		</div>
	</div>

	<script src="../window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="../window/js/base.js" type="text/javascript" charset="utf-8"></script>
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
			for (i = 0; i < $(".leftPanel a").length; i++) {
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