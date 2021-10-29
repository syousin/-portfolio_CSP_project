package csp.service;

import csp.DataBase.*;

public class User_Service {
	
	public boolean loginMsg(String user_id, String user_pwd) {
		return new User_DAO().login(user_id, user_pwd);
	}
	
	public boolean joinMsg(String user_id, String user_pwd, String user_name) {
		User_DTO user_dto = new User_DTO();
		
		user_dto.setUser_id(user_id);
		user_dto.setUser_pwd(user_pwd);
		user_dto.setUser_name(user_name);
		
		return new User_DAO().join(user_dto);
	}
	
	public boolean idchk_joinMsg(String user_id) {
		return new User_DAO().idchk(user_id);
	}
}
