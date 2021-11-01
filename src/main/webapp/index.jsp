<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.layout{
	border:0px solid gray;
	position:absolute;
}

.title{
width:100%;
height: 100px;
line-height: 80px;
font-size: 30pt;
font-family: "바탕체";
text-align: center;
}
.menu{
width:100%;
height:80px;
line-height:80px;
font-size: 20pt;
text-align: center;
top:100px;
}
.info{
width:200px;
height: 100%;
left:30px;
top:200px;
padding:20px 10px;
background-color: lightgray;

}
.main{
width:1200px;
height: 700px;
font-size: 12pt;
left:300px;
top:200px;
}
a:hover{
color: black;
text-decoration: none;

}
</style>
</head>
<body>
<%
String root=request.getContextPath();

String mainPage="layout/main.jsp";

if(request.getParameter("main")!=null){
	
	mainPage=request.getParameter("main");
	
}
%>

<div class="layout title">
<jsp:include page="layout/title.jsp"></jsp:include>
</div>

<div class="layout menu">
<jsp:include page="layout/menu.jsp"></jsp:include>
</div>

<div class="layout info">
<jsp:include page="layout/info.jsp"></jsp:include>
</div>

<div class="layout main">
<jsp:include page="<%=mainPage %>"></jsp:include>
</div>

</body>
</html>