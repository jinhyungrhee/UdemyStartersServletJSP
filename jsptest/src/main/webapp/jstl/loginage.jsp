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

<%-- empty인지 아닌지의 결과를 미리 받아서 저장 --%>
<c:set var="isName" value="${!empty param.name }" /> <%-- empty하지 않을 경우에만 true --%>
<c:set var="isAge" value="${!empty param.age }" />

<c:if test="${isName && isAge}">
	<c:choose>
		<c:when test="${ param.age >= 20 }">
			<h1 style="color:blue">${param.name }님 성인인증되셨습니다.</h1>
		</c:when>
		<c:when test="${ param.age >= 17 }">
			<h1 style="color:green">${param.name }님 고등학생입니다.</h1>
		</c:when>
		<c:otherwise>
			<h1 style="color:red">${param.name }님 미성년입니다.</h1>
		</c:otherwise>
	</c:choose>
</c:if>
 
<c:if test="${!isName || !isAge}">
	<h1 style="color:red">필요한 데이터를 입력해주세요</h1>
</c:if>
 
<%-- <c:set var="name" value="${param.name}" />
<c:set var="age" value="${param.age}" />
 
<c:if test="${!empty name && !empty age }">
<c:choose>
	<c:when test="${age >= 20}">
		<h1>${name }님 성인인증되셨습니다.</h1>
	</c:when>
	<c:when test="${age >= 17}">
		<h1>${name }님 고등학생입니다.</h1>
	</c:when>
	<c:when test="${age >= 1}">
		<h1>${name }님 미성년입니다.</h1>
	</c:when>
	<c:otherwise>
		<h1>잘못된 나이입니다.</h1>
	</c:otherwise>
</c:choose>
</c:if>

<c:if test="${empty name || empty age }">
<h1>필요한 데이터를 입력해주세요</h1>
</c:if> --%>



</body>
</html>