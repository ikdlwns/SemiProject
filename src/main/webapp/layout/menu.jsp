<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.menu-bar{
	display: flex;
	justify-content: space-around;
	margin-right: 70px;
	list-style: none;
}
</style>


<%
String root = request.getContextPath();
%>
</head>
<body>
	<%-- <a href="<%=root %>/">메인</a>&nbsp;&nbsp;&nbsp;
<a href="<%=root %>/">로그인</a>&nbsp;&nbsp;&nbsp;
<a href="<%=root %>/index.jsp?main=member/memberform.jsp">회원</a>&nbsp;&nbsp;&nbsp;
<a href="<%=root %>/">방명록</a>&nbsp;&nbsp;&nbsp;
<a href="<%=root %>/">Q&A</a>&nbsp;&nbsp;&nbsp;
<a href="<%=root %>/">답변형게시판</a>&nbsp;&nbsp;&nbsp;
<a href="<%=root %>/">상품등록게시판</a>&nbsp;&nbsp;&nbsp; --%>

<div class="wrap">
<ul class="menu-bar">
<li><a href="<%=root %>/index.jsp?main=">Mac</a></li>
<li><a href="<%=root %>/index.jsp?main=">iPad</a></li>
<li><a href="<%=root %>/index.jsp?main=">iPhone</a></li>
<li><a href="<%=root %>/index.jsp?main=">액세서리</a></li>
<li><a href="<%=root %>/index.jsp?main=">고객지원</a></li>
<li><a href="<%=root %>/index.jsp?main=">개인정보</a></li>
</ul>
</div>


</body>
</html>