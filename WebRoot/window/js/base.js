$(document).ready(function() {
	/*仿写下拉菜单*/
	$(".select_box").click(function(event) {
		event.stopPropagation();
		$(this).find(".option").toggle();
		$(this).parent().siblings().find(".option").hide();
	});
	$(document).click(function(event) {
		var eo = $(event.target);
		if ($(".select_box").is(":visible") && eo.attr("class") != "option" && !eo.parent(".option").length)
			$('.option').hide();
	});
	/*赋值给文本框*/
	$(".option a").click(function() {
		var value = $(this).text();
		$(this).parent().siblings(".select_txt").text(value);
		$("#select_value").val(value)
	});

	/*iframe窗口高度*/
	$(window).resize(function() {
		oH = $(".main").height()
		$("iframe").height(oH);
	});
	var oH = $(".main").height();
	$("iframe").height(oH);
	/*建设情况*/
	$(".jsqk .nav ul li a").each(function(index) {
		$(this).click(function() {
			$(".jsqk .nav ul li a").removeClass("cur");
			$(this).addClass("cur");
			$(".jsqk .jsqk-con").hide();
			$(".jsqk .jsqk-con").eq(index).show();
		});
	});

});