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

<link rel="stylesheet" type="text/css" href="../css/lfdj.css">

<script type="text/javascript" src="../js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.json-2.4.js"></script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
<script type="text/javascript" src="../js/util.js"></script>
<script type="text/javascript" src="../js/lfdj.js"></script>

<title>来访登记</title>
</head>
<body>
  <jsp:include page="lfHeader.jsp" />
  
  <div id="body">
    <form action="../lfdj/add" method="post" class="form-horizontal" enctype="multipart/form-data">
		<div class="form-group">
		  <h2 align="center">网上信访</h2>
		  <p align="center">请如实填写以下信访内容</p>
		</div>
		<div class="form-group">
			<label for="inputUsername" class="col-sm-3 control-label">信访人姓名</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="username" name="username">
			</div>
			<div id="validateUser" class="col-sm-3 validateTop">
				<font color="red">*</font>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputPassword" class="col-sm-3 control-label">结果查询密码</label>
			<div class="col-sm-6">
				<input type="password" class="form-control" id="password" name="password">
			</div>
			<div id="validatePwd" class="col-sm-3 validateTop">
				<font color="red">*</font>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
			    <font color="blue">8-20位英文或数字组成，请务必牢记，查询办理结果需此密码</font>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputConfirmPassword" class="col-sm-3 control-label">再次确认密码</label>
			<div class="col-sm-6">
				<input type="password" class="form-control" id="confirmPassword" name="confirmPassword">
			</div>
			<div id="validateConfirmPwd" class="col-sm-3 validateTop">
				<font color="red">*</font>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputAddress" class="col-sm-3 control-label">信访人地址</label>
			<div class="col-sm-6">
			    <input type="text" class="form-control" id="address" name="address">
			</div>
			<div id="validateAddress" class="col-sm-3 validateTop">
				<font color="red">*</font>
			</div>
		</div>
		<div class="form-group">
			<label for="inputPostCode" class="col-sm-3 control-label">信访人邮政编码</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="postcode" name="postcode">
			</div>
			<div id="validatePostcode" class="col-sm-3 validateTop">
				<font color="red">*</font>
			</div>
		</div>
		<div class="form-group">
			<label for="inputTel" class="col-sm-3 control-label">信访人电话</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="tel" name="tel">
			</div>
			<div id="validateTel" class="col-sm-3 validateTop">
				<font color="red">*</font>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
			    <font color="blue">必须输入区号与英文半角-，如：0932-88888888</font>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputMobilePhone" class="col-sm-3 control-label">信访人手机</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="mobilephone" name="mobilephone">
			</div>
			<div id="validateMobilephone" class="col-sm-3 validateTop">
				<font color="red">*</font>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
			    <font color="blue">信访编号或密码找回需要手机号</font>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputRelationship" class="col-sm-3 control-label">您所反映的情况与您的关系是</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="relationship" name="relationship">
			</div>
			<div id="validateRelationship" class="col-sm-3 validateTop">
				<font color="red">*</font>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
			    <font color="blue">如：本人、亲属、律师、单位或其他</font>
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputEmail" class="col-sm-3 control-label">信访人电子邮件</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="email" name="email">
			</div>
			<div id="validateEmail" class="col-sm-3 validateTop">
				<font color="red">*</font>
			</div>
		</div>
		<div class="form-group">
			<label for="inputIdentity" class="col-sm-3 control-label">信访人身份</label>
			<div class="col-sm-6">
				<select class="form-control" name="identity" id="identity">
				    <option>少数民族</option>
				    <option>外国公民</option>
				    <option>港、澳、台</option>
				    <option>侨胞</option>
				    <option>政协委员</option>
				    <option>人大代表</option>
				    <option>民主党派</option>
				    <option>知名人士</option>
				    <option selected>无特殊身份</option>
				</select>
			</div>
			<div id="validateIdentity" class="col-sm-3 validateTop">
				<font color="red">*</font>
			</div>
		</div>
				
		<div class="form-group">
			<label for="inputCase" class="col-sm-3 control-label">反映情况</label>
			<div class="col-sm-6">
				<textarea class="form-control" id="case" name="case"></textarea>
			</div>
			<div id="validateCase" class="col-sm-3 validateTop">
				<font color="red">*</font>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
			    <font color="blue">请输入2000个以内的字符，一个汉字占两个字符！如您的信访涉及案件，请注明受理法院或有关案件编号等案件信息</font>
			</div>
		</div>
				
		<div class="form-group">
			<label for="inputOtherInfo" class="col-sm-3 control-label">其它内容</label>
			<div class="col-sm-6">
				<textarea class="form-control" id="otherInfo" name="otherInfo"></textarea>
			</div>
			<div id="validateOtherInfo" class="col-sm-3 validateTop">
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
			    <font color="blue">请输入2000个以内的字符，一个汉字占两个字符！</font>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label">添加附件</label>
			<div class="col-sm-6">
				<input type="file" class="form-control" id="attachment" name="attachment" 
				        onChange="uploadAttach()" style="display:none" />
			    <input type="text" id="uploadAttachment" class="form-control" />
			</div>
			
			<div id="" class="col-sm-1">
				<button type="button" class="btn btn-default"
					onclick="attachment.click()">浏览</button>
			</div>
			<div id="validateAttachment" class="col-sm-2 validateTop">
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
			    <font color="blue">附件必须是doc,pdf或各种图片格式，如需上传多个附件，请打包后再上传</font>
			</div>
			<div id="deleteAttachment" class="col-sm-1" style="display:none">
			    <button id="deleteFileBtn" type="button" class="btn" onclick="deleteAttachment()">删除</button>
			</div>
		</div>
				
		<div class="form-group">
			<label for="inputFeedback" class="col-sm-3 control-label">期望反馈方式</label>
			<div class="col-sm-6">
				<label class="checkbox-inline">
					<input type="checkbox" name="feedback" id="feedback" value="tel"> 电话
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="feedback" id="feedback" value="message"> 短信
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" name="feedback" id="feedback" value="email"> 邮件
				</label>
			</div>
			<div id="validateFeedback" class="col-sm-3 validateTop">
			</div>
		</div>
				
		<div class="form-group">
			<label for="inputKaptcha" class="col-sm-3 control-label">验证码</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="kaptcha" name="kaptcha" />
			</div>
			<div id="validateKaptcha" class="col-sm-2 validateTop">
				<font color="red">*</font>
			</div>
			<div class="col-sm-4">
				<img src="../kaptcha/image?&src=lfdj" id="kaptchaImage" />
				<a href="javascript:void(0)" onclick="changeCode('lfdj')">看不清楚，换一张</a>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-3"></div>
			<div id="validateAll" class="col-sm-6">
			</div>
		</div>
				
		<br />
				
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-8" align="center">
				<button type="submit" class="btn btn-primary" id="submit">提交</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="reset" class="btn btn-primary" id="reset">重置</button>
			</div>
		</div>
	</form>
  </div>
  
  <jsp:include page="lfFooter.jsp" />
  

</body>
</html>











