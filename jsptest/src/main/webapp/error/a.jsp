<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="e.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setAttribute("file", request.getRequestURI());
int num = Integer.parseInt(request.getParameter("num")); // 오류발생-forward
%>
<h1>결과=<%=num %></h1>

</body>
</html>