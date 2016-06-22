<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>建设情况</title>
		<link rel="stylesheet" type="text/css" href="../window/css/base.css" />
		<script src="../window/js/jquery1.9.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			window.onload = function() {
				for (var i = 1; i < $(".jsqk .jsqk-con").length; i++) {
					$(".jsqk .jsqk-con").eq(i).hide();
				}
			};
			function change(){
				
			}
		</script>
	</head>
	<body>
		<div class="jsqk subcontent clearfloat">
			<div class="nav clearfloat">
				<ul>
					<li> <a href="##" class="cur">项目促建联系人</a></li>
					<li> <a href="##" onclick="change()">政务办理情况</a></li>
					<li> <a href="##">国土办理情况</a></li>
					<li> <a href="##">要素保障</a></li>
					<li> <a href="##">项目建设进度</a></li>
				</ul>
			</div>
			<div class="jsqk-con">
				<div class="intbox">
					<span class="name">姓名</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">联系方式</span>
					<input type="text" class="write" />
				</div>
				<div class="btn clearfloat">
					<a href="##" class="submit">提交</a>
				</div>
			</div>
			<div class="jsqk-con">
				<p class="title">工商税务</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<p class="title">发改立项</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<p class="title">环评</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<p class="title">用地许可</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<p class="title">工程许可</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<p class="title">施工工程</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<p class="title">消防备验</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<p class="title">总平图设计及方案报规</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<p class="title">施工图设计及图审</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<p class="title">施工、监理单位确定</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<p class="title">招标备案</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<p class="title">其他</p>
				<div class="intbox">
					<span class="name">办理时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<div class="btn clearfloat">
					<a href="##" class="submit">提交</a>
				</div>
			</div>
			<div class="jsqk-con">
				<p class="title">下达指标</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">面积</span>
					<input type="text" class="write" />
				</div>
				<p class="title">土地报征</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">面积</span>
					<input type="text" class="write" />
				</div>
				<p class="title">土地挂牌</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">面积</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">价格</span>
					<input type="text" class="write" />
				</div>
				<p class="title">土地办证</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">面积</span>
					<input type="text" class="write" />
				</div>
				<div class="btn clearfloat">
					<a href="##" class="submit">提交</a>
				</div>
			</div>
		    <div class="jsqk-con">
				<div class="intbox">
					<span class="name">道路</span>
					<input type="text" class="write" placeholder="描述"/>
				</div>
				<div class="intbox">
					<span class="name">水</span>
					<input type="text" class="write" placeholder="描述"/>
				</div>
				<div class="intbox">
					<span class="name">电</span>
					<input type="text" class="write" placeholder="描述"/>
				</div>
				<div class="intbox">
					<span class="name">气</span>
					<input type="text" class="write" placeholder="描述"/>
				</div>
				<div class="intbox">
					<span class="name">视</span>
					<input type="text" class="write" placeholder="描述"/>
				</div>
				<div class="intbox">
					<span class="name">讯</span>
					<input type="text" class="write" placeholder="描述"/>
				</div>
				<div class="btn clearfloat">
					<a href="##" class="submit">提交</a>
				</div>
		    </div>
		    <div class="jsqk-con">
		    	<p class="title">计划开工时间</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">解决方案</span>
					<input type="text" class="write" />
				</div>
				<p class="title">计划竣工时间</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">解决方案</span>
					<input type="text" class="write" />
				</div>
				<p class="title">实际开工时间</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">解决方案</span>
					<input type="text" class="write" />
				</div>
				<p class="title">实际竣工时间</p>
				<div class="intbox">
					<span class="name">时间</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">存在问题</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">解决方案</span>
					<input type="text" class="write" />
				</div>
				<p class="title">项目建设进度</p>
				<div class="intbox">
					<span class="name">建筑内容及规模</span>
					<input type="text" class="write" />
				</div>
				<div class="intbox">
					<span class="name">项目形象进度</span>
					<input type="text" class="write" />
				</div>
				<div class="btn clearfloat">
					<a href="##" class="submit">提交</a>
				</div>
		    </div>
		</div>
	</body>
</html>
