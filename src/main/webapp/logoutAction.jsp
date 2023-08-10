<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 회원 세션 내용삭제 로그아웃처리 -->
	<% session.invalidate(); 
	   // 리다이렉트 클라이언트에게 새로운 위치로 요청을 다시 보내라는 응답.	
	   response.sendRedirect("index.jsp");
	%>
	
</body>
</html>