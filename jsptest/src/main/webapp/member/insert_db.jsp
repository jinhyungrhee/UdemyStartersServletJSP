<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입</h1>
<form action="/jsptest/memberanswer" method="get">
아이디입력: <input type="text" name="id"><br>
암호입력: <input type="password" name="pw"><br>
이름입력: <input type="text" name="name"><br>
이메일입력: <input type="text" name="email"><br>
폰번호입력: <input type="text" name="phone"><br>
주소입력: <input type="text" name="address"><br>
<input type="hidden" name="menu" value="insertprocess">
<input type="submit" value="가입하기">
</form>

</body>
</html>