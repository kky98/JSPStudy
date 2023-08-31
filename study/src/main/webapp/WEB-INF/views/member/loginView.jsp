<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<script>
	let msg = "${msg}";
	if(msg =='N'){
		alert("아이디를 확인해 주세요");
	}else if(msg =='M'){
		alert("비번을 확인해 주세요");
	}
</script>
<body>
		<%@include file="/WEB-INF/inc/top.jsp" %>
		<!-- Contact Section-->
        <section class="page-section" id="contact">
            <div class="container" style="margin-top: 150px">
                <!-- Contact Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">로그인</h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Contact Section Form-->
                <div class="row justify-content-center">
                    <div class="col-lg-8 col-xl-7">
                        <form method="post" action="<c:url value="/loginDo" />" >
                        	<div class="form-floating mb-3">
                        		<input class="form-control" name="memId" type="text" value="${cookie.rememberId.value }"
                        		   placeholder="아이디를 입력해주세요 ">
                        		<label>아이디</label>
                        	</div>
                        	<div class="form-floating mb-3">
                        		<input class="form-control" name="memPw" type="password" 
                        		   placeholder="비밀번호를 입력해주세요 ">
                        		<label>비밀번호</label>
                        	</div>
							<!-- 아이디 기억      		 -->
							<div class="form-floating mb-3">
								아이디 기억하기 <input class="form-check-input" name="remember" type="checkbox"
								                 ${cookie.rememberId.value==null ? "":"checked" } />
								<input name="fromUrl" type="hidden" value="${fromUrl }" />
							</div>
                        	
                        	<button class="btn btn-primary btn-xl" type="submit">로그인</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
		<%@include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>