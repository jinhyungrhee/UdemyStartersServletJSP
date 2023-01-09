<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- member -- forward -- request.getParameter -->
<jsp:useBean id="dto" class="dto.MemberDTO" />
<jsp:setProperty property="*" name="dto" /> <%-- form에서 한번에 넘겨받은 데이터 저장 --%>

<jsp:useBean id="dao" class="dao.MemberDAO" scope="request"/> <%-- servlet에서 전달받은 객체 --%>

<%
int result = dao.insertMember(dto);

if (result == 1) {
	out.println("<h1>회원가입 처리되었습니다.</h1>");
}
%>

<!--  JSP 내부 독립적 언어 : 변수, 연산자, 조건문, 반복문 객체 -->

</body>
</html>