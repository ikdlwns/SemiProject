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
//세션값 얻기
String saveok=(String)session.getAttribute("saveok");
String myid="";

if(saveok!=null)
	myid=(String)session.getAttribute("myid");
%>
<body>
<div style="margin-left: 130px;">
  <form action="login/loginaction.jsp" method="post" class="form-inline">
    <table class="table table-bordered" style="width: 300px;">
       <caption><b>세션 로그인</b></caption>
         <tr>
           <td colspan="2" align="center">
             <input type="checkbox" name="cbsave"
             <%=saveok==null?"":"checked" %>>아이디저장
           </td>
         </tr>
         <tr>
           <th width="100" bgcolor="#fcc">아이디</th>
           <td>
             <input type="text" name="id" class="form-control" autofocus="autofocus"
             required="required" style="width: 120px;" value="<%=myid%>">
           </td>
         </tr>
         <tr>
           <th width="100" bgcolor="#fcc">비밀번호</th>
           <td>
             <input type="password" name="pass" class="form-control" 
             required="required" style="width: 120px;">
           </td>
         </tr>
         <tr>
           <td colspan="2" align="center">
             <button type="submit" class="btn btn-success" style="width: 100px;">로그인</button>
           </td>
         </tr>
    </table>
  </form>
</div>
</body>
</html>