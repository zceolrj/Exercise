/**
 * 
 */
function changeCode(src)
{
	$('#kaptchaImage').hide().attr('src', '../kaptcha/image?src='+src).fadeIn();
	$("#validateKaptcha").text("*").css({"color":"red"});
	event.cancelBubble = true;
};

$(function(){
	var validcxbh=false;
	var validcxmm=false;
	var validylacxyzm=false;
	
	$("#cxbh").blur(function(){
		var cxbh = $(this).val();
		if(!cxbh)
		{
			$("#validateCxbh").text("请输入查询编号").css({"color":"red"});
			validcxbh=false;
		}
		else
		{
			$("#validateCxbh").empty();
		    $("#validateCxbh").append('<img src="../images/valid.png" />');
		    validcxbh=true;
		}
	});
	
	$("#cxmm").blur(function(){
		var cxmm = $(this).val();
		if(!cxmm)
		{
			$("#validateCxmm").text("请输入查询密码").css({"color":"red"});
			validcxmm=false;
		}
		else
		{
			$("#validateCxmm").empty();
		    $("#validateCxmm").append('<img src="../images/valid.png" />');
		    validcxmm=true;
		}
	});
	
	$("#ylacxyzm").keyup(function(){
    	var code = $(this).val();
    	if(code.length==4){
    		jQuery.ajax
    		({
    			type: 'GET',
    			url:'../kaptcha/verify',
    			contentType:"application/json", //application/xml
    			processData:true, 
    			dataType:"json", //json--返回json数据类型     xml--返回xml
    			data:
    			{
    				code:code,
    				src:"lacx"
    			},
    			success:function(data)
    			{
    				if(data.result=="right"){
    					$("#validateYlacxyzm").empty();
    				    $("#validateYlacxyzm").append('<img src="../images/valid.png" />');
    					validylacxyzm = true;
    				}
    				else if(data.result=="wrong"){
    					$("#validateYlacxyzm").empty();
    					$("#validateYlacxyzm").append('<img src="../images/error.png" />');
    					validylacxyzm = false;
    				}
    			},
    			error:function(e)
    			{
    			}
    		});
    	}
    	/* else{
    		$("#validateKaptcha").text("验证码错误").css({"color":"red"});
    	} */
    });
	
	$("#ylacxSubmit").click(function(){
		//这些事件是为了处理浏览器点击后退按钮后的情况
		$("#cxbh").blur();
		$("#cxmm").blur();
		$("#ylacxyzm").keyup();
		
		if(validcxbh && validcxmm && validylacxyzm)
		{
			$('form').submit();
		}
		else{
			$("#validateAll").text("*为必填项，请完善后再提交").css({"color":"red"});
			return false;
		}
	});
});
