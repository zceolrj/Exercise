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

<link rel="stylesheet" type="text/css" href="../css/laCxFail.css">

<script type="text/javascript" src="../js/jquery-2.1.0.min.js"></script>

<title>预立案查询失败</title>
</head>
<body>
    <jsp:include page="laHeader.jsp" />
    
    <div id="cxfailNavigation">
        <!-- <img src="" /> -->
        <font size="4px"><b></b></font>
    </div>
    
    <div id="cxfailBody">
        <div id="rederror">
            <img src="../images/rederror.jpg" />
        </div>
        <div id="cxfailContent">
            <font size="3px">很抱歉，没有找到您要查询的案号！</font>
            <br />
            <font size="5px">请确认您的查询编号和密码</font>
        </div>
        &nbsp;
    </div>    
    
    <jsp:include page="laFooter.jsp" />
</body>
</html>