<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage="error.jsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "kr.itedu.boardmvc.*" %>
<%
	ArrayList<BoardVO> result = (ArrayList<BoardVO>) request.getAttribute("boardList");
	//result.clear();
	String title = (String)request.getAttribute("title");
	String strNum = (String)request.getParameter("num");
	int num = Integer.parseInt(strNum);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
<link rel="stylesheet" type="text/css" href="css/boardList.css?ver=1">
<link rel="stylesheet" type="text/css" href="css/common.css?ver=5">
</head>
<body>
	<jsp:include page="top.jsp"/>
	<div class="container">
	<%if(result.size() > 0){ %>
	<table>
			<tr>
				<th class="num">번호</th>
				<th class="tit">제목</th>
				<th class="time">등록일시</th>
			</tr>
				<% for(BoardVO vo : result) {%>
				<tr>
					<td><%=vo.getBid() %></td>
					<td>
						<a href="boardDetail?bid=<%=vo.getBid() %>&num=<%=num%>">
							<%=vo.getBtitle() %>
						</a>
					</td>
					<td><%=vo.getBregdate() %></td>
				</tr>
				<% } %>
		</table>
		<%} else { %>
		<h4>게시글이없습니다.</h4>
		<%} %>
		<a class="new" href="boardRegMod?bid=0&num=<%=num %>"><button>글쓰기</button></a>
	</div>
	<jsp:include page="bottom.jsp"/>
</body>
</html>