function login() {
	var user_id = $("input[name=user_id]").val();
	var user_pwd = $("input[name=user_pwd]").val();
	
	$.ajax({
		url : 'login_action?user_id=' + user_id + '&user_pwd=' + user_pwd,
		type : 'get',
		success : function(data) {
			if (data == 1) {
					$("#login_warning").text("아이디 혹은 비밀번호를 확인해주세요.");
					$("#login_warning").css("color", "red");
				} else {
					 location.href = "main";
				} 
			}, error : function() {
					alert("오류가 발생했습니다.");
			}
		});
}
