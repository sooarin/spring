<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.css">
<style type="text/css">
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
    <title>Home</title>
</head>
<body>
<h1>
   소아린의 홈페이지 
</h1>
<nav id="topMenu">
	<ul>
		<li><a class="menuLink" href="/board/login">Login</a></li>
		<li><a class="menuLink" href="/board/signup" >SignUp</a></li>
		<li><a class="menuLink" href="#">Gallery</a>
		<li><a class="menuLink" href="/board/listAll">Board</a>
		<li><a class="menuLink" href="#">Q&A</a>
		<li><a class="menuLink" href="#">Library</a>
	</ul>
</nav>
</body>
</html>
