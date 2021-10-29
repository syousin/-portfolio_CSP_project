package csp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import csp.service.Board_Service;

public class CSP_BoardReplyWriteAction implements CSP_Action {

	@Override
	public CSP_ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Board_Service board_service = new Board_Service();
		HttpSession session = request.getSession();
		
		CSP_ActionForward forward = null;

		String idKey = null;
		String reply_content = null;
		int board_num = 0;
		
		if((String)session.getAttribute("idKey") != null) {
			idKey = (String)session.getAttribute("idKey");
		}
		
		if(request.getParameter("reply_write_content") != null) {
			reply_content = request.getParameter("reply_write_content");
		}
		
		if(request.getParameter("board_num") != null) {
			board_num = Integer.parseInt(request.getParameter("board_num"));
		}
		
		if(idKey == null) {
			forward = new CSP_ActionForward("views/login/login_form.jsp", false);
		} else {
			board_service.reply_writeMsg(board_num, idKey, reply_content);
			
			forward = new CSP_ActionForward("board_view?board_num=" + board_num, true);
		}
		return forward;
	}
}
