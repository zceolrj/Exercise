/**
 * 立案申请页面的javascript
 */
// alert("xxx");

$(function() {
	$("#ygzrr").hide();
	$("#ygfr").hide();
	$("#ygffrqtzz").hide();

	$("#tjygzrr").click(function() {
		$("#ygzrr").fadeIn("slow");
	});

	$("#ygzrr_span").click(function() {
		$("#ygzrr").fadeOut("slow");// 淡入淡出效果
	});
	
	$("#ygzrrsubmit").click(function(){
		var ygzrrxm = $("#ygzrrxm").val();
		var ygzrrsfz = $("#ygzrrsfz").val();
		var ygzrrcsrq = $("#ygzrrcsrq").val();
		var ygzrrgj = $("#ygzrrgj").val();
		var ygzrrmz = $("#ygzrrmz").val();
		var ygzrrzzmm = $("#ygzrrzzmm").val();
		var ygzrrwhcd = $("#ygzrrwhcd").val();
		var ygzrrlxdh = $("#ygzrrlxdh").val();
		var ygzrryzbm = $("#ygzrryzbm").val();
		var ygzrrzz = $("#ygzrrzz").val();
		
		var text = "<div id='ygzrrInfo1' style='background-color:lightblue'>" + 
		               "<label>原告自然人</label>" +
		               "<label id='xm'>" + ygzrrxm + "</label>" +
		               "<label id='gj'>" + ygzrrgj + "</label>" +
		               "<label id='mz'>" + ygzrrmz + "</label>" +
		               "<label id='csrq'>" + ygzrrcsrq + "</label>" +
		               "<label id='sfz'>" + ygzrrsfz + "</label>" +
		               "<a href='javascript:void(0)' id='deleteYgzrrInfo1' class=''><font color='red'>X</font></a>" +
		           "</div>";
		
		$("#ygzrrInfo").append(text);
		$("#ygzrr").fadeOut("slow");
	});

	$('#ygzrrcsrq').datetimepicker({
		// yearOffset:222,
		lang : 'ch',
		timepicker : false,
		format : 'Y-m-d',
		formatDate : 'Y-m-d',
	    // minDate:'-1970/01/02',
	    // maxDate:'+1970/01/02'
	});

	$("#material").change(
			function() {
				$.ajaxFileUpload({
					url : '../upload/laMaterial',
					secureuri : false,
					fileElementId : 'material',
					dataType : "json",
					success : function(data, status) {
						var result = data.uploadResult;
						var filename = data.originalFilename;
						var wholePath = data.serverWholePath;
						if (result == "success") {
							$("#uploadedFilename").text(filename);
							$("#wholePath").val(wholePath);
							$("#uploadedMaterial").css({
								"display" : "block"
							});

							$("#validateMaterial").empty();
							$("#validateMaterial").append(
									'<img src="../images/valid.png" />');
							validAttachment = true;
						} else if (result == "fail") {
							$("#validateMaterial").text("上传失败").css({
								"color" : "red"
							});
							validAttachment = false;
						} else if (result == "errorFormat") {
							$("#validateMaterial").text("文件格式错误").css({
								"color" : "red"
							});
							validAttachment = false;
						}
					},
					error : function(data, e) {
						alert("error");
					}
				});
			});

	$("#deleteFile").click(function() {
		var wholePath = $("#wholePath").val();
		$("#uploadedAttachment").empty();
		$("#uploadedAttachment").css({
			"display" : "none"
		});
		$("#validateAttachment").empty();
		$.ajax({
			type : 'GET',
			url : '../upload/deleteAttachment',
			cache : false,
			contentType : "application/json",
			processData : true,
			dataType : "json",
			data : {
				wholePath : wholePath
			//要删除的文件名
			},
			success : function(data) {

			},
			error : function(e) {
				alert("error");
			}
		});
	});

});