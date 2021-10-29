<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>글 수정</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/clothing_store_theme.css" rel="stylesheet">
  </head>  
  <body class="pt-5">
	<jsp:include page="../navigation/navigation.jsp" flush="false"/>
	<div class="container">
	 <div class="main_content">
	 <form action="board_update_action" method="get">
	 	<div class="board_title"><h3><b>글 수정</b></h3></div>
	 	<div><input class="form-control" type="text" name="update_title" maxlength="50" placeholder="제목을 입력하세요" onkeyup="update_chk()" value="${onemsg.board_title}"></div>
	 	<div><textarea class="form-control" name="update_content" maxlength="2048" style="resize: none; height: 350px; margin: 10px 0px 10px 0px;" placeholder="내용을 입력하세요" onkeyup="update_chk()">${onemsg.board_content}</textarea></div>
	 	<div>
	 		<input type="hidden" name="update_num" value="${onemsg.board_num}">
	 		<input type="hidden" name="user_id" value="${onemsg.user_id}">
	 		<input type="submit" class="btn btn-info pull-right" id="update_submit" disabled="true" value="수정">
	 	</div>
	 </form>
	 </div>
	</div>
	<jsp:include page="../footer/footer.jsp" flush="false"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/js_action/board/board_action.js" charset="utf-8"></script>
  </body>
</html>