<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
  <link rel="stylesheet" href="/css/bootstrap.css">
  
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="imgs/favicon.ico">
    
 
    <title>Checkout example for Bootstrap</title>
  
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="cusuom-css/form-validation.css" rel="stylesheet">
    
  </head>
 <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
 <script type="text/javascript">
 $(document).ready(function() {
   $(".idCheck").click(function(){
	   var query = {id : $('#userId').val()};
	  
		   $.ajax({
		   url : '/board/idCheck',
		   type : 'POST',
		   data : query,
		   success : function(data) {
		   if(data == true) {
		   $(".result .msg").text("사용 불가");
		   $(".result .msg").attr("style", "color:#f00"); 
		   $("#submit").attr("disabled","disabled");
		   } else {
		   $(".result .msg").text("사용 가능");
		   $(".result .msg").attr("style", "color:#00f");
		   $("#submit").removeAttr("disabled");
		   }
		   }
		   }); // ajax 끝

		  
		   }); 
 });
   </script>
  <body class="bg-light">
<form method="post" action="/board/signup">
    <div class="container">
      <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="brand/bootstrap-solid.svg" alt="" width="72" height="72">
        <h2>환영합니당</h2>
        <p class="lead">제 칭구가 되시려면 반드시 회원가입을 하셔야 합니다</p>
      </div>

      <div class="row">
   
        <div class="col-md-8 order-md-1" style="margin: auto;">
          <h4 class="mb-3">개인 정보</h4>
         
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName">이름</label>
                <input type="text" class="form-control" name="name" placeholder="" value="" required>
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
              </div>
              
            </div>

            <div class="mb-3">
              <label for="ID">ID</label>
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text">@</span>
                </div>
                <input type="text" id="userId" name="id" placeholder="ID" required>
                <button type="button" class="idCheck" onclick="check()">아이디 확인</button>
                <div class="invalid-feedback" style="width: 100%;">
                 
                </div>
                <p class="result">
                	<span class="msg">아이디를 확인해주십시오</span>
                </p>
              </div>
            </div>
            <div class="mb-3">
              <label for="PS">PassWord</label>
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text">@</span>
                </div>
                <input type="password" class="form-control" name="pw" placeholder="PassWord" required>
                <div class="invalid-feedback" style="width: 100%;">
                 
                </div>
              </div>
            </div>
            <div class="mb-3">
              <label for="email">Email <span class="text-muted">(Optional)</span></label>
              <input type="email" class="form-control" name="email" placeholder="you@example.com">
              <div class="invalid-feedback">
                Please enter a valid email address for shipping updates.
              </div>
            </div>
            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit" disabled="disabled" id="submit">가입하기</button>
        </div>
      </div>
    </div>

   
   </form>
  
  </body>
</html>
