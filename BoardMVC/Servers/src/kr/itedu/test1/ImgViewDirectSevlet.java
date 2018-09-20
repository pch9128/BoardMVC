package kr.itedu.test1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImgViewSevlet
 */
@WebServlet("/Direct")
public class ImgViewDirectSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgViewDirectSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("img5","data:image/jpeg;base64,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");
		request.setAttribute("img6","https://pbs.twimg.com/profile_images/2797288504/bf567ea001538e34bb2d650633c19f98_400x400.jpeg");
		
		RequestDispatcher dis = request.getRequestDispatcher("ImgViewSec");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
