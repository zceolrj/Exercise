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

<link rel="stylesheet" type="text/css" href="../css/jquery.datetimepicker.css"/>

<link rel="stylesheet" type="text/css" href="../css/laApply.css">

<script type="text/javascript" src="../js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
<script type="text/javascript" src="../js/laApply.js"></script>

<title>在线预立案申请</title>
</head>
<body>
    <jsp:include page="lfHeader.jsp" />
    
    <div id="laApply_body">
      <form action="../la/apply" method="post" class="form-horizontal" enctype="multipart/form-data">
        <div id="laApply_title">
          <h2>在线预立案申请</h2>
        </div>
        
        <div id="dsrzl">
          <h2>当事人资料</h2>
          <div id="yg_title">
              <h3>诉讼主体：原告/上诉人</h3>
          </div>
          <div id="tjyg">
              <button id="tjygzrr" type="button" class="btn btn-primary btn-sm">添加原告自然人</button>
              &nbsp;&nbsp;&nbsp;
              <button id="tjygfr" type="button" class="btn btn-primary btn-sm">添加原告法人</button>
              &nbsp;&nbsp;&nbsp;
              <button id="tjygffrqtzz" type=button class="btn btn-primary btn-sm">添加原告非法人其它组织</button>
          </div>
          <div id="ygzrrInfo" style="text-align: center"></div>
          <div id="ygfrInfo"></div>
          <div id="ygffrqtzzInfo"></div>
          
          <div id="bg_title">
              <h3>诉讼主体：被告/被上诉人</h3>
          </div>
          <div id="tjbg">
              <button id="tjbgzrr" type="button" class="btn btn-primary btn-sm">添加被告自然人</button>
              &nbsp;&nbsp;&nbsp;
              <button id="tjbgfr" type="button" class="btn btn-primary btn-sm">添加被告法人</button>
              &nbsp;&nbsp;&nbsp;
              <button id="tjbgffrqtzz" type=button class="btn btn-primary btn-sm">添加被告非法人其它组织</button>
          </div>
          <div id="bgzzrInfo"></div>
          <div id="bgfrInfo"></div>
          <div id="bgffrqtzzInfo"></div>
          
          <br />
          
          <div id="ayANDcl">
            <div id="ay">
              <h3>案由</h3>
              <select class="" name="ay1" id="ay1">
				<option selected>人格权纠纷</option>
				<option>继承纠纷</option>
				<option>物权纠纷</option>
			  </select>
			  <h3>↓</h3>
			  <select class="" name="ay2" id="ay2">
				<option selected>人格权纠纷</option>
				<option>继承纠纷</option>
				<option>物权纠纷</option>
			  </select>
			  <h3>↓</h3>
			  <select class="" name="ay3" id="ay3">
				<option selected>人格权纠纷</option>
				<option>继承纠纷</option>
				<option>物权纠纷</option>
			  </select>
            </div>
            <div id="clsc">
              <h3>材料上传</h3>
              <h4 align="left">材料说明：上传文件，每个文件大小不能超过20M</h4>
              <div class="">
			    <div class="">
				  <input type="file" class="" id="material" name="material" style="display:none" />
			      <input type="button" id="uploadMaterial" class="" onclick="material.click()" value="添加 " />
			    </div>
			    <div class="">    
			      <div class="" id="uploadedMaterial">
                    <label class="" id="uploadedFilename"></label>
                    &nbsp;
                    <a href="javascript:void(0)" id="deleteFile" class=""><font color="red">X</font></a>
                    <input type="text" id="wholePath" value="originalPath" style="display:none" />
			      </div>
			    </div>
			    <div id="validateAttachment" class="col-sm-3">
			    </div>
		      </div>
            </div>
          </div>
          
          <div id="ssbdbe" class="form-group">
            <label for="inputOtherInfo" class="col-sm-4 control-label">诉讼标的总额</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="email" name="email">
			</div>
			<div id="validateOtherInfo" class="col-sm-4">
			</div>
          </div>
          
          <div id="hint" class="form-group">
            <p>温情提示：请输入准确的材料，提交相关信息、相关证据。带“*”的为必须填写的信息。提交成功后，系统会给您返回“立案编号”，请您一定要记住“立案编号”与您输入的“立案查询密码”，以便查询立案的状态。</p>
          </div>
          
          <div id="lacx">
            <div class="form-group">
              <label for="inputOtherInfo" class="col-sm-4 control-label">立案查询密码</label>
			  <div class="col-sm-4">
				<input type="text" class="form-control" id="email" name="email">
			  </div>
			  <div id="validateOtherInfo" class="col-sm-4">
			  </div>
            </div>
            
            <div class="form-group">
              <label for="inputOtherInfo" class="col-sm-4 control-label">再次确认密码</label>
			  <div class="col-sm-4">
				<input type="text" class="form-control" id="email" name="email">
			  </div>
			  <div id="validateOtherInfo" class="col-sm-4">
			  </div>
			</div>
			
			<div class="form-group">
              <label for="inputOtherInfo" class="col-sm-4 control-label">联系电子邮件</label>
			  <div class="col-sm-4">
				<input type="text" class="form-control" id="email" name="email">
			  </div>
			  <div id="validateOtherInfo" class="col-sm-4">
			  </div>
			</div>
			
			<div class="form-group">
              <label for="inputOtherInfo" class="col-sm-4 control-label">联系电话</label>
			  <div class="col-sm-4">
				<input type="text" class="form-control" id="email" name="email">
			  </div>
			  <div id="validateOtherInfo" class="col-sm-4">
			  </div>
			</div>
			
			<div class="form-group">
			  <label for="inputKaptcha" class="col-sm-4 control-label">验证码</label>
			  <div class="col-sm-4">
				<input type="text" class="form-control" id="kaptcha" name="kaptcha" />
			  </div>
			  <div id="validateKaptcha" class="col-sm-1">
				<font color="red">*</font>
			  </div>
			  <div class="col-sm-3">
				<img src="../kaptcha/image" id="kaptchaImage" />
				<a href="javascript:void(0)" onclick="changeCode()">看不清楚，换一张</a>
			  </div>
		    </div>
          </div>
          
          <br />
          <br />
          
          <div id="finalApply">
            <button type="submit" class="btn btn-primary">提交立案申请</button>
          </div>
        </div>
        
        <div id="ygzrr">
          <div id="closeYgzrr" style="text-align: right">
            <span id="ygzrr_span" style="cursor:pointer">关闭&nbsp;</span>
          </div>
          <div class="">
		    <h3>&nbsp;自然人</h3>
		  </div>
		
		  <div class="form-group">
			<label class="col-sm-3 control-label">姓名</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="ygzrrxm" name="ygzrrxm">
			</div>
			<div id="validateYgzrrxm" class="col-sm-3">
				<font color="red">*</font>
			</div>
		  </div>
		  
		  <div class="form-group">
			<label class="col-sm-3 control-label">身份证</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="ygzrrsfz" name="ygzrrsfz">
			</div>
			<div id="validateYgzrrsfz" class="col-sm-3">
				<font color="red">*</font>
			</div>
		  </div>
		  
		  <div class="form-group">
			<label class="col-sm-3 control-label">出生日期</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="ygzrrcsrq" name="ygzrrcsrq">
			</div>
			<div id="validateYgzrrcsrq" class="col-sm-3">
				<font color="red">*</font>
			</div>
		  </div>
		  
		  <div class="form-group">
			<label class="col-sm-3 control-label">国籍</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="ygzrrgj" name="ygzrrgj">
			</div>
			<div id="validateYgzrrgj" class="col-sm-3">
				<font color="red">*</font>
			</div>
		  </div> 
		  
		  <div class="form-group">
			<label class="col-sm-3 control-label">民族</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="ygzrrmz" name="ygzrrmz">
			</div>
			<div id="validateYgzrrmz" class="col-sm-3">
				<font color="red">*</font>
			</div>
		  </div> 
		  
		  <div class="form-group">
			<label class="col-sm-3 control-label">政治面貌</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="ygzrrzzmm" name="ygzrrzzmm">
			</div>
			<div id="validateYgzrrzzmm" class="col-sm-3">
				<font color="red">*</font>
			</div>
		  </div>
		  
		  <div class="form-group">
			<label class="col-sm-3 control-label">文化程度</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="ygzrrwhcd" name="ygzrrwhcd">
			</div>
			<div id="validateYgzrrwhcd" class="col-sm-3">
				<font color="red">*</font>
			</div>
		  </div>
		  
		  <div class="form-group">
			<label class="col-sm-3 control-label">联系电话</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="ygzrrlxdh" name="ygzrrlxdh">
			</div>
			<div id="validateYgzrrlxdh" class="col-sm-3">
				<font color="red">*</font>
			</div>
		  </div>
		  
		  <div class="form-group">
			<label class="col-sm-3 control-label">邮政编码</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="ygzrryzbm" name="ygzrryzbm">
			</div>
			<div id="validateYgzrryzbm" class="col-sm-3">
				<font color="red">*</font>
			</div>
		  </div>
		  
		  <div class="form-group">
			<label class="col-sm-3 control-label">住址</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="ygzrrzz" name="ygzrrzz">
			</div>
			<div id="validateYgzrrzz" class="col-sm-3">
				<font color="red">*</font>
			</div>
		  </div>
		  
		  <div class="form-group">
			<div class="col-sm-offset-2 col-sm-7" align="center">
				<button type="button" class="btn btn-primary" id="ygzrrsubmit">提交</button>
			</div>
		  </div>
        </div>
    
        <div id="ygfr">
            <div id="closeYgfr" style="text-align: right">
                <span id="ygfr_span" style="cursor:pointer">关闭&nbsp;</span>
            </div>
            <div class="">
		        <h3>&nbsp;法人</h3>
		    </div>
		    <div class="form-group">
			    <label class="col-sm-3 control-label">名称</label>
			    <div class="col-sm-6">
				    <input type="text" class="form-control" id="ygfrmc" name="ygfrmc">
			    </div>
			    <div id="validateYgfrmc" class="col-sm-3">
				    <font color="red">*</font>
			    </div>
		    </div>
		    <div class="form-group">
			    <label for="inputFzrDbr" class="col-sm-3 control-label">单位负责人或法定代表人姓名</label>
			    <div class="col-sm-6">
				    <input type="text" class="form-control" id="ygfrxm" name="ygfrxm">
			    </div>
			    <div id="validateYgfrxm" class="col-sm-3">
				    <font color="red">*</font>
			    </div>
		    </div>
		    <div class="form-group">
			    <label class="col-sm-3 control-label">联系电话</label>
			    <div class="col-sm-6">
				    <input type="text" class="form-control" id="ygfrlxdh" name="ygfrlxdh">
			    </div>
			    <div id="validateYgfrlxdh" class="col-sm-3">
				    <font color="red">*</font>
			    </div>
		    </div>
		    <div class="form-group">
			    <label class="col-sm-3 control-label">邮政编码</label>
			    <div class="col-sm-6">
				    <input type="text" class="form-control" id="ygfryzbm" name="ygfryzbm">
			    </div>
			    <div id="validateUser" class="col-sm-3">
				    <font color="red">*</font>
			    </div>
		    </div>
		    <div class="form-group">
			    <label class="col-sm-3 control-label">住址</label>
			    <div class="col-sm-6">
				    <input type="text" class="form-control" id="ygfrzz" name="ygfrzz">
			    </div>
			    <div id="validateYgfrzz" class="col-sm-3">
				    <font color="red">*</font>
			    </div>
		    </div>
		    <div class="form-group">
			  <div class="col-sm-offset-2 col-sm-7" align="center">
				<button type="button" class="btn btn-primary" id="ygfrsubmit">提交</button>
			  </div>
		    </div>
        </div>
    
        <div id="ygffrqtzz">
            <div id="closeYgffrqtzz" style="text-align: right">
                <span id="ygffrqtzz_span" style="cursor:pointer">关闭&nbsp;</span>
            </div>
            <div class="">
		        <h3>&nbsp;非法人其它组织</h3>
		    </div>
		    <div class="form-group">
			    <label class="col-sm-3 control-label">名称</label>
			    <div class="col-sm-6">
				    <input type="text" class="form-control" id="ygffrqtzzmc" name="ygffrqtzzmc">
			    </div>
			    <div id="validateYgffrqtzzmc" class="col-sm-3">
				    <font color="red">*</font>
			    </div>
		    </div>
		    <div class="form-group">
			    <label class="col-sm-3 control-label">单位负责人或法定代表人姓名</label>
			    <div class="col-sm-6">
				    <input type="text" class="form-control" id="ygffrqtzzxm" name="ygffrqtzzxm">
			    </div>
			    <div id="validateYgffrqtzzxm" class="col-sm-3">
				    <font color="red">*</font>
			    </div>
		    </div>
		    <div class="form-group">
			    <label class="col-sm-3 control-label">联系电话</label>
			    <div class="col-sm-6">
				    <input type="text" class="form-control" id="ygffrqtzzlxdh" name="ygffrqtzzlxdh">
			    </div>
			    <div id="validateYgffrqtzzlxdh" class="col-sm-3">
				    <font color="red">*</font>
			    </div>
		    </div>
		    <div class="form-group">
			    <label class="col-sm-3 control-label">邮政编码</label>
			    <div class="col-sm-6">
				    <input type="text" class="form-control" id="ygffrqtzzyzbm" name="ygffrqtzzyzbm">
			    </div>
			    <div id="validateYgffrqtzzyzbm" class="col-sm-3">
				    <font color="red">*</font>
			    </div>
		    </div>
		    <div class="form-group">
			    <label class="col-sm-3 control-label">住址</label>
			    <div class="col-sm-6">
				    <input type="text" class="form-control" id="ygffrqtzzzz" name="ygffrqtzzzz">
			    </div>
			    <div id="validateYgffrqtzzzz" class="col-sm-3">
				    <font color="red">*</font>
			    </div>
		    </div>
		    <div class="form-group">
			  <div class="col-sm-offset-2 col-sm-7" align="center">
				<button type="button" class="btn btn-primary" id="ygffrqtzzsubmit">提交</button>
			  </div>
		    </div>
        </div>
      </form>
    </div>
    
    
    
    <jsp:include page="lfFooter.jsp" />
</body>
</html>