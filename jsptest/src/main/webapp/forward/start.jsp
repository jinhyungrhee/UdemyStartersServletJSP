<%@page import="java.net.URLEncoder"%>
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
String id = request.getParameter("id"); 
String filename = "";
// 메뉴를 미리 만들어서 각각 페이지에 맞게 넣어줌
String[] menu = null;
if(id != null) {
	if(id.equals("admin") || id.equals("administrator")) {
		filename="admin.jsp";
		menu = new String[3];
		menu[0] = "모든사용자정보조회";
		menu[1] = "회원강제탈퇴";
		menu[2] = "상품관리";
		
	}
	else {
		filename="user.jsp";
		menu = new String[4];
		menu[0] = "회원가입";
		menu[1] = "상품구입";
		menu[2] = "결제";
		menu[3] = "장바구니조회";
	}
	
	request.setAttribute("menu", menu); // String 배열을 넘김
	
}
else {
    // forward 특징 : forward 이전에 출력을 만들어 놓아도 무시됨!
	//out.println("<h1>아이디 입력해 주세요</h1>");
    filename = "none.jsp";
}
%>
<!-- forward는 path상에서 항상 처음화면(start.jsp)으로 남아있고, 이동한 jsp파일로 변경되지 않음! -->
<jsp:forward page="<%= filename %>" >
<jsp:param name="username" value="<%= URLEncoder.encode(\"홍길동\")%>" /> <%-- request body로 전달된 값은 한글 인코딩 처리 필요 --%>
</jsp:forward>

</body>
</html>