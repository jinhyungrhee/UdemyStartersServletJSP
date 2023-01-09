<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> user.jsp 입니다. </h1>

<%
// 암호화된 것을 원래 데이터로 다시 보여주기 : Decode
String username = URLDecoder.decode(request.getParameter("username"));
%>

<h2> <%= username %>님의 회원용 메뉴는 다음과 같습니다. </h2>

<% 
String[] menu = (String[])request.getAttribute("menu"); 
for (String m : menu) {
	out.println("<h3>" + m + "</h3>");
}
%>

</body>
</html>