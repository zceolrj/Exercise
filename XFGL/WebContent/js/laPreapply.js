/**
 * 
 */
var editZrrInfo;
var editFrInfo;
var editFfrqtzzInfo;

var deleteZrrInfo;
var deleteFrInfo;
var deleteFfrqtzzInfo;

$(function() {
	
	$("#zrr").hide();
	$("#fr").hide();
	$("#ffrqtzz").hide();

//添加原告自然人/法人/非法人其它组织
	$("#tjygzrr").click(function() {
		//清空原来的数据
		$("#zrrxm").val("");
		$("#zrrcsrq").val("");
		$("#zrryb").val("");
		$("#zrrdh").val("");
		$("#zrrzwzy").val("");
		$("#zrrzjhm").val("");
		$("#zrrgzdw").val("");
		$("#zrrjzd").val("");
		$("#zrrzzd").val("");
		//所有下拉框默认选择第一个
		$('select').prop('selectedIndex', 0);
		$("#zrrgj").val("中国");
		$("#zrrmz").val("汉族");
		
		$("#zrrSsdw").val("yg");
		$("#zrrEditId").val("edit");
		
		//在浏览器中间显示
		var top = ($(window).height() - $("#zrr").height())/2;
		var left = ($(window).width() - $("#zrr").width())/2;
		var scrollTop = $(document).scrollTop();
		var scrollLeft = $(document).scrollLeft();
		$("#zrr").css({position:'absolute',top:top+scrollTop,left:left+scrollLeft});
		$("#zrr").fadeIn("slow");
	});

	$("#zrrSpan").click(function() {
		$("#zrr").fadeOut("slow");// 淡入淡出效果
	});
	
	$("#tjygfr").click(function(){
		$("#frdwqc").val("");
		$("#frdh").val("");
		$("#fryb").val("");
		$("#frdz").val("");
		$("#frfddbr").val("");
		$("#frzw").val("");
		$("#frlxdh").val("");
		$("#frdjzh").val("");
		
		//所有下拉框默认选择第一个
		$('select').prop('selectedIndex', 0);
		
		$("#frSsdw").val("yg");
		$("#frEditId").val("edit");
		
		//在浏览器中间显示
		var top = ($(window).height() - $("#fr").height())/2;
		var left = ($(window).width() - $("#fr").width())/2;
		var scrollTop = $(document).scrollTop();
		var scrollLeft = $(document).scrollLeft();
		$("#fr").css({position:'absolute',top:top+scrollTop,left:left+scrollLeft});
		$("#fr").fadeIn("slow");
	});
	
	$("#frSpan").click(function(){
		$("#fr").fadeOut("slow");
	});
	
	$("#tjygffrqtzz").click(function(){
		$("#ffrqtzzdsrjc").val("");
		$("#ffrqtzzjgmc").val("");
		$("#ffrqtzzdbrxm").val("");
		$("#ffrqtzzjgxz").val("");
		$("#ffrqtzzlxdh").val("");
		$("#ffrqtzzyb").val("");
		$("#ffrqtzzdjzh").val("");
		$("#ffrqtzzdz").val("");
		//所有下拉框默认选择第一个
		$('select').prop('selectedIndex', 0);
		
		$("#ffrqtzzSsdw").val("yg");
		$("#ffrqtzzEditId").val("edit");
		
		//在浏览器中间显示
		var top = ($(window).height() - $("#ffrqtzz").height())/2;
		var left = ($(window).width() - $("#ffrqtzz").width())/2;
		var scrollTop = $(document).scrollTop();
		var scrollLeft = $(document).scrollLeft();
		$("#ffrqtzz").css({position:'absolute',top:top+scrollTop,left:left+scrollLeft});
		$("#ffrqtzz").fadeIn("slow");
	});
	
	$("#ffrqtzzSpan").click(function(){
		$("#ffrqtzz").fadeOut("slow");
	});
//添加原告自然人/法人/非法人其它组织
	
	
//添加被告自然人/法人/非法人其它组织
	$("#tjbgzrr").click(function() {
		//清空原来的数据
		$("#zrrxm").val("");
		$("#zrrcsrq").val("");
		$("#zrryb").val("");
		$("#zrrdh").val("");
		$("#zrrzwzy").val("");
		$("#zrrzjhm").val("");
		$("#zrrgzdw").val("");
		$("#zrrjzd").val("");
		$("#zrrzzd").val("");
		//所有下拉框默认选择第一个
		$('select').prop('selectedIndex', 0);
		$("#zrrgj").val("中国");
		$("#zrrmz").val("汉族");
		
		$("#zrrSsdw").val("bg");
		$("#zrrEditId").val("edit");
		
		//在浏览器中间显示
		var top = ($(window).height() - $("#zrr").height())/2;
		var left = ($(window).width() - $("#zrr").width())/2;
		var scrollTop = $(document).scrollTop();
		var scrollLeft = $(document).scrollLeft();
		$("#zrr").css({position:'absolute',top:top+scrollTop,left:left+scrollLeft});
		$("#zrr").fadeIn("slow");
	});
	
	$("#tjbgfr").click(function(){
		$("#frdwqc").val("");
		$("#frdh").val("");
		$("#fryb").val("");
		$("#frdz").val("");
		$("#frfddbr").val("");
		$("#frzw").val("");
		$("#frlxdh").val("");
		$("#frdjzh").val("");
		
		//所有下拉框默认选择第一个
		$('select').prop('selectedIndex', 0);
		
		$("#frSsdw").val("bg");
		$("#frEditId").val("edit");
		
		//在浏览器中间显示
		var top = ($(window).height() - $("#fr").height())/2;
		var left = ($(window).width() - $("#fr").width())/2;
		var scrollTop = $(document).scrollTop();
		var scrollLeft = $(document).scrollLeft();
		$("#fr").css({position:'absolute',top:top+scrollTop,left:left+scrollLeft});
		$("#fr").fadeIn("slow");
	});
	
	$("#tjbgffrqtzz").click(function(){
		$("#ffrqtzzdsrjc").val("");
		$("#ffrqtzzjgmc").val("");
		$("#ffrqtzzdbrxm").val("");
		$("#ffrqtzzjgxz").val("");
		$("#ffrqtzzlxdh").val("");
		$("#ffrqtzzyb").val("");
		$("#ffrqtzzdjzh").val("");
		$("#ffrqtzzdz").val("");
		
		//所有下拉框默认选择第一个
		$('select').prop('selectedIndex', 0);
		
		$("#ffrqtzzSsdw").val("bg");
		$("#ffrqtzzEditId").val("edit");
		
		//在浏览器中间显示
		var top = ($(window).height() - $("#ffrqtzz").height())/2;
		var left = ($(window).width() - $("#ffrqtzz").width())/2;
		var scrollTop = $(document).scrollTop();
		var scrollLeft = $(document).scrollLeft();
		$("#ffrqtzz").css({position:'absolute',top:top+scrollTop,left:left+scrollLeft});
		$("#ffrqtzz").fadeIn("slow");
	});
//添加被告自然人/法人/非法人其它组织	
	
	
	var zrrId = 1;
	
	$("#zrrsubmit").click(function(){
		var id;
		var validxm = false;
		var validxb = false;
		var validzjlx = false;
		var validzjhm = false;
		
		var ssdw = $("#zrrSsdw").val();
		var dsrlb = "zrr";
		var zrrxm = $("#zrrxm").val();
		var zrrxb = $("#zrrxb").val();
		var zrrcsrq = $("#zrrcsrq").val();
		var zrrgj = $("#zrrgj").val();
		var zrrmz = $("#zrrmz").val();
		var zrryb = $("#zrryb").val();
		var zrrdh = $("#zrrdh").val();
		var zrrzwzy = $("#zrrzwzy").val();
		var zrrzjlx = $("#zrrzjlx").val();
		var zrrzjhm = $("#zrrzjhm").val();
		var zrrgzdw = $("#zrrgzdw").val();
		var zrrjzd = $("#zrrjzd").val();
		var zrrzzd = $("#zrrzzd").val();
		
		var zrrEditId = $("#zrrEditId").val();
		
		if(!zrrxm){
			validxm = false;
		}
		else{
			validxm = true;
		}
		
		if(!zrrxb){
			validxb = false;
		}
		else{
			validxb = true;
		}
		
		if(!zrrzjlx){
			validzjlx = false;
		}
		else{
			validzjlx = true;
		}
		
		if(!zrrzjhm){
			validzjhm = false;
		}
		else{
			validzjhm = true;
		}
		
		if(validxm && validxb && validzjlx && validzjhm){
			if(zrrEditId && zrrEditId!="edit"){
				id = "zrr" + zrrEditId;
			}
			else{
				id = "zrr" + zrrId;
			}
			$.ajax({
				type:'post',
				url:'../la/tjzrr',
				cache:false,
				processData:true,
				dataType:"json",
				data:
				{
					id:id,
					ssdw:ssdw,//诉讼地位
					dsrlb:dsrlb,//当事人类别
					xm:zrrxm,//姓名
					xb:zrrxb,//性别
					csrq:zrrcsrq,//出生日期
					gj:zrrgj,
					mz:zrrmz,
					yb:zrryb,
					dh:zrrdh,
					zwzy:zrrzwzy,
					zjlx:zrrzjlx,
					zjhm:zrrzjhm,
					gzdw:zrrgzdw,
					jzd:zrrjzd,
					zzd:zrrzzd
				},
				success:function(data)
				{
					if(zrrEditId && zrrEditId!="edit"){
						$("#zrrxm"+zrrEditId).text(zrrxm);
						$("#zrrxb"+zrrEditId).text(zrrxb);
						$("#zrrcsrq"+zrrEditId).text(zrrcsrq);
						$("#zrrgj"+zrrEditId).text(zrrgj);
						$("#zrrmz"+zrrEditId).text(zrrmz);
						$("#zrr").fadeOut("slow");
					}
					else{
						var title="";
						if(ssdw=="yg"){
							title="原告自然人:";
						}
						else if(ssdw=="bg"){
							title="被告自然人:";
						}
							
						var text = "<div id='zrrInfo" + zrrId + "' class='form-group'>" + 
                                     "<div class='col-sm-3'></div>" +
                                     "<div class='col-sm-6' style=''>" +
                                       "<div class='activeInfo' style=''>" +
                                         "<label>"+ title + "</label>&nbsp;&nbsp;" +
                                         "<label id='zrrxm" + zrrId + "'>" + zrrxm + "</label>&nbsp;&nbsp;" +
                                         "<label id='zrrxb" + zrrId + "'>" + zrrxb + "</label>&nbsp;&nbsp;" +
                                         "<label id='zrrcsrq" + zrrId + "'>" + zrrcsrq + "</label>&nbsp;&nbsp;" +
                                         "<label id='zrrgj" + zrrId + "'>" + zrrgj + "</label>&nbsp;&nbsp;" +
                                         "<label id='zrrmz" + zrrId + "'>" + zrrmz + "</label>&nbsp;&nbsp;" +
                                         "<div id='operateZzr' class='activeDelete'>" +
                                           "<a href='javascript:void(0)' data-id='"+ zrrId +"' id='" + zrrId +
                                               "' onclick='editZrrInfo(this)' class=''><font color='red'>编辑</font></a>&nbsp;&nbsp;" +
                                           "<a href='javascript:void(0)' data-id='"+ zrrId +"' id='" + zrrId +
                                               "' onclick='deleteZrrInfo(this)' class=''><font color='red'>删除</font></a>" +
                                         "</div>" +
                                       "</div>" +
                                     "</div>" +
                                   "<div class='col-sm-3'></div>" +
                                 "</div>";
			            if(ssdw=='yg'){
				            $("#ygzrrInfo").append(text);
			            }
			            else if(ssdw=='bg'){
				            $("#bgzrrInfo").append(text);
			            }
          
                        $("#zrr").fadeOut("slow");
 		                zrrId++;
					}	
				    	
				},
				error:function(e)
				{
					alert("error");
				}
			});
		}
		else{
			$("#validateZrr").text("*为必填项").css({"color":"red"});
		}
		
	});
	
	editZrrInfo = function(self){
		var editZrrId = $(self).data("id");
		var id = "zrr" + editZrrId;
		$.ajax({
			type:'post',
			url:'../la/editZrr',
			cache:false,
			processData:true,
			dataType:"json",
			data:
			{
				id:id//
			},
			success:function(data)
			{
				$("#zrrxm").val(data.result.xm);//姓名
				$("#zrrxb").val(data.result.xb);//性别
				$("#zrrcsrq").val(data.csrq);//出生日期
				$("#zrrgj").val(data.result.ssgj);//国家
				$("#zrrmz").val(data.result.mz);//民族
				$("#zrryb").val(data.result.yb);//邮编
				$("#zrrdh").val(data.result.dh);//电话
				$("#zrrzwzy").val(data.result.zwzy);//职务职业
				$("#zrrzjlx").val(data.result.zjlb);//证件类型
				$("#zrrzjhm").val(data.result.sfzhm);//证件号码
				$("#zrrgzdw").val(data.result.gzdw);//工作单位
				$("#zrrjzd").val(data.result.dz);//居住地
				$("#zrrzzd").val(data.result.zzd);//租住地
				
				$("#zrrEditId").val(editZrrId);//编辑ID
				
				//在浏览器中间显示
				var top = ($(window).height() - $("#zrr").height())/2;
				var left = ($(window).width() - $("#zrr").width())/2;
				var scrollTop = $(document).scrollTop();
				var scrollLeft = $(document).scrollLeft();
				$("#zrr").css({position:'absolute',top:top+scrollTop,left:left+scrollLeft});
				$("#zrr").fadeIn("slow");
			},
			error:function(e)
			{
				alert("error");
			}
		});
	};
	
	deleteZrrInfo = function(self){
		var deleteZrrId = $(self).data("id");
		var id = "zrr" + deleteZrrId;
		$.ajax({
			type:'post',
			url:'../la/deleteZrr',
			cache:false,
			processData:true,
			dataType:"json",
			data:
			{
				id:id//
			},
			success:function(data)
			{
				$("#zrrInfo"+deleteZrrId).remove();
				zrrId--;
			},
			error:function(e)
			{
				alert("error");
			}
		});
	};
	
	
	$('#zrrcsrq').datetimepicker({
		lang : 'ch',
		timepicker : false,
		format : 'Y-m-d',
		formatDate : 'Y-m-d',
	    // minDate:'-1970/01/02',
	    // maxDate:'+1970/01/02'
	});
	
	
	
	var frId = 1;
	
	$("#frsubmit").click(function(){
		var id;
		var validfddbr = false;
		var validdjzlb = false;
		var validdjzh = false;
		
		var ssdw = $("#frSsdw").val();
		var dsrlb = "fr";
		var frdwqc = $("#frdwqc").val();
		var frsyzxz = $("#frsyzxz").val();
		var frdh = $("#frdh").val();
		var fryb = $("#fryb").val();
		var frdz = $("#frdz").val();
		var frfddbr = $("#frfddbr").val();
		var frzw = $("#frzw").val();
		var frqygm = $("#frqygm").val();
        var frlxdh = $("#frlxdh").val();		
		var frdjzlb = $("#frdjzlb").val();
		var frdjzh = $("#frdjzh").val();
		
		var frEditId = $("#frEditId").val();
		
		if(!frfddbr){
			validfddbr = false;
		}
		else{
			validfddbr = true;
		}
		
		if(!frdjzlb){
			validdjzlb = false;
		}
		else{
			validdjzlb = true;
		}
		
		if(!frdjzh){
			validdjzh = false;
		}
		else{
			validdjzh = true;
		}
		
		if(validfddbr && validdjzlb && validdjzh){
			if(frEditId && frEditId!="edit"){
				id = "fr" + frEditId;
			}
			else{
				id = "fr" + frId;
			}
			$.ajax({
				type:'post',
				url:'../la/tjfr',
				cache:false,
				processData:true,
				dataType:"json",
				data:
				{
					id:id,
					ssdw:ssdw,
					dsrlb:dsrlb,
					dwqc:frdwqc,//单位全称
					syzxz:frsyzxz,//所有制性质
					dh:frdh,//电话
					yb:fryb,
					dz:frdz,
					fddbr:frfddbr,
					zw:frzw,//职务
					qygm:frqygm,
					lxdh:frlxdh,
					djzlb:frdjzlb,
					djzh:frdjzh,
					
				},
				success:function(data)
				{
					if(frEditId && frEditId!="edit"){
						$("#frdwqc"+frEditId).text(frdwqc);
						$("#frsyzxz"+frEditId).text(frsyzxz);
						//$("#frdh"+frEditId).text(frdh);
						//$("#fryb"+frEditId).text(fryb);
						$("#fr").fadeOut("slow");
					}
					else{
						var title="";
						if(ssdw=="yg"){
							title="原告法人:";
						}
						else if(ssdw=="bg"){
							title="被告法人:";
						}
						var text = "<div id='frInfo" + frId + "' class='form-group'>" + 
                                       "<div class='col-sm-3'></div>" +
                                       "<div class='col-sm-6' style=''>" +
                                           "<div class='activeInfo'>" +
                                               "<label>" + title + "</label>&nbsp;&nbsp;" +
                                               "<label id='frdwqc" + frId + "'>" + frdwqc + "</label>&nbsp;&nbsp;" +
                                               "<label id='frsyzxz" + frId + "'>" + frsyzxz + "</label>&nbsp;&nbsp;" +
                                               "<div id='operateFr' class='activeDelete'>" +
                                                   "<a href='javascript:void(0)' data-id='"+ frId +"' id='" + frId +
                                                       "' onclick='editFrInfo(this)' class=''><font color='red'>编辑</font></a>&nbsp;&nbsp;" +
                                                   "<a href='javascript:void(0)' data-id='"+ frId +"' id='" + frId +
                                                       "' onclick='deleteFrInfo(this)' class=''><font color='red'>删除</font></a>" +
                                               "</div>" +
                                           "</div>" +
                                       "</div>" +
                                       "<div class='col-sm-3'></div>" +
                                   "</div>";
			            if(ssdw=='yg'){
				            $("#ygfrInfo").append(text);
			            }
			            else if(ssdw=='bg'){
				            $("#bgfrInfo").append(text);
			            }
          
                        $("#fr").fadeOut("slow");
 		                frId++;
				   	}
				},
				error:function(e)
				{
					alert("error");
				}
			});
		}
		else{
			$("#validateFr").text("*为必填项").css({"color":"red"});
		}
		
	});
	
	editFrInfo = function(self){
		var editFrId = $(self).data("id");
		var id = "fr" + editFrId;
		$.ajax({
			type:'post',
			url:'../la/editFr',
			cache:false,
			processData:true,
			dataType:"json",
			data:
			{
				id:id//
			},
			success:function(data)
			{
				$("#frdwqc").val(data.result.dwmc);//工作单位
				$("#frsyzxz").val(data.result.frxz);//所有制性质
				$("#frdh").val(data.result.dh);//电话
				$("#fryb").val(data.result.yb);//邮编
				$("#frdz").val(data.result.dz);//地址
				$("#frfddbr").val(data.result.fddbrxm);//法定代表人
				$("#frzw").val(data.result.zw);//职务
				$("#frqygm").val(data.result.gyqygm);//企业规模
                $("#frlxdh").val(data.result.lxdh);//联系电话				
				$("#frdjzlb").val(data.result.djzlb);//登记证类别
				$("#frdjzh").val(data.result.djzh);//登记证号
				
				$("#frEditId").val(editFrId);//编辑ID
				
				var top = ($(window).height() - $("#fr").height())/2;
				var left = ($(window).width() - $("#fr").width())/2;
				var scrollTop = $(document).scrollTop();
				var scrollLeft = $(document).scrollLeft();
				$("#fr").css({position:'absolute',top:top+scrollTop,left:left+scrollLeft});
				$("#fr").fadeIn("slow");
			},
			error:function(e)
			{
				alert("error");
			}
		});
	};
	
	deleteFrInfo = function(self){
		var deleteFrId = $(self).data("id");
		var id = "fr" + deleteFrId;
		$.ajax({
			type:'post',
			url:'../la/deleteFr',
			cache:false,
			processData:true,
			dataType:"json",
			data:
			{
				id:id//
			},
			success:function(data)
			{
				$("#frInfo"+deleteFrId).remove();
				frId--;
			},
			error:function(e)
			{
				alert("error");
			}
		});
	};
	
	
	
	var ffrqtzzId = 1;
	
	$("#ffrqtzzsubmit").click(function(){
		var id;
		var validdjzlb = false;
		var validdjzh = false;
		
		var ssdw = $("#ffrqtzzSsdw").val();
		var dsrlb = "ffrqtzz";
		var ffrqtzzjgmc = $("#ffrqtzzjgmc").val();
		var ffrqtzzjgxz = $("#ffrqtzzjgxz").val();
		var ffrqtzzdbrxm = $("#ffrqtzzdbrxm").val();
		var ffrqtzzyb = $("#ffrqtzzyb").val();
		var ffrqtzzlxdh = $("#ffrqtzzlxdh").val();
		var ffrqtzzdz = $("#ffrqtzzdz").val();
		var ffrqtzzsjpc = $("#ffrqtzzsjpc").val();
		var ffrqtzzsffy = $("#ffrqtzzsffy").val();
		var ffrqtzzdjzlb = $("#ffrqtzzdjzlb").val();
		var ffrqtzzdjzh = $("#ffrqtzzdjzh").val();
		
		var ffrqtzzEditId = $("#ffrqtzzEditId").val();
		
		if(!ffrqtzzdjzlb){
			validdjzlb = false;
		}
		else{
			validdjzlb = true;
		}
		
		if(!ffrqtzzdjzh){
			validdjzh = false;
		}
		else{
			validdjzh = true;
		}
		
		if(validdjzlb && validdjzh){
			if(ffrqtzzEditId && ffrqtzzEditId!="edit"){
				id = "ffrqtzz" + ffrqtzzEditId;
			}
			else{
				id = "ffrqtzz" + ffrqtzzId;
			}
			$.ajax({
				type:'post',
				url:'../la/tjffrqtzz',
				cache:false,
				processData:true,
				dataType:"json",
				data:
				{
					id:id,
					ssdw:ssdw,
					dsrlb:dsrlb,
					jgmc:ffrqtzzjgmc,//机关名称
					jgxz:ffrqtzzjgxz,//机关性质
					dbrxm:ffrqtzzdbrxm,//代表人姓名
					yb:ffrqtzzyb,
					lxdh:ffrqtzzlxdh,//联系电话
					dz:ffrqtzzdz,
					sjpc:ffrqtzzsjpc,
					sffy:ffrqtzzsffy,
					djzlb:ffrqtzzdjzlb,
					djzh:ffrqtzzdjzh,
				},
				success:function(data)
				{
					if(ffrqtzzEditId && ffrqtzzEditId!="edit"){
						$("#ffrqtzzjgmc"+ffrqtzzEditId).text(ffrqtzzjgmc);
						$("#ffrqtzzjgxz"+ffrqtzzEditId).text(ffrqtzzjgxz);
						$("#ffrqtzzdbrxm"+ffrqtzzEditId).text(ffrqtzzdbrxm);
						$("#ffrqtzzlxdh"+ffrqtzzEditId).text(ffrqtzzlxdh);
						$("#ffrqtzz").fadeOut("slow");
					}
					else{
						var title="";
						if(ssdw=="yg"){
							title="原告行政机关:";
						}
						else if(ssdw=="bg"){
							title="被告行政机关:";
						}
						var text = "<div id='ffrqtzzInfo" + ffrqtzzId + "' class='form-group'>" + 
                                       "<div class='col-sm-3'></div>" +
                                       "<div class='col-sm-6'>" +
                                           "<div  class='activeInfo'>" +
                                               "<label>" + title + "</label>&nbsp;&nbsp;" +
                                               "<label id='ffrqtzzjgmc" + ffrqtzzId + "'>" + ffrqtzzjgmc + "</label>&nbsp;&nbsp;" +
                                               "<label id='ffrqtzzjgxz" + ffrqtzzId + "'>" + ffrqtzzjgxz + "</label>&nbsp;&nbsp;" +
                                               "<label id='ffrqtzzdbrxm" + ffrqtzzId + "'>" + ffrqtzzdbrxm + "</label>&nbsp;&nbsp;" +
                                               "<label id='ffrqtzzlxdh" + ffrqtzzId + "'>" + ffrqtzzlxdh + "</label>&nbsp;&nbsp;" +
                                               "<div id='operateFfrqtzz' class='activeDelete'>" +
                                                   "<a href='javascript:void(0)' data-id='"+ ffrqtzzId +"' id='" + ffrqtzzId +
                                                       "' onclick='editFfrqtzzInfo(this)' class=''><font color='red'>编辑</font></a>&nbsp;&nbsp;" +
                                                   "<a href='javascript:void(0)' data-id='"+ ffrqtzzId +"' id='" + ffrqtzzId +
                                                       "' onclick='deleteFfrqtzzInfo(this)' class='activeDelete'><font color='red'>删除</font></a>" +
                                               "</div>" +
                                           "</div>" +
                                       "</div>" +
                                       "<div class='col-sm-3'></div>" +
                                   "</div>";
			            if(ssdw=='yg'){
				            $("#ygffrqtzzInfo").append(text);
			            }
			            else if(ssdw=='bg'){
				            $("#bgffrqtzzInfo").append(text);
			            }
          
                        $("#ffrqtzz").fadeOut("slow");
                        ffrqtzzId++;
					}
					
				},
				error:function(e)
				{
					alert("error");
				}
			});
		}
		else{
			$("#validateFfrqtzz").text("*为必填项").css({"color":"red"});
		}
		
	});
	
	editFfrqtzzInfo = function(self){
		var editFfrqtzzId = $(self).data("id");
		var id = "ffrqtzz" + editFfrqtzzId;
		$.ajax({
			type:'post',
			url:'../la/editFfrqtzz',
			cache:false,
			processData:true,
			dataType:"json",
			data:
			{
				id:id//
			},
			success:function(data)
			{
				//$("#ygfrxm").val(data.result.xm);//名称
				$("#ffrqtzzjgmc").val(data.result.jgmc);//机关名称
				$("#ffrqtzzjgxz").val(data.result.xzjgxz);//机关性质
				$("#ffrqtzzdbrxm").val(data.result.fddbrxm);//代表人姓名
				$("#ffrqtzzyb").val(data.result.yb);//邮编
				$("#ffrqtzzlxdh").val(data.result.lxdh);//联系电话
				$("#ffrqtzzdz").val(data.result.dz);//地址
				$("#ffrqtzzsjpc").val(data.result.sfpc);//涉及赔偿
				$("#ffrqtzzsffy").val(data.result.sffy);//是否复议
				$("#ffrqtzzdjzlb").val(data.result.djzlb);//登记证类别
				$("#ffrqtzzdjzh").val(data.result.djzh);//登记证号
				
				$("#ffrqtzzEditId").val(editFfrqtzzId);//编辑ID
				
				var top = ($(window).height() - $("#ffrqtzz").height())/2;
				var left = ($(window).width() - $("#ffrqtzz").width())/2;
				var scrollTop = $(document).scrollTop();
				var scrollLeft = $(document).scrollLeft();
				$("#ffrqtzz").css({position:'absolute',top:top+scrollTop,left:left+scrollLeft});
				$("#ffrqtzz").fadeIn("slow");
			},
			error:function(e)
			{
				alert("error");
			}
		});
	};
	
	
	deleteFfrqtzzInfo = function(self){
		var deleteFfrqtzzId = $(self).data("id");
		var id = "ffrqtzz" + deleteFfrqtzzId;
		$.ajax({
			type:'post',
			url:'../la/deleteFfrqtzz',
			cache:false,
			processData:true,
			dataType:"json",
			data:
			{
				id:id//
			},
			success:function(data)
			{
				$("#ffrqtzzInfo"+deleteFfrqtzzId).remove();
				ffrqtzzId--;
			},
			error:function(e)
			{
				alert("error");
			}
		});
	};
});



var validMaterial = false;

function uploadMaterial(){
	$.ajaxFileUpload({
		url:'../upload/material',
		secureuri:false,
		fileElementId:'material',
		dataType:"json",
		success:function(data, status)
		{
			var result = data.uploadResult;
			var filename = data.originalFilename;
			if(result=="success"){
				$("#fakeMaterial").val(filename);
				
				$("#validateMaterial").empty();
			    $("#validateMaterial").append('<img src="../images/valid.png" />');
			    $("#deleteFileDiv").css({"display":"block"});
				validMaterial = true;
			}
			else if(result=="fail"){
				$("#validateMaterial").text("上传失败").css({"color":"red"});
				validAttachment = false;
			}
			else if(result=="errorFormat"){
				$("#validateMaterial").text("文件格式错误").css({"color":"red"});
				validMaterial = false;
			}
		},
		error:function(data, e){
			alert("error");
		}
	});
}

function deleteFile(){
	$.ajax
	({
		type: 'post',
		url:'../upload/deleteFile',
		processData:true, 
		dataType:"json", //json--返回json数据类型     xml--返回xml
		data:
		{
			src:"LA"
		},
		success:function(data)
		{
			$("#fakeMaterial").val("");
			$("#validateMaterial").empty();
			$("#deleteFileDiv").css({"display":"none"});
		},
		error:function(e)
		{
		}
	});
}

var validAqsm = false;
var validLacxmm = false;
var validZcqrmm = false;
var validDzyj = false;
var validLxdh = false;
var validYzm = false;

$(function() {
	
	$("#aqsm").blur(function(){//案情说明
		var aqsm = $(this).val();
		if(!aqsm)
		{
		    $("#validateAqsm").text("请输入案情说明").css({"color":"red"});
		    validAqsm=false;
		}
		else{
			$("#validateAqsm").empty();
		    $("#validateAqsm").append('<img src="../images/valid.png" />');
		    validAqsm=true;
		}
	});
	
	$("#lacxmm").blur(function(){//校验密码
		var password=$(this).val();
		var charAndDigit = /^[_0-9a-zA-Z]*$/;
		if(!password){
			$("#validateLacxmm").text("请输入密码").css({"color":"red"});
			validLacxmm=false;
		}
		else if(password.length<5 || password.length>15 || !charAndDigit.test(password))
		{
		    $("#validateLacxmm").text("密码不符合规则").css({"color":"red"});
		    validLacxmm=false;
		}
		else{
			$("#validateLacxmm").empty();
		    $("#validateLacxmm").append('<img src="../images/valid.png" />');
		    validLacxmm=true;
		}
	});
	
	$("#zcqrmm").blur(function(){//确认密码
		var pwd = $("#lacxmm").val();
		if($(this).val()!=pwd)
		{
			$("#validateZcqrmm").text("两次输入的密码不一致").css({"color":"red"});
			validZcqrmm=false;
		}
		else
		{
			$("#validateZcqrmm").empty();
		    $("#validateZcqrmm").append('<img src="../images/valid.png" />');
		    validZcqrmm=true;
		}
	});
	
	$("#dzyj").blur(function(){//信访人电子邮件
    	var email = $(this).val();
        if(!email){
        	validDzyj=true;
        	return;
        }
    	if(email.search(/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/)==-1)
		{
		    $("#validateDzyj").text("请输入正确的邮箱地址").css({"color":"red"});
		    validDzyj=false;
		}
		else{
			$("#validateDzyj").empty();
		    $("#validateDzyj").append('<img src="../images/valid.png" />');
			validEmail=true;
		}
    });
	
	$("#lxdh").blur(function(){//联系电话
		var lxdh = $(this).val();
		if(!lxdh)
		{
			$("#validateLxdh").text("请输入联系电话").css({"color":"red"});
			validLxdh=false;
		}
		else
		{
			$("#validateLxdh").empty();
		    $("#validateLxdh").append('<img src="../images/valid.png" />');
		    validLxdh=true;
		}
	});
	
	$("#layzm").keyup(function(){
    	var code = $(this).val();
    	if(code.length==4){
    		jQuery.ajax
    		({
    			type: 'GET',
    			url:'../kaptcha/verify',
    			contentType:"application/json", //application/xml
    			processData:true, 
    			dataType:"json", //json--返回json数据类型     xml--返回xml
    			data:
    			{
    				code:code,
    				src:"la"
    			},
    			success:function(data)
    			{
    				if(data.result=="right"){
    					$("#validateLayzm").empty();
    				    $("#validateLayzm").append('<img src="../images/valid.png" />');
    					validKaptcha = true;
    				}
    				else if(data.result=="wrong"){
    					$("#validateLayzm").text("验证码错误").css({"color":"red"});
    					validKaptcha = false;
    				}
    			},
    			error:function(e)
    			{
    			}
    		});
    	}
    	/* else{
    		$("#validateKaptcha").text("验证码错误").css({"color":"red"});
    	} */
    });
	
	$("#finalSubmit").click(function(){
		if(validAqsm && validLacxmm && validZxqrm && validLxdh && validYzm){
			$('form').submit();
		}
		else{
			$("#validateAll").text("* 为必填项，请完善后再提交").css({"color":"red"});
			return false;
		}
	});
});

function changeCode(src)
{
	$('#kaptchaImage').hide().attr('src', '../kaptcha/image?src='+src).fadeIn();
	$("#validateLayzm").text("*").css({"color":"red"});
	event.cancelBubble = true;
};





