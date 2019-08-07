<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/bootstrap.css">
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form role="form" method="post" autocomplete="off">
	<p>
		<label for="userId">아이디</label>
		<input type="text" id="userId" name="userId" value="${user.id}"/>
	</p>
	<p>
		<label for="userPass">패스워드</label>
		<input type="password" id="userPass" name="userPass"/>
	</p>
	<p>
		<button type="submit">회원탈퇴</button>
	</p>
	<p>	
		<a href="/">Home</a>
	</form>
	
</body>
</html>