<%@page import="data.dao.UserDao"%>
<%@page import="data.dto.UserDto"%>
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
request.setCharacterEncoding("utf-8");

String id=request.getParameter("id");
String pass=request.getParameter("pass");
String name=request.getParameter("name");
String hp=request.getParameter("hp");
String addr=request.getParameter("addr");

//데이터 읽어서 dto 담기
UserDto dto=new UserDto();

dto.setUser_id(id);
dto.setUser_pw(pass);
dto.setUser_name(name);
dto.setUser_hp(hp);
dto.setUser_addr(addr);

//dao 선언 후 insert 호출
UserDao dao=new UserDao();
dao.insertMember(dto);

//gaipsuccess로 이동
response.sendRedirect("../index.jsp?main=user/joinsuccess.jsp?id="+id);
%>
</body>
</html>

