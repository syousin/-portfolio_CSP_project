var id_bool = false;
var pwd_bool = false;
var pwd_con_bool = false;
var name_bool = false;

function len(user_id) {
	var chk = true;
	
	if(user_id.length < 4 || user_id.length > 13) {
		chk = false;
	}
	
	return chk;
}

function id_chk() {
	var user_id = $("input[name=user_id]").val();
	$.ajax({
		url : 'join_id_check?user_id=' + user_id,
		type : 'get',
		success : function(data) {
			if (data == 1) {
					$("#id_warning").text("사용할 수 없는 아이디 입니다.");
					$("#id_warning").css("color", "red");		
					id_bool = false;
				} else {
					if(len(user_id)) {
						$("#id_warning").text("사용 가능한 아이디입니다.");
						$("#id_warning").css("color", "blue");
						id_bool = true;
					} else if(user_id == "") {
						$("#id_warning").text("아이디를 입력해주세요.");						
						$("#id_warning").css("color", "red");
						id_bool = false;
					} else {
						$("#id_warning").text("4~12자 영문 대 소문자, 숫자를 사용하세요.");						
						$("#id_warning").css("color", "red");
						id_bool = false;
					}
				} 
			}, error : function() {
					alert("오류가 발생했습니다.");
			}
		});
}

function pwd_chk() {
	var user_pwd = $("input[name=user_pwd]").val();
	var user_pwd_con = $("input[name=user_pwd_con]").val();
	
	if(len(user_pwd)) {
		$("#pwd_warning").text("사용가능한 비밀번호 입니다.");
		$("#pwd_warning").css("color", "blue");
		pwd_bool = true;
	} else if(user_pwd == "") {
		$("#pwd_warning").text("비밀번호를 입력해주세요.");
		$("#pwd_warning").css("color", "red");
		pwd_bool = false;
	} else {
		$("#pwd_warning").text("4~12자 영문 대 소문자, 숫자, 특수문자를 사용하세요.");
		$("#pwd_warning").css("color", "red");
		pwd_bool = false;
	}
	
	if(user_pwd_con != "") {
		pwd_con_chk();
	}
}

function pwd_con_chk() {
	var user_pwd = $("input[name=user_pwd]").val();
	var user_pwd_con = $("input[name=user_pwd_con]").val();
	
	if(user_pwd == user_pwd_con) {
		$("#pwd_con_warning").text("비밀번호가 서로 일치합니다.");
		$("#pwd_con_warning").css("color", "blue");
		pwd_con_bool = true;
	} else if(user_pwd_con == "") {
		$("#pwd_con_warning").text("");
		pwd_con_bool = false;
	} else {
		$("#pwd_con_warning").text("비밀번호가 서로 다릅니다.");
		$("#pwd_con_warning").css("color", "red");
		pwd_con_bool = false;
	}
}

function name_chk() {
	var user_name = $("input[name=user_name]").val();
	
	if(user_name == "") {
		$("#name_warning").text("이름을 입력해주세요.");
		$("#name_warning").css("color", "red");
		name_bool = false;
	} else {
		$("#name_warning").text("");
		name_bool = true;
	}
}

function join() {
	var user_id = $("input[name=user_id]").val();
	var user_pwd = $("input[name=user_pwd]").val();
	var user_pwd_con = $("input[name=user_pwd_con]").val();
	var user_name = $("input[name=user_name]").val();
	var join_bool = true;
	
	if(!name_bool) {
		$("input[name=user_name]").focus();
		name_chk();
		join_bool = false;
	}
	
	if(!pwd_bool) {
		$("input[name=user_pwd]").focus();
		pwd_chk();
		join_bool = false;
	} else if(!pwd_con_bool) {
		$("input[name=user_pwd_con]").focus();
		pwd_con_chk();
		join_bool = false;
	}
	
	if(!id_bool) {
		$("input[name=user_id]").focus();
		id_chk();
		join_bool = false;
	}
	
	return join_bool;
}