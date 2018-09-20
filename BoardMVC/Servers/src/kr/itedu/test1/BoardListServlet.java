package kr.itedu.test1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("title", "Board List");
		int num = Integer.parseInt(request.getParameter("num").trim());
		
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		
		if(num==1 || num==2 || num==3) {
			
			result = Query.getAllBoardList(num);
			
			request.setAttribute("boardList", result);
			RequestDispatcher rd = request.getRequestDispatcher("boardList.jsp");
			rd.forward(request, response);
			
		} else {
			response.sendRedirect("error.jsp");
		}
	}
}
