/**
 * 
 */
$(function(){
	var validLfcxbh=false;
	var validPwd=false;
	
	$("#lfcxbh").blur(function(){
		var lfcxbh = $(this).val();
		if(!lfcxbh)
		{
			$("#validateLfcxbh").text("请输入查询编号").css({"color":"red"});
			validLfcxbh=false;
		}
		else
		{
			$("#validateLfcxbh").empty();
		    $("#validateLfcxbh").append('<img src="../images/valid.png" />');
		    validLfcxbh=true;
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
		$("#lfcxbh").blur();
		$("#password").blur();
		
		if(validLfcxbh && validPwd ){
			$('form').submit();
		}
		else{
			$("#validateAll").text("*为必填项，请完善后再提交").css({"color":"red"});
			return false;
		}
	});
	
	$("#reset").click(function(){
		$("#validateLfcxbh").empty();
		$("#validatePwd").empty();
		$("#validateAll").empty();
	});
});