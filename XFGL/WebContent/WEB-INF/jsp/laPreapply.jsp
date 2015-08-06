<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.min.css">

<link rel="stylesheet" type="text/css" href="../css/jquery.datetimepicker.css" />

<link rel="stylesheet" type="text/css" href="../css/laPreapply.css">

<script type="text/javascript" src="../js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>

<script type="text/javascript" src="../js/laPreapply.js"></script>

<title>立案预申请</title>
</head>
<body>
	<jsp:include page="laHeader.jsp" />

	<div id="preapply_navigation">
		<img src="../images/brush.jpg"  id="navigationImg"/>
		<div id="navigationContent">
		    <font size="4px"><b>预立案申请</b></font>
		</div>
	</div>

	<div id="preapply_body">
		<div id="dsszl">
			<div id="dsszl_title">
				<img src="" />
				<h3>当事人资料</h3>
			</div>
			<div id="dsszl_form">
				<form action="../la/applyLa" method="post" class="form-horizontal"
					enctype="multipart/form-data">
					<div id="ygssr" class="form-group">
						<label class="col-sm-3 control-label">诉讼主体（原告/上诉人）</label>
						<div class="col-sm-6" style="padding-top: 7px">
							<button id="tjygzrr" type="button" class="btn btn-yg">添加原告自然人</button>
							&nbsp;&nbsp;&nbsp;
							<button id="tjygfr" type="button" class="btn btn-yg">添加原告法人</button>
							&nbsp;&nbsp;&nbsp;
							<button id="tjygffrqtzz" type="button" class="btn btn-yg">添加原告非法人其它组织</button>
						</div>
						<div id="validateSszt" class="col-sm-3"></div>
					</div>
					<div id="ygzrrInfo"></div>
					<div id="ygfrInfo"></div>
					<div id="ygffrqtzzInfo"></div>

					<div id="bgssr" class="form-group">
						<label class="col-sm-3 control-label">诉讼主体（被告/被上诉人）</label>
						<div class="col-sm-6" style="padding-top: 7px">
							<button id="tjbgzrr" type="button" class="btn btn-primary">添加被告自然人</button>
							&nbsp;&nbsp;&nbsp;
							<button id="tjbgfr" type="button" class="btn btn-primary">添加被告法人</button>
							&nbsp;&nbsp;&nbsp;
							<button id="tjbgffrqtzz" type=button
								class="btn btn-primary">添加被告非法人其它组织</button>
						</div>
						<div id="validateSszt" class="col-sm-3"></div>
					</div>
					<div id="bgzrrInfo"></div>
					<div id="bgfrInfo"></div>
					<div id="bgffrqtzzInfo"></div>
					
					<br />

					<div class="form-group">
						<label class="col-sm-3 control-label">材料上传</label>
						<div class="col-sm-6">
							<input type="file" class="form-control" id="material"
								name="material" onChange="uploadMaterial()" style="display: none" /> 
							<input type="text" id="fakeMaterial"
								class="form-control" />
						</div>
						<div id="" class="col-sm-1">
							<button type="button" class="btn btn-default"
								onclick="material.click()">浏览</button>
						</div>
						<div id="validateMaterial" class="col-sm-2 validateTop"></div>
					</div>

					<div class="form-group">
						<div class="col-sm-3"></div>
						<div class="col-sm-6">
							<font color="blue">文件大小不能超过20M,如果有多个文件，请打包后再上传</font>
						</div>
						<div id="deleteFileDiv" class="col-sm-1" style="display:none">
						    <button type="button" class="btn" id="deleteFileBtn"
						        onclick="deleteFile()">删除</button>
						</div>
					</div>
					
					<div class="form-group">
			            <label class="col-sm-3 control-label">案情说明</label>
			            <div class="col-sm-6">
				            <textarea class="form-control" id="aqsm" name="aqsm"></textarea>
			            </div>
			            <div id="validateAqsm" class="col-sm-3 validateTop">
				            <font color="red">*</font>
			            </div>
		            </div>

					<div class="form-group">
						<label class="col-sm-3 control-label">立案查询密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="lacxmm" name="lacxmm">
						</div>
						<div id="validateLacxmm" class="col-sm-3 validateTop">
							<font color="red">*</font>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-3"></div>
						<div class="col-sm-6">
							<font color="blue">大于5小于15个字符，不能使用特殊字符</font>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">再次确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="zcqrmm" name="zcqrmm">
						</div>
						<div id="validateZcqrmm" class="col-sm-3 validateTop">
							<font color="red">*</font>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">电子邮件</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="lxdzyj" name="dzyj">
						</div>
						<div id="validatedzyj" class="col-sm-3 validateTop"></div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">联系电话</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="lxdh" name="lxdh">
						</div>
						<div id="validateLxdh" class="col-sm-3 validateTop">
							<font color="red">*</font>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">验证码</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="layzm"
								name="layzm" />
						</div>
						<div id="validateLayzm" class="col-sm-2 validateTop">
							<font color="red">*</font>
						</div>
						<div class="col-sm-3">
							<img src="../kaptcha/image?src=la" id="kaptchaImage" /> <a
								href="javascript:void(0)" onclick="changeCode('la')">看不清楚，换一张</a>
						</div>
					</div>
                    
                    <br />
                    
					<div id="hint" class="form-group">
					    <div class="col-sm-2"></div>
					    <div class="col-sm-8">
						    <font color="blue">温情提示：请输入准确的材料，提交相关信息、相关证据。带</font>
						    <font color="red">*</font>
						    <font color="blue">的为必须填写的信息。提交成功后，系统会给您返回“立案编号”，请您一定要记住“立案编号”与您输入的“立案查询密码”，以便查询立案的状态。</font>
						</div>
						<div class="col-sm-2"></div>
					</div>
					
					<div class="form-group">
			            <div class="col-sm-3"></div>
			            <div id="validateAll" class="col-sm-6"></div>
			            <div class="col-sm-3"></div>
		            </div>

					<br />

					<div id="finalSubmitDiv" class="">
						<button type="submit" class="btn btn-lg" id="finalSubmit">提交</button>
					</div>
					
					<!-- 隐藏窗体 -->
					<!-- 自然人 -->
					<div id="zrr">
						<div id="closeZrr">
							<span id="zrrSpan">关闭</span>
						</div>
						<div class="" id="zrrTitle">
							<font size="5px">自然人</font>
						</div>

						<div class="form-group">
							<label class="col-self-2 control-label">姓名</label>
							<div class="col-self-3">
								<input type="text" class="form-control" id="zrrxm"
									name="zrrxm">
							</div>
							<div id="validateZrrxm" class="col-self-1">
								<label class="control-label"><font color="red">*</font></label>
							</div>

							<label class="col-self-1 control-label">性别</label>
							<div class="col-self-3">
								<select class="form-control" name="zrrxb" id="zrrxb">
				                    <option>男</option>
				                    <option>女</option>
				                </select>
							</div>
							<div id="validateZrrxb" class="col-self-2">
								<label class="control-label"><font color="red">*</font></label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-self-2 control-label">出生日期</label>
							<div class="col-self-3">
								<input type="text" class="form-control" id="zrrcsrq"
									name="zrrcsrq">
							</div>
							<div id="validateZrrcsrq" class="col-self-1"></div>

							<label class="col-self-1 control-label">国家</label>
							<div class="col-self-3">
								<select class="form-control" name="zrrgj" id="zrrgj">
								  <c:forEach items="${countryList }" var="country">
                                    <option>${country }</option>
                                  </c:forEach>
				                </select>
							</div>
							<div id="validateZrrgj" class="col-self-2"></div>
						</div>

						<div class="form-group">
							<label class="col-self-2 control-label">民族</label>
							<div class="col-self-3">
								<select class="form-control" name="zrrmz" id="zrrmz">
								  <c:forEach items="${raceList }" var="race">
                                    <option>${race }</option>
                                  </c:forEach>
				                </select>
							</div>
							<div id="validateZrrcmz" class="col-self-1"></div>

							<label class="col-self-1 control-label">邮编</label>
							<div class="col-self-3">
								<input type="text" class="form-control" id="zrryb"
									name="zrryb">
							</div>
							<div id="validateZrryb" class="col-self-2"></div>
						</div>

						<div class="form-group">
							<label class="col-self-2 control-label">电话</label>
							<div class="col-self-3">
								<input type="text" class="form-control" id="zrrdh"
									name="zrrdh">
							</div>
							<div id="validateZrrdh" class="col-self-1"></div>

							<label class="col-self-1 control-label">职务职业</label>
							<div class="col-self-3">
								<input type="text" class="form-control" id="zrrzwzy"
									name="zrrzwzy">
							</div>
							<div id="validateZrrzwzy" class="col-self-2"></div>
						</div>

						<div class="form-group">
							<label class="col-self-2 control-label">证件类型</label>
							<div class="col-self-3">
								<select class="form-control" name="zrrzjlx" id="zrrzjlx">
								  <c:forEach items="${zjlbList }" var="zjlb">
                                    <option>${zjlb }</option>
                                  </c:forEach>
				                </select>
							</div>
							<div id="validateZrrzjlx" class="col-self-1">
								<label class="control-label"><font color="red">*</font></label>
							</div>

							<label class="col-self-1 control-label"></label>
							<div class="col-self-3"></div>
							<div id="" class="col-self-2"></div>
						</div>

						<div class="form-group">
							<label class="col-self-2 control-label">证件号码</label>
							<div class="col-self-6">
								<input type="text" class="form-control" id="zrrzjhm"
									name="zrrzjhm">
							</div>
							<div id="validateZrrzjhm" class="col-self-4">
								<label class="control-label"><font color="red">*</font></label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-self-2 control-label">工作单位</label>
							<div class="col-self-6">
								<input type="text" class="form-control" id="zrrgzdw"
									name="zrrgzdw">
							</div>
							<div id="validateZrrgzdw" class="col-self-4"></div>
						</div>

						<div class="form-group">
							<label class="col-self-2 control-label">居住地</label>
							<div class="col-self-6">
								<input type="text" class="form-control" id="zrrjzd"
									name="zrrjzd">
							</div>
							<div id="validateZrrjzd" class="col-self-4"></div>
						</div>

						<div class="form-group">
							<label class="col-self-2 control-label">租住地</label>
							<div class="col-self-6">
								<input type="text" class="form-control" id="zrrzzd"
									name="zrrzzd">
							</div>
							<div id="validateZrrzzd" class="col-self-4"></div>
						</div>
						
						<div id="hideZrr" class="form-group">
						    <input type="text" id="zrrSsdw" style="display: none;">
						    <input type="text" id="zrrDsrlb" style="display: none;">
						    <input type="text" id="zrrEditId" style="display: none;">
						</div>
						
						<div class="form-group">
						    <div class="col-self-2"></div>
						    <div class="col-self-6" id="validateZrr"></div>
						    <div class="col-self-4"></div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-7" align="center">
								<button type="button" class="btn btn-default" id="zrrsubmit">提交</button>
							</div>
						</div>
					</div>

					<!-- 法人 -->
					<div id="fr">
						<div id="closeFr">
							<span id="frSpan" style="cursor: pointer">关闭</span>
						</div>
						<div class="" id="frTitle">
							<font size="5px">法人</font>
						</div>
						
						<div class="form-group">
							<label class="col-self-2 control-label">单位全称</label>
							<div class="col-self-6">
								<input type="text" class="form-control" id="frdwqc"
									name="frdwqc">
							</div>
							<div id="validateFrdwqc" class="col-self-4"></div>
						</div>
						
						<div class="form-group">
						    <label class="col-self-2 control-label">所有制性质</label>
							<div class="col-self-3">
								<select class="form-control" name="frsyzxz" id="frsyzxz">
								  <c:forEach items="${syzxzList }" var="syzxz">
                                    <option>${syzxz }</option>
                                  </c:forEach>
				                </select>
							</div>
							<div id="validateFrsyzxz" class="col-self-1"></div>
							
							<label class="col-self-1 control-label">电话</label>
							<div class="col-self-3">
								<input type="text" class="form-control" id="frdh"
									name="frdh">
							</div>
							<div id="validateFrdh" class="col-self-2"></div>
						</div>
						
						<div class="form-group">
						    <label class="col-self-2 control-label">邮编</label>
							<div class="col-self-3">
								<input type="text" class="form-control" id="fryb"
									name="fryb">
							</div>
							<div id="validateFryb" class="col-self-1"></div>
						</div>
						
						<div class="form-group">
							<label class="col-self-2 control-label">地址</label>
							<div class="col-self-6">
								<input type="text" class="form-control" id="frdz"
									name="frdz">
							</div>
							<div id="validateFrdz" class="col-self-4"></div>
						</div>
						
						<div class="form-group">
						    <label class="col-self-2 control-label">法定代表人</label>
							<div class="col-self-3">
								<input type="text" class="form-control" id="frfddbr"
									name="frfddbr">
							</div>
							<div id="validateFrfddbr" class="col-self-1">
								<label class="control-label"><font color="red">*</font></label>
							</div>
							
							<label class="col-self-1 control-label">职务</label>
							<div class="col-self-3">
								<input type="text" class="form-control" id="frzw"
									name="frzw">
							</div>
							<div id="validateFrzw" class="col-self-2"></div>
						</div>
						
						<div class="form-group">
							<label class="col-self-2 control-label">企业规模</label>
							<div class="col-self-3">
								<select class="form-control" name="frqygm" id="frqygm">
								  <c:forEach items="${qygmList }" var="qygm">
                                    <option>${qygm }</option>
                                  </c:forEach>
				                </select>
							</div>
							<div id="validateFrqygm" class="col-self-1"></div>

							<label class="col-self-1 control-label">联系电话</label>
							<div class="col-self-3">
								<input type="text" class="form-control" id="frlxdh"
									name="frlxdh">
							</div>
							<div id="validateFrqygm" class="col-self-2"></div>
						</div>

						<div class="form-group">
							<label class="col-self-2 control-label">登记证类别</label>
							<div class="col-self-6">
								<select class="form-control" name="frdjzlb" id="frdjzlb">
								  <c:forEach items="${frdjzlbList }" var="frdjzlb">
                                    <option>${frdjzlb }</option>
                                  </c:forEach>
				                </select>
							</div>
							<div id="validateFrdjzlb" class="col-self-4">
								<label class="control-label"><font color="red">*</font></label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-self-2 control-label">登记证号</label>
							<div class="col-self-6">
								<input type="text" class="form-control" id="frdjzh"
									name="frdjzh">
							</div>
							<div id="validateFrdjzh" class="col-self-4">
								<label class="control-label"><font color="red">*</font></label>
							</div>
						</div>
						
						<div id="hideFr" class="form-group">
						    <input type="text" id="frSsdw" style="display: none;">
						    <input type="text" id="frDsrlb" style="display: none;">
						    <input type="text" id="frEditId" style="display: none;">
						</div>
						
						<div class="form-group">
						    <div class="col-self-2"></div>
						    <div class="col-self-6" id="validateFr"></div>
						    <div class="col-self-4"></div>
						</div>

						<br />

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-7" align="center">
								<button type="button" class="btn btn-default" id="frsubmit">提交</button>
							</div>
						</div>
					</div>


					<!-- 非法人其他组织 -->
					<div id="ffrqtzz">
						<div id="closeFfrqtzz">
							<span id="ffrqtzzSpan" style="cursor: pointer">关闭</span>
						</div>
						<div class="" id="ffrqtzzTitle">
						    <font size="5px">非法人其它组织</font>
						</div>
						<div class="form-group">
							<label class="col-self-2 control-label">机关名称</label>
							<div class="col-self-3">
								<input type="text" class="form-control" id="ffrqtzzjgmc"
									name="ffrqtzzjgmc">
							</div>
							<div id="validateFfrqtzzjgmc" class="col-self-1"></div>
							
							<label class="col-self-1 control-label">机关性质</label>
							<div class="col-self-3">
								<select class="form-control" name="ffrqtzzjgxz" id="ffrqtzzjgxz">
								  <c:forEach items="${jgxzList }" var="jgxz">
                                    <option>${jgxz }</option>
                                  </c:forEach>
				                </select>
							</div>
							<div id="validateFfrqtzzjgxz" class="col-self-2"></div>
						</div>

						<div class="form-group">
							<label class="col-self-2 control-label">代表人姓名</label>
							<div class="col-self-3">
								<input type="text" class="form-control" id="ffrqtzzdbrxm"
									name="ffrqtzzdbrxm">
							</div>
							<div id="validateFfrqtzzdbrxm" class="col-self-1"></div>
							
							<label class="col-self-1 control-label">邮编</label>
							<div class="col-self-3">
								<input type="text" class="form-control" id="ffrqtzzyb"
									name="ffrqtzzyb">
							</div>
							<div id="validateFfrqtzzyb" class="col-self-2"></div>
						</div>
						
						<div class="form-group">
							<label class="col-self-2 control-label">联系电话</label>
							<div class="col-self-3">
								<input type="text" class="form-control" id="ffrqtzzlxdh"
									name="ffrqtzzlxdh">
							</div>
							<div id="validateFfrqtzzlxdh" class="col-self-1"></div>
							
						</div>
						
						<div class="form-group">
							<label class="col-self-2 control-label">地址</label>
							<div class="col-self-6">
								<input type="text" class="form-control" id="ffrqtzzdz"
									name="ffrqtzzdz">
							</div>
							<div id="validateFfrqtzzdz" class="col-self-4"></div>
						</div>

						<div class="form-group">
							<label class="col-self-2 control-label">涉及赔偿</label>
							<div class="col-self-3">
								<select class="form-control" name="ffrqtzzsjpc" id="ffrqtzzsjpc">
				                    <option>是</option>
				                    <option>否</option>
				                </select>
							</div>
							<div id="validateFfrqtzzsjpc" class="col-self-1"></div>
							<label class="col-self-1 control-label">是否复议</label>
							<div class="col-self-3">
								<select class="form-control" name="ffrqtzzsffy" id="ffrqtzzsffy">
				                    <option>是</option>
				                    <option>否</option>
				                </select>
							</div>
							<div id="validateFfrqtzzsffy" class="col-self-2"></div>
						</div>

						<div class="form-group">
							<label class="col-self-2 control-label">登记证类别</label>
							<div class="col-self-3">
								<select class="form-control" name="ffrqtzzdjzlb" id="ffrqtzzdjzlb">
								  <c:forEach items="${xzjgdjzlbList }" var="xzjgdjzlb">
                                    <option>${xzjgdjzlb }</option>
                                  </c:forEach>
				                </select>
							</div>
							<div id="validateFfrqtzzdjzlb" class="col-self-7">
								<label class="control-label"><font color="red">*</font></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-self-2 control-label">登记证号</label>
							<div class="col-self-6">
								<input type="text" class="form-control" id="ffrqtzzdjzh"
									name="ffrqtzzdjzh">
							</div>
							<div id="validateFfrqtzzdjzh" class="col-self-4">
								<label class="control-label"><font color="red">*</font></label>
							</div>
						</div>

						<div id="hideFfrqtzz" class="form-group">
						    <input type="text" id="ffrqtzzSsdw" style="display: none;">
						    <input type="text" id="ffrqtzzDsrlb" style="display: none;">
						    <input type="text" id="ffrqtzzEditId" style="display: none;">
						</div>
						
						<div class="form-group">
						    <div class="col-self-2"></div>
						    <div class="col-self-6" id="validateFfrqtzz"></div>
						    <div class="col-self-4"></div>
						</div>

						<br />

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-7" align="center">
								<button type="button" class="btn btn-default"
									id="ffrqtzzsubmit">提交</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="laFooter.jsp" />
</body>
</html>