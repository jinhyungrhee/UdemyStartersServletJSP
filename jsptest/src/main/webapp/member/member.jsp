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

<jsp:useBean id="member" class="dto.MemberDTO" scope="request"/>

<h3>아이디: <jsp:getProperty name="member" property="id" /> </h3>
<h3>암호:  <jsp:getProperty name="member" property="pw" /> </h3>
<h3>이름:  <jsp:getProperty name="member" property="name" /> </h3>
<h3>폰:   <jsp:getProperty name="member" property="phone" /> </h3>
<h3>이메일: <jsp:getProperty name="member" property="email" /> </h3> 


<a href="member?menu=insertform">회원가입하러 가기</a>

</body>
</html>