<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error page</title>
</head>
<body>
		<%@include file="/WEB-INF/inc/top.jsp" %>
		<header class="masthead bg-primary text-white text-center">
			<div class="container d-flex align-items-center flex-column">
			<img alt="" src="assets/img/avataaars.svg"
			            class="masthead-avatar md-5">
			<h1 class="masthead-hearding text-uppercase mb-0">에러 페이지</h1>
		    <div class="divider-custom">
                   <div class="divider-custom-line"></div>
                   <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                   <div class="divider-custom-line"></div>
             </div>
			<p class="masthead-subheading font-weight-light mb-0">
			        의도치 않은 에러가 발생했습니다.</p>
			</div>
		</header>
		<%@include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>