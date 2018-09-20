package kr.itedu.boardmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.common.Var;

public class BoardHomeAction implements Action {
	
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		String title=Var.TITLES[3];
		forward.setPath("jsp/template.jsp");
		request.setAttribute("title",title);
		
		return forward;
	}

}
