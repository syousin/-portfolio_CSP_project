package csp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import csp.service.User_Service;

public class CSP_LoginAction implements CSP_Action {

	@Override
	public CSP_ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		User_Service user_service = new User_Service();
		
		String user_id = null;
		String user_pwd = null;
		
		CSP_ActionForward forward = null;
		
		if(request.getParameter("user_id") != null) {
			user_id = request.getParameter("user_id");
		}
		
		if(request.getParameter("user_pwd") != null) {
			user_pwd = request.getParameter("user_pwd");;
		}
		
		if(user_service.loginMsg(user_id, user_pwd)) {
			session.setAttribute("idKey", user_id);
			request.setAttribute("num", 0);
		} else {
			request.setAttribute("num", 1);
		}
		
		forward = new CSP_ActionForward("views/login/ajax/login_check.jsp", false);
		
		return forward;
	}
}
