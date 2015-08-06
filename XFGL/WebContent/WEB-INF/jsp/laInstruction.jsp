<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap-theme.min.css">
<link href="../fonts/glyphicons-halflings-regular.eot">
<link href="../fonts/glyphicons-halflings-regular.svg">
<link href="../fonts/glyphicons-halflings-regular.ttf">
<link href="../fonts/glyphicons-halflings-regular.woff">

<link rel="stylesheet" type="text/css" href="../css/laInstruction.css">

<script type="text/javascript" src="../js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>

<title>La Instruction</title>
</head>
<body>
	<jsp:include page="laHeader.jsp" />

	<div id="noticeNavigation">
		<img src="" style="float: left" /> <font size="4px"><b>请仔细阅读以下预立案须知</b></font>
	</div>
	<br />

	<div id="banner">
		<div id="carousel-example-generic" class="carousel slide">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li id="0" class="active"></li>
				<li id="1"></li>
				<li id="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active" id="div0">
					<img src="../images/fengjing01.jpg" alt="First slide" id="img0">
					<div class="carousel-caption">
					    <h3>First slide</h3>
					    <p>Hello World</p>
					</div>
				</div>
				<div class="item" id="div1">
					<img src="../images/fengjing02.jpg" alt="Second slide" id="img1">
					<div class="carousel-caption">
					    <h3>Second slide</h3>
					    <p>Nice to meet you</p>
					</div>
				</div>
				<div class="item" id="div2">
				    <img src="../images/fengjing03.jpg" alt="Third slide" id="img2">
				    <div class="carousel-caption">
				        <h3>Third slide</h3>
				        <p>Bye bye</p>
				    </div>
				</div>
			</div>

			<!-- Controls -->
			<a id="leftA" class="left carousel-control" href="#carousel-example-generic"> 
			    <span class="glyphicon glyphicon-chevron-left"></span>
			</a> 
			<a id="rightA" class="right carousel-control" href="#carousel-example-generic"> 
			    <span class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>

	</div>

	<br />
	<div id="laNotice_button">
		<button id="confirm" type="button" class="btn btn-lg">确定</button>
	</div>

	<jsp:include page="laFooter.jsp" />
</body>

<script type="text/javascript">
	$(document).ready(function() {
		$("#confirm").click(function() {
			window.location.href = "../la/zxyla";
		});
	});
</script>
<script type="text/javascript">
$('.carousel').carousel({
	interval: 10000
});

var imgCount = 3;
var index = 0;

$("#leftA").click(function(){
	index--;
	if(index<0){
		index = imgCount-1;
	}
	change(index);	
});
$("#rightA").click(function(){
	index++;
	if(index>imgCount-1){
		index=0;
	}
	change(index);
});

function change(index){
	$(".item").removeClass('active');
	$("#div"+index).addClass('active');
	/* $("#div"+index).siblings().animate({
		opacity:0
	},1000);
	$("#div"+index).animate({
		opacity:1
	},1000); */
	//$("#div"+index).siblings().fadeIn('slow');
	//$("#div"+index).fadeOut('slow');
}
</script>

</html>