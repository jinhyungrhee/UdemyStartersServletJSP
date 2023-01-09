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


<%-- <% MemberDTO dto = new MemberDTO();
dto.setId("id");
dto.setPw("1111");
dto.setName("name");
dto.setPhone("01011112222");
dto.setEmail("email@mul.com");
%>

<H1> 회원정보를 생성 완료했습니다. 확인해 볼까요?</H1>
<h3>아이디:<%=dto.getId() %></h3>
<h3>암호:<%=dto.getPw() %></h3>
<h3>이름:<%=dto.getName() %></h3>
<h3>폰:<%=dto.getPhone() %></h3>
<h3>이메일:<%=dto.getEmail() %></h3> --%>

<!-- 자바 문장을 action 태그로 변경 -->
============================================
<%-- class 속성에 import와 상관없이 패키지명을 써줘야 함! --%>
<jsp:useBean id="dto" class="dto.MemberDTO" /> <%-- java dto 변수 선언 --%>
<jsp:setProperty property="id" name="dto" value="id" /> <%-- dto.setId() 메서드 호출 의미 --%>
<jsp:setProperty property="pw" name="dto" value="1111" /> <%-- dto.setPw() 메서드 호출 의미 --%>
<jsp:setProperty property="name" name="dto" value="name" /> <%-- dto.setName() 메서드 호출 의미 --%>
<jsp:setProperty property="phone" name="dto" value="01011112222" /> <%-- dto.setPhone() 메서드 호출 의미 --%>
<jsp:setProperty property="email" name="dto" value="email@mul.com" /> <%-- dto.setEmail() 메서드 호출 의미 --%>

<%-- <% MemberDAO().insertMember(dto); %> --%>

<H1> 회원정보를 생성 완료했습니다. 확인해 볼까요?</H1>
<h3>아이디: <jsp:getProperty name="dto" property="id" /> </h3>
<h3>암호:  <jsp:getProperty name="dto" property="pw" /> </h3>
<h3>이름:  <jsp:getProperty name="dto" property="name" /> </h3>
<h3>폰:   <jsp:getProperty name="dto" property="phone" /> </h3>
<h3>이메일: <jsp:getProperty name="dto" property="email" /> </h3>

</body>
</html>