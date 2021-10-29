package csp.DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Board_Reply_DAO extends CSP_JDBC {
	
	public Board_Reply_DAO() {
		super();
	}
	
	public ArrayList<Board_Reply_DTO> reply_selectList(int board_num, int curPage, int paging_size) {
		ArrayList<Board_Reply_DTO> board_reply_list = new ArrayList<Board_Reply_DTO>();
	    try ( 
	        Connection conn = dataSource.getConnection();
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from clothing_store_board_reply where board_num=" + board_num + " order by reply_num desc limit " + curPage +  ", "  + paging_size);
	    ) { 
	        while(rs.next()){
	        	Board_Reply_DTO board_reply_dto = new Board_Reply_DTO();
	        	board_reply_dto.setReply_num(rs.getInt("reply_num"));
	        	board_reply_dto.setBoard_num(rs.getInt("board_num"));
	        	board_reply_dto.setUser_id(rs.getString("user_id"));
	        	board_reply_dto.setReply_content(rs.getString("reply_content"));
	        	board_reply_dto.setReply_date(rs.getString("reply_date"));
	        	
	        	board_reply_list.add(board_reply_dto);
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }    
	    return board_reply_list;
	}
	
	public void reply_write(Board_Reply_DTO board_reply_dto) {
		try (
				Connection conn = dataSource.getConnection();
		        Statement stmt = conn.createStatement();
		) {
	    	String query = String.format("insert into clothing_store_board_reply (board_num, user_id, reply_content, reply_date) values (%s, '%s', '%s', '%s')",
	    		 board_reply_dto.getBoard_num(),
	    		 board_reply_dto.getUser_id(),
	    		 board_reply_dto.getReply_content(),
	    		 board_reply_dto.getReply_date());
	    	stmt.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reply_delete(int board_num, int reply_num) {
		try (	
				Connection conn = dataSource.getConnection();
		        Statement stmt = conn.createStatement();
		) {
	    	String query = String.format("delete from clothing_store_board_reply where board_num=" + board_num + " and reply_num=" + reply_num);
	    	stmt.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int reply_getCount(int board_num) {
		int rsCount = 0;
		try ( 
		        Connection conn = dataSource.getConnection();
		        Statement stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery("select board_reply_count from clothing_store_board where board_num=" + board_num);
		    ) { 
		        if(rs.next()){
		        	rsCount = rs.getInt(1);
		        }
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		    return rsCount;
	}
}
