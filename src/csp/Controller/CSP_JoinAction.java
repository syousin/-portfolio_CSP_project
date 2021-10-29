package csp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import csp.service.User_Service;

public class CSP_JoinAction implements CSP_Action {

	@Override
	public CSP_ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		User_Service user_service = new User_Service();
		
		String user_id = null;
		String user_pwd = null;
		String user_name = null;
		
		CSP_ActionForward forward = null;
		
		if(request.getParameter("user_id") != null) {
			user_id = request.getParameter("user_id");
		}
		
		if(request.getParameter("user_pwd") != null) {
			user_pwd = request.getParameter("user_pwd");;
		}
		
		if(request.getParameter("user_name") != null) {
			user_name = request.getParameter("user_name");
		}
						
		if(user_service.joinMsg(user_id, user_pwd, user_name)) {
			session.setAttribute("idKey", user_id);
			forward = new CSP_ActionForward("main", true);
		} else {
			forward = new CSP_ActionForward("views/error/error_form.jsp", false);
		}
		
		return forward;
	}

}
