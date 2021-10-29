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
    <title>자유게시판</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/clothing_store_theme.css" rel="stylesheet">
  </head>
  <body class="pt-5">
	<jsp:include page="../navigation/navigation.jsp" flush="false"/>
	<div class="container">
	 <div class="main_content">
	 	<div class="board_title"><h3><b>자유게시판</b></h3></div>
	 	<div class="input-group pull-right" style="width: 20%; margin: 0px 30px 20px 30px;">
	 		<input type="text" class="form-control" name="search_keyword">
  			<span class="input-group-btn">
    			<input type="button" class="btn btn-secondary" value="검색" onclick="board_search_action()">
  			</span>
	 	</div>
	 	<table class="board_table" id="test">
	 		<thead>
	 			<tr>
	 				<th style="width: 10%;">번호</th>
	 				<th style="width: 50%; text-align: left;">제목</th>
	 				<th style="width: 20%;">작성자</th>
	 				<th style="width: 20%;">작성일</th>
	 			</tr>
	 		</thead>
	 		<tbody>
	 			<c:choose>
	 				<c:when test="${boardcount eq 0}">
	 					<tr>
	 						<td colspan="4">현재 혹은 검색하신 게시글이 없습니다</td>
	 					</tr>
	 				</c:when>
	 				<c:when test="${boardcount ne 0}">
			 			<c:forEach var="listmsg" items="${listmsg}">
			 			<tr class="board_cursor" onclick="location.href='board_view?board_num=${listmsg.board_num}'">
			 				<td>${listmsg.board_num}</td>
			 				<td style="text-align: left;">${listmsg.board_title} <c:if test="${listmsg.board_reply_count ne 0}"><font color="#dedede">[${listmsg.board_reply_count}]</font></c:if></td>
			 				<td>${listmsg.user_id}</td>
			 				<td>${listmsg.board_date}</td>
			 			</tr>
			 			</c:forEach>
	 				</c:when>
	 			</c:choose>
	 		</tbody>
	 	</table>
	 	<c:if test="${boardcount ne 0}">
	 	<div class="board_content">
	 		<c:if test="${pagingmsg.curpage ne pagingmsg.curpage_start}">
	 		<c:choose>
				<c:when test="${keyword eq null}">
					<a href="board_main?curpage=${pagingmsg.block_begin - 1}">이전</a>
				</c:when>
				<c:when test="${keyword ne null}">
					<a href="board_main?keyword=${keyword}&curpage=${pagingmsg.block_begin - 1}"><b>이전</b></a>
				</c:when>
			</c:choose>
			</c:if>
	 		<c:forEach var="i" begin="${pagingmsg.block_begin}" end="${pagingmsg.block_end}">
				<c:choose>
					<c:when test="${keyword eq null}">
						<a href="board_main?curpage=${i}"><b>${i}</b></a>
					</c:when>
					<c:when test="${keyword ne null}">
						<a href="board_main?keyword=${keyword}&curpage=${i}"><b>${i}</b></a>
					</c:when>
				</c:choose>
	 		</c:forEach>
	 		<c:if test="${pagingmsg.curpage ne pagingmsg.curpage_last}">
	 		<c:choose>
				<c:when test="${keyword eq null}">
					<a href="board_main?curpage=${pagingmsg.block_end + 1}">다음</a>
				</c:when>
				<c:when test="${keyword ne null}">
					<a href="board_main?keyword=${keyword}&curpage=${pagingmsg.block_end + 1}"><b>다음</b></a>
				</c:when>
			</c:choose>
			</c:if>
	 	</div>
	 	</c:if>
		<div>
			<a href="board_write_form" class="btn btn-primary pull-right" style="margin: 10px 30px 10px 30px;">글쓰기</a>
	 	</div>
	 </div>
	</div>
	<jsp:include page="../footer/footer.jsp" flush="false"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/js_action/board/board_action.js" charset="utf-8"></script>
  </body>
</html>