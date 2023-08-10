<%@page import="model.UserVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="service.UserService" %>
<jsp:useBean id="user" class="model.UserVO" scope="page" ></jsp:useBean>
<jsp:setProperty property="userId" name="user" />
<jsp:setProperty property="userPw" name="user"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginAction</title>
</head>
<% 
    String id = request.getParameter("userId");
    String pw = request.getParameter("userPw");
    UserService userService = UserService.getInstance();
    UserVO userVO = userService.loginUser(id, pw);
%>
<body>
	<%  if(userVO !=null){
		session.setAttribute("userId", userVO.getUserId());
		session.setMaxInactiveInterval(1 * 60); //1분
	%>
		<script> 
		         alert('환영합니다.^^');
		         location.href="main.jsp";
		</script>
	<% }else{ %>
	    <script> 
	             alert("아이디/비번을 확인하세요!");
	             history.back();
	    </script>
	<%  } %>
</body>
</html>