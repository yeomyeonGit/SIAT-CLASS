<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">This is my first Servlet</div>
	
    <form action = "/todo/insert" method = "post">
		<input type = "id"	        name = "id">
		<input type = "password"	name = "password">
		<input type = "submit"	value = "로그인">
	</form>

	<ul>
		<li><a href = "./todo/registerForm">Todo 등록하기</a>  <!-- 페이지 바뀜 -->
		<li><a href = "./todo/select">Todo 목록 보기</a>			  <!-- 페이지 안 바뀜. 요청이 바뀜 -->
			
		</li>
	</ul>

</body>
</html>