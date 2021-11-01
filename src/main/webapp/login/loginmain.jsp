<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://fonts.googleapis.com/css2?family=Dokdo&family=Gaegu&family=Gugi&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<%
//세션에 저장된 loginok를 읽는다
String loginok=(String)session.getAttribute("loginok");
//loginok 는 로그인 성공시 저장하고 로그아웃시 제거

if(loginok==null)
{%>
	<jsp:include page="loginform.jsp"/>
<%}else{%>
	<jsp:include page="logoutform.jsp"/>
<%}


%>
</body>
</html>

