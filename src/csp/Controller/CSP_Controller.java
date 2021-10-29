package csp.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Clothing_store_Controller
 */
@WebServlet("/")
public class CSP_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSP_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
	
		CSP_Action action = null;
		CSP_ActionForward forward = null;

		if(com.equals("/main") || com.equals("/")) {
			action = new CSP_MainFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}

		} else if(com.equals("/login_form")) {
			action = new CSP_LoginFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(com.equals("/login_action")) {
			action = new CSP_LoginAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}			
			
		} else if(com.equals("/logout_action")) {
			action = new CSP_LogoutAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}

		} else if(com.equals("/join_form")) {
			action = new CSP_JoinFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}

		} else if(com.equals("/join_id_check")) {
			action = new CSP_joinIdCheckAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(com.equals("/join_action")) {
			action = new CSP_JoinAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}

		} else if(com.equals("/board_main")) {
			action = new CSP_BoardMainAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(com.equals("/board_view")) {
			action = new CSP_BoardViewAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(com.equals("/board_write_form")) {
			action = new CSP_BoardWriteFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}

		} else if(com.equals("/board_write_action")) {
			action = new CSP_BoardWriteAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}

		} else if(com.equals("/board_update_form")) {
			action = new CSP_BoardUpdateFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}

		} else if(com.equals("/board_update_action")) {
			action = new CSP_BoardUpdateAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}

		} else if(com.equals("/board_delete_action")) {
			action = new CSP_BoardDeleteAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}

		} else if(com.equals("/board_reply_write_action")) {
			action = new CSP_BoardReplyWriteAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}

		} else if(com.equals("/board_reply_delete_action")) {
			action = new CSP_BoardReplyDeleteAction();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}

		} else {
			try {
				forward = new CSP_ActionForward("views/error/error_404.jsp", false);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
