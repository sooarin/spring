<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.css">
<style>
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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
 
</head>
<body>
    <nav id="topMenu">
	<ul>
		<li><a class="menuLink" href="#">Gallery</a>
		<li><a class="menuLink" href="/board/listAll">Board</a>
		<li><a class="menuLink" href="#">Q&A</a>
		<li><a class="menuLink" href="#">Library</a>
	</ul>
</nav>
    <form action="/board/update/${detail.b_no}" method="POST">
    <input type="text" name="b_title" value="${detail.b_title}">
    <input type="text" name="b_detail" value="${detail.b_detail}">
   <input type="submit" value="수정하기">
</form>

<button type="button" class="btn btn-dark"
onclick="location.href='/board/delete/${detail.b_no}'" >
삭제
</button>
 
</body>
</html>

