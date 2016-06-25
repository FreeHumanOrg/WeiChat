<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>党团建设</title>
		<link rel="stylesheet" type="text/css" href="../window/css/base.css" />
		<script src="../window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		</script>
	</head>
	<body>
	<form action="../party/partyupdate.jhtml" method="POST" id="partyform">
		<input name="id" type="text" hidden="hidden" value="${party.id }">
		<input name="infomation.id" hidden="hidden" value="${id }">
		<div class="dtjs subcontent clearfloat">
			<div class="intbox">
				<span class="name">党组织建设情况</span>
				<input name="jianSeQingK" type="text" class="write" value="${party.jianSeQingK }"/>
			</div>
			<div class="intbox">
				<span class="name">党支部书记</span>
				<input name="shuji" type="text" class="write" value="${party.shuji }"/>
			</div>
			<div class="intbox">
				<span class="name">联系电话</span>
				<input name="phone" type="text" class="write" value="${party.phone }"/>
			</div>
			<div class="intbox">
				<span class="name">党务工作者</span>
				<input name="dangwugzz" type="text" class="write" value="${party.dangwugzz }"/>
			</div>
			<div class="intbox">
				<span class="name">党员人数</span>
				<input name="dangYpeoper" type="text" class="write" value="${party.dangYpeoper }"/>
			</div>
			<div class="intbox">
				<span class="name">团组织建设情况</span>
				<input name="tjianSeQingK" type="text" class="write" value="${party.tjianSeQingK }"/>
			</div>
			<div class="intbox">
				<span class="name">团员人数</span>
				<input name="tuanYpeoper" type="text" class="write" value="${party.tuanYpeoper }"/>
			</div>
			<div class="intbox">
				<span class="name">活动开展情况</span>
				<input name="huoDongkaiZhan" type="text" class="write" value="${party.huoDongkaiZhan }"/>
			</div>
			<div class="btn clearfloat">
					<a href="##" class="submit" onclick="document.getElementById('partyform').submit();">提交</a>
				</div>
		</div>
		</form>
	</body>
</html>
