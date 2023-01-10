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
// jsp 태그 값 정의 -- el 출력
String b = "jsp만의 변수";
pageContext.setAttribute("a", "pageContext공유");
request.setAttribute("a", "reqeust공유");
session.setAttribute("a", "session공유");
application.setAttribute("a", "application공유");
%>

jsp b 출력 = <%=b %><br>
jsp a 출력(pageContext) = <%=pageContext.getAttribute("a") %><br>
jsp a 출력(request) = <%=request.getAttribute("a") %><br>
jsp a 출력(session)= <%=session.getAttribute("a") %><br>
jsp a 출력(application) = <%=application.getAttribute("a") %><br>


el b 출력 = ${b }<br> <%-- script 태그 안의 변수는 el에서 사용 불가 --%>
el a 출력 = ${a }<br> <%-- jsp에서 값을 정의하고 el에서 값을 출력할 때 사용하는 것 : setAttribute / getAttribute --%>
el a 출력 = ${a }<br>
el a 출력 = ${a }<br>
el a 출력 = ${a }<br>

<%-- <a href="/jsptest/el/scopetest2.jsp">링크이동</a> --%>
<a href="${pageContext.request.contextPath }/el/scopetest2.jsp">링크이동</a>
<%-- **el표현식으로 context path를 적기** => 여러 사람들과 협업할 때 일일이 수정할 필요 없음! --%>
<%-- jsp에서 context path 적기 : <%=request.getContextPath() %> --%>

<%-- forward를 만들면 이전의 출력문장들은 모두 무시됨 --%>
<%--<jsp:forward page="/el/scopetest2.jsp" />  현재 context를 포함(=같은 dynamic web project에서만 이루어짐)하고 있기 때문에 프로젝트명 생략 가능  --%>

</body>
</html>