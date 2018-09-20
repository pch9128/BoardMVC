<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.itedu.boardmvc.*" %>
<%
	BoardVO result = (BoardVO) request.getAttribute("boardDetail");
	int num = (int)request.getAttribute("num");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/boardDetail.css">
<title>Detail</title>
</head>
<body>
<div class="container">
	<jsp:include page="top.jsp"/>
	<div class="link">
	<a href="boardList?num=<%=num %>"><button>게시판으로 이동</button></a>
	</div>
	<table>
	<tr>
		<th class="title">제목</th>
		<th	class="content"><%=result.getBtitle() %></th>
	</tr>
	<tr>
		<td>내용</td>
		<td><%=result.getBcontent() %></td>
	</tr>
	<tr>
		<td>등록일시</td>
		<td><%=result.getBregdate() %></td>
	</tr>
	</table>
	<div class="alter">
	
	<a href="boardRegMod?bid=<%=result.getBid()%>&num=<%=num %>"><button>수정</button></a>
	<a href="boardDelete?bid=<%=result.getBid()%>&num=<%=num %>"><button>삭제</button></a>
	</div>	
</div><br>
<jsp:include page="bottom.jsp"/>
</body>
</html>