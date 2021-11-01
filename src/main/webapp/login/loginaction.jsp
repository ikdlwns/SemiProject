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
<%
String id=request.getParameter("id");
String pass=request.getParameter("pass");
String cbsave=request.getParameter("cbsave"); //체크안하면 null

UserDao dao=new UserDao();

boolean b=dao.isIdPass(id, pass);

//아이디돠 비번이 맞으면 3개세션 저장
//로그인메인

if(b){
	//세션유지시간(생략시 30분)
	/* 	로그인성공시  loginok  yes
		아이디저장체크시  myid  로그인한아이디
		체크값 saveok  yes
 */
	session.setMaxInactiveInterval(20);
	session.setAttribute("loginok", "yes");
	session.setAttribute("myid", id);
	session.setAttribute("saveok", cbsave==null?null:"yes");
	
	//로그인메인으로 이동
	response.sendRedirect("../index.jsp?main=login/loginmain.jsp");
}else{
%>
	<script type="text/javascript">
	  alert("아이디 또는 비밀번호가 맞지 않네요~~");
	  history.back();
	</script>
<%}
%>
<body>

</body>
</html>
