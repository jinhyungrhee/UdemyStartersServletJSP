<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% String msg="콘솔출력";  // jsp -> servlet 변환시, 작성한 모든 문장은 _jspService() 내부 문장으로 간주(=지역적)
	System.out.println(msg); // msg는 _jspService()의 '지역변수'
%>

<!-- 새로운 메서드 하나 생성하여 추가 -->
<%! 
String msg2 = "멤버변수";

int multiply(int a, int b) {
	
		System.out.println(msg2 + " : " + a * b);
		return a * b;
}
%>

<%= multiply(10, 20) %> <!-- 문장 끝날 때 세미콜론 제외 -->

</body>
</html>