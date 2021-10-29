package csp.DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Board_DAO extends CSP_JDBC {

	public Board_DAO() {
		super();
	}
	
	public ArrayList<Board_DTO> selectList(int curpage, int paging_size) {
		ArrayList<Board_DTO> board_list = new ArrayList<Board_DTO>();
	    try ( 
	        Connection conn = dataSource.getConnection();
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from clothing_store_board order by board_num desc limit " + curpage + ", " + paging_size);
	    ) { 
	        while(rs.next()){
	        	Board_DTO board_dto = new Board_DTO();
	        	board_dto.setBoard_num(rs.getInt("board_num"));
	        	board_dto.setBoard_title(rs.getString("board_title"));
	        	board_dto.setBoard_content(rs.getString("board_content"));
	        	board_dto.setUser_id(rs.getString("user_id"));
	        	board_dto.setBoard_date(rs.getString("board_date"));
	        	board_dto.setBoard_reply_count(rs.getInt("board_reply_count"));
	        	
	        	board_list.add(board_dto);
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }    
	    return board_list;
	}
	
	public ArrayList<Board_DTO> selectList(int curpage, int paging_size, String keyword) {
		ArrayList<Board_DTO> board_list = new ArrayList<Board_DTO>();
	    try ( 
	        Connection conn = dataSource.getConnection();
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from clothing_store_board where board_title like '%" + keyword +  "%' order by board_num desc limit " + curpage + ", " + paging_size);
	    ) { 
	        while(rs.next()){
	        	Board_DTO board_dto = new Board_DTO();
	        	board_dto.setBoard_num(rs.getInt("board_num"));
	        	board_dto.setBoard_title(rs.getString("board_title"));
	        	board_dto.setBoard_content(rs.getString("board_content"));
	        	board_dto.setUser_id(rs.getString("user_id"));
	        	board_dto.setBoard_date(rs.getString("board_date"));
	        	board_dto.setBoard_reply_count(rs.getInt("board_reply_count"));
	        	
	        	board_list.add(board_dto);
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }    
	    return board_list;
	}
	
	public Board_DTO selectOne(int board_num) {
    	Board_DTO board_dto = new Board_DTO();
	    try ( 
	        Connection conn = dataSource.getConnection();
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from clothing_store_board where board_num=" + board_num);
	    ) { 
	        if(rs.next()){
	        	board_dto.setBoard_num(rs.getInt("board_num"));
	        	board_dto.setBoard_title(rs.getString("board_title"));
	        	board_dto.setBoard_content(rs.getString("board_content"));
	        	board_dto.setUser_id(rs.getString("user_id"));
	        	board_dto.setBoard_date(rs.getString("board_date"));
	        	board_dto.setBoard_reply_count(rs.getInt("board_reply_count"));
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }    
	    return board_dto;
	}
	
	public int getCount() {
		int rsCount = 0; 
		try ( 
		        Connection conn = dataSource.getConnection();
		        Statement stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery("select count(*) from clothing_store_board");
		    ) { 
		        if(rs.next()){
		        	rsCount = rs.getInt(1);
		        }
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		    return rsCount;
	}
	
	public int getCount(String keyword) {
		int rsCount = 0; 
		try ( 
		        Connection conn = dataSource.getConnection();
		        Statement stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery("select count(*) from clothing_store_board where board_title like '%" + keyword +  "%'");
		    ) { 
		        if(rs.next()){
		        	rsCount = rs.getInt(1);
		        }
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		    return rsCount;
	}
	
	public void write(Board_DTO board_dto) {
		try (	
				Connection conn = dataSource.getConnection();
		        Statement stmt = conn.createStatement();
		) {
	    	String query = String.format("insert into clothing_store_board (board_title, board_content, user_id, board_date) values ('%s', '%s', '%s', '%s')",
   				 board_dto.getBoard_title(),
   				 board_dto.getBoard_content(),
   				 board_dto.getUser_id(),
   				 board_dto.getBoard_date());
	    	stmt.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Board_DTO board_dto) {
		try (	
				Connection conn = dataSource.getConnection();
		        Statement stmt = conn.createStatement();
		) {
	    	String query = String.format("update clothing_store_board set board_title='%s', board_content='%s' where board_num=%s",
   				 board_dto.getBoard_title(),
   				 board_dto.getBoard_content(),
   				 board_dto.getBoard_num());
	    	stmt.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int board_num) {
		try (	
				Connection conn = dataSource.getConnection();
		        Statement stmt = conn.createStatement();
		) {
	    	String query = String.format("delete from clothing_store_board where board_num=" + board_num);
	    	stmt.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void board_reply_count(int board_num) {
		try (	
				Connection conn = dataSource.getConnection();
		        Statement stmt = conn.createStatement();
		) {
	    	String query = String.format("update clothing_store_board set board_reply_count=(select count(*) from clothing_store_board_reply where board_num=" + board_num + ") where board_num=" + board_num);
	    	stmt.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
