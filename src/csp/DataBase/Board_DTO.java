package csp.DataBase;

public class Board_DTO {
	private int board_num;
	private String board_title;
	private String board_content;
	private String user_id;
	private String board_date;
	private int board_reply_count;
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public int getBoard_reply_count() {
		return board_reply_count;
	}
	public void setBoard_reply_count(int board_reply_count) {
		this.board_reply_count = board_reply_count;
	}
}
