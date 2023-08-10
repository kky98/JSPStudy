<%@page import="model.UserVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@page import="service.UserService" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% 
	String userId = request.getParameter("userId");  
	String userPw = request.getParameter("userPw");  
	String userNm = request.getParameter("userNm");
	System.out.println(userId);
	System.out.println(userNm);
	UserVO vo = new UserVO();
	vo.setUserId(userId);
	vo.setUserNm(userNm);
	UserService service = UserService.getInstance();
	service.updateUser(vo);
	out.println("<script> ");
	out.println("alert('수정되었습니다.'); location.href='mypage.jsp'; ");
	out.println("</script>");
	//업데이트 
	// 1.Userdao 쪽 update query 기능을 수행하는 메서드 생성
	// 2.UserService 쪽 생성 
	// 3.mypageAction에서 위의 메서드 호출 
	// 4.mypage.jsp로 이동 
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