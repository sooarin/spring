<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="/css/bootstrap.css">
  <style>
  td a{
  color: black;
  }
  .btn-block {
  width: 100px;
  margin: auto;
  }
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
<script type="text/javascript">
</script>
 
</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<body>
 <h4>${login.name}님 안녕하세요</h4> 
 <nav id="topMenu">
	<ul>
		<li><a class="menuLink" href="/board/login">Logout</a></li>
		<li><a class="menuLink" href="#">Gallery</a>
		<li><a class="menuLink" href="#">Q&A</a>
		<li><a class="menuLink" href="#">Library</a>
		<li><a class="menuLink" href="/board/user">Mypage</a>
	</ul>
</nav>

    <table class="table table-board" border="1px" width="80%" align="center">
        <tr>
            <th style="width:10%" >글 번호</th>
            <th style="width:10%" >제목</th>
            <th style="width:20%">작성자</th>
            <th style="width:20%">날짜</th>
            <th style="width:20%">조회수</th>
        </tr>
 
 
    <c:forEach items="${boardList }" var="boardVO" varStatus="status">
        <tr>
            <td>${status.count}</td>
           <td><a href="/board/detail?b_no=${boardVO.b_no}">${boardVO.b_title }</a></td>
            <td>${boardVO.b_writer }</td>
            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.b_date }" /> </td>
            <td><span> ${boardVO.b_count }</span> </td>
        </tr>
    </c:forEach>
    </table>
    <form class="createBoard" method="get" action="/board/create">
     <button type ="submit" class="btn btn-lg btn-warning btn-block">글쓰기</button>   
 </form>
<div>
 <ul>
  <c:if test="${pageMaker.prev}">
   <li><a href="listAll${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
  </c:if> 
  
  <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
   <li><a href="listAll${pageMaker.makeQuery(idx)}">${idx}</a></li>
  </c:forEach>
    
  <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
   <li><a href="listAll${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
  </c:if> 
 </ul>
</div>
</body>
</html>