function join_chk() {
	chk = true;
	
	if(document.join_form.user_name.value == "") {
		document.getElementById("user_name_null").style.display = "block";
		document.join_form.user_name.focus();
		chk = false;
	} else {
		document.getElementById("user_name_null").style.display = "none";
	}
		
	if(document.join_form.user_pwd.value == "" || document.join_form.user_pwd_chk.value == "" || document.join_form.user_pwd.value != document.join_form.user_pwd_chk.value) {
		document.getElementById("user_pwd_null").style.display = "block";
		document.join_form.user_pwd.focus();
		chk = false;
	} else {
		document.getElementById("user_pwd_null").style.display = "none";
	}
	
	if(document.join_form.user_id.value == "") {
		document.getElementById("user_id_null").style.display = "block";
		document.join_form.user_id.focus();
		chk = false;
	} else {
		document.getElementById("user_id_null").style.display = "none";
	}
	
	return chk;
}

function login_chk() {
	
	chk = true;

	if(document.login_form.user_pwd.value == "") {
		document.getElementById("user_pwd_null").style.display = "block";
		document.login_form.user_pwd.focus();
		chk = false;
	} else {
		document.getElementById("user_pwd_null").style.display = "none";
	}
	
	if(document.login_form.user_id.value == "") {
		document.getElementById("user_id_null").style.display = "block";
		document.login_form.user_id.focus();
		chk = false;
	} else {
		document.getElementById("user_id_null").style.display = "none";
	}
	
	return chk;
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

$("input[name=user_id]").blur(function() {
	// id = "id_reg" / name = "userId"
	var user_id = $('input[name=user_id]').val();
	$.ajax({
		url : 'test',
		type : 'get',
		success : function(data) {
			alert("성공4."+data);
			if (data == 1) {
					$("#id_check").text("사용중인 아이디입니다 :p");
					$("#id_check").css("color", "red");
					alert("zz.");
				} else {
					
				}
			}, error : function() {
					alert("실패.2");
			}
		});
	});