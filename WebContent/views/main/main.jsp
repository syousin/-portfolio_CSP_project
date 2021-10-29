<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>메인페이지</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/clothing_store_theme.css" rel="stylesheet">
  </head>  
  <body class="pt-5">
	<jsp:include page="../navigation/navigation.jsp" flush="false"/>
  	<div class="image-box">
	<div class="container">
		<div class="logo">
			<img src="images/CSP_Logo_White.png">
		</div>
	</div>
	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">
				<div class="item active">
					<img src="images/CSP_Main_Slide_1.png" width="1280px" height="720px">
				</div>
				<div class="item">
					<img src="images/CSP_Main_Slide_2.png" width="1280px" height="720px">
				</div>
				<div class="item">
					<img src="images/CSP_Main_Slide_3.png" width="1280px" height="720px">
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="icon-prev"></span></a>
			<a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="icon-next"></span></a>
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
		</div>
	</div>
	<div class="container">
	 &nbsp;
	</div>
	</div>
	<div class="container">
		<table class="main_content">
			<tr>
				<td colspan="3"><h3><b>TEXT</b></h3></td>
			</tr>
			<tr>
				<td style="margin: 20px;"><img src="images/main_content_sample.png"></td>
				<td style="margin: 20px;"><img src="images/main_content_sample.png"></td>
				<td style="margin: 20px;"><img src="images/main_content_sample.png"></td>
			</tr>
			<tr>
				<td>TEXT</td>
				<td>TEXT</td>
				<td>TEXT</td>
			</tr>
		</table>
	</div>
	
	<jsp:include page="../footer/footer.jsp" flush="false"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>