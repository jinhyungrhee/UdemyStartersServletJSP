<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="<%=request.getContextPath()%>/js/jquery-3.6.1.min.js"></script>

<script>
$(document).ready(function(){
	$('tr:even').css("background-color", "pink");
	$('tr:odd').css("background-color", "silver");
})
</script>

<style>
table {margin:auto;}
td, table{border : 2px solid blue;}
</style>

</head>
<body>
<h1> 구구단을 출력합니다. </h1>
<!-- JSP - GET, POST 동일 로직 처리 -->
<%

// id=admin일때만 구구단 출력

if(request.getMethod().equals("GET") && request.getParameter("id").equals("admin")) {
	String startString = request.getParameter("start");
	String endString = request.getParameter("end");
	
	int start = 0, end = 0;
	
	if (startString != null && !startString.equals("")) {
		start = Integer.parseInt(startString);
	}
	if (endString != null && !endString.equals("")) {
		end = Integer.parseInt(endString);	
	}
%>
	<table border=1>
	<%for (int j = 1; j <= 9; j++) { %>
		<tr>
		<%for(int i = start; i <= end; i++) {%>
			<td><%=i%> * <%=j%> = <%=i * j%></td>
		<%}%>
		</tr>
	<%}%>
	</table>
<%
}
else {
%>
	<h3>post방식은 지원하지 않습니다.</h3>
	
<%
}
%>

<h1><a href="input.jsp?id=admin">구구단입력하기</a></h1>
</body>
</html>