<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
MemberDTO dto = (MemberDTO)request.getAttribute("result");
%>

<h3>아이디: <%= dto.getId() %></h3>
<h3>암호:  <%= dto.getPw() %> </h3>
<h3>이름:  <%= dto.getName() %> </h3>
<h3>휴대폰:   <%= dto.getPhone() %> </h3>
<h3>이메일: <%= dto.getEmail() %> </h3>
<h3>주소: <%= dto.getAddress() %> </h3>

<%-- 방법2 --%>
<%-- 바로 받는 것은 안되고 중계 jsp를 만들어서 <jsp:useBean /> 하나더 사용해야 할듯! --%>
<%-- <jsp:useBean id="dto" class="dto.MemberDTO" scope="request" />
<h3>아이디: <jsp:getProperty name="dto" property="id" /> </h3>
<h3>암호:  <jsp:getProperty name="dto" property="pw" /> </h3>
<h3>이름:  <jsp:getProperty name="dto" property="name" /> </h3>
<h3>폰:   <jsp:getProperty name="dto" property="phone" /> </h3>
<h3>이메일: <jsp:getProperty name="dto" property="email" /> </h3> --%>

</body>
</html>