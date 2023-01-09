<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<img src="../images/html5.jpg">
<img src="<%=request.getContextPath()%>/images/html5.jpg">
<h3> 연락처 - 이메일로 문의하세요. </h3>
<h3> 오시는 길 - 서울시 용산구 전자월드 3층 </h3>

<%if(request.getParameter("id") != null){ %>
<h1><%= request.getParameter("id") %></h1>
<%} %>

<h1><%= request.getParameter("filename") %></h1>

<%if(request.getAttribute("member") != null) {  %>
<%=request.getAttribute("mebmer") %>
<%} %>

</body>
</html>