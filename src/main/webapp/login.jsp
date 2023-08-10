<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, inital-scale=1.0">
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" ></script>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
   <nav class="navbar navbar-expand-lg bg-body-tertiary">
   	   <div class="container-fluid">
   	   		<a class="navbar-brand" href="#">미래융합 게시판</a>
   	   		<button class="navbar-toggler" type="button"
   	   	       data-bs-toggle="collapse" data-bs-target="#navbarContent" 
   	   	       aria-controls="navbarContent" aria-expanded="false"
   	   	       aria-label="Toggle naviation">
   	   	       <span class="navbar-toggler-icon"></span>
   	   		</button>
   	   		<div class="collapse navbar-collapse" id="navbarContent">
   	   			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
   	   				<li class="nav-item">
   	   				<a class="nav-link active" aria-current="page"
   	   				   href="main.jsp">메인</a>
   	   				</li>
   	   				<li class="nav-item">
   	   					<a class="nav-link" href="bbs.jsp">게시판</a>
   	   				</li>
   	   			</ul>
   	   			<ul class="nav navbar-nav navbar-right">
   	   				<li class="nav-item dropdown">
   	   					<a class="nav-link dropdown-toggle" href="#"
   	   					   role="button" data-bs-toggle="dropdown"
   	   					   aria-expanded="false">
   	   					   접속하기</a>
   	   					<ul class="dropdown-menu">
   	   						<li><a class="dropdown-item" href="login.jsp">로그인</a>
   	   						</li>
   	   						<li><hr class="dropdown-divider">
   	   						</li>
   	   						<li><a class="dropdown-item" href="join.jsp">회원가입</a>
   	   						</li>
   	   					</ul>
   	   				</li>
   	   			</ul>
   	   		</div>
   	   </div>
   </nav>
   <div class="container-fluid">
   		<div class="row">
   			<div class="col-lg-4"></div>
   			<div class="col-lg-4">
   				<form action="loginAction.jsp" method="post">
   					<h3 style="text-align:center; padding-bottom:5%;
   					     padding-top:15%">로그인 화면</h3>
   					<div class="form-group">
   						<input type="text" class="form-control" 
   						 placeholder="아이디" name="userId" maxlength="20">
   					</div>
   					<div class="form-group">
   					    <input type="password" class="form-control"
   					    placeholder="비밀번호" name="userPw" maxlength="20">
   					</div>
   					<input type="submit" class="btn btn-primary form-control"
   					  value="로그인">
   				</form>
   			</div>
   			<div class="col-lg-4"></div>
   		</div>
   </div>
   
   
</body>
</html>