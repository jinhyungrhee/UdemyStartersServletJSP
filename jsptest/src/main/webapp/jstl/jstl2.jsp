<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js }"></script>
<script>
${document}.ready(function(){
	
});
</script>
</head>
<body>

<!-- url 변수 생성 -->
<c:url var="mypage" value="http://localhost:8081/jsptest/jstl/loginage.jsp" />
<%-- <c:url var="mypage" value="http://www.google.com" /> --%>

<!-- forward 동작 유사 -->
<!-- jsp:forward는 최초 요청 url에서 변하지 않음(jsp주소불변) / 같은 서버 같은 어플리케이션 파일만 가능 -->
<!-- c:redirect는 최초 요청 url에서 변경됨! / 다른 서버 다른 어플리케이션이어도 가능 (param은 전달 가능하지만 자바 객체 전달은 불가) -->
<%-- <c:redirect url="${mypage}" >
	<c:param name="name" value="홍길동" />
	<c:param name="age" value="21" />
</c:redirect>
 --%>

<!-- jsp:include  -->
<!-- 최초 요청 url에서 변하지 않음(jsp주소불변) -->
<c:import url="${mypage}" >
	<c:param name="name" value="홍길동" />
	<c:param name="age" value="21" />
</c:import>

<h1>import한 직후입니다.</h1>


</body>
</html>