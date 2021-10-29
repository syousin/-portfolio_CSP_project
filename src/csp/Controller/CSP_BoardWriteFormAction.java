package csp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CSP_BoardWriteFormAction implements CSP_Action {

	@Override
	public CSP_ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String idKey = null;
		
		CSP_ActionForward forward = null;
		
		if((String)session.getAttribute("idKey") != null) {
			idKey = (String)session.getAttribute("idKey");
		}
		
		if(idKey != null) {
			forward = new CSP_ActionForward("views/board/board_write_form.jsp", false);
		} else {
			forward = new CSP_ActionForward("views/login/login_form.jsp", false);
		}
		
		return forward;
	}
}
