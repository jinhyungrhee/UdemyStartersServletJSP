<%@page import="java.util.HashMap"%>
<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js }"></script>
<script>
</script>

</head>
<body>

<c:forEach begin="1" end="10" step="2" var="odd" varStatus="vs">
${odd } : ${vs.current }<br> <%-- current : 현재 반복중인 값 --%>
</c:forEach>

<%
String[] array = {"red", "black","white","green","blue"};
%>

<c:set var="colors" value="<%=array %>" /> <%-- colors 배열은 el에서 사용 --%>

<c:forEach items="${colors }" var="col" varStatus="st">
<%-- index는 0번부터 시작, count는 1번부터 시작 --%>
<h3>${st.index }번째 데이터 =  ${col } : ${st.current } --- ${st.count } 번 반복중입니다. </h3>
<h3>첫번째냐? - ${st.first } : 마지막이냐? - ${st.last } : </h3>
</c:forEach>

<c:forEach items="${colors }" varStatus="st">
<c:if test="${st.first }">
<h1>첫번째  = ${st.current }</h1>
</c:if>
<c:if test="${st.last }">
<h1>마지막  = ${st.current }</h1>
</c:if>
</c:forEach>
                                                                                   
<%-- 일반적으로 bean은 JSP에서 dto 수준으로 객체를 사용하기 위함임! --%>
<%-- ArrayList --%>
<jsp:useBean id="list" class="java.util.ArrayList" /> <%-- ArrayList list = new ArrayList();  --%>
<jsp:useBean id="dto" class="dto.MemberDTO" />
<jsp:setProperty property="id" name="dto" value="el" />

<%
list.add(dto);
list.add(new MemberDTO("MEM1","1","회원1","01012341234","이메일1@a.com","서울시 용산구", "2022-12-12"));
list.add(new MemberDTO("MEM2","2","회원2","01012344321","이메일2@a.com","부산시 용산구","2023-01-12"));
list.add(new MemberDTO("MEM3","3","회원3","01043211234","이메일3@a.com","제주시 용산구","2012-08-12"));
list.add(new MemberDTO("MEM4","4","회원4","01043214321","이메일4@a.com","전주시 용산구","2022-08-12"));
list.add(new MemberDTO("MEM5","5","회원5","01012345678","이메일5@a.com","청주시 용산구","2022-08-12"));
//((MemberDTO)list.get(0)).getId();
%>

<table border=3>
<c:forEach items="${list}" varStatus="vs">
	<tr>
	<td>${vs.current.id }</td><td>${vs.current.name }</td><td>${vs.current.address }</td>
	</tr>
</c:forEach>
</table>



<%-- Map --%>
<%
HashMap<String, String> map = new HashMap();
map.put("빨강", "red");
map.put("주황", "orange");
map.put("노랑", "yellow");
map.put("초록", "green");
map.put("파랑", "blue");
map.put("남색", "navy");
map.put("빨강", "purple");
map.put("one", "black");

pageContext.setAttribute("colormap", map);
%>

<!--  vs.current.key/value -->
<c:set var="colormap" value="<%=map%>" />
<c:forEach items="${colormap}" var="col" >
<h3>한국어 색상명 ${col.key }에 대한 영문 색상명은 ${col.value }입니다.</h3>

</c:forEach>


</body>
</html>