<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% if(request.getParameter("name") != null) { %>
<h1><%=request.getParameter("name").length() %></h1>
<% } %>

<%-- el에서 if문 처리 --%>

<h1>${!empty param.name ? param.name.length() : "없다" } </h1> <!-- el은 값이 없으면 자동으로 빈값으로 출력 (null X) -->


<%-- 표현 언어에서 데이터 출력하기 --%> 

<h1>표현 언어에서 데이터 출력하기</h1>
<h1>\${100}의 결과는 = ${100 }</h1>
<h1>${3.14}</h1>
<h1>${true}</h1>
<h1>${"안녕"}</h1>
<h1>${"안녕" += "하세요"}</h1>
<h1>${100 + 100}</h1>
<h1>${requestScope.dto}</h1> <!-- request.getAttribute("dto") -->
<h1>${sessionScope.dto}</h1> <!-- session.getAttribute("dto") -->
<h1>${applicationScope.dto}</h1> <!-- application.getAttribute("dto") -->

</body>
</html>