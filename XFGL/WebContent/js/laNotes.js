/**
 * 
 */
$(document).ready(function() {
	$("#confirm").click(function() {
		window.location.href = "../la/zxyla";
	});
});

/*$(function(){

	var aPage = $('#laNotesBody .page a');		//分页按钮
	var aImg = $('#laNotesBody .box img');		//图像集合
	var iSize = aImg.size();		//图像个数
	var index = 0;		//切换索引
	//var t;
	$('#btnLeft').click(function(){		//左边按钮点击
		index--;
		if(index<0){
			index=iSize-1;
		}
		change(index);
	});
	$('#btnRight').click(function(){    //右边按钮点击
		index++;
		if(index>iSize-1){
			index=0;
		}
		change(index);
	});
	//分页按钮点击
	aPage.click(function(){
		index = $(this).index();
		change(index);
	});
	//切换过程
	function change(index){
		aPage.removeClass('active');
		aPage.eq(index).addClass('active');
		aImg.stop();
		//隐藏除了当前元素，所以图像
		aImg.eq(index).siblings().animate({
			opacity:0
		},1000);
		//显示当前图像
		aImg.eq(index).animate({
			opacity:1
		},1000);
	}

	 
	function autoshow() {
		index=index+1;
		if(index<=iSize-1){
		   change(index);
		}else{
			index=0;
			change(index);
		}
			
	}
	int=setInterval(autoshow,5000);
	function clearInt() {
		$('#btnLeft,#btnRight,.page a').mouseover(function() {
			clearInterval(int);
		});
	
	}
	function setInt() {
		$('#btnLeft,#btnRight,.page a').mouseout(function() {
			int=setInterval(autoshow,5000);
		});
	}
	clearInt();
	setInt();
});*/

$(function(){

	var aPage = $('#laNotesBody .page a');		//分页按钮
	var aImg = $('#laNotesBody .box .content');		//图像集合
	var iSize = aImg.size();		//图像个数
	var index = 0;		//切换索引
	//var t;
	$('#btnLeft').click(function(){		//左边按钮点击
		index--;
		if(index<0){
			index=iSize-1;
		}
		change(index);
	});
	$('#btnRight').click(function(){    //右边按钮点击
		index++;
		if(index>iSize-1){
			index=0;
		}
		change(index);
	});
	//分页按钮点击
	aPage.click(function(){
		index = $(this).index();
		change(index);
	});
	//切换过程
	function change(index){
		aPage.removeClass('active');
		aPage.eq(index).addClass('active');
		aImg.stop();
		//隐藏除了当前元素，所以图像
		aImg.eq(index).siblings().animate({
			opacity:0
		},1000);
		//显示当前图像
		aImg.eq(index).animate({
			opacity:1
		},1000);
		aImg.eq(index).siblings().hide();
		aImg.eq(index).show();
		//aImg.eq(index).fadeOut("slow");
		//aImg.eq(index).siblings().fadeIn("slow");
		//aImg.eq(index).fadeOut("slow");
	}

	 
	function autoshow() {
		index=index+1;
		if(index<=iSize-1){
		   change(index);
		}else{
			index=0;
			change(index);
		}
			
	}
	int=setInterval(autoshow,60000);
	function clearInt() {
		$('#btnLeft,#btnRight,.page a').mouseover(function() {
			clearInterval(int);
		});
	
	}
	function setInt() {
		$('#btnLeft,#btnRight,.page a').mouseout(function() {
			int=setInterval(autoshow,6000);
		});
	}
	clearInt();
	setInt();
});