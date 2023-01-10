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
request.getParameterValues("lunch")
<h1>${param.id } 회원님 </h1>
${param.pw } 암호를 입력했습니다.

<h3>주문목록은 <br>
<c:forEach items="${paramValues.lunch }" varStatus="v">
<h3>${v.current  }</h3>
</c:forEach>
<%-- el 내부에도 collection 존재 --%>
</h3>
</body>
</html>