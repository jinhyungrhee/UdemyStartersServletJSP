<%@page import="dao.MemberDAO"%>
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

============================================
<%-- request 객체에다가 DTO를 만들어서 넣어줌 (request 범위의 파일과 공유)--%>
<jsp:useBean id="dto" class="dto.MemberDTO" scope="request" /> 
<jsp:setProperty property="*" name="dto" />
<jsp:forward page="beanrequest2.jsp" />

</body>
</html>