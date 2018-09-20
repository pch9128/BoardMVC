package kr.itedu.test1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardRegModServlet
 */
@WebServlet("/boardRegMod")
public class BoardRegModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		if(bid==0) {
			RequestDispatcher rd = request.getRequestDispatcher("boardRegMod.jsp");
			rd.forward(request, response);
		}else {
			BoardVO vo = Query.getDetail(bid, num);
			request.setAttribute("boardRegMod", vo);
			request.setAttribute("num", num);
			RequestDispatcher rd = request.getRequestDispatcher("boardRegMod.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		int num = Integer.parseInt(request.getParameter("num").trim());
	
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if(bid == 0) {
			int result = Query.insert(title, content, num);
			if(result == -1) {
				response.sendRedirect("error.jsp");
			}else {
				response.sendRedirect("boardList?num="+num);
			}
		}else {
			int result = Query.update(title, content, bid, num);
			if(result == -1) {
				response.sendRedirect("error.jsp");
			}else {
				response.sendRedirect("boardList?num="+num);
			}
		}
	}
}
