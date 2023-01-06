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

out.println("출력");
//자동생성 - HttpSession session1 = request.getSession();
session.setAttribute("sessiondto", dto);

%>

<%="출력" %>

</body>
</html>