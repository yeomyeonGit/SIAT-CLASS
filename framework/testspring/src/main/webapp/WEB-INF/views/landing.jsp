<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib	uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">This is my first Servlet</div>
	
	
    <div align="right">
		<c:if test="${ UserSession == null }">
			<form action="./user/login" method="post"> 
			아이디 :  <input 	type="text" 	name="id"  placeholder="아이디입력">
			패스워드 : <input 	type="password" name="pwd" placeholder="패스워드입력">
			<input type="submit" value="로그인">
			</form>
		</c:if>

		<c:if test="${ UserSession != null }">
			<h2>${ UserSession.name }님 환영합니다</h2>
			<a href="./user/logout">로그아웃</a>
		</c:if>
	</div>
	<ul>
		<li><a href = "./todo/registerForm">Todo 등록하기</a>  <!-- 페이지 바뀜 -->
		<li><a href = "./todo/select">Todo 목록 보기</a>			  <!-- 페이지 안 바뀜. 요청이 바뀜 -->
			
		</li>
	</ul>

</body>
</html>