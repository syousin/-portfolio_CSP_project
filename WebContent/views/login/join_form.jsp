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
    <title>회원가입</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/clothing_store_theme.css" rel="stylesheet">
  </head>
  <body>
  	<div class="join_form">
  		<form action="join_action" method="post" name="join_form">
	  	<div class="join_form_logo">
			<a href="main"><img src="images/CSP_Logo_Black.png"></a>
		</div>
		<div>
			<input class="form-control" type="text" name="user_id" maxLength="20" placeholder="아이디" onkeyup="id_chk();">
		</div>
		<div id="id_warning"></div>
		<div>
			<input class="form-control" type="password" name="user_pwd" maxLength="20" placeholder="비밀번호" onkeyup="pwd_chk();">
		</div>
		<div id="pwd_warning"></div>
		<div>
			<input class="form-control" type="password" name="user_pwd_con" maxLength="20" placeholder="비밀번호 확인" onkeyup="pwd_con_chk();">
		</div>
		<div id="pwd_con_warning"></div>
		<div>
			<input class="form-control" type="text" name="user_name" maxLength="20" placeholder="이름" onkeyup="name_chk();">
		</div>
		<div id="name_warning"></div>
		<div>
			<input type="submit" class="btn btn-info pull" value="회원가입" onclick="return join();">
		</div>
		</form>
  	</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/js_action/login/join_action.js" charset="utf-8"></script>
  </body>
</html>