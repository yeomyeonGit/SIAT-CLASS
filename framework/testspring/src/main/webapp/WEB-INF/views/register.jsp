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
	<c:if test="${ userSession != null }">
	<h2>${ userSession.name }님 환영합니다</h2>

	</c:if>
	<form action = "../valid/insert" method = "post">
		<input type = "text"	name = "title">
		${validError.title}
		<input type = "text"	name = "content">
		${validError.content}
		<input type = "number"	name = "priority">
		${validError.priority}
		<input type = "text"	name = "phone">
		${validError.phone}
		<input type = "submit"	value = "작성하기">
	</form>
</body>
</html>