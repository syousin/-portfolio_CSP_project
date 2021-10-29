<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${onemsg.board_title}</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/clothing_store_theme.css" rel="stylesheet">
  </head>  
  <body class="pt-5">
	<jsp:include page="../navigation/navigation.jsp" flush="false"/>
	<div class="container">
	 <div class="main_content">
	 	<div class="board_title"><h3><b>자유게시판</b></h3></div>
	 	<table class="board_view_table">
	 		<thead>
	 			<tr>
	 				<th style="text-align: left;" colspan="2">${onemsg.board_title}</th>
	 			</tr>
	 		</thead>
	 		<tbody>
	 			<tr>
	 				<td style="text-align: left;"><b>작성자</b> ${onemsg.user_id}</td>
	 				<td style="text-align: right;"><b>작성일</b> ${onemsg.board_date}</td>
	 			</tr>
	 			<tr>
	 				<td style="text-align: left;" colspan="2">${fn:replace(onemsg.board_content, cn, br)}</td>
	 			</tr>
	 		</tbody>
	 	</table>
	 	<div class="board_view_div_reply">
			<h3>댓글 ${onemsg.board_reply_count}</h3>
	 		<c:choose>
	 			 <c:when test="${idKey eq null}">
			 		<div class="input-group pull-right">
			 			<textarea class="form-control" maxlength="2048" style="resize: none; height: 100px; margin: 10px 0px 10px 0px;" placeholder="로그인을 해주세요" onclick="click_login()" readonly></textarea>
			 			<span class="input-group-btn">
			 				<input type="button" class="btn btn-secondary" value="작성" style="width:100px; height: 100px;" onclick="click_login()">
			 			</span>
			 		</div>
			 	</c:when>
	 			<c:when test="${idKey ne null}">
	 				<form action="board_reply_write_action" method="get">
			 		<div class="input-group pull-right">
			 				<textarea class="form-control" name="reply_write_content" maxlength="2048" style="resize: none; height: 100px; margin: 10px 0px 10px 0px;" placeholder="댓글을 입력해주세요"></textarea>
			 			<span class="input-group-btn">
			 					<input type="hidden" name="board_num" value="${onemsg.board_num}">
			 					<input type="submit" class="btn btn-secondary" value="작성" style="width:100px; height: 100px;" onclick="return reply_chk();">
			 			</span>
			 		</div>
			 		</form>
	 			</c:when>
	 		</c:choose>
	 	</div> 
	 	<table class="board_view_table_reply">
	 		<tbody>
	 			<c:forEach var="reply_listmsg" items="${reply_listmsg}" varStatus="status">
	 			<tr>
	 				<td class="reply_img"><img src="images/main_content_sample.png"></td>
	 				<td class="reply_content">
	 					<h4>${reply_listmsg.user_id}</h4>
	 					${fn:replace(reply_listmsg.reply_content, cn, br)}<br>
						<font color="#dedede">${reply_listmsg.reply_date}</font>
					<c:if test="${reply_listmsg.user_id eq idKey}">
						<a href="board_reply_delete_action?board_num=${onemsg.board_num}&reply_num=${reply_listmsg.reply_num}&user_id=${reply_listmsg.user_id}" class="reply_cursor">삭제</a>
						</c:if>
	 				</td>
	 			</tr>
	 			<c:if test="${status.last eq false}">
	 			<tr>
	 				<td colspan="2"><hr></td>
	 			</tr>
	 			</c:if>
	 			</c:forEach>
	 		</tbody>
	 	</table>
	 	<c:if test="${replycount ne 0}">
	 	<div class="board_content">
	 		<c:if test="${pagingmsg.curpage ne pagingmsg.curpage_start}">
					<a href="board_view?board_num=${onemsg.board_num}&curpage=${pagingmsg.block_begin - 1}">이전</a>
			</c:if>
	 		<c:forEach var="i" begin="${pagingmsg.block_begin}" end="${pagingmsg.block_end}">
						<a href="board_view?board_num=${onemsg.board_num}&curpage=${i}"><b>${i}</b></a>
	 		</c:forEach>
	 		<c:if test="${pagingmsg.curpage ne pagingmsg.curpage_last}">
					<a href="board_view?board_num=${onemsg.board_num}&curpage=${pagingmsg.block_end + 1}">다음</a>
			</c:if>
	 	</div>
	 	</c:if>
	 	<div>
	 		<a href="board_main" class="btn btn-primary pull-right" style="margin: 10px 30px 10px 0px;">목록</a>
	 		<c:if test="${idKey eq onemsg.user_id}">
	 			<input type="button" class="btn btn-primary pull-right" style="margin: 10px 5px 0px 0px" value="수정" onclick="board_update(${onemsg.board_num}, '${onemsg.user_id}');">
	 			<input type="button" class="btn btn-primary pull-right" style="margin: 10px 5px 0px 0px" value="삭제" onclick="board_delete_msgbox(${onemsg.board_num}, '${onemsg.user_id}');">
	 		</c:if>
	 	</div>
	 </div>
	</div>
	<jsp:include page="../footer/footer.jsp" flush="false"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/js_action/board/board_action.js" charset="utf-8"></script>
    <script src="js/js_action/click_action.js" charset="utf-8"></script>
  </body>
</html>