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

<link rel="stylesheet" type="text/css" href="../css/laCxjg.css">

<title>立案查询结果</title>
</head>
<body>
    <jsp:include page="laHeader.jsp" />
    
    <div id="cxjgBody">
      <div id="bs-example">
        <div class="title">
          <font size="5px">预立案查询结果</font>
        </div>
        <table class="table table-bordered">
          <tbody>
            <tr>
              <td class="leftTD"><strong>预立案编号</strong></td>
              <td class="rightTD"><div class="rightContent">${lasq.cxbh }</div></td>
            </tr>
            <tr>
              <td class="leftTD"><strong>申请时间</strong></td>
              <td class="rightTD"><div class="rightContent">${sqrq }</div></td>
            </tr>
            <tr>
              <td class="leftTD"><strong>审核状态</strong></td>
              <td class="rightTD"><div class="rightContent"><font color="red">${shzt }</font></div></td>
            </tr>
            <tr>
              <td class="leftTD"><strong>回复内容</strong></td>
              <td class="rightTD"><div class="rightContent"></div></td>
            </tr>
          </tbody>
        </table>
      </div>
      
      <div id="bs-example">
        <div class="title">
          <font size="5px">预立案详情</font>
        </div>
        <table class="table table-bordered">
          <tbody>
            <tr>
              <td class="quarterTD"><strong>电子邮箱</strong></td>
              <td><div class="rightContent">${lasq.dzyj }</div></td>
              <td class="quarterTD"><strong>联系电话</strong></td>
              <td><div class="rightContent">${lasq.lxdh }</div></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    
    <jsp:include page="laFooter.jsp" />
</body>
</html>