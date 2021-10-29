package csp.DataBase;

import java.sql.*;

public class User_DAO extends CSP_JDBC {

	public User_DAO() {
		super();
	}
	
	public boolean login(String user_id, String user_pwd) {
		boolean loginCon = false;
		try (	
				Connection conn = dataSource.getConnection();
		        Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(String.format("select count(*) from clothing_store_user where user_id='%s' and user_pwd='%s';", user_id, user_pwd));
		) {
			if(rs.next() && rs.getInt(1)>0)
				loginCon = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return loginCon;
	}
	
	public boolean join(User_DTO user_dto) {
		boolean joinCon = false;
	    try (
	        Connection conn = dataSource.getConnection();
	        Statement stmt = conn.createStatement();
	    	ResultSet rs = stmt.executeQuery(String.format("select user_id from clothing_store_user where user_id='%s';", user_dto.getUser_id()));
	    ) {
	    	if(!rs.next()) {
		    	String query = String.format("insert into clothing_store_user (user_id, user_pwd, user_name) values ('%s', '%s', '%s');",
	 				   	   user_dto.getUser_id(),
	 				   	   user_dto.getUser_pwd(),
	 				   	   user_dto.getUser_name());
		    	stmt.executeUpdate(query);
		    	joinCon = true;
	    	}
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return joinCon;
	}
	
	public boolean idchk(String user_id) {
		boolean loginCon = false;
		try (	
				Connection conn = dataSource.getConnection();
		        Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(String.format("select user_id from clothing_store_user where user_id='%s';", user_id));
		) {
			if(rs.next())
				loginCon = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return loginCon;
	}
}
