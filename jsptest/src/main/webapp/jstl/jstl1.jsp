<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% String jspname = "홍길동"; %>
<c:set var="id" value="jstl" /> <%-- 브라우저에 보여줄 값을 나타냄 --%>
<c:set var="pw" value="1111" /> <%-- 숫자들만 있으면 정수값으로 인식 --%>
<c:set var="name" value="<%=jspname %>" /> <%-- jsp 변수도 사용 가능 --%>
<c:set var="result" value="${ pw + 100 }" /> <%-- c:set 태그 변수는 무조건 el처럼 읽어옴! --%>

<%-- el태그를 하나의 변수로 선언 c:set태그 사용 --%>
<c:set var="clientip" value="${pageContext.request.remoteAddr}" />
<c:set var="clientfile" value="${pageContext.request.requestURI}" />

<h1>${id }</h1>
<h1>${pw }</h1>
<h1>${name }</h1>
<h1>${result }</h1>
<%-- el표현에서  c:set태그 변수 사용 --%>
<%-- <h1>클라이언트ip = ${clientip }</h1>  --%>
<h1>클라이언트ip = ${clientip } : <c:out value="${clientip}" /> </h1>

<h1>클라이언트요청파일명 = ${clientfile }</h1>

<%-- c:set 변수 없애기 --%>
<c:remove var="clientip" />
<c:remove var="clientfile" />

<c:if test="${empty clientip}" > 
<h1>clientip 변수는 삭제되었습니다.</h1>
</c:if>
 
 <c:if test="${!empty clientip }">
<h1>클라이언트ip = ${clientip }</h1> 
</c:if>


<h1>클라이언트요청파일명 = ${clientfile }</h1>

<c:set var="sum" value="${param.num1 + param.num2}" />
<c:choose>
	<c:when test="${sum >= 200}">
		<h1>200이 넘었으니 최상급입니다.</h1>
	</c:when>
	<c:when test="${sum >= 100}">
		<h1>100이 넘었으니 중상급입니다.</h1>
	</c:when>
	<c:when test="${sum >= 50}">
		<h1>50이 넘었으니 중하급입니다.</h1>
	</c:when>
	<c:otherwise>
		<h1>등급이 없습니다.</h1>
	</c:otherwise>
</c:choose>

<%-- 
1. jstl-fmt.jar
2. <%@ taglib prefix="fmt" uri=""
3. <fmt:xxxx />
--%>

</body>
</html>