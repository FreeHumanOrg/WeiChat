$(document).ready(function() {
	/*浠垮啓涓嬫媺鑿滃�*/
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
	/*璧嬪�缁欐枃鏈�*/
	$(".option a").click(function() {
		var value = $(this).text();
		$(this).parent().siblings(".select_txt").text(value);
		$("#select_value").val(value)
	});

	/*宸﹁竟鑿滃崟鏍忓睍寮�寜閽�*/
    $(".zk-icon").click(function(){
    	$(".leftPanel").show(500);
    });
    $(".leftPanel a").click(function(){
    	$(".leftPanel").hide();
    });
	/*寤鸿鎯呭喌*/
    $(".main .nav ul li a").each(function(index){
    	$(this).click(function(){
    		$(".main .nav ul li a").removeClass("cur");
    	    $(this).addClass("cur");
    	    $(".main .jsqk-con").hide();
    	    $(".main .jsqk-con").eq(index).show();
    	});
    });

});
