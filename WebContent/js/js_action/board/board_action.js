function board_search_action() {
	var search_keyword = $('input[name=search_keyword]').val();
	
	location.href = "board_main?keyword=" + search_keyword;
}

function board_update(board_num, user_id) {
	location.href = "board_update_form?board_num=" + board_num + "&user_id=" + user_id;
}

function board_delete_msgbox(board_num, user_id) {
	var msgbox = confirm("삭제된 게시물은 복수 할 수 없습니다. 점말로 삭제하시겠습니까?");
	if(msgbox == true) {
		location.href = "board_delete_action?board_num=" + board_num + "&user_id=" + user_id;
	}
}

function write_chk() {
	var write_title = $('input[name=write_title]').val();
	var write_title_length = write_title.toString().length;
	var write_content = $('textarea[name=write_content]').val();
	var write_content_length = write_content.toString().length;
	
	if(write_title_length == 0 || write_content_length == 0) {
	  $('#write_submit').attr('disabled', true);
	} else {
	  $('#write_submit').attr('disabled', false);
	}
}

function update_chk() {
	var update_title = $('input[name=update_title]').val();
	var update_title_length = update_title.toString().length;
	var update_content = $('textarea[name=update_content]').val();
	var update_content_length = update_content.toString().length;
	
	if(update_title_length == 0 || update_content_length == 0) {
	  $('#update_submit').attr('disabled', true);
	} else {
	  $('#update_submit').attr('disabled', false);
	}
}

function reply_chk() {
	var reply_write_content = $('textarea[name=reply_write_content]').val();
	var reply_chk = true;
	
	if(!reply_write_content) {
		alert("댓글을 입력해주세요.");
		reply_chk = false;
	}
	
	return reply_chk;
}