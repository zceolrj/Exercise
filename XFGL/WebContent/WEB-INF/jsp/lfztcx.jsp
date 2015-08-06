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

<link rel="stylesheet" type="text/css" href="../css/lfztcx.css">

<script type="text/javascript" src="../js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="../js/lfztcx.js"></script>

<title>来访状态查询</title>
</head>
<body>
    <jsp:include page="lfHeader.jsp" />
    
    <div id="bodyHeight">
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
			<label class="col-sm-4 control-label">结果查询密码</label>
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
		
		<div id="gap"></div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-8" align="center">
				<button type="submit" class="btn btn-primary" id="submit">提交</button>
				&nbsp;&nbsp;&nbsp;
				<button type="reset" class="btn btn-primary" id="reset">重置</button>
			</div>
		</div>
      </form>
    </div>
    
    <jsp:include page="lfFooter.jsp" />
</body>

</html>