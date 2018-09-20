<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.itedu.boardmvc.*" %>
<%
	BoardVO vo = (BoardVO)request.getAttribute("boardRegMod");
	int num = Integer.parseInt(request.getParameter("num"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardRegMod</title>
<script type="text/javascript" src="script/board.js"></script>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/boardRegMod.css">
</head>
<body>
	
	<form name="frm" action="boardRegMod" method="post">
	<%if(vo != null){%>
	<input type="hidden" name="bid" value="<%=vo.getBid()%>">
	<input type="hidden" name="num" value=<%=num %>>
		제목 : <input type="text" name="title" value="<%=vo.getBtitle() %>">
		<br>
		내용
		<br>
		<textarea rows="5" cols="50" name="content"><%=vo.getBcontent() %></textarea>
		<br>
		
		<% } else { %>
	<input type="hidden" name="bid" value="0">
	<input type="hidden" name="num" value=<%=num %>>
		제목 : <input type="text" name="title">
		<br>
		내용
		<br>
		<textarea rows="5" cols="50" name="content"></textarea>
		<br>
		<% } %>
		<input type="submit" value="저장" onclick="return check()">
	</form>
</body>
</html>