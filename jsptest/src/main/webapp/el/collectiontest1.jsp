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
</head>
<body>

<%-- el 가능한 타입 : 문자열, 실수, 정수, null --%>
<%-- el 목적 : 만들어진 변수 화면에 간단하게 출력 --%>
<%
String[] array = {"red", "black","white","green","blue"};
pageContext.setAttribute("colors", array);
%>

<%-- pageScope는 생략 가능 --%>
${colors[0] } : ${pageScope.colors[0] } : ${colors[0].toUpperCase() } <br>
${colors[1] } : ${pageScope.colors[2] } : ${colors[3].toUpperCase() } <br>
<%-- index 번호가 없는 것은 '공백'으로 표현 --%>
${colors[100] } : ${pageScope.colors[100] } : ${colors[100].toUpperCase() } <br>

${Integer.parseInt("100") + 100 } <br>
${"100" += "100" }<br>


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

${list.get(0).id} : ${list[0] }  <br> <%-- toString()메서드 출력 --%>
${list.get(1).id} : ${list[1].id }  <br>
${list.get(2).id} : ${list[2].id }  <br>
${list.get(3).id} : ${list[3].id }  <br>
${list.get(4).id} : ${list[4].id }  <br>
${list.get(5).id} : ${list[5].id }  <br>

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

${colormap["빨강"] } <br>
${empty colormap["빨강색"] ? "해당색상없음" : colormap["빨강색"] } <br>
${colormap.one } <br>

</body>
</html>