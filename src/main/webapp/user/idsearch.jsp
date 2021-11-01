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
<%

request.setCharacterEncoding("utf-8");
String key=request.getParameter("key"); 

if(key==null){
	//아이디 입력폼
	%>
	<form action="idsearch.jsp" method="post" class="form-inline">
	   <input type="hidden" name="key" value="result">
	  <table class="table table-bordered">
	    <tr height="100">
	        <td>
	        <img alt="" src="../image2/2.png" width="70" align="left"><br>
	        
	          <b>아이디를 입력해 주세요</b><br>
	          <input type="text" name="id" class="form-control" style="width: 100px;"
	          autofocus="autofocus" required="required" maxlength="8"><br>
	          <button type="submit" class="btn btn-info btn-sm">중복체크</button>
	        </td>
	    </tr>
	  </table>
	</form>
<%}else{
	
	//아이디 db체크
	//id읽기
	String id=request.getParameter("id");
	
	//dao선언
	UserDao dao=new UserDao();
	
	//id가 db에 존재하는지 체크     
	boolean isid=dao.isIdCheck(id);
	
	if(isid){%>
		<script type="text/javascript">
		alert("이미 등록된 아이디입니다");
		location.href='idsearch.jsp';
		</script>
	<%}else{%>
		
		<h3 class="alert alert-success"><%=id %>는  사용가능한 아이디 입니다
		</h3>
		
		<button type="button" class="btn btn-warning btn-sm" id="btnuse"
		style="margin-left: 200px;" myid="<%=id%>">사용하기</button>
		
<%-- 		<button type="button" class="btn btn-warning btn-sm" id="btnuse"
		style="margin-left: 200px;" onclick='goBack('<%=id%>')>사용하기</button> --%>
		<button type="button" class="btn btn-danger btn-sm" onclick="location.href='idsearch.jsp'">다시입력</button>
	<%}
	
}

%>

<script type="text/javascript">
  $("#btnuse").click(function(){
	  
	  //아이디 얻기
	  var myid=$(this).attr("myid");
	  //부모창에 아이디 보내기
	  opener.memberfrm.id.value=myid;
	  
	  //현재창 닫기
	  window.close();
  });
  
/*   function gpBack(id){
	  //부모창에 아이디 보내기
	  opener.memberfrm.id.value=myid;
	  
	  //현재창 닫기
	  window.close();
	  
  } */

</script>

</body>
</html>

