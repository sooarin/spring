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
  </style>
<title>Insert title here</title>
<script type="text/javascript">
</script>
 
</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<body>
 <h4>${login.name}님 안녕하세요</h4> 
 <a href="/board/logout">logout</a>
 <a href="/board/user">mypage</a>
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
 <div class="search">
 <select name="searchType">
  <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
  <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
  <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
  <option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
  <option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
 </select>
 
 <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>

 <button id="searchBtn">검색</button>
 
 <script>
 $(function(){
  $('#searchBtn').click(function() {
   self.location = "listSearch"
     + '${pageMaker.makeQuery(1)}'
     + "&searchType="
     + $("select option:selected").val()
     + "&keyword="
     + encodeURIComponent($('#keywordInput').val());
    });
 });   
 </script>
</div>
<div>
 <ul>
  <c:if test="${pageMaker.prev}">
   <li><a href="listSearch${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
  </c:if> 
  
  <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="b_no">
   <li><a href="listSearch${pageMaker.makeSearch(idx)}">${b_no}</a></li>
  </c:forEach>
    
  <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
   <li><a href="listSearch${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
  </c:if> 
 </ul>
</div>
</body>
</html>