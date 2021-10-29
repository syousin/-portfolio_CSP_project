<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main">CSP</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#">menu1</a></li>
				<li><a href="#">menu2</a></li>
				<li><a href="#">menu3</a></li>
				<li><a href="board_main">자유게시판</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
			<c:choose>
				<c:when test="${idKey eq null}">
					<li><a href="login_form">로그인</a></li>
				</c:when>
				<c:when test="${idKey ne null}">
					<li><a>${idKey}</a></li>
					<li><a href="logout_action">로그아웃</a></li>
				</c:when>
			</c:choose>
			</ul>
		</div>
	</div>
</nav>