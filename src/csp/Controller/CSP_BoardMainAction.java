package csp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csp.service.Board_Service;

public class CSP_BoardMainAction implements CSP_Action {

	@Override
	public CSP_ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Board_Service board_service = new Board_Service();
		CSP_ActionForward forward = null;
		
		final int paging_size = 5;
		final int block_size = 5;
		int curpage = 1;
		String keyword = null;
		
		if(request.getParameter("curpage") != null) {
			curpage = Integer.parseInt(request.getParameter("curpage"));
		}
		
		if(request.getParameter("keyword") != null) {
			keyword = request.getParameter("keyword");
			request.setAttribute("listmsg", board_service.ListMsg(paging_size * (curpage - 1), paging_size, keyword));
			request.setAttribute("pagingmsg", board_service.paging(curpage, paging_size, block_size, keyword));
			request.setAttribute("keyword", keyword);
			request.setAttribute("boardcount",board_service.countMsg(keyword));
		} else {
			request.setAttribute("listmsg", board_service.ListMsg(paging_size * (curpage - 1), paging_size));	
			request.setAttribute("pagingmsg", board_service.paging(curpage, paging_size, block_size));
			request.setAttribute("boardcount",board_service.countMsg());
		}
		
		forward = new CSP_ActionForward("views/board/board_main.jsp", false);
		
		return forward;
	}
}
