<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	String title = (String)request.getAttribute("title");
 %>
<header><h1><%=title %></h1></header>
	<nav>
		<ul>
			<li><a href="home">Home</a></li>
			<li class="dd">
				<a class="dd-1">Board</a>
					<div class="dd-content">
						<a href="boardList?num=1">게시판1</a>
						<a href="boardList?num=2">게시판2</a>
						<a href="boardList?num=3">게시판3</a>
					</div>
			</li>
		</ul>
	</nav>