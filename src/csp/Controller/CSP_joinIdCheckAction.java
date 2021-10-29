package csp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csp.service.User_Service;

public class CSP_joinIdCheckAction implements CSP_Action {

	@Override
	public CSP_ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		User_Service user_service = new User_Service();
		CSP_ActionForward forward = null;
		
		String user_id = null;
		
		if(request.getParameter("user_id") != null) {
			user_id = request.getParameter("user_id");
		}
		
		if(user_service.idchk_joinMsg(user_id)) {
			request.setAttribute("num", 1);
		} else {
			request.setAttribute("num", 0);
		}
		
		forward = new CSP_ActionForward("views/login/ajax/join_id_check.jsp", false);
		
		return forward;
	}

}
