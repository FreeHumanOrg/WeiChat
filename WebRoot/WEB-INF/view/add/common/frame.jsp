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
			<a name="qyjbqk" class="sel" href="../addindex/ebs.jhtml" target="myFrameName"><i class="one"></i>企业基本情况</a>
			<a name="yhzcqk" <c:choose><c:when test="${displayAfterModel == true}"> href="../addindex/policy.jhtml" </c:when><c:otherwise> href="javascript:alert('尊敬的客户，非常抱歉。必须先添加“企业基本情况”且添加成功后方可继续点击其他项进行操作。');" </c:otherwise></c:choose> target="myFrameName"><i class="two"></i>优惠政策情况</a>
			<a name="jsqk" <c:choose><c:when test="${displayAfterModel == true}"> href="../addindex/development.jhtml" </c:when><c:otherwise> href="javascript:alert('尊敬的客户，非常抱歉。必须先添加“企业基本情况”且添加成功后方可继续点击其他项进行操作。');" </c:otherwise></c:choose> target="myFrameName"><i class="three"></i>建设情况</a>
			<a name="aqsc" <c:choose><c:when test="${displayAfterModel == true}"> href="../addindex/safety.jhtml" </c:when><c:otherwise> href="javascript:alert('尊敬的客户，非常抱歉。必须先添加“企业基本情况”且添加成功后方可继续点击其他项进行操作。');" </c:otherwise></c:choose> target="myFrameName"><i class="four"></i>安全生产</a>
			<a name="qyfz" <c:choose><c:when test="${displayAfterModel == true}"> href="../addindex/expand.jhtml" </c:when><c:otherwise> href="javascript:alert('尊敬的客户，非常抱歉。必须先添加“企业基本情况”且添加成功后方可继续点击其他项进行操作。');" </c:otherwise></c:choose> target="myFrameName"><i class="five"></i>企业发展</a>
			<a name="qyfw" <c:choose><c:when test="${displayAfterModel == true}"> href="../addindex/server.jhtml" </c:when><c:otherwise> href="javascript:alert('尊敬的客户，非常抱歉。必须先添加“企业基本情况”且添加成功后方可继续点击其他项进行操作。');" </c:otherwise></c:choose> target="myFrameName"><i class="six"></i>企业服务</a>
			<a name="dtjs" <c:choose><c:when test="${displayAfterModel == true}"> href="../addindex/party.jhtml" </c:when><c:otherwise> href="javascript:alert('尊敬的客户，非常抱歉。必须先添加“企业基本情况”且添加成功后方可继续点击其他项进行操作。');" </c:otherwise></c:choose> target="myFrameName"><i class="seven"></i>党团建设</a>
		</div>
		
		<!--右边内容-->
		<div class="main">
			<iframe frameborder="0" scrolling="auto" src="../addindex/ebs.jhtml" name="myFrameName" id="myFrameName"></iframe>
		</div>
	</div>

	<script src="../window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="../window/js/base.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function (){
			$(".leftPanel a").bind("click", function() {
				$(".leftPanel a").removeClass("sel");
				$(this).addClass("sel");
			});
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