<%@page import="data.dao.UserDao"%>
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
<div style="margin-left:100px; margin-top:50px;">
	<img alt="" src="image/mainImg.png" width="200" align="left" hspace="20">
	
	<%
		//세션으로 아이디를 얻는다
			String myid=(String)session.getAttribute("myid");
			
			//db로부터 아이디에 해당하는 이름을 얻는다.
			UserDao dao=new UserDao();
			String name=dao.getName(myid);
		%>
	<br><br>
	<b><%=name %>님이 로그인 하셨습니다.</b><br><br><br>
	
	<button type="button" class="btn btn-danger" style="width:100px;"
	onclick="location.href='login/logoutaction.jsp'">로그아웃</button>
	<br><br>
	<button type="button" class="btn btn-default" style="width:100px;"
	onclick="location.href='member/updateform.jsp'">정보조회(X)</button>
	<br><br>
	<button type="button" class="btn btn-info" style="width:100px;"
	onclick="location.href='member/updateform.jsp'">정보수정(X)</button>
	
</div>
</body>
</html>

