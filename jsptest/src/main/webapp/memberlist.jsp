<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

li {
	padding:50px;
}

</style>

</head>
<body>

<%
ArrayList<MemberDTO> result = (ArrayList<MemberDTO>)request.getAttribute("result");
%>

<ul>
	<li><%= result.get(0).getId() %> | <%= result.get(0).getName() %> | <%= result.get(0).getPw() %></li>
	<li><%= result.get(1).getId() %> | <%= result.get(1).getName() %> | <%= result.get(1).getPw() %></li>
	<li><%= result.get(2).getId() %> | <%= result.get(2).getName() %> | <%= result.get(2).getPw() %></li>
	<li><%= result.get(3).getId() %> | <%= result.get(3).getName() %> | <%= result.get(3).getPw() %></li>
</ul>

</body>
</html>