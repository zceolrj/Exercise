<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.min.css">

<link rel="stylesheet" type="text/css" href="../css/lfztcxjg.css">

<script type="text/javascript" src="../js/jquery-2.1.0.min.js"></script>


<title>来访查询结果</title>
</head>
<body>
  <jsp:include page="lfHeader.jsp" />
  
  <div id="bodyHeight">
    <h2 id="result" align="center">${state }</h2>
    <div id="symbol" style="display:none">${symbol }</div>
    <div id="stateSearch" style="display:none">
      <form action="../lfdj/stateSearch" method="post" class="form-horizontal" id="searchForm">
        <div class="form-group">
		  <h3 align="center">信访结果查询</h3>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">来访查询编号</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="lfcxbh" name="lfcxbh">
			</div>
			<div id="validateLfcxbh" class="col-sm-4 validateTop">
				<font color="red">*</font>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputPassword" class="col-sm-4 control-label">结果查询密码</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" id="password" name="password">
			</div>
			<div id="validatePwd" class="col-sm-4 validateTop">
				<font color="red">*</font>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-4"></div>
			<div id="validateAll" class="col-sm-4">
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-8" align="center">
				<button type="submit" class="btn btn-primary" id="submit">提交</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="reset" class="btn btn-primary" id="reset">重置</button>
			</div>
		</div>
      </form>
    </div>
  </div>
  
  <jsp:include page="lfFooter.jsp" />
</body>
<script type="text/javascript">
$(document).ready(function() {
	var symbol = String("${symbol}");
	
	if(symbol==-1){
		$("#bodyHeight").css({"padding-top":"5px"});
		$("#stateSearch").css({"display":"block"});
		$("#validateAll").text("信访人姓名或结果查询密码错误").css({"color":"red"});
	};
});

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
</script>
</html>