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

<link rel="stylesheet" type="text/css" href="../css/lfdjjg.css">

<script type="text/javascript" src="../js/jquery-2.1.0.min.js"></script>

<title>来访登记结果</title>
</head>
<body>
    <jsp:include page="lfHeader.jsp" />
    
    <div id="lfdjjgBody">
        <div id="greenTick">
            <img src="../images/greentick.jpg" />
        </div>
        
        <div id="lfdjjgContent">
            <font size="3px">恭喜您，资料提交成功！</font>
            <br />
            <font size="5px">请牢记您的查询编号</font>
            <font size="5px">${lfcxbh }</font>
        </div>
        &nbsp;
    </div>
    
    <jsp:include page="lfFooter.jsp" />
</body>
</html>