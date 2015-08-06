/**
 * 
 */
$(document).ready(function() {
	//var symbol = String("${symbol}");
	var symbol = $("#symbol").val();
	if(symbol==-1){
		$("#stateSearch").css({"display":"block"});
		$("#validateAll").text("信访人姓名或结果查询密码错误").css({"color":"red"});
	};
});

$(function(){
	var validUser=false;
	var validPwd=false;
	
	$("#username").blur(function(){
		var username = $(this).val();
		if(!username)
		{
			$("#validateUser").text("请输入用户名").css({"color":"red"});
			validUser=false;
		}
		else
		{
			$("#validateUser").empty();
		    $("#validateUser").append('<img src="../images/valid.png" />');
		    validUser=true;
		}
	});
	
	$("#password").blur(function(){//校验密码
		var password=$(this).val();
		var charAndDigit = /^[_0-9a-zA-Z]*$/;
		if(!password){
			$("#validatePwd").text("请输入密码").css({"color":"red"});
			validPwd=false;
		}
		else if(password.length<8 || password.length>20 || !charAndDigit.test(password))
		{
		    $("#validatePwd").text("密码不符合规则").css({"color":"red"});
		    validPwd=false;
		}
		else{
			$("#validatePwd").empty();
		    $("#validatePwd").append('<img src="../images/valid.png" />');
			validPwd=true;
		}
	});
	
	$("#submit").click(function(){
		//这些事件是为了处理浏览器点击后退按钮后的情况
		$("#username").blur();
		$("#password").blur();
		
		if(validUser && validPwd ){
			$('form').submit();
		}
		else{
			$("#validateAll").text("*为必填项，请完善后再提交").css({"color":"red"});
			return false;
		}
	});
});