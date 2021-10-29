package csp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csp.service.Board_Service;

public class CSP_BoardViewAction implements CSP_Action{

	@Override
	public CSP_ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Board_Service board_service = new Board_Service();
		CSP_ActionForward forward = null;
		
		final int paging_size = 5;
		final int block_size = 5;
		
		int curpage = 1;
		int board_num = 0;
		
		if(request.getParameter("curpage") != null) {
			curpage = Integer.parseInt(request.getParameter("curpage"));
		}
		
		if(request.getParameter("board_num") != null) {
			board_num = Integer.parseInt(request.getParameter("board_num"));
		}
		
		request.setAttribute("onemsg", board_service.getOneMsg(board_num));
		request.setAttribute("pagingmsg", board_service.reply_paging(curpage, paging_size, block_size, board_num));
		request.setAttribute("reply_listmsg", board_service.reply_ListMsg(board_num, paging_size * (curpage - 1), paging_size));
		request.setAttribute("replycount", board_service.reply_countMsg(board_num));
	  	request.setAttribute("br", "<br/>");
	  	request.setAttribute("cn", "\n");
	  	
		forward = new CSP_ActionForward("views/board/board_view.jsp", false);
		
		return forward;
	}
}
