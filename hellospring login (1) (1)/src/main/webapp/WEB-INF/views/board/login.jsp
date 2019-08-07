<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>

<html lang="en">
  <head>
  <link rel="stylesheet" href="/css/bootstrap.css">
  
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Signin Template for Bootstrap</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
   <script>
   $(document).ready(function(){
	   $("#submit").click(function(){
		   var id = $("#id").val();
		   var pw = $("#pw").val();
		   if(id==""){
			   alert("아이디를 입력하세요.");
			   $("#id").focus();
			   return;
		   }
		   if(pw == ""){
			   alert("비밀번호를 입력하세요.");
			   $("pw").focus();
			   return;
		   }
		   document.form.action="${path}/board/login"
		   document.form.submit();
	   });
   });
   </script>
</head> 

  <body class="text-center">
 <form class="form-signin" method="post" action="/board/login">
   </form>
    <form method="post" action="/board/loginProcess">
      <h1 class="h3 mb-3 font-weight-normal">어서오세요~.~</h1>
     <!-- <label for="inputEmail" class="sr-only">Email address</label> -->
      <input type="text" id="id" name="id" class="form-control" placeholder="ID" style="width:200px;display: inline-block;text-align: center;"><br>
                                                                           <!--require속성 필수항목 만들기 -->
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" name="pw" class="form-control" placeholder="Password" style="width:200px;display: inline-block;text-align: center;">
      <div class="checkbox mb-3">
        <label>
          <input id="remember-me" type="checkbox" value="remember-me"> 리멤버미-☆
        </label>
      </div>
   
    
      <button class="btn btn-lg btn-primary btn-block" type="submit" style="width:200px; display: inline-block;text-align: center;">로그인</button><br><br>
    </form>
   <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
var userInputId = getCookie("userInputId");
$("input[name='id']").val(userInputId); 
 
if($("input[name='id']").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
    $("#remember-me").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
}
 
$("#remember-me").change(function(){ // 체크박스에 변화가 있다면,
    if($("#remember-me").is(":checked")){ // ID 저장하기 체크했을 때,
        var userInputId = $("input[name='id']").val();
        setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
    }else{ // ID 저장하기 체크 해제 시,
        deleteCookie("userInputId");
    }
});
 
// ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
$("input[name='id']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
    if($("#remember-me").is(":checked")){ // ID 저장하기를 체크한 상태라면,
        var userInputId = $("input[name='id']").val();
        setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
    }
});
});

function setCookie(cookieName, value, exdays){
var exdate = new Date();
exdate.setDate(exdate.getDate() + exdays);
var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
document.cookie = cookieName + "=" + cookieValue;
}

function deleteCookie(cookieName){
var expireDate = new Date();
expireDate.setDate(expireDate.getDate() - 1);
document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}

function getCookie(cookieName) {
cookieName = cookieName + '=';
var cookieData = document.cookie;
var start = cookieData.indexOf(cookieName);
var cookieValue = '';
if(start != -1){
    start += cookieName.length;
    var end = cookieData.indexOf(';', start);
    if(end == -1)end = cookieData.length;
    cookieValue = cookieData.substring(start, end);
}
return unescape(cookieValue);
}
</script>
  </body>
</html>
