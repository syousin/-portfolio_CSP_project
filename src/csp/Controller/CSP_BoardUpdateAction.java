package csp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import csp.service.Board_Service;

public class CSP_BoardUpdateAction implements CSP_Action {

	@Override
	public CSP_ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Board_Service board_service = new Board_Service();
		HttpSession session = request.getSession();
					
		CSP_ActionForward forward = null;
		
		
		String idKey = null;
		String user_id = null;
		String board_title = request.getParameter("update_title");
		String board_content = request.getParameter("update_content");
		int board_num = 0;
		
		if((String)session.getAttribute("idKey") != null) {
			idKey = (String)session.getAttribute("idKey");
		}
		
		if(request.getParameter("user_id") != null) {
			user_id = request.getParameter("user_id");
		}
		
		if(request.getParameter("update_title") != null) {
			board_title = request.getParameter("update_title");
		}
		
		if(request.getParameter("update_content") != null) {
			board_content = request.getParameter("update_content");
		}
		
		if(request.getParameter("update_num") != null) {
			board_num = Integer.parseInt(request.getParameter("update_num"));
		}
		
		if(idKey == null) {
			forward = new CSP_ActionForward("views/login/login_form.jsp", false);
		} else if(!idKey.equals(user_id)) {
			forward = new CSP_ActionForward("views/error/error_inaccessible.jsp", false);
		} else {
			board_service.updateMsg(board_title, board_content, board_num);
			
			forward = new CSP_ActionForward("board_view?board_num=" + board_num, true);
		}
		
		return forward;
	}
}
