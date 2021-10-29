package csp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CSP_MainFormAction implements CSP_Action {

	@Override
	public CSP_ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		CSP_ActionForward forward = null;
		
		forward = new CSP_ActionForward("views/main/main.jsp", false);
		
		return forward;
	}

}
