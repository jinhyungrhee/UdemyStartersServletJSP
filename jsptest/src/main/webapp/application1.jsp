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

<% 
String id = request.getParameter("id"); 
String pw = request.getParameter("pw");
String name = request.getParameter("name");

MemberDTO dto = new MemberDTO();
dto.setId(id);
dto.setPw(pw);
dto.setName(name);
// 서블릿은 ServletContext application = request.getServletContext();
// JSP는 이미 객체 만들어둠
application.setAttribute("appdto", dto);

%>

<%="출력" %>

</body>
</html>