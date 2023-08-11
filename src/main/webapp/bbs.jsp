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
<title>bbs</title>
</head>
<%
		String userId = null;
		if(session.getAttribute("userId") != null){
			userId =(String)session.getAttribute("userId");
		}
%>
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
   	   				<a class="nav-link" aria-current="page"
   	   				   href="main.jsp">메인</a>
   	   				</li>
   	   				<li class="nav-item">
   	   					<a class="nav-link active" href="bbs.jsp">게시판</a>
   	   				</li>
   	   			</ul>
   	   			<%if(userId == null){ %>
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
   	   			<%}else{ %>
   	   			<ul class="nav navbar-nav navbar-right">
   	   				<li class="nav-item dropdown">
   	   					<a class="nav-link dropdown-toggle" href="#"
   	   					 role="button" data-bs-toggle="dropdown" 
   	   					 aria-expanded="false">
<%--    	   					<%=userId %>  --%>
   	   					${userId}  님
   	   					</a>
   	   					<ul class="dropdown-menu">
   	   						<li><a class="dropdown-item" href="logoutAction.jsp"
   	   						>로그아웃</a></li>
   	   					</ul>
   	   				</li>
   	   			</ul>
   	   			<%} %>
   	   			
   	   		</div>
   	   </div>
   </nav>
   <div class="container-fluid p-3">
   		<div class="row">
   			<div class="col-lg-1"></div>
   			<div class="col-lg-10">
   				<table class="table table-striped" 
   				    style="text-align:center">
   				    <thead>
   				    	<tr><th>제목</th><th>작성자</th><th>작성일</th></tr>
   				    </thead>
   				    <tbody>
   				    	<tr><td>내용1</td><td>팽수1</td><td>2023-09-06</td></tr>
   				    	<tr><td>내용2</td><td>팽수2</td><td>2023-09-06</td>
   				    	</tr>
   				    </tbody>
   				</table>
   			</div>
   			<div class="col-lg-1">
   			</div>
   		</div>
   </div>
   
   
</body>
</html>