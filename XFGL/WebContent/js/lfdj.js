/**
 * 网上信访页面的js校验
 */


var validAttachment = true;//校验附件是否上传正确

function changeCode(src)
{
	//alert(src);
	$('#kaptchaImage').hide().attr('src', '../kaptcha/image?src='+src).fadeIn();
	$("#validateKaptcha").text("*").css({"color":"red"});
	event.cancelBubble = true;
};

function uploadAttach(){
	$.ajaxFileUpload({
		url:'../upload/attachment',
		secureuri:false,
		fileElementId:'attachment',
		dataType:"json",
		success:function(data, status)
		{
			var result = data.uploadResult;
			var filename = data.originalFilename;
			//var wholePath = data.serverWholePath;
			if(result=="success"){
				$("#uploadAttachment").val(filename);
				//$("#wholePath").val(wholePath);
				$("#uploadedAttachment").css({"display":"block"});
				
				$("#validateAttachment").empty();
			    $("#validateAttachment").append('<img src="../images/valid.png" />');
			    $("#deleteAttachment").css({"display":"block"});
				validAttachment = true;
			}
			else if(result=="fail"){
				//$("#uploadedAttachment").text("上传失败").css({"color":"red"});
				$("#validateAttachment").text("上传失败").css({"color":"red"});
				validAttachment = false;
			}
			else if(result=="errorFormat"){
				//$("#uploadedAttachment").text("文件格式错误").css({"color":"red"});
				$("#validateAttachment").text("文件格式错误").css({"color":"red"});
				validAttachment = false;
			}
		},
		error:function(data, e){
			alert("error");
		}
	});
}

function deleteAttachment(){
	$.ajax
	({
		type: 'post',
		url:'../upload/deleteFile',
		processData:true, 
		dataType:"json", //json--返回json数据类型     xml--返回xml
		data:
		{
			src:"LFDJ"
		},
		success:function(data)
		{
			$("#uploadAttachment").val("");
			$("#validateAttachment").empty();
			$("#deleteAttachment").css({"display":"none"});
		},
		error:function(e)
		{
		}
	});
}

$(function(){
	var validUser=false;
	var validPwd=false;
	var validConfirmPwd=false;
	var validAddress=false;
	var validPostcode=false;
	var validTel=false;
	var validMobilephone=false;
	var validRelationship=false;
	var validEmail=false;
	var validIdentity=true;//这里设为true，因为默认选中了一个值
	var validCase=false;
	var validOtherInfo=true;//其它信息可以不填的，故初始化为true，如果超过2000字则设为false
	var validKaptcha=false;
	
	
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
	
	$("#confirmPassword").blur(function(){//确认密码
		var pwd = $("#password").val();
		if($(this).val()!=pwd)
		{
			$("#validateConfirmPwd").text("两次输入的密码不一致").css({"color":"red"});
			validConfirmPwd=false;
		}
		else
		{
			$("#validateConfirmPwd").empty();
		    $("#validateConfirmPwd").append('<img src="../images/valid.png" />');
			validConfirmPwd=true;
		}
	});
	
	$("#address").blur(function(){//信访人地址
		var address = $(this).val();
		if(!address)
		{
		    $("#validateAddress").text("请输入地址").css({"color":"red"});
		    validAddress=false;
		}
		else
		{
			$("#validateAddress").empty();
		    $("#validateAddress").append('<img src="../images/valid.png" />');
		    validAddress=true;
		}
	});
	
	$("#postcode").blur(function(){//校验邮政编码
	    var postcode = $(this).val();
		if(!postcode)
		{
		    $("#validatePostcode").text("请输入邮政编码").css({"color":"red"});
		    validPostcode=false;
		}
		else if(postcode.length!=6 || !isNum(postcode)){//长度必须为6位，且由数字组成
			$("#validatePostcode").text("请输入6位邮政编码，由数字组成").css({"color":"red"});
			validPostcode=false;
		}
		else{
			$("#validatePostcode").empty();
		    $("#validatePostcode").append('<img src="../images/valid.png" />');
			validPostcode=true;
		}
	});
	
    $("#tel").blur(function(){//信访人电话
    	var tel = $(this).val();
        if(!tel){
        	$("#validateTel").text("请输入电话号码").css({"color":"red"});
        	validTel=false;
        }
        else if(!isTel(tel))
		{
		    $("#validateTel").text("电话号码不符合规范").css({"color":"red"});
		    validTel=false;
		}
		else{
			$("#validateTel").empty();
		    $("#validateTel").append('<img src="../images/valid.png" />');
			validTel=true;
		}
	});
    
    $("#mobilephone").blur(function(){//信访人手机
    	var mobilephone = $(this).val();
        if(!mobilephone){
        	$("#validateMobilephone").text("请输入手机号码").css({"color":"red"});
        	validMobilephone=false;
        }
        else if(mobilephone.length!=11 || !isNum(mobilephone))
		{
		    $("#validateMobilephone").text("手机号码不符合规范，应由11位数字组成").css({"color":"red"});
		    validMobilephone=false;
		}
		else{
			$("#validateMobilephone").empty();
		    $("#validateMobilephone").append('<img src="../images/valid.png" />');
			validMobilephone=true;
		}
	});
	
    $("#relationship").blur(function(){//您所反映的情况与您的关系
    	var relationship = $(this).val();
    	if(!relationship)
		{
		    $("#validateRelationship").text("请输入关系").css({"color":"red"});
		    validRelationship=false;
		}
		else{
			$("#validateRelationship").empty();
		    $("#validateRelationship").append('<img src="../images/valid.png" />');
			validRelationship=true;
		}
    });

    $("#email").blur(function(){//信访人电子邮件
    	var email = $(this).val();
        if(!email){
        	$("#validateEmail").text("请输入电子邮箱").css({"color":"red"});
        	validEmail=false;
        }
    	if(email.search(/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/)==-1)
		{
		    $("#validateEmail").text("请输入正确的邮箱").css({"color":"red"});
		    validEmail=false;
		}
		else{
			$("#validateEmail").empty();
		    $("#validateEmail").append('<img src="../images/valid.png" />');
			validEmail=true;
		}
    });
    
    $("#identity").click(function()//信访人身份
    {
    	$("#validateIdentity").empty();
	    $("#validateIdentity").append('<img src="../images/valid.png" />');
		validIdentity=true;
	});
	
    $("#case").keyup(function(){//反映情况
    	var cases = $(this).val();
    	var length = getStrLength(cases);
    	if(!cases)
		{
		    $("#validateCase").text("请输入案例").css({"color":"red"});
		    validCase=false;
		}
    	else if(length>2000){
    		$("#validateCase").text("您输入的内容超过了2000个字符").css({"color":"red"});
    		validCase=false;
    	}
		else{
			var info = length + "/" + 2000;
			$("#validateCase").text(info).css({"color":"green"});
			validCase=true;
		}
    });

    $("#otherInfo").keyup(function(){//其它信息
    	var otherInfo = $(this).val();
    	var length = getStrLength(otherInfo);
    	if(!otherInfo){
    		$("#validateOtherInfo").text("");
    		validOtherInfo = true;
    	}
    	if(length>2000){
    		$("#validateOtherInfo").text("您输入的内容超过了2000个字符").css({"color":"red"});
    		validOtherInfo = false;
    	}
		else{
			var info = length + "/" + 2000;
			$("#validateOtherInfo").text(info).css({"color":"green"});
			validOtherInfo=true;
		}
    });
    
    
    $("#kaptcha").keyup(function(){
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
    				src:"lfdj"
    			},
    			success:function(data)
    			{
    				if(data.result=="right"){
    					$("#validateKaptcha").empty();
    				    $("#validateKaptcha").append('<img src="../images/valid.png" />');
    					validKaptcha = true;
    				}
    				else if(data.result=="wrong"){
    					$("#validateKaptcha").text("验证码错误").css({"color":"red"});
    					validKaptcha = false;
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
	
	$("#submit").click(function(){
		//这些事件是为了处理浏览器点击后退按钮后的情况
		$("#username").blur();
		$("#password").blur();
		$("#confirmPassword").blur();
		$("#address").blur();
		$("#postcode").blur();
		$("#tel").blur();
		$("#mobilephone").blur();
		$("#relationship").blur();
		$("#email").blur();
		$("#identity").click();
		$("#case").keyup();
		$("#otherInfo").keyup();
		$("#kaptcha").keyup();
		
		if(validUser && validPwd && validConfirmPwd && validAddress && validPostcode 
				&& validTel && validMobilephone && validRelationship && validEmail 
				&& validIdentity && validCase && validOtherInfo && validAttachment && validKaptcha)
		{
			$('form').submit();
		}
		else{
			$("#validateAll").text("*为必填项，请完善后再提交").css({"color":"red"});
			return false;
		}
	});
	
	$("#reset").click(function(){
		$('form').reset();
		
		validUser=false;
		validPwd=false;
		validConfirmPwd=false;
		validAddress=false;
		validPostcode=false;
		validTel=false;
		validMobilephone=false;
		validRelationship=false;
		validEmail=false;
		validIdentity=false;
		validCase=false;
		validOtherInfo=false;
		validKaptcha=false;
		
		$("#validateUser").text("*").css({"color":"red"});
		$("#validatePwd").text("*").css({"color":"red"});
		$("#validateConfirmPwd").text("*").css({"color":"red"});
		$("#validateAddress").text("*").css({"color":"red"});
		$("#validatePostcode").text("*").css({"color":"red"});
		$("#validateTel").text("*").css({"color":"red"});
		$("#validateMobilephone").text("*").css({"color":"red"});
		$("#validateRelationship").text("*").css({"color":"red"});
		$("#validateEmail").text("*").css({"color":"red"});
		$("#validateIdentity").text("*").css({"color":"red"});
		$("#validateCase").text("*").css({"color":"red"});
		$("#validateKaptcha").text("*").css({"color":"red"});
	});
	
	//changeCode();
});