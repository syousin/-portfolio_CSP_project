package csp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import csp.service.Board_Service;

public class CSP_BoardReplyDeleteAction implements CSP_Action {

	@Override
	public CSP_ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Board_Service board_service = new Board_Service();
		HttpSession session = request.getSession();
		
		CSP_ActionForward forward = null;
		
		String idKey = null;
		String user_id = null;
		int board_num = 0;
		int reply_num = 0;
		
		if((String)session.getAttribute("idKey") != null) {
			idKey = (String)session.getAttribute("idKey");
		}
		
		if(request.getParameter("user_id") != null) {
			user_id = request.getParameter("user_id");
		}
				
		if(request.getParameter("board_num") != null) {
			board_num = Integer.parseInt(request.getParameter("board_num"));
		}
		
		if(request.getParameter("reply_num") != null) {
			reply_num = Integer.parseInt(request.getParameter("reply_num"));
		}
		
		if(idKey == null) {
			forward = new CSP_ActionForward("views/login/login_form.jsp", false);
		} else if(!idKey.equals(user_id)) {
			forward = new CSP_ActionForward("views/error/error_inaccessible.jsp", false);
		} else {
			board_service.reply_deleteMsg(board_num, reply_num);
			
			forward = new CSP_ActionForward("board_view?board_num=" + board_num, true);
		}
		
		return forward;
	}

}
