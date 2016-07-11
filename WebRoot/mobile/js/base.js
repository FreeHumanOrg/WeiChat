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
    
    /*首页菜单弹出层*/
    $(".zk-icon").click(function(){
    	$(".leftPanel").show(500);
    });

    $(".leftPanel a").click(function(){
    	$(".leftPanel").hide();
    });
	/*建设情况*/
	$(".nav_a").each(function(index) {
		$(this).click(function() {
			$(".nav_a").removeClass("cur");
			$(this).addClass("cur");
			$(".main .jsqk-con").hide();
    	    $(".main .jsqk-con").eq(index).show();
		});
	});

});