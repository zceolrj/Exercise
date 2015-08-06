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

<link rel="stylesheet" type="text/css" href="../css/laSearch.css">

<script type="text/javascript" src="../js/jquery-2.1.0.min.js"></script>

<script type="text/javascript" src="../js/laSearch.js"></script>

<title>预立案查询</title>
</head>
<body>
  <div id="laSearchBody">
    <form action="../la/ylacx" method="post" class="form-horizontal">
        <div class="form-group">
		  <h2 align="center">预立案查询</h2>
		</div>
        
        <div class="form-group">
			<label class="col-sm-3 control-label">立案查询编号</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="cxbh" name="cxbh">
			</div>
			<div id="validateCxbh" class="col-sm-3 validateTop">
				<font color="red">*</font>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label">查询密码</label>
			<div class="col-sm-6">
				<input type="password" class="form-control" id="cxmm" name="cxmm">
			</div>
			<div id="validateCxmm" class="col-sm-3 validateTop">
				<font color="red">*</font>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label">验证码</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="ylacxyzm" name="ylacxyzm" />
			</div>
			<div id="validateYlacxyzm" class="col-sm-1 validateTop">
				<font color="red">*</font>
			</div>
			<div class="col-sm-4 yzmPicContent">
				<img src="../kaptcha/image?src=lacx" id="kaptchaImage" />
				<a href="javascript:void(0)" onclick="changeCode('lacx')">看不清楚，换一张</a>
			</div>
		</div>
		
		<div class="form-group" id="validateDiv">
		    <div class="col-sm-3"></div>
		    <div class="col-sm-6" id="validateAll"></div>
		    <div class="col-sm-3"></div>
		</div>
		
		<div class="form-group" id="ylacxButton">
			<div class="col-sm-offset-2 col-sm-8" align="center">
				<button type="submit" class="btn btn-lg" id="ylacxSubmit">提交</button>
			</div>
		</div>
    </form>
  </div>
</body>
</html>