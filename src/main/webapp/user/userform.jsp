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
<script type="text/javascript">
$(function(){
	
	//아이디 입력버튼 이벤트
	$("#btnidcheck").click(function(){
		
		window.open("user/idsearch.jsp","","width=600px, height=200px, left=500px;");
		
	});
	
});

//check
function check(f){
	
	if(f.id.value.length==0){
		alert('아이디 입력을 해주세요');
		return false; 
		
	}
	
	if(f.pass.value!=f.pass2.value){
		alert("비밀번호가 서로 다릅니다.");
		f.pass.value="";
		f.pass2.value="";
		return false; //action이 호출되지 않는다
	}
	
}

</script>

</head>
<body>
<form action="user/useraddaction.jsp" method="post" class="form-inline" name="memberfrm"
onsubmit="return check(this)">
	<table class="table table-bordered" style="width:500px;">
		<caption><b>회원가입</b></caption>
			<tr>
				<th width="100" bgcolor="#aaa">아이디</th>
				<td>
					<input type="text" name="id" maxlength="8" class="form-control"
					required="required" style="width: 120px;" readonly="readonly">
					
					<button type="button" class="btn btn-danger btn-sm" id="btnidcheck">아이디입력</button>
					
				</td>
			</tr>
	
			<tr>
				<th width="100" bgcolor="#aaa">비밀번호</th>
				<td>
					<input type="password" name="pass" class="form-control"
					required="required" style="width: 120px;" placeholder="비밀번호">
					
					<input type="password" name="pass2" class="form-control"
					required="required" style="width: 120px;" placeholder="비밀번호확인">
				</td>
			</tr>
			
			<tr>
				<th width="100" bgcolor="#aaa">이름</th>
				<td>
					<input type="text" name="name" class="form-control"
					required="required" style="width: 120px;">

				</td>
			</tr>
			
			<tr>
				<th width="100" bgcolor="#aaa">핸드폰</th>
				<td>
					<input type="text" name="hp" class="form-control"
					required="required" style="width: 200px;">
				</td>
			</tr>
			
			<tr>
				<th width="100" bgcolor="#aaa">주소</th>
				<td>
					<input type="text" name="addr" class="form-control"
					required="required" style="width: 400px;">
				</td>
			</tr>
			

			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-default" style="width:100px;">저장하기</button>
			</tr>
			
	</table>	
</form>
</body>
</html>

