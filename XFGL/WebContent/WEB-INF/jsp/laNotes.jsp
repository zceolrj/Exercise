<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.min.css">

<link rel="stylesheet" type="text/css" href="../css/laNotes.css">

<script type="text/javascript" src="../js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="../js/laNotes.js"></script>

<title>La Notes</title>
</head>
<body>
    <jsp:include page="laHeader.jsp" />
    
    <div id="noticeNavigation">
		<img src="../images/note.gif" id="navigationImg" style="float: left" /> 
		<div id="navigationContent">
		    <font size="4px"><b>请仔细阅读以下预立案须知</b></font>
		</div>
	</div>
	
	<div id="laNotesGap"></div>
    
    <div id="laNotesBody">
	  <a class="btnLeft" id="btnLeft" href="javascript:void(0);"></a>
	  <a class="btnRight" id="btnRight" href="javascript:void(0);"></a>
	  <div class="box">
		<!-- <img style="opacity:1;filter:alpha(opacity=100);" src="../images/laNotes1.jpg" />
		<img src="../images/laNotes2.jpg" /> 
		<img src="../images/laNotes3.jpg" /> -->
		
		<!-- notes begin -->
		<div id="mssajla" style="float:left;height:330px;" class="content">
          <div id="mssajla_content">
            <div id="mssajla_title">
                <h2>民商事案件立案须知</h2>
            </div>
            <div id="mssajla_list">
                <c:forEach items="${mssajList }" var="mssaj">
                  <p>${mssaj }</p>
                </c:forEach>
            </div>
          </div>
        </div>
        
        <div id="xzspla" class="content" style="float:left;height:330px;">
          <div id="xzspla_content">
            <div id="xzspla_title">
                <h2>行政审判立案须知</h2>
            </div>
            <div id="xzspla_list">
                <c:forEach items="${xzspList }" var="xzsp">
                  <p>${xzsp }</p>
                </c:forEach>
            </div>
          </div>
        </div>
        
        <div id="zxajla" class="content" style="float:left;height:330px;">
          <div id="zxajla_content">
            <div id="zxajla_title">
                <h2>执行案件立案须知</h2>
            </div>
            <div id="zxajla_list">
                <c:forEach items="${zxajList }" var="zxaj">
                  <p>${zxaj }</p>
                </c:forEach>
            </div>
          </div>
        </div>
      </div>
      
      <!-- notes end -->
	  <!-- <div class="page" id="page" >
		<a class="active" href="javascript:void(0);">1</a>
		<a href="javascript:void(0);">2</a> 
		<a href="javascript:void(0);">3</a>
	  </div> -->
    </div>
    
    <br />
	<div id="laNotes_button">
		<button id="confirm" type="button" class="btn btn-lg">确定</button>
	</div>
    
    <jsp:include page="laFooter.jsp" />
</body>
</html>