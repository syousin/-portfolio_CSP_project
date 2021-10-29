package csp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CSP_Action {
	CSP_ActionForward execute(HttpServletRequest request, HttpServletResponse response);
}
