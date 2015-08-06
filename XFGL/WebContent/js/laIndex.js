/**
 * 
 */
$(document).ready(function(){

	$.get("../la/overview", function(data) {
		$("#rightContent").html(data);
	});

	$("#leftMenu ul li").click(function() 
	{
		$(this).addClass('active').siblings().removeClass('active');
		var target = $(this).find('a').attr('name'); //找到链接a中的target的值
		$.get(target, function(data) {
			$("#rightContent").html(data);
		});
	});
});