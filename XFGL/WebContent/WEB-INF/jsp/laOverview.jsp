<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="../js/laOverview.js"></script>

<title>Overview</title>
</head>
<body>
  
    <!-- <div id="laOverviewTitle">
        <h2>网上预立案</h2>
    </div> -->
    <div id="laOverviewBody">
      <div id="overviewContent">
        <font size="">网上预立案</font>
        
        <c:forEach items="${noticeList }" var="notice">
          <div style="text-align:left;">
            <font size="3px">${notice }</font>
          </div>
        </c:forEach>
        
        <div id="laOverviewButton">
          <button id="laConfirm" type="button" class="btn btn-lg">立案</button>
        </div>
      </div>
    </div>
    
    <!-- <div id="laOverviewContent">
        
    </div>
    <div id="laOverviewButton">
        <button id="laConfirm" type="button" class="btn btn-lg">立案</button>
    </div> -->
  
</body>
</html>