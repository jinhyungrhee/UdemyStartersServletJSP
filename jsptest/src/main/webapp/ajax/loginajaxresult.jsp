<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%-- 아이디 ajax이고 pw ajax일때만 로그인 성공
나머지 로그인 실패 
--%>

<% String logintime = null;
String result = null; %>
<c:if test="${param.id.equals(\"ajax\") && param.pw.equals(\"ajax\")}">


<%-- <%= new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초").format(new Date()) %> 시각에 로그인 성공! --%>


<% logintime = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초").format(new Date()); 
result = "{ \"login\":\"success\", \"logintime\" : \"" + logintime +"\" }";
%>
</c:if>

<%= result  %>