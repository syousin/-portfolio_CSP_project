package csp.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import csp.DataBase.*;

public class Board_Service {
	
	public ArrayList<Board_DTO> ListMsg(int curPage, int paging_size) {
		return new Board_DAO().selectList(curPage, paging_size);
	}
	
	public ArrayList<Board_DTO> ListMsg(int curPage, int paging_size, String keyword) {
		return new Board_DAO().selectList(curPage, paging_size, keyword);
	}
	
	public Board_DTO getOneMsg(int board_num) {
		return new Board_DAO().selectOne(board_num);
	}
	
	public void writeMsg(String board_title, String board_content, String user_id) {
		Board_DTO board_dto = new Board_DTO();
		
		board_dto.setBoard_title(board_title);
		board_dto.setBoard_content(board_content);
		board_dto.setUser_id(user_id);
		board_dto.setBoard_date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		
		new Board_DAO().write(board_dto);
	}
	
	public Board_Service_Paging paging(int curpage, int paging_size, int block_size) {
		Board_Service_Paging paging_service = new Board_Service_Paging();
		
		paging_service.setCurpage((curpage - 1) / block_size + 1);
		paging_service.setCurpage_total((new Board_DAO().getCount() - 1) / paging_size + 1);
		paging_service.setCurpage_start(1);
		paging_service.setCurpage_last((paging_service.getCurpage_total() - 1) / block_size + 1);
		paging_service.setBlock_begin(block_size * (paging_service.getCurpage() - 1) + 1);
		
		if(paging_service.getCurpage_total() < block_size * paging_service.getCurpage())
			paging_service.setBlock_end(paging_service.getCurpage_total());
		else
			paging_service.setBlock_end(block_size * paging_service.getCurpage());
		
		return paging_service;
	}
	
	public Board_Service_Paging paging(int curpage, int paging_size, int block_size, String keyword) {
		Board_Service_Paging paging_service = new Board_Service_Paging();
		
		paging_service.setCurpage((curpage - 1) / block_size + 1);
		paging_service.setCurpage_total((new Board_DAO().getCount(keyword) - 1) / paging_size + 1);
		paging_service.setCurpage_start(1);
		paging_service.setCurpage_last((paging_service.getCurpage_total() - 1) / block_size + 1);
		paging_service.setBlock_begin(block_size * (paging_service.getCurpage() - 1) + 1);
		
		if(paging_service.getCurpage_total() < block_size * paging_service.getCurpage())
			paging_service.setBlock_end(paging_service.getCurpage_total());
		else
			paging_service.setBlock_end(block_size * paging_service.getCurpage());
		
		return paging_service;
	}
	
	public void updateMsg(String board_title, String board_content, int board_num) {
		Board_DTO board_dto = new Board_DTO();
		
		board_dto.setBoard_title(board_title);
		board_dto.setBoard_content(board_content);
		board_dto.setBoard_num(board_num);
		
		new Board_DAO().update(board_dto);
	}
	
	public void deleteMsg(int board_num) {		
		new Board_DAO().delete(board_num);
	}
	
	public int countMsg() {
		return new Board_DAO().getCount();
	}
	
	public int countMsg(String keyword) {
		return new Board_DAO().getCount(keyword);
	}
	
	public ArrayList<Board_Reply_DTO> reply_ListMsg(int board_num, int curpage, int paging_size) {
		return new Board_Reply_DAO().reply_selectList(board_num, curpage, paging_size);
	}
		
	public void reply_writeMsg(int board_num, String user_id, String reply_content) {
		Board_Reply_DTO board_reply_dto = new Board_Reply_DTO();
		
		board_reply_dto.setBoard_num(board_num);
		board_reply_dto.setUser_id(user_id);
		board_reply_dto.setReply_content(reply_content);
		board_reply_dto.setReply_date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		
		new Board_Reply_DAO().reply_write(board_reply_dto);
		new Board_DAO().board_reply_count(board_num);
	}
	
	public void reply_deleteMsg(int board_num, int reply_num) {
		new Board_Reply_DAO().reply_delete(board_num, reply_num);
		new Board_DAO().board_reply_count(board_num);
	}
	
	public int reply_countMsg(int board_num) {
		return new Board_Reply_DAO().reply_getCount(board_num);
	}
	
	public Board_Service_Paging reply_paging(int curpage, int paging_size, int block_size, int board_num) {
		Board_Service_Paging paging_service = new Board_Service_Paging();
		
		paging_service.setCurpage((curpage - 1) / block_size + 1);
		paging_service.setCurpage_total((new Board_Reply_DAO().reply_getCount(board_num) - 1) / paging_size + 1);
		paging_service.setCurpage_start(1);
		paging_service.setCurpage_last((paging_service.getCurpage_total() - 1) / block_size + 1);
		paging_service.setBlock_begin(block_size * (paging_service.getCurpage() - 1) + 1);
		
		if(paging_service.getCurpage_total() < block_size * paging_service.getCurpage())
			paging_service.setBlock_end(paging_service.getCurpage_total());
		else
			paging_service.setBlock_end(block_size * paging_service.getCurpage());
		
		return paging_service;
	}
}

	
