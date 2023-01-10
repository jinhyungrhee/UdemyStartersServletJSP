<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
${!empty paramValues.lunch[0] ? paramValues.lunch[0] : "없음" }<br>
${paramValues.lunch[1] }<br>
${paramValues.lunch[2] }<br>
${paramValues.lunch[3] }<br>
${!empty paramValues.lunch[4] ? paramValues.lunch[4] : "없음" }<br>
입니다.
<%-- el 내부에도 collection 존재 --%>
</h3>
</body>
</html>