<%@ page 
contentType="text/html; charset=UTF-8"
buffer="8kb"
autoFlush="true"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>버커크기: <%= out.getRemaining() %></h1>
<h1>자바문장 실행 결과와 html 태그를 모아서 </h1>
<h1>응답 내용으로 만들고 '서버 내부 버퍼'에 저장합니다. (=아직 클라이언트에 전송 전) - 일괄적으로 모아서 한번에 전송 </h1>
<%= Integer.parseInt(request.getParameter("name")) %>
<h1>예외 발생시 취소합니다.(out.clearBuffer()) </h1>
<h1>버커크기: <%= out.getRemaining() %></h1>
<% out.flush(); %>

</body>
</html>