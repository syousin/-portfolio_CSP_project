<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>페이지를 찾을 수 없습니다.</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/clothing_store_theme.css" rel="stylesheet">
  </head>
  <body class="pt-5">
	<jsp:include page="../navigation/navigation.jsp" flush="false"/>
	<div class="container">
		<div class="main_content">
			<br/><br/><h1>페이지를 찾을 수 없습니다.</h1><br/>
			<input type="button" class="btn btn-primary" value="메인으로가기" onclick="click_main()">
		</div>
	</div>
	<jsp:include page="../footer/footer.jsp" flush="false"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/js_action/click_action.js" charset="utf-8"></script>
  </body>
</html>