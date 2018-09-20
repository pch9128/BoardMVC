package kr.itedu.boardmvc.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.BoardListService;

public class BoardListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward(); //액션 받기 위해 항상 먼저적는다.
		forward.setPath(Var.TEMPLATE_1);
				
		BoardListService service = new BoardListService();//실질적 모델 / 
		int btype =Utils.getParamInt(request.getParameter("btype"));//직접만듬 paramint 체크 1 or -1
		ArrayList<BoardVO> data = service.getBoardList(btype);//데이터에 쿼리문에 대한 모든값을 받을수있다.
		//btype게시판 구분하기위한 숫자가 들어감
		
		
		request.setAttribute("title", Var.TITLES[btype]);//비타입 받아오고
		request.setAttribute("content", "boardList");
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);
		//request.setAttribute("boardList", result);
		//forward.setRedirect(false);
		return forward;
	}

}
