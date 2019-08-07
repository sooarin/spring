<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="/css/bootstrap.css">
<style>
a{
color: black;
}
/* 기본 설정*/
         a{text-decoration:none; color:#000000;}         
         a:hover{color:#ff0000;}                     
         
         /* nav tag */
         nav {height:60px;
         text-decoration: none;
         color: white;
         display: block;
         font-size: 12px;
         font-weight: bold;
         line-height: 30px;
         vertical-align: middle;
         text-align: center;
         }
         nav ul{padding-top:10px;}                     /*  상단 여백 10px  */
         nav ul li {
            display:inline;                         /*  세로나열을 가로나열로 변경 */
            border-left:1px solid #999;             /* 각 메뉴의 왼쪽에 "|" 표시(분류 표시) */
            font:bold 12px Dotum;                     /* 폰트 설정 - 12px의 돋움체 굵은 글씨로 표시 */
            padding:0 10px;                         /* 각 메뉴 간격 */
        }
         nav ul li:first-child{border-left:none;}
         a {
         font-size: 20px;
         color: #ffffff;
         } 
         a:hover {
         color: #ffe0ffff;
         }    /* 메뉴 분류중 제일 왼쪽의 "|"는 삭제   
</style>
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보 페이지</h1>
 <nav id="topMenu">
	<ul>
		<li><a class="menuLink" href="#">Gallery</a>
		<li><a class="menuLink" href="/board/listAll">Board</a>
		<li><a class="menuLink" href="#">Q&A</a>
		<li><a class="menuLink" href="#">Library</a>
	</ul>
</nav>
<h4>이름은 : ${login.name}</h4> 
<h4>아이디 : ${login.id}</h4>
<h4>이메일 : ${login.email}</h4>
<form role="form" method="post" autocomplete="off">
	<p>
		<label for = "userName">닉네임</label>
		<input type="text" id="name" name="name" value="${login.name}"/>
	</p>
	<p>
		<label for = "userpw">기존 비밀번호</label>
		<input type = "password" id="userpw" name="userpw"/>
		</p>
	<p>
		<label for="pw">새로운 비밀번호</label>
		<input type="password" id="pw" name="pw"/>
	</p>
	<p>
		<button type="submit">회원정보 수정</button>
	</p>
	<p>
		<a href="/board/login">Home</a>
		<a href="/board/withdrawal">탈퇴</a>
	</p>
</form>
</body>
</html>