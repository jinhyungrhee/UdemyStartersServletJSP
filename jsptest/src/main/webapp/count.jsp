<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%! int count = 0; %>
<% 
// 서블릿은 ServletContext application = request.getServletContext();
// JSP는 이미 객체 만들어둠
application.setAttribute("count", count += 1);

%>

<h1>서버 시작 후 <%= application.getAttribute("count") %> 번째 방문자입니다.</h1>

</body>
</html>