<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.css">
   <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<style>
a{
color: black;
}
ul, li:hover{
color: #ffffff;
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
 
</head>

<body>
 <h1>${login.name}님 안녕하세요 detail 1입니다</h1>
 <nav id="topMenu">
	<ul>
		<li><a class="menuLink" href="/board/login">Login</a></li>
		<li><a class="menuLink" href="/board/gallery">Gallery</a>
		<li><a class="menuLink" href="/board/listAll">Board</a>
		<li><a class="menuLink" href="/board/QnA">Q&A</a>
		<li><a class="menuLink" href="/board/library">Library</a>
	</ul>
</nav>
    <table class="table table-board" border="1px" width="80%" align="center">
        <tr>
            <th style="width:10%">제목</th>
            <th style="width:20%">내용</th>
            <th style="width:20%">작성자</th>
            <th style="width:20%">날짜</th>
            <th style="width:20%">조회수</th>
        </tr>
 
 
   
        <tr>
            <td><a href="/board/detail?b_no=${detail.b_no}">${detail.b_title }</a></td>
            <td>${detail.b_detail}</td>
            <td>${detail.b_writer }</td>
            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${detail.b_date }" /> </td>
            <td><span> ${detail.b_count }</span> </td>
        </tr>
    </table>
    <!-- 게시물 끝 -->
<div id="reply">
 <ol class="replyList">
 <c:forEach items="${repList}" var="repList">
 <li>
  <p>
   작성자 : ${login.name}<br />
   작성 날짜 :  <fmt:formatDate value="${repList.b_date}" pattern="yyyy-MM-dd" />
  </p>
  <p>${repList.b_detail}</p>
 </li>
 </c:forEach>   
 </ol>
 <section class="replyForm">
<form role="form" method="post" autocomplete="off">

 <input type="hidden" id="b_no" name="b_no" value="${detail.b_no}" readonly="readonly" />
 <input type="hidden" id="page" name="page" value="${scri.page}" readonly="readonly" />
 <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}" readonly="readonly" />
 <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}" readonly="readonly" />
 <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}" readonly="readonly" />
 <p><label for="b_writer">작성자</label><input type="hidden" id="b_writer" name="b_writer" value= "${login.name}"/></p>
 <p><label for="b_detail">댓글 내용</label><textarea id="b_detail" name="b_detail"></textarea></p>
 <p>
  <button type="button" class="repSubmit">작성</button>
  <script>
  var formObj = $(".replyForm form[role='form']");
        
  $(".repSubmit").click(function(){
   formObj.attr("action", "replyWrite");
   formObj.submit();
  });
  </script>
 </p>
</form>
</section>
 
</div>
    <c:if test="${login.id eq detail.b_writer}">
    <button type="button" class="btn btn-dark"
onclick="location.href='/board/update/${detail.b_no}'" >
수정
</button>
</c:if>
 
</body>
</html>

