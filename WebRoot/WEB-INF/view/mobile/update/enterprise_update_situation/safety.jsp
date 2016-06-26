<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name=" apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <title>企业安全生产</title>
    <meta http-equiv="keywords" content="企业">
    <meta http-equiv="description" content="企业">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../mobile/css/base.css" />
		<script src="../mobile/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(".intbox i.chose").click(function(){
		        $(this).siblings().removeClass("cur");
				$(this).addClass("cur");
			});
</script>
	</head>
	<body>
		<form id="safetyform" action="../safetymobile/safetyupdate.jhtml" method="post">
		<input name="id" type="text" hidden="hidden" value="${safety.id }">
		<input name="infomation.id" hidden="hidden" value="${id }">
		<div class="aqsc subcontent clearfloat">
			<div class="intbox">
				<span class="name name-long">安全生产管理机构及人员配备情况</span>
				<input name="peoYuanQingk" type="text" class="write" value="${safety.peoYuanQingk }"/>
			</div>
			
			<div class="intbox">
				<p class="title">安全生产负责人</p>
				<span class="name name-long">姓名</span>
				<input name="fuzeName" type="text" class="write" value="${safety.fuzeName }"/>
			</div>
			<div class="intbox">
				<span class="name name-long">联系方式</span>
				<input name="phone" type="text" class="write" value="${safety.phone }"/>
			</div>
			<div class="intbox">
				<span class="name name-long">安全生产管理规章制度建立健全情况</span>
				<input name="jianquanqingk" type="text" class="write" value="${safety.jianquanqingk }"/>
			</div>
			<div class="intbox">
				<span class="name name-long">是否安装监控设备</span>
				<c:if test="${safety.yesOrNoJianko eq '是' }">
					<input class="chose" type="radio" name="yesOrNoJianko" id="yesjianko" value="是" checked="checked"><label class="chose" for="yesjianko">是</label>
					<input class="chose" type="radio" name="yesOrNoJianko" id="nojianko" value="否"><label class="chose" for="nojianko">否</label>
				</c:if>
				<c:if test="${safety.yesOrNoJianko eq '否' }">
					<input class="choose" type="radio" name="yesOrNoJianko" id="yesjianko" value="是"><label class="choose" for="yesjianko">是</label>
					<input class="choose" type="radio" name="yesOrNoJianko" id="nojianko" value="否" checked="checked"><label class="choose" for="nojianko">否</label>
				</c:if>
				<c:if test="${safety.yesOrNoJianko eq null }">
					<input class="choose" type="radio" name="yesOrNoJianko" id="nojianko" value="否"><label class="choose" for="nojianko">否</label>
					<input class="choose" type="radio" name="yesOrNoJianko" id="yesjianko" value="是"><label class="choose" for="yesjianko">是</label>
				</c:if>
			</div>
			<div class="intbox">
				<span class="name name-long">是否加入园区安全生产管理QQ群（群号：373263636）</span>
				<c:if test="${safety.yesOrNoJoinQq eq '是' }">
					<input class="choose" type="radio" name="yesOrNoJoinQq" id="yesjoinqq" value="是" checked="checked"><label class="choose" for="yesjoinqq">是</label>
					<input class="choose" type="radio" name="yesOrNoJoinQq" id="nojoinqq" value="否"><label class="choose" for="nojoinqq">否</label>
				</c:if>
				<c:if test="${safety.yesOrNoJoinQq eq '否' }">
					<input class="choose" type="radio" name="yesOrNoJoinQq" id="yesjoinqq" value="是"><label class="choose" for="yesjoinqq">是</label>
					<input class="choose" type="radio" name="yesOrNoJoinQq" id="nojoinqq" value="否" checked="checked"><label class="choose" for="nojoinqq">否</label>
				</c:if>
				<c:if test="${safety.yesOrNoJoinQq eq null }">
					<input class="choose" type="radio" name="yesOrNoJoinQq" id="yesjoinqq" value="是"><label class="choose" for="yesjoinqq">是</label>
					<input class="choose" type="radio" name="yesOrNoJoinQq" id="nojoinqq" value="否"><label class="choose" for="nojoinqq">否</label>
				</c:if>
			</div>
			<div class="intbox">
				<span class="name name-long">安全设施“三同时”情况</span>
				<input name="anquansheshi" type="text" class="write" value="${safety.anquansheshi }"/>
			</div>
			<div class="intbox">
				<span class="name name-long">职业病防护设施“三同时”情况</span>
				<input name="zhiyebing" type="text" class="write" value="${safety.zhiyebing }"/>
			</div>
			<div class="intbox">
				<span class="name name-long">安全生产标准化建设情况</span>
				<input name="anquanshengchan" type="text" class="write" value="${safety.anquanshengchan }"/>
			</div>
			<div class="intbox">
				<span class="name name-long">安全生产教育培训情况</span>
				<input name="jiaoyuqingk" type="text" class="write" value="${safety.jiaoyuqingk }"/>
			</div>
			<div class="intbox">
				<span class="name name-long">事故隐患排查治理情况</span>
				<input name="shiguyinhuan" type="text" class="write" value="${safety.shiguyinhuan }"/>
			</div>
			<div class="intbox">
				<span class="name name-long">生产、储存、使用危化品情况</span>
				<input name="shengchanchucun" type="text" class="write" value="${safety.shengchanchucun }"/>
			</div>
			<div class="intbox">
				<span class="name name-long">是否涉及可燃性粉尘（如涉及可燃性粉尘请注明名称）</span>
				<c:if test="${safety.yesornofenchen eq '是' }">
					<input class="choose" type="radio" name="yesornofenchen" id="yesfenchen" value="是" checked="checked"><label class="choose" for="yesfenchen">是</label>
					<input class="choose" type="radio" name="yesornofenchen" id="nofenchen" value="否"><label class="choose" for="nofenchen">否</label>
					<input name="yesName" type="text" class="write shoter" value="${safety.yesName }"/>
				</c:if>
				<c:if test="${safety.yesornofenchen eq '否' }">
					<input class="choose" type="radio" name="yesornofenchen" id="yesfenchen" value="是"><label class="choose" for="yesfenchen">是</label>
					<input class="choose" type="radio" name="yesornofenchen" id="nofenchen" value="否" checked="checked"><label class="choose" for="nofenchen">否</label>
				</c:if>
				<c:if test="${safety.yesornofenchen eq null }">
					<input class="choose" type="radio" name="yesornofenchen" id="yesfenchen" value="是"><label class="choose" for="yesfenchen">是</label>
					<input class="choose" type="radio" name="yesornofenchen" id="nofenchen" value="否"><label class="choose" for="nofenchen">否</label>
					<input name="yesName" type="text" class="write shoter" value="${safety.yesName }"/>
				</c:if>
			</div>
			<div class="intbox">
				<span class="name name-long">是否存在有限空间作业（如存在有限空间请注明名称)</span>
				<c:if test="${safety.yesoryouxiankj eq '是'}">
					<input class="choose" type="radio" name="yesoryouxiankj" id="yesyouxiankj" value="是" checked="checked"><label class="choose" for="yesyouxiankj">是</label>
					<input class="choose" type="radio" name="yesoryouxiankj" id="noyouxiankj" value="否"><label class="choose" for="noyouxiankj">否</label>
					<input name="yesyouname" type="text" class="write shoter" value="${safety.yesyouname }"/>
				</c:if>
				<c:if test="${safety.yesoryouxiankj eq '否'}">
					<input class="choose" type="radio" name="yesoryouxiankj" id="yesyouxiankj" value="是"><label class="choose" for="yesyouxiankj">是</label>
					<input class="choose" type="radio" name="yesoryouxiankj" id="noyouxiankj" value="否" checked="checked"><label class="choose" for="noyouxiankj">否</label>
				</c:if>
				<c:if test="${safety.yesoryouxiankj eq null }">
					<input class="choose" type="radio" name="yesoryouxiankj" id="yesyouxiankj" value="是"><label class="choose" for="yesyouxiankj">是</label>
					<input class="choose" type="radio" name="yesoryouxiankj" id="noyouxiankj" value="否"><label class="choose" for="noyouxiankj">否</label>
					<input name="yesyouname" type="text" class="write shoter" value="${safety.yesyouname }"/>
				</c:if>
				
			</div>
			<div class="intbox">
				<span class="name name-long">是否存在重大危险源</span>
				<c:if test="${safety.yesorzhongda eq '是'}">
					<input class="choose" type="radio" name="yesorzhongda" id="yeszhongda" value="是" checked="checked"><label class="choose" for="yeszhongda">是</label>
					<input class="choose" type="radio" name="yesorzhongda" id="nozhongda" value="否"><label class="choose" for="nozhongda">否</label>
				</c:if>
				<c:if test="${safety.yesorzhongda eq '否'}">
					<input class="choose" type="radio" name="yesorzhongda" id="yeszhongda" value="是"><label class="choose" for="yeszhongda">是</label>
					<input class="choose" type="radio" name="yesorzhongda" id="nozhongda" value="否" checked="checked"><label class="choose" for="nozhongda">否</label>
				</c:if>
				<c:if test="${safety.yesorzhongda eq null }">
					<input class="choose" type="radio" name="yesorzhongda" id="yeszhongda" value="是"><label class="choose" for="yeszhongda">是</label>
					<input class="choose" type="radio" name="yesorzhongda" id="nozhongda" value="否"><label class="choose" for="nozhongda">否</label>
				</c:if>
			</div>
			<div class="intbox">
				<span class="name name-long">是否消防重点单位</span>
				<c:if test="${safety.yesorxiaofang eq '是'}">
					<input class="choose" type="radio" name="yesorxiaofang" id="yesxiaofang" value="是" checked="checked"><label class="choose" for="yesxiaofang">是</label>
					<input class="choose" type="radio" name="yesorxiaofang" id="noxiaofang" value="否"><label class="choose" for="noxiaofang">否</label>
				</c:if>
				<c:if test="${safety.yesorxiaofang eq '否'}">
					<input class="choose" type="radio" name="yesorxiaofang" id="yesxiaofang" value="是"><label class="choose" for="yesxiaofang">是</label>
					<input class="choose" type="radio" name="yesorxiaofang" id="noxiaofang" value="否" checked="checked"><label class="choose" for="noxiaofang">否</label>
				</c:if>
				<c:if test="${safety.yesorxiaofang eq null }">
					<input class="choose" type="radio" name="yesorxiaofang" id="yesxiaofang" value="是"><label class="choose" for="yesxiaofang">是</label>
					<input class="choose" type="radio" name="yesorxiaofang" id="noxiaofang" value="否"><label class="choose" for="noxiaofang">否</label>
				</c:if>
			</div>
			<div class="intbox">
				<span class="name name-long">职业病危害及职业健康管理情况</span>
				<input name="zhiybjiankang" type="text" class="write" value="${safety.zhiybjiankang }"/>
			</div>
			<div class="intbox">
				<span class="name name-long">安全管理人员、职业健康管理人员持证情况</span>
				<input name="anquanguanli" type="text" class="write" value="${safety.anquanguanli }"/>
			</div>
			<p class="title">特种（设备）作业人员</p>
			<div class="intbox">
				<span class="name name-long">电工作业</span>
				<input name="diangongzuoye" type="text" class="write" value="${safety.diangongzuoye }" />
			</div>
			<div class="intbox">
				<span class="name name-long">焊接与热切割作业</span>
				<input name="hanjiezuoye" type="text" class="write" value="${safety.hanjiezuoye }"/>
			</div>
			<div class="intbox">
				<span class="name name-long">高处作业</span>
				<input name="gaochuzuoye" type="text" class="write" value="${safety.gaochuzuoye }"/>
			</div>
			<div class="intbox">
				<span class="name name-long">制冷与空调作业</span>
				<input name="zhilengzuoye" type="text" class="write" value="${safety.zhilengzuoye }"/>
			</div>
			<div class="intbox">
				<span class="name name-long">危险化学品安全作业</span>
				<input name="weixianhuaxue" type="text" class="write" value="${safety.weixianhuaxue }"/>
			</div>
			<div class="intbox">
				<span class="name name-long">安全监管总局认定的其他作业</span>
				<input name="qitazuoye" type="text" class="write" value="${safety.qitazuoye }"/>
			</div>
			<div class="btn">
			    <a href="##" class="submit" onclick="document.getElementById('safetyform').submit();">提交</a>
			</div>
		</div>
		</form>
	</body>
</html>
