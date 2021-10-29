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
    <title>로그인</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/clothing_store_theme.css" rel="stylesheet">
  </head>
  <body>
  	<div class="login_form">
  		<form action="login_action" method="post" name="login_form">
	  	<div class="login_form_logo">
			<a href="main"><img src="images/CSP_Logo_Black.png"></a>
		</div>
		<div>
			<input class="form-control" type="text" name="user_id" maxLength="20" placeholder="아이디">
		</div>
		<div>
			<input class="form-control" type="password" name="user_pwd" maxLength="20" placeholder="비밀번호">
		</div>
		<div>
			<a href="#">아이디 찾기</a>
			&nbsp;|&nbsp;
			<a href="#">비밀번호 찾기</a>
			&nbsp;|&nbsp;
			<a href="join_form">회원가입</a>
		</div>
		<div id="login_warning"></div>
		<div>
			<input type="button" class="btn btn-info pull" value="로그인" onclick="login();">
		</div>
		</form>
  	</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/js_action/login/login_action.js" charset="utf-8"></script>
  </body>
</html>