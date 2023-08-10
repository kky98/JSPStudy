<%@page import="model.UserVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@page import="service.UserService" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="userVO" class="model.UserVO" scope="page"></jsp:useBean>
<jsp:setProperty property="userId" name="userVO" />
<jsp:setProperty property="userPw" name="userVO" />
<jsp:setProperty property="userNm" name="userVO" />
<% 
	String userId = request.getParameter("userId");  
	String userPw = request.getParameter("userPw");  
	String userNm = request.getParameter("userNm");  
	System.out.println(userNm);
	System.out.println(userVO);
	UserService service = UserService.getInstance();
	int cnt = service.insertUser(userVO);
%>
<!-- 	UserService 의 insertUser 메서드를 호출하여 회원정보 저장 후  -->
<!--    리턴값이 1 이면(정상저장) 세션에 userId저장 후 main.jsp로 이동 -->
<!--    리턴값이 0 이면 join.jsp 화면으로 이동시켜 주세요 ^^  -->
<%
    out.println("<script>");
    if(cnt == 0){
	    out.println("alert('동일 아이디가 존재합니다.')");
	    out.println("history.back();");
	}else{
		out.println("alert(' " +userVO.getUserNm()+ "님 환영합니다. ')");
		session.setAttribute("userId", userVO.getUserId());
		out.println("location.href='main.jsp'");
	}
    out.println("</script>");
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinAction</title>
</head>
<body>
</body>
</html>