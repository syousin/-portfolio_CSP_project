package csp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import csp.service.Board_Service;

public class CSP_BoardWriteAction implements CSP_Action {

	@Override
	public CSP_ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		Board_Service board_service = new Board_Service();
		HttpSession session = request.getSession();
					
		CSP_ActionForward forward = null;
		
		String idKey = null;
		String board_title = null;
		String board_content =null;
		
		if((String)session.getAttribute("idKey") != null) {
			idKey = (String)session.getAttribute("idKey");
		}
		
		if(request.getParameter("write_title") != null) {
			board_title = request.getParameter("write_title");
		}
		
		if(request.getParameter("write_content") != null) {
			board_content = request.getParameter("write_content");
		}
		
		if(idKey == null) {
			forward = new CSP_ActionForward("views/login/login_form.jsp", false);
		} else {
			board_service.writeMsg(board_title, board_content, idKey);
			
			forward = new CSP_ActionForward("board_main", true);
		}
		
		return forward;
	}
}
