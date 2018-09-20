<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String img1 = (String)request.getAttribute("img1");
String img2 = (String)request.getAttribute("img2");
String img3 = (String)request.getAttribute("img3");
String img4 = (String)request.getAttribute("img4");
String img5 = (String)request.getAttribute("img5");
String img6 = (String)request.getAttribute("img6");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 보기</title>
</head>
<body>
	<img src="<%=img1%>" alt="img1"><br>
	<img src="<%=img2%>" alt="img2"><br>
	<img src="<%=img3%>" alt="img3"><br>
	<img src="<%=img4%>" alt="img4"><br>
	<img src="<%=img5%>" alt="img5"><br>
	<img src="<%=img6%>" alt="img6">
</body>
</html>	