<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> scopetest2.jsp </h1>

jsp a 출력(pageContext) = <%=pageContext.getAttribute("a") %><br>
jsp a 출력(request) = <%=request.getAttribute("a") %><br>
jsp a 출력(session)= <%=session.getAttribute("a") %><br>
jsp a 출력(application) = <%=application.getAttribute("a") %><br>

el a 출력(현재 페이지의 jsp태그 전달값) = ${pageScope.a }<br> <%-- jsp에서 값을 정의하고 el에서 값을 출력할 때 사용하는 것 : setAttribute / getAttribute --%>
el a 출력(이동 전의 jsp태그 전달값) = ${requestScope.a }<br>
el a 출력(세션 전달값) = ${sessionScope.a }<br>
el a 출력(어플리케이션 전달값) = ${applicationScope.a }<br>

<hr>
<!-- 
el 전달 변수 해석 출력
1. pageScope 찾는다
2. requestScope 찾는다
3. sessionScope 찾는다
4. applicationScope 찾는다
 -->

el 컨텍스트명 출력 = ${ pageContext.request.contextPath } <br> <%-- get을 빼고 사용 --%>
el jsp명 출력 = ${ pageContext.request.requestURI } <br> <%-- forward 했을 때 원래 파일 알고 싶을 때 사용 --%>
 <%-- request.getContextPath(); /jsptest/js/jquery1.1.1.js --%>






</body>
</html>